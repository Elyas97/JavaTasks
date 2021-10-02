package model;

/**
 * @author Oma nimesi
 */
import javax.persistence.*;
 @Entity
 @Table(name="valuutat")
public class Valuutta {
	
	
	@Id
	@Column(name="tunnus")
	String tunnus;
	@Column(name="vaihtkurrsi")
	double vaihtokurssi;
	@Column(name="nimi")
	String nimi;
	public Valuutta(String tunnus, double vaihtokurssi,String nimi) {
		if(tunnus.length()<=3) {
		this.tunnus=tunnus.toUpperCase();
		}
		else if(tunnus.length()>3) {
			this.tunnus=tunnus.substring(0, 3).toUpperCase();
		}
		this.vaihtokurssi=vaihtokurssi;
		
		if(nimi.length()<=50) {		
			this.nimi=nimi;
		}
		else if(nimi.length()>50) {
			this.nimi=nimi.substring(0, 50);
		}
		
	}
	public Valuutta() {
		// TODO Auto-generated constructor stub
	}
	public String getTunnus() {
		return tunnus;
	}
	public void setTunnus(String tunnus) {
		if(tunnus.length()<=3) {
		this.tunnus = tunnus.toUpperCase();
		}else {
			this.tunnus=tunnus.substring(0,3).toUpperCase();
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
		if(nimi.length()<=50) {
		this.nimi = nimi;
		}else if(nimi.length()>50){
			this.nimi=nimi.substring(0, 50);
		}
	}
	
	
}
