package de.tgehring.itdb.android.rechner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import de.tgehring.itdb.android.MainActivity;
import de.tgehring.itdb.android.R;
import de.tgehring.itdb.android.todo.TodoActivity;

public class RechnerDetailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rechner_detail);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.layout.db_menu_detail, menu);
		return true;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
	        case R.id.menu_todo:
	        	Intent intent = new Intent(this, TodoActivity.class);
	        	startActivity(intent);
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
