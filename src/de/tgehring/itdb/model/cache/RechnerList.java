package de.tgehring.itdb.model.cache;

import java.util.LinkedList;
import java.util.List;

import de.tgehring.itdb.model.Rechner;

public class RechnerList {
	
	private List<Rechner> list;
	private int selected = -1;
	private String inventarnummer = "";
	private static RechnerList instance;
	
	private RechnerList() {
		setList(new LinkedList<Rechner>());
	}
	
	public static RechnerList getInstance() {
		if(instance == null) {
			instance = new RechnerList();
		}
		return instance;
	}

	public List<Rechner> getList() {
		return list;
	}

	public void setList(List<Rechner> list) {
		this.list = list;
	}
	
	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		this.selected = selected;
	}

	public String getInventarnummer() {
		return inventarnummer;
	}

	public void setInventarnummer(String inventarnummer) {
		this.inventarnummer = inventarnummer;
	}

}
