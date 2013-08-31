package de.tgehring.itdb.model;

public class Rechnung {
	
	private long id;
	private String rechnungsnummer;
	private double rechnungsbetrag;
	private String rechnungsdatum;
	
	public Rechnung() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRechnungsnummer() {
		return rechnungsnummer;
	}

	public void setRechnungsnummer(String rechnungsnummer) {
		this.rechnungsnummer = rechnungsnummer;
	}

	public double getRechnungsbetrag() {
		return rechnungsbetrag;
	}

	public void setRechnungsbetrag(double rechnungsbetrag) {
		this.rechnungsbetrag = rechnungsbetrag;
	}

	public String getRechnungsdatum() {
		return rechnungsdatum;
	}

	public void setRechnungsdatum(String rechnungsdatum) {
		this.rechnungsdatum = rechnungsdatum;
	}

	@Override
	public String toString() {
		return rechnungsnummer + " (" + rechnungsdatum + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rechnung other = (Rechnung) obj;
		if (id != other.id)
			return false;
		if (Double.doubleToLongBits(rechnungsbetrag) != Double
				.doubleToLongBits(other.rechnungsbetrag))
			return false;
		if (rechnungsdatum == null) {
			if (other.rechnungsdatum != null)
				return false;
		} else if (!rechnungsdatum.equals(other.rechnungsdatum))
			return false;
		if (rechnungsnummer == null) {
			if (other.rechnungsnummer != null)
				return false;
		} else if (!rechnungsnummer.equals(other.rechnungsnummer))
			return false;
		return true;
	}
	
}
