package de.tgehring.itdb.model.json;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import de.tgehring.itdb.model.Rechner;

public class RechnerParser implements ListParser<Rechner> {

	private JSONArray arrayParser;
	
	public RechnerParser(String json) {
		try {
			JSONObject jsonResponse = new JSONObject(json);
			this.arrayParser = jsonResponse.getJSONArray("rechner");
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public JSONObject getJSON(int i) {
		try {
			return arrayParser.getJSONObject(i);
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Rechner getEntity(int i) {
		try {
			JSONObject rechnerJSON = getJSON(i);
			JSONArray names = rechnerJSON.names();
			Rechner rechner = new Rechner();
			for(int pos=0; pos<names.length(); pos++) {
				String name = names.getString(pos);
				if(name.equals("id")) {
					rechner.setId(Long.parseLong(rechnerJSON.getString("id")));
				} else if(name.equals("computername")) {
					rechner.setComputername(rechnerJSON.getString("computername"));
				} else if(name.equals("benutzer")) {
					BenutzerParser bp = new BenutzerParser(rechnerJSON.getString("benutzer"));
					rechner.setBenutzer(bp.getValue());
				} else if(name.equals("cpu")) {
					CpuParser cp = new CpuParser(rechnerJSON.getString("cpu"));
					rechner.setCpu(cp.getValue());
				} else if(name.equals("gpu")) {
					GpuParser gp = new GpuParser(rechnerJSON.getString("gpu"));
					rechner.setGpu(gp.getValue());
				} else if(name.equals("ram")) {
					rechner.setRam(rechnerJSON.getString("ram"));
				} else if(name.equals("hdd1")) {
					rechner.setHdd1(rechnerJSON.getString("hdd1"));
				} else if(name.equals("hdd2")) {
					rechner.setHdd2(rechnerJSON.getString("hdd2"));
				} else if(name.equals("hdd3")) {
					rechner.setHdd3(rechnerJSON.getString("hdd3"));
				} else if(name.equals("hdd4")) {
					rechner.setHdd4(rechnerJSON.getString("hdd4"));
				} else if(name.equals("inventarnummer")) {
					rechner.setInventarnummer(rechnerJSON.getString("inventarnummer"));
				} else if(name.equals("gerätenummer")) {
					rechner.setGerätenummer(rechnerJSON.getString("gerätenummer"));
				} else if(name.equals("ip1")) {
					rechner.setIp1(rechnerJSON.getString("ip1"));
				}
			}
			return rechner;
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Rechner> getEntities() {
		List<Rechner> result = new LinkedList<Rechner>();
		for (int i=0; i < arrayParser.length(); i++) {
			result.add(getEntity(i));
		}
		return result;
	}

}
