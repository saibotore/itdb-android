package de.tgehring.itdb.android.todo;

import java.util.List;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import de.tgehring.itdb.android.R;
import de.tgehring.itdb.android.connection.CheckInternetConnection;
import de.tgehring.itdb.model.Todo;
import de.tgehring.itdb.model.cache.TodoList;
import de.tgehring.itdb.model.json.TodoParser;
import de.tgehring.itdb.service.CRUDClient;
import de.tgehring.itdb.service.DatabaseHandler;

public class TodoListFragment extends ListFragment {
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		getTodos();
	}

	private void getTodos() {
		Thread loader = new Thread() {
			public void run() {
				try {
					Log.i("INFO", "CheckInternetConnection");
					if(CheckInternetConnection.check()) {
						Log.i("INFO", "Begin to load the resource");
						final String todos = CRUDClient.getInstance().getAllTodo();
						getActivity().runOnUiThread(new Runnable() {

							@Override
							public void run() {
								Log.i("INFO", "Begin to parse the resource");
								TodoParser tparser = new TodoParser(todos);
								TodoList.getInstance().setList(tparser.getEntities());
								updateAdapter();
								saveLocally();
							}
						  	
						});
					} else {
						getActivity().runOnUiThread(new Runnable() {

							@Override
							public void run() {
								Log.i("INFO", "Begin to load the local resource");
								DatabaseHandler dbhandler = new DatabaseHandler(getActivity());
								TodoList.getInstance().setList(dbhandler.getAllTodos());
								updateAdapter();
							}
						  	
						});
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		};
		loader.start();
	}
	
	private void updateAdapter() {
		Log.i("INFO", "Begin to show the resource");
		List<Todo> todoList = TodoList.getInstance().getList();
		Todo[] todos = new Todo[todoList.size()];
		for(int i=0; i<todoList.size(); i++) {
			todos[i] = todoList.get(i);
		}
		ArrayAdapter<Todo> adapter = new ArrayAdapter<Todo>(getActivity(),
				android.R.layout.simple_list_item_1, todos);
		setListAdapter(adapter);
	}
	
	private void saveLocally() {
		DatabaseHandler dbhandler = new DatabaseHandler(getActivity());
		dbhandler.truncateTodoTable();
		for(Todo todo: TodoList.getInstance().getList()) {
			dbhandler.addTodo(todo);
		}
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		TodoList.getInstance().setSelected(position);
		TodoDetailFragment fragment = (TodoDetailFragment) getFragmentManager().findFragmentById(R.id.fragment_detail);
		if (fragment != null && fragment.isInLayout()) {
			fragment.setText(position);
		} else {
			Intent intent = new Intent(getActivity().getApplicationContext(), TodoDetailActivity.class);
			startActivity(intent);
		}
 	}

	public void update() {
		getTodos();
	}

	public void refresh() {
		// TODO Auto-generated method stub
		
	}    
}
