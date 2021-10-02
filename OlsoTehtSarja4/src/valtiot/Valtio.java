package valtiot;

import java.io.Serializable;

/**
* @author laita tähän nimesi ja päiväys
*/

public class Valtio  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	// Selvitä itsellesi www-haulla mikä on ylläolevan merkitys/tarve
		
	private String nimi;
	private String pääkaupunki;
	private int asukasluku;
	public Valtio(String nimi,String pääkaupunki,int asukasluku) {
		this.nimi=nimi;
		this.pääkaupunki=pääkaupunki;
		this.asukasluku=asukasluku;
	}
	
	// Lisää getterit ja setterit
	public String getNimi() {
		return this.nimi;
	};
	public String getPääkaupunki() {
		return this.pääkaupunki;
	}
	public int getAsukasluku() {
		return this.asukasluku;
	}
	public void setNimi(String nimi) {
		 this.nimi=nimi;
	};
	public void setPääkaupunki(String pääkaupunki) {
		 this.pääkaupunki=pääkaupunki;
	};
	public void setAsukasluku(int asukasluku) {
		this.asukasluku=asukasluku;
	};
	// Lisää toString()
	public String toString() {
		return String.format("%-10s %-10s %-10d", this.nimi, this.pääkaupunki, this.asukasluku);
	}
	// Saat tiedot sarakkeittain String-luokan staattisella format-metodilla
	// esim. String.format("%-10s %-10s %-10d", nimi, pääkaupunki, asukasluku);
	
}
