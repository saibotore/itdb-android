package de.tgehring.itdb.android.todo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import de.tgehring.itdb.android.MainActivity;
import de.tgehring.itdb.android.R;
import de.tgehring.itdb.android.rechner.RechnerActivity;

public class TodoDetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_todo_detail);
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.layout.todo_detail_menu, menu);
		return true;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
		TodoListFragment listFragment = (TodoListFragment) getFragmentManager().findFragmentById(R.id.fragment_list);
        switch (item.getItemId()) {
	        case R.id.menu_db:
	        	Intent intent = new Intent(this, RechnerActivity.class);
	        	startActivity(intent);
	            return true;
	 
	        case R.id.menu_refresh:
	        	listFragment.refresh();
	            return true;
	 
	        case R.id.menu_scan:
	        	intent = new Intent(this, MainActivity.class);
	        	startActivity(intent);
	        	return true;
	        	
	        default:
	            return super.onOptionsItemSelected(item);
        }
    }  

}
