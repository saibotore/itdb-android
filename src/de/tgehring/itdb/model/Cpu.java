package de.tgehring.itdb.model;

public class Cpu {

	private long id;
	private Hersteller hersteller;
	private Lieferant lieferant;
	private Rechnung rechnung;
	private String sockel;
	private String taktung;
	private String bezeichnung;
	
	public Cpu() {
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Hersteller getHersteller() {
		return hersteller;
	}
	public void setHersteller(Hersteller hersteller) {
		this.hersteller = hersteller;
	}
	public Lieferant getLieferant() {
		return lieferant;
	}
	public void setLieferant(Lieferant lieferant) {
		this.lieferant = lieferant;
	}
	public Rechnung getRechnung() {
		return rechnung;
	}
	public void setRechnung(Rechnung rechnung) {
		this.rechnung = rechnung;
	}
	public String getSockel() {
		return sockel;
	}
	public void setSockel(String sockel) {
		this.sockel = sockel;
	}
	public String getTaktung() {
		return taktung;
	}
	public void setTaktung(String taktung) {
		this.taktung = taktung;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
	@Override
	public String toString() {
		if(hersteller != null) {
			return hersteller + ": " + bezeichnung;
		}
		return bezeichnung;
	}

}
