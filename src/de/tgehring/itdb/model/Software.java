package de.tgehring.itdb.model;

public class Software {

	private long id;
	private Lieferant lieferant;
	private Rechnung rechnung;
	private String softwarenummer;
	private int maxLizenzen;
	private int anzahlLizenzen;
	private String bezeichnung;
	
	public Software() {
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getSoftwarenummer() {
		return softwarenummer;
	}
	public void setSoftwarenummer(String softwarenummer) {
		this.softwarenummer = softwarenummer;
	}
	public int getMaxLizenzen() {
		return maxLizenzen;
	}
	public void setMaxLizenzen(int maxLizenzen) {
		this.maxLizenzen = maxLizenzen;
	}
	public int getAnzahlLizenzen() {
		return anzahlLizenzen;
	}
	public void setAnzahlLizenzen(int anzahlLizenzen) {
		this.anzahlLizenzen = anzahlLizenzen;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Software other = (Software) obj;
		if (anzahlLizenzen != other.anzahlLizenzen)
			return false;
		if (bezeichnung == null) {
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
			return false;
		if (id != other.id)
			return false;
		if (lieferant == null) {
			if (other.lieferant != null)
				return false;
		} else if (!lieferant.equals(other.lieferant))
			return false;
		if (maxLizenzen != other.maxLizenzen)
			return false;
		if (rechnung == null) {
			if (other.rechnung != null)
				return false;
		} else if (!rechnung.equals(other.rechnung))
			return false;
		if (softwarenummer == null) {
			if (other.softwarenummer != null)
				return false;
		} else if (!softwarenummer.equals(other.softwarenummer))
			return false;
		return true;
	}
	
}
