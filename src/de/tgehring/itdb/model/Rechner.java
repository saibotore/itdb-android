package de.tgehring.itdb.model;


public class Rechner {

	private long id;
	private String computername;
	private String benutzer;
	private String cpu;
	private String gpu;
	private String ram;
	private String hdd1;
	private String hdd2;
	private String hdd3;
	private String hdd4;
	private String inventarnummer;
	private String gerätenummer;
	private String ip1;
	
	public Rechner() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(String benutzer) {
		this.benutzer = benutzer;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getGpu() {
		return gpu;
	}

	public void setGpu(String gpu) {
		this.gpu = gpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getHdd1() {
		return hdd1;
	}

	public void setHdd1(String hdd1) {
		this.hdd1 = hdd1;
	}

	public String getHdd2() {
		return hdd2;
	}

	public void setHdd2(String hdd2) {
		this.hdd2 = hdd2;
	}

	public String getHdd3() {
		return hdd3;
	}

	public void setHdd3(String hdd3) {
		this.hdd3 = hdd3;
	}

	public String getHdd4() {
		return hdd4;
	}

	public void setHdd4(String hdd4) {
		this.hdd4 = hdd4;
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

	public String getIp1() {
		return ip1;
	}

	public void setIp1(String ip1) {
		this.ip1 = ip1;
	}

	public String getComputername() {
		return computername;
	}

	public void setComputername(String computername) {
		this.computername = computername;
	}

	@Override
	public String toString() {
		return inventarnummer + ": " + computername;
	}
	
}
