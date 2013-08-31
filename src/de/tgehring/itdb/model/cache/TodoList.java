package de.tgehring.itdb.model.cache;

import java.util.LinkedList;
import java.util.List;

import de.tgehring.itdb.model.Todo;

public class TodoList {
	
	private List<Todo> list;
	private int selected = -1;
	private static TodoList instance;
	
	private TodoList() {
		setList(new LinkedList<Todo>());
	}
	
	public static TodoList getInstance() {
		if(instance == null) {
			instance = new TodoList();
		}
		return instance;
	}

	public List<Todo> getList() {
		return list;
	}

	public void setList(List<Todo> list) {
		this.list = list;
	}

	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		this.selected = selected;
	}

}
