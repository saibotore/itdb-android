package de.tgehring.itdb.model.json;

import de.tgehring.itdb.model.Benutzer;

public class BenutzerParser implements Parser<Benutzer> {

	private String json;
	private boolean nextBenutzer;
	
	public BenutzerParser(String json) {
		this.json = json;
		this.nextBenutzer = true;
	}
	
	public BenutzerParser(String json, boolean nextBenutzer) {
		this.json = json;
		this.nextBenutzer = nextBenutzer;
	}

	@Override
	public String getValue() {
		String bezeichnung = "";
		String hersteller = "";
		String[] values = json.split(":");
		boolean nextBenutzername = false;
		boolean gotBenutzername = false;
		for(String element: values) {
			if(nextBenutzer) {
				if(nextBenutzername && !gotBenutzername) {
					gotBenutzername = true;
					bezeichnung = getPlain(element);
				} else if(element.contains("benutzername")) {
					nextBenutzername = true;
				}
			} else {
				if(element.contains("benutzer")) {
					nextBenutzer = true;
				}
			}
		}
		return hersteller + " " + bezeichnung;
	}
	
	public static String getPlain(String value) {
		if(value.contains("\"")) {
			value = value.replaceAll("\"", "");
		}
		if(value.contains("{")) {
			value = value.replaceAll("\\{", "");
		}
		if(value.contains("}")) {
			value = value.replaceAll("\\}", "");
		}
		if(value.contains(",")) {
			String[] values = value.split(",");
			value = values[0];
		}
		return value;
	}

}
