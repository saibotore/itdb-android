package de.tgehring.itdb.model.json;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import de.tgehring.itdb.model.Todo;

public class TodoParser implements ListParser<Todo> {
	
	private JSONArray arrayParser;
	private JSONObject todoJSON;
	
	public TodoParser(String json) {
		try {
			JSONObject jsonResponse = new JSONObject(json);
			if(json.contains("todo\":[")) {
				this.arrayParser = jsonResponse.getJSONArray("todo");
			} else {
				this.todoJSON = jsonResponse.getJSONObject("todo");
			}
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
	}
	
	public JSONObject getJSON(int i) {
		try {
			if(arrayParser != null) {
				return arrayParser.getJSONObject(i);
			} else {
				return todoJSON;
			}
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
	}

	public Todo getEntity(int i) {
		try {
			if(arrayParser != null) {
				todoJSON = getJSON(i);
			}
			Todo todo = new Todo();
			String id = todoJSON.getString("id");
			String name = todoJSON.getString("name");
			String beschreibung = todoJSON.getString("beschreibung");
			String date = todoJSON.getString("date");
			String wichtig = todoJSON.getString("wichtig");
			todo.setId(Long.parseLong(id));
			todo.setName(name);
			todo.setBeschreibung(beschreibung);
			todo.setDate(date);
			todo.setWichtig(Integer.parseInt(wichtig));
			return todo;
		} catch (JSONException e) {
//			throw new RuntimeException(e);
		}
		return null;
	}
	
	public List<Todo> getEntities() {
		List<Todo> result = new LinkedList<Todo>();
		for (int i=0; i < arrayParser.length(); i++) {
			result.add(getEntity(i));
		}
		return result;
	}


}