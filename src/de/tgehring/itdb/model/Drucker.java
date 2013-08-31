package de.tgehring.itdb.model;

public class Drucker {

	private long id;
	private Hersteller hersteller;
	private Lieferant lieferant;
	private Rechnung rechnung;
	private Dvm material;
	private String inventarnummer;
	private String gerätenummer;
	private String bezeichnung;
	
	public Drucker() {
		
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
	public Dvm getMaterial() {
		return material;
	}
	public void setMaterial(Dvm material) {
		this.material = material;
	}
	public String getInventarnummer() {
		return inventarnummer;
	}
	public void setInventarnummer(String inventarnummer) {
		this.inventarnummer = inventarnummer;
	}
	public String getGerätenummer() {
		return gerätenummer;
	}
	public void setGerätenummer(String gerätenummer) {
		this.gerätenummer = gerätenummer;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
	@Override
	public String toString() {
		return inventarnummer + ": " + bezeichnung;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Drucker other = (Drucker) obj;
		if (bezeichnung == null) {
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
			return false;
		if (gerätenummer == null) {
			if (other.gerätenummer != null)
				return false;
		} else if (!gerätenummer.equals(other.gerätenummer))
			return false;
		if (hersteller == null) {
			if (other.hersteller != null)
				return false;
		} else if (!hersteller.equals(other.hersteller))
			return false;
		if (id != other.id)
			return false;
		if (inventarnummer == null) {
			if (other.inventarnummer != null)
				return false;
		} else if (!inventarnummer.equals(other.inventarnummer))
			return false;
		if (lieferant == null) {
			if (other.lieferant != null)
				return false;
		} else if (!lieferant.equals(other.lieferant))
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (rechnung == null) {
			if (other.rechnung != null)
				return false;
		} else if (!rechnung.equals(other.rechnung))
			return false;
		return true;
	}
	
	
	
}