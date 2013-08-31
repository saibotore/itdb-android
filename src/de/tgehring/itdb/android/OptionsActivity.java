package de.tgehring.itdb.android;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import de.tgehring.itdb.service.ConnectionClient;

public class OptionsActivity extends Activity implements OnClickListener {

	private EditText editServerAddress;
	private Button saveSettings;
	private final String PREFS = "ITDB";
	private final String ADDRESS = "serverAddress";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_options);
		editServerAddress = (EditText) findViewById(R.id.editServerAddress);
		SharedPreferences settings = getSharedPreferences(PREFS, 0);
		String input = settings.getString(ADDRESS, "");
		if(input.length() == 0) {
			input = ConnectionClient.getInstance().getHost();
		}
		editServerAddress.setText(input);
		saveSettings = (Button) findViewById(R.id.saveSettings);
		saveSettings.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.saveSettings) {
			String input = editServerAddress.getText().toString();
			if (!input.contains(".") && input.length() == 12) {
				editServerAddress.setText(getIp(input));
				input = editServerAddress.getText().toString();
			}
			// Gets the SharedPreferences
			SharedPreferences settings = getSharedPreferences(PREFS, 0);
			SharedPreferences.Editor editor = settings.edit();
			editor.putString(ADDRESS, input);
			// Commit the entry
			editor.commit();
			ConnectionClient.getInstance().setHost(input);
		}
	}

	private String getIp(String value) {
		String result = value.substring(0, 3);
		result += ".";
		result += getSegment(value.substring(3, 6));
		result += ".";
		result += getSegment(value.substring(6, 9));
		result += ".";
		result += getSegment(value.substring(9, 12));
		return result;
	}

	private String getSegment(String value) {
		String result = "";
		for (int i = 0; i < 3; i++) {
			char c = value.charAt(i);
			if (c != '0') {
				return result = value.substring(i);
			}
		}
		if (result.length() == 0) {
			result = value.substring(2);
		}
		return result;
	}

}
