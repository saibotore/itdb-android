package de.tgehring.itdb.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import de.tgehring.itdb.android.rechner.RechnerActivity;
import de.tgehring.itdb.android.rechner.RechnerDetailActivity;
import de.tgehring.itdb.android.todo.TodoActivity;
import de.tgehring.itdb.model.cache.RechnerList;

public class MainActivity extends Activity implements OnClickListener {
	
	Button scanButton;
	RadioButton scanRechner;
	RadioButton scanMonitor;
	RadioButton scanDrucker;
	
	String iNummer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		scanButton = (Button) findViewById(R.id.scanButton);
		scanButton.setOnClickListener(this);
		scanRechner = (RadioButton) findViewById(R.id.scanRechner);
		scanMonitor = (RadioButton) findViewById(R.id.scanMonitor);
		scanDrucker = (RadioButton) findViewById(R.id.scanDrucker);
	}
	
	@Override
	public void onClick(View v){
		if(v.getId()==R.id.scanButton){
			IntentIntegrator scanIntegrator = new IntentIntegrator(this);
			scanIntegrator.initiateScan();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.layout.main_menu, menu);
		return true;
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
		if (scanningResult != null) {
			iNummer = scanningResult.getContents();
			Intent resultIntent = null;
			if(scanRechner.isChecked()) {
				RechnerList.getInstance().setInventarnummer(iNummer);
				resultIntent = new Intent(this, RechnerDetailActivity.class);
				startActivity(resultIntent);
			} else if(scanMonitor.isChecked()) {
				
			} else if(scanDrucker.isChecked()) {
				
			} else {
				Toast.makeText(this, "Bitte Gerät wählen!", Toast.LENGTH_SHORT).show();
			}
		}
		else{
			Toast.makeText(getApplicationContext(), 
					"Keine Scan-Daten erhalten!", Toast.LENGTH_SHORT).show();
		}
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent = null;
        switch (item.getItemId()) {
        	case R.id.menu_options:
        	intent = new Intent(this, OptionsActivity.class);
        	startActivity(intent);
        	return true;
        
	        case R.id.menu_todo:
	        	intent = new Intent(this, TodoActivity.class);
	        	startActivity(intent);
	            return true;
	            
	        case R.id.menu_db:
	        	intent = new Intent(this, RechnerActivity.class);
	        	startActivity(intent);
	        	return true;
	 
	        case R.id.menu_scan:
	            return true;
	 
	        default:
	            return super.onOptionsItemSelected(item);
        }
    }    

}
