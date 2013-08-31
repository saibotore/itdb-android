package de.tgehring.itdb.android;

import java.util.Observable;

public class StateHolder extends Observable {
	
	private boolean loading;
	private static StateHolder instance;
	
	private StateHolder() {
		setLoading(false);
	}
	
	public static StateHolder getInstance() {
		if(instance == null) {
			instance = new StateHolder();
		}
		return instance;
	}

	public boolean isLoading() {
		return loading;
	}

	public void setLoading(boolean loading) {
		this.loading = loading;
	}

}
