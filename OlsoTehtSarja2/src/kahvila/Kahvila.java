package kahvila;

import java.util.ArrayList;

/**
 *
 * @author Elyas Addawe
 */
public class Kahvila {

    // Esittele instanssimuuttuja valikoiman ja tilausten tallettamiseksi (ArrayList)
	Valikoima valikoima;
	ArrayList <Tilaus> lista1=new ArrayList<Tilaus>();

    // Ohjelmoi yhden parametrin konstruktori
	public Kahvila(Valikoima valikoima) {
		this.valikoima=valikoima;
	}
    // Ohjelmoi lisääTilaus()
	public void lisaaTilaus(Tilaus tilaus) {
		lista1.add(tilaus);
	}

    // Ohjelmoi toString(), joka palauttaa merkkijonoesityksen KAhvila-oliosta
	public String toString() {
		String temp=" ";
		for(Tilaus x:lista1) {
			temp=temp+x+"\n";
		}
		return temp;
	}

}
