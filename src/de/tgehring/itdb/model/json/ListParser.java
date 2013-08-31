package de.tgehring.itdb.model.json;

import java.util.List;

import org.json.JSONObject;

public interface ListParser<T> {
	
	JSONObject getJSON(int i);
	
	T getEntity(int i);
	
	List<T> getEntities();

}
