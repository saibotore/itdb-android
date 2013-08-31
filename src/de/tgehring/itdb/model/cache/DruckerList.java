package de.tgehring.itdb.model.cache;

import java.util.LinkedList;
import java.util.List;

import de.tgehring.itdb.model.Drucker;

public class DruckerList {
	
	private List<Drucker> list;
	private static DruckerList instance;
	
	private DruckerList() {
		setList(new LinkedList<Drucker>());
	}
	
	public static DruckerList getInstance() {
		if(instance == null) {
			instance = new DruckerList();
		}
		return instance;
	}

	public List<Drucker> getList() {
		return list;
	}

	public void setList(List<Drucker> list) {
		this.list = list;
	}

}
