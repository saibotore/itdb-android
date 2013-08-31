package de.tgehring.itdb.model;

public class Lieferant {

	private long id;
	private String bezeichnung;
	private String strasse;
	private String plz;
	private String ort;
	private String postfach;
	private String url;
	private String telefon;
	private String fax;
	private String hotline;
	private String kundennummer;
	private String lkz;
	
	public Lieferant() {
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	public String getStrasse() {
		return strasse;
	}
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	public String getPlz() {
		return plz;
	}
	public void setPlz(String plz) {
		this.plz = plz;
	}
	public String getOrt() {
		return ort;
	}
	public void setOrt(String ort) {
		this.ort = ort;
	}
	public String getPostfach() {
		return postfach;
	}
	public void setPostfach(String postfach) {
		this.postfach = postfach;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getHotline() {
		return hotline;
	}
	public void setHotline(String hotline) {
		this.hotline = hotline;
	}
	public String getKundennummer() {
		return kundennummer;
	}
	public void setKundennummer(String kundennummer) {
		this.kundennummer = kundennummer;
	}
	public String getLkz() {
		return lkz;
	}
	public void setLkz(String lkz) {
		this.lkz = lkz;
	}
	
	@Override
	public String toString() {
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
		Lieferant other = (Lieferant) obj;
		if (bezeichnung == null) {
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (hotline == null) {
			if (other.hotline != null)
				return false;
		} else if (!hotline.equals(other.hotline))
			return false;
		if (id != other.id)
			return false;
		if (kundennummer == null) {
			if (other.kundennummer != null)
				return false;
		} else if (!kundennummer.equals(other.kundennummer))
			return false;
		if (lkz == null) {
			if (other.lkz != null)
				return false;
		} else if (!lkz.equals(other.lkz))
			return false;
		if (ort == null) {
			if (other.ort != null)
				return false;
		} else if (!ort.equals(other.ort))
			return false;
		if (plz == null) {
			if (other.plz != null)
				return false;
		} else if (!plz.equals(other.plz))
			return false;
		if (postfach == null) {
			if (other.postfach != null)
				return false;
		} else if (!postfach.equals(other.postfach))
			return false;
		if (strasse == null) {
			if (other.strasse != null)
				return false;
		} else if (!strasse.equals(other.strasse))
			return false;
		if (telefon == null) {
			if (other.telefon != null)
				return false;
		} else if (!telefon.equals(other.telefon))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
}
