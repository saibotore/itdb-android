package de.tgehring.itdb.model.cache;

import java.util.LinkedList;
import java.util.List;

import de.tgehring.itdb.model.Monitor;

public class MonitorList {
	
	private List<Monitor> list;
	private static MonitorList instance;
	
	private MonitorList() {
		setList(new LinkedList<Monitor>());
	}
	
	public static MonitorList getInstance() {
		if(instance == null) {
			instance = new MonitorList();
		}
		return instance;
	}

	public List<Monitor> getList() {
		return list;
	}

	public void setList(List<Monitor> list) {
		this.list = list;
	}

}
