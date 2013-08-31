package de.tgehring.itdb.model;

public class Hersteller {
	
	private long id;
	private String bezeichnung;
	private HerstellerTyp typ;
	
	public Hersteller() {
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public HerstellerTyp getTyp() {
		return typ;
	}
	public void setTyp(HerstellerTyp typ) {
		this.typ = typ;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	@Override
	public String toString() {
		String result = bezeichnung;
		if(typ != null) {
			result += " (" + typ.name() + ")";
		}
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hersteller other = (Hersteller) obj;
		if (bezeichnung == null) {
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
			return false;
		if (id != other.id)
			return false;
		if (typ != other.typ)
			return false;
		return true;
	}
	
}
