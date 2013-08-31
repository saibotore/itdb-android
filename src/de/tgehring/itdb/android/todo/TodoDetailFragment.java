package de.tgehring.itdb.android.todo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import de.tgehring.itdb.android.R;
import de.tgehring.itdb.model.Todo;
import de.tgehring.itdb.model.cache.TodoList;

public class TodoDetailFragment extends Fragment  {
	
	private TextView idText;
	private TextView nameText;
	private TextView beschreibungText;
	private TextView dateText;
	private TextView wichtigText;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_todo_detail,
				container, false);
		initComponents(view);
		if(TodoList.getInstance().getSelected() != -1){
			setText(TodoList.getInstance().getSelected());
		}
		return view;
	}
	

	private void initComponents(View view) {
		idText = (TextView) view.findViewById(R.id.todoIdText);
		nameText = (TextView) view.findViewById(R.id.todoNameText);
		beschreibungText = (TextView) view.findViewById(R.id.todoBeschreibungText);
		dateText = (TextView) view.findViewById(R.id.todoDateText);
		wichtigText = (TextView) view.findViewById(R.id.todoWichtigText);
	}

	public void setText(int item) {
		Todo todo = TodoList.getInstance().getList().get(item);
		idText.setText("" + todo.getId());
		nameText.setText(todo.getName());
		beschreibungText.setText(todo.getBeschreibung());
		wichtigText.setText(todo.getWichtig());
		dateText.setText(todo.getDate());
	}
	
}
