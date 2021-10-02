package model;

/**
 * @author Oma nimesi
 */
 
public class Valuutta {
	// Nämä rajoitteet tulevat tietokannan schemasta
	public final int TUNNUS_MAX = 3;
	public final int NIMI_MAX = 50;
	String tunnus;
	double vaihtokurssi;
	String nimi;
	public Valuutta(String tunnus, double vaihtokurssi,String nimi) {
		if(tunnus.length()<=TUNNUS_MAX) {
		this.tunnus=tunnus.toUpperCase();
		}
		else if(tunnus.length()>TUNNUS_MAX) {
			this.tunnus=tunnus.substring(0, TUNNUS_MAX).toUpperCase();
		}
		this.vaihtokurssi=vaihtokurssi;
		
		if(nimi.length()<=NIMI_MAX) {		
			this.nimi=nimi;
		}
		else if(nimi.length()>NIMI_MAX) {
			this.nimi=nimi.substring(0, NIMI_MAX);
		}
		
	}
	public Valuutta() {
		// TODO Auto-generated constructor stub
	}
	public String getTunnus() {
		return tunnus;
	}
	public void setTunnus(String tunnus) {
		if(tunnus.length()<=TUNNUS_MAX) {
		this.tunnus = tunnus.toUpperCase();
		}else {
			this.tunnus=tunnus.substring(0,TUNNUS_MAX).toUpperCase();
		}
	}
	public double getVaihtokurssi() {
		return vaihtokurssi;
	}
	public void setVaihtokurssi(double vaihtokurssi) {
		this.vaihtokurssi = vaihtokurssi;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		if(nimi.length()<=NIMI_MAX) {
		this.nimi = nimi;
		}else if(nimi.length()>NIMI_MAX){
			this.nimi=nimi.substring(0, NIMI_MAX);
		}
	}
	
	
}
