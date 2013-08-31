package de.tgehring.itdb.model;

public class Benutzer {
	
	private long id;
	private String vorname;
	private String nachname;
	private String benutzername;
	private String passwort;
	private boolean admin;
	
	public Benutzer() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "" + benutzername;
	}
	
	public static String getTableName() {
		return "benutzer";
	}
	
	public static String createTable() {
		StringBuilder sb = new StringBuilder();
		sb.append("CREATE TABLE if not exists " + Todo.getTableName());
		sb.append("(ID INTEGER PRIMARY KEY, VORNAME TEXT,");
		sb.append("NACHNAME TEXT, BENUTZERNAME TEXT,");
		sb.append("PASSWORT TEXT, ADMIN INTEGER)");
		return sb.toString();
	}

}