package de.tgehring.itdb.service;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import android.net.Uri;
import de.tgehring.itdb.android.connection.NetworkUtility;
import de.tgehring.itdb.model.Todo;

public class CRUDClient {
	
	private static CRUDClient instance = null;

	private CRUDClient() {
	}

	public static CRUDClient getInstance() {
		if (instance == null) {
			instance = new CRUDClient();
		}
		return instance;
	}
	
	public String getAllTodo() {
		NetworkUtility nwu = new NetworkUtility();
		Uri source = Uri.parse(ConnectionClient.getInstance().getUrl() + "/crud/todo");
		return nwu.get(source);
	}
	
	public String getAllBenutzer() {
		NetworkUtility nwu = new NetworkUtility();
		Uri source = Uri.parse(ConnectionClient.getInstance().getUrl() + "/crud/benutzer");
		return nwu.get(source);
	}
	
	public String getAllRechner() {
		NetworkUtility nwu = new NetworkUtility();
		Uri source = Uri.parse(ConnectionClient.getInstance().getUrl() + "/crud/rechner");
		return nwu.get(source);
	}
	
	public URI buildURI(String path) {
		String base = "http://222.111.0.22:8080/ITDB-Server";
		return UriBuilder.fromUri(base + path).build();
	}
	
	public URI getBaseURI() {
		return UriBuilder.fromUri("http://222.111.0.22:8080/ITDB-Server").build();
	}

	public void createTodo(Todo todo) {
		try {
			String json = todo.getJSON().toString();
			System.out.println(json);
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost request = new HttpPost("http://222.111.0.22:8080/ITDB-Server/crud/todo");
			StringEntity s = new StringEntity(json);
			
			s.setContentEncoding("UTF-8");
			s.setContentType("application/json");
			
			request.setEntity(s);
			request.addHeader("accept", "application/json");
			System.out.println("createTodo");
			httpclient.execute(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
