package de.tgehring.itdb.android.rechner;

import java.util.List;

import android.app.ListFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import de.tgehring.itdb.android.R;
import de.tgehring.itdb.android.StateHolder;
import de.tgehring.itdb.android.connection.CheckInternetConnection;
import de.tgehring.itdb.android.connection.NetworkUtility;
import de.tgehring.itdb.model.Rechner;
import de.tgehring.itdb.model.cache.RechnerList;
import de.tgehring.itdb.model.json.RechnerParser;
import de.tgehring.itdb.service.ConnectionClient;

public class RechnerListFragment extends ListFragment {
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		StateHolder.getInstance().setLoading(true);
		final NetworkUtility nwu = new NetworkUtility();
		final Uri rechnerSource = Uri.parse(ConnectionClient.getInstance().getUrl() + "/crud/rechner");
		Thread loader = new Thread() {
			public void run() {
				try {
					Log.i("INFO", "CheckInternetConnection");
					if(CheckInternetConnection.check()) {
						Log.i("INFO", "Begin to load the resource");
						final String rechner = nwu.get(rechnerSource);
						getActivity().runOnUiThread(new Runnable() {

							@Override
							public void run() {
								Log.i("INFO", "Begin to parse the resource");
								RechnerParser rparser = new RechnerParser(rechner);
								RechnerList.getInstance().setList(rparser.getEntities());
								updateAdapter();
							}
		
						});
					} else {
						Toast.makeText(getActivity(), "Keine Verbindung zum Server", Toast.LENGTH_SHORT).show();
//						getActivity().runOnUiThread(new Runnable() {
//
//							@Override
//							public void run() {
//								Log.i("INFO", "Begin to load the local resource");
//								DatabaseHandler dbhandler = new DatabaseHandler(getActivity());
//								RechnerList.getInstance().setList(dbhandler.getAllRechner());
//								updateAdapter();
//							}
//						  	
//						});
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					StateHolder.getInstance().setLoading(false);
				}
				
			}
		};
		loader.start();
	}
	
	private void updateAdapter() {
		Log.i("INFO", "Begin to show the resource");
		List<Rechner> rechnerList = RechnerList.getInstance().getList();
		Rechner[] rechner = new Rechner[rechnerList.size()];
		for(int i=0; i<rechnerList.size(); i++) {
			rechner[i] = rechnerList.get(i);
		}
		ArrayAdapter<Rechner> adapter = new ArrayAdapter<Rechner>(getActivity(),
				android.R.layout.simple_list_item_1, rechner);
		setListAdapter(adapter);
	}
	
//	private void saveLocally() {
//		DatabaseHandler dbhandler = new DatabaseHandler(getActivity());
//		dbhandler.truncateTodoTable();
//		for(Todo todo: TodoList.getInstance().getList()) {
//			dbhandler.addTodo(todo);
//		}
//	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		RechnerList.getInstance().setSelected(position);
		RechnerDetailFragment fragment = (RechnerDetailFragment) getFragmentManager().findFragmentById(R.id.fragment_detail);
		if (fragment != null && fragment.isInLayout()) {
			fragment.setText(position);
		} else {
			Intent intent = new Intent(getActivity().getApplicationContext(), RechnerDetailActivity.class);
			startActivity(intent);
		}
 	}

	public void refresh() {
		
	}    

}
