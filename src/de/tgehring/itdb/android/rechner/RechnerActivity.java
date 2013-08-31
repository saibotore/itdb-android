package de.tgehring.itdb.android.rechner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import de.tgehring.itdb.android.MainActivity;
import de.tgehring.itdb.android.R;
import de.tgehring.itdb.android.todo.TodoActivity;

public class RechnerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rechner);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.layout.db_menu, menu);
		return true;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
		RechnerListFragment listFragment = (RechnerListFragment) getFragmentManager().findFragmentById(R.id.fragment_list);
        switch (item.getItemId()) {
	        case R.id.menu_todo:
	        	Intent intent = new Intent(this, TodoActivity.class);
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
