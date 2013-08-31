package de.tgehring.itdb.service;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;


public class ConnectionClient {

	private static ConnectionClient instance = null;
	private ClientConfig config;
	private Client client;
	private WebResource service;
	private String url;
	private String host;

	private ConnectionClient() {
		host = "222.111.0.222";
		url = "http://222.111.0.22:8080/ITDB-Server";
		config = new DefaultClientConfig();
		client = Client.create(config);
		service = client.resource(getBaseURI());
	}

	public static ConnectionClient getInstance() {
		if (instance == null) {
			instance = new ConnectionClient();
		}
		return instance;
	}
	
	public void setUrl(String url) {
		this.url = url;
		this.host = url.substring(0, getUrl().length()-12);
	}
	
	public String getUrl() {
		return url;
	}

	public URI getBaseURI() {
		return UriBuilder.fromUri(url).build();
	}
	
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
		this.url = "http://" + host + ":8080/ITDB-Server";
	}
	
}
