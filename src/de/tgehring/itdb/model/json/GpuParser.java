package de.tgehring.itdb.model.json;

import de.tgehring.itdb.model.Gpu;

public class GpuParser implements Parser<Gpu> {
	
	private String json;
	
	public GpuParser(String json) {
		this.json = json;
	}

	@Override
	public String getValue() {
		String bezeichnung = "";
		String hersteller = "";
		hersteller = new HerstellerParser(json).getValue();
		String[] values = json.split(":");
		boolean nextBezeichnung = false;
		boolean gotBezeichnung = false;
		for(String element: values) {
			if(nextBezeichnung && !gotBezeichnung) {
				gotBezeichnung = true;
				bezeichnung = getPlain(element);
			} else if(element.contains("bezeichnung")) {
				nextBezeichnung = true;
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
