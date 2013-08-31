package de.tgehring.itdb.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Todo {
	
	private long id;
	private String name;
	private String beschreibung;
	private int wichtig;
	private String date;
	
	public Todo() {
		
	}
	
	public Todo(String json) {
		Todo data = new Gson().fromJson(json, Todo.class);
		this.name = data.getName();
		this.beschreibung = data.getBeschreibung();
		this.date = data.getDate();
		this.wichtig = data.getWichtig();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public int getWichtig() {
		return wichtig;
	}

	public void setWichtig(int wichtig) {
		this.wichtig = wichtig;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return name + " (" + date + ")";
	}
	
	public static String getTableName() {
		return "todo";
	}
	
	public static String createTable() {
		StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE if not exists " + Todo.getTableName());
		sb.append("(ID INTEGER PRIMARY KEY, NAME TEXT,");
		sb.append("BESCHREIBUNG TEXT, WICHTIG INTEGER,");
		sb.append("DATE TEXT)");
		return sb.toString();
	}

	public JsonObject getJSON() {
		JsonObject json = new JsonObject();
		json = new JsonObject();
		json.addProperty("beschreibung", this.beschreibung);
		json.addProperty("date", this.date);
		json.addProperty("id", this.id);
		json.addProperty("name", this.name);
		json.addProperty("wichtig", this.wichtig);
		return json;
	}
	
}
