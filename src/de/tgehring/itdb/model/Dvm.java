package de.tgehring.itdb.model;

public class Dvm {
	
	private long id;
	private Lieferant lieferant;
	private Rechnung rechnung;
	private String schwarzgross;
	private String schwarz;
	private String colorpack;
	private String cyan;
	private String magenta;
	private String yellow;
	private String tonerbezeichnung;
	private String leitereinheit;
	
	public Dvm() {
		
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

	public String getSchwarzgross() {
		return schwarzgross;
	}

	public void setSchwarzgross(String schwarzgross) {
		this.schwarzgross = schwarzgross;
	}

	public String getSchwarz() {
		return schwarz;
	}

	public void setSchwarz(String schwarz) {
		this.schwarz = schwarz;
	}

	public String getColorpack() {
		return colorpack;
	}

	public void setColorpack(String colorpack) {
		this.colorpack = colorpack;
	}

	public String getCyan() {
		return cyan;
	}

	public void setCyan(String cyan) {
		this.cyan = cyan;
	}

	public String getMagenta() {
		return magenta;
	}

	public void setMagenta(String magenta) {
		this.magenta = magenta;
	}

	public String getYellow() {
		return yellow;
	}

	public void setYellow(String yellow) {
		this.yellow = yellow;
	}

	public String getTonerbezeichnung() {
		return tonerbezeichnung;
	}

	public void setTonerbezeichnung(String tonerbezeichnung) {
		this.tonerbezeichnung = tonerbezeichnung;
	}

	public String getLeitereinheit() {
		return leitereinheit;
	}

	public void setLeitereinheit(String leitereinheit) {
		this.leitereinheit = leitereinheit;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dvm other = (Dvm) obj;
		if (colorpack == null) {
			if (other.colorpack != null)
				return false;
		} else if (!colorpack.equals(other.colorpack))
			return false;
		if (cyan == null) {
			if (other.cyan != null)
				return false;
		} else if (!cyan.equals(other.cyan))
			return false;
		if (id != other.id)
			return false;
		if (leitereinheit == null) {
			if (other.leitereinheit != null)
				return false;
		} else if (!leitereinheit.equals(other.leitereinheit))
			return false;
		if (lieferant == null) {
			if (other.lieferant != null)
				return false;
		} else if (!lieferant.equals(other.lieferant))
			return false;
		if (magenta == null) {
			if (other.magenta != null)
				return false;
		} else if (!magenta.equals(other.magenta))
			return false;
		if (rechnung == null) {
			if (other.rechnung != null)
				return false;
		} else if (!rechnung.equals(other.rechnung))
			return false;
		if (schwarz == null) {
			if (other.schwarz != null)
				return false;
		} else if (!schwarz.equals(other.schwarz))
			return false;
		if (schwarzgross == null) {
			if (other.schwarzgross != null)
				return false;
		} else if (!schwarzgross.equals(other.schwarzgross))
			return false;
		if (tonerbezeichnung == null) {
			if (other.tonerbezeichnung != null)
				return false;
		} else if (!tonerbezeichnung.equals(other.tonerbezeichnung))
			return false;
		if (yellow == null) {
			if (other.yellow != null)
				return false;
		} else if (!yellow.equals(other.yellow))
			return false;
		return true;
	}
	
}
