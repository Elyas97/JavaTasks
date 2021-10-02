package kahvila;

import java.util.ArrayList;

/**
 *
 * @author Oma Nimesi
 */
public class Tilaus {

    // Esittele ArrayList tilausrivien tallettamiseksi
	private ArrayList<Tilausrivi>lista=new ArrayList<Tilausrivi>();

    // Ohjelmoi lisääRiviTilaukseen()
	public void lisaaRiviTilaukseen(Tilausrivi tilausrivi) {
		lista.add(tilausrivi);
	}

    // Ohjelmoi annaLoppusumma()
	public double annaLoppusumma() {
		double sum=0;
		for(Tilausrivi x:lista) {
			sum= sum+x.annaSumma();
			
		}
		return sum;
	}
	
    // Ohjelmoi toString, joka palauttaa merkkijonoesityksen yhdestä Tilaus-oliosta¨
	public String toString() {
		String temp="";
		for(Tilausrivi x:lista) {
			temp=temp+ x+"\n";
			
		}
		return temp+" .Loppusumma"+annaLoppusumma();
	}

}
