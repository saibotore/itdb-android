package de.tgehring.itdb.model;

public class Gpu {
	
	private long id;
	private Hersteller hersteller;
	private Lieferant lieferant;
	private Rechnung rechnung;
	private String schnittstelle;
	private String speicher;
	private String bezeichnung;
	
	public Gpu() {
		
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
	public String getSchnittstelle() {
		return schnittstelle;
	}
	public void setSchnittstelle(String schnittstelle) {
		this.schnittstelle = schnittstelle;
	}
	public String getSpeicher() {
		return speicher;
	}
	public void setSpeicher(String speicher) {
		this.speicher = speicher;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gpu other = (Gpu) obj;
		if (bezeichnung == null) {
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
			return false;
		if (hersteller == null) {
			if (other.hersteller != null)
				return false;
		} else if (!hersteller.equals(other.hersteller))
			return false;
		if (id != other.id)
			return false;
		if (lieferant == null) {
			if (other.lieferant != null)
				return false;
		} else if (!lieferant.equals(other.lieferant))
			return false;
		if (rechnung == null) {
			if (other.rechnung != null)
				return false;
		} else if (!rechnung.equals(other.rechnung))
			return false;
		if (schnittstelle == null) {
			if (other.schnittstelle != null)
				return false;
		} else if (!schnittstelle.equals(other.schnittstelle))
			return false;
		if (speicher == null) {
			if (other.speicher != null)
				return false;
		} else if (!speicher.equals(other.speicher))
			return false;
		return true;
	}
	
}
