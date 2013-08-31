package de.tgehring.itdb.model.json;

import de.tgehring.itdb.model.Hersteller;

public class HerstellerParser implements Parser<Hersteller>{
	
	private String json;
	
	public HerstellerParser(String json) {
		this.json = json;
	}

	@Override
	public String getValue() {
		String[] values = json.split(":");
		boolean nextHersteller = false;
		boolean nextBezeichnung = false;
		String bezeichnung = "";
		for(String element: values) {
			if(nextHersteller) {
				if(nextBezeichnung) {
					return getPlain(element);
				} else if(element.contains("bezeichnung")) {
					nextBezeichnung = true;
				}
			} else if(element.contains("hersteller")) {
				nextHersteller = true;
			}
		}
		return bezeichnung;
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
