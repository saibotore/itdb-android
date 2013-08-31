package de.tgehring.itdb.android.connection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import de.tgehring.itdb.service.ConnectionClient;

public class CheckInternetConnection {
	
	public static boolean check() {
		try {
			URL url = new URL(ConnectionClient.getInstance().getHost());
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestProperty("User-Agent", "Android Application");
			con.setRequestProperty("Connection", "close");
			con.setConnectTimeout(3000);
			con.connect();
			return con.getResponseCode() == 200;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
