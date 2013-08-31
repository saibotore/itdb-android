package de.tgehring.itdb.model;

public class Tablet {

	private long id;
	private Benutzer benutzer;
	private Hersteller hersteller;
	private Lieferant lieferant;
	private Rechnung rechnung;
	private String bezeichnung;
	private String ip;
	private String subnet;
	private String gateway;
	private String dnsPrimary;
	private String dnsSecondary;

	public Tablet() {
		
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
	public Benutzer getBenutzer() {
		return benutzer;
	}
	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
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
	public String getBezeichnung() {
		return bezeichnung;
	}
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getSubnet() {
		return subnet;
	}
	public void setSubnet(String subnet) {
		this.subnet = subnet;
	}
	public String getGateway() {
		return gateway;
	}
	public void setGateway(String gateway) {
		this.gateway = gateway;
	}
	public String getDnsPrimary() {
		return dnsPrimary;
	}
	public void setDnsPrimary(String dnsPrimary) {
		this.dnsPrimary = dnsPrimary;
	}
	public String getDnsSecondary() {
		return dnsSecondary;
	}
	public void setDnsSecondary(String dnsSecondary) {
		this.dnsSecondary = dnsSecondary;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tablet other = (Tablet) obj;
		if (benutzer == null) {
			if (other.benutzer != null)
				return false;
		} else if (!benutzer.equals(other.benutzer))
			return false;
		if (bezeichnung == null) {
			if (other.bezeichnung != null)
				return false;
		} else if (!bezeichnung.equals(other.bezeichnung))
			return false;
		if (dnsPrimary == null) {
			if (other.dnsPrimary != null)
				return false;
		} else if (!dnsPrimary.equals(other.dnsPrimary))
			return false;
		if (dnsSecondary == null) {
			if (other.dnsSecondary != null)
				return false;
		} else if (!dnsSecondary.equals(other.dnsSecondary))
			return false;
		if (gateway == null) {
			if (other.gateway != null)
				return false;
		} else if (!gateway.equals(other.gateway))
			return false;
		if (hersteller == null) {
			if (other.hersteller != null)
				return false;
		} else if (!hersteller.equals(other.hersteller))
			return false;
		if (id != other.id)
			return false;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
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
		if (subnet == null) {
			if (other.subnet != null)
				return false;
		} else if (!subnet.equals(other.subnet))
			return false;
		return true;
	}
	
}
