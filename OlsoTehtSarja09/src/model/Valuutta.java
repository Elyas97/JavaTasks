package model;

public class Valuutta {
	private String nimi;
	private double vaihtokurssi;
	public Valuutta(String nimi,double vaihtokurssi) {
		this.nimi=nimi;
		this.vaihtokurssi=vaihtokurssi;
	}
	public double getVaihtokurssi() {
		return vaihtokurssi;
	}
	public void setVaihtokurssi(double vahtokurssi) {
		this.vaihtokurssi = vahtokurssi;
	}
	public String getNimi() {
		return nimi;
	}
	
	
	

}
