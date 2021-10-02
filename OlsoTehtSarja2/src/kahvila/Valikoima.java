package kahvila;

import java.util.ArrayList;

/**
 *
 * @author Oma Nimesi
 */
public class Valikoima {

    // Esittele ArrayList tuotteiden tallettamiseksi
	private ArrayList<Tuote>tuotteet=new ArrayList<Tuote>();

    // Ohjelmoi getTuote()
	public Tuote getTuote(int tuotenumero) {
		int index=-1;
		for(int i=0;i<tuotteet.size();i++) {
		if(tuotteet.get(i).getTuotenumero()==tuotenumero) {
			index=i;
			return tuotteet.get(index);
		}}
		return null;
		}
	public Tuote getTuote(String nimi) {
		int index=-1;
		for(int i=0;i<tuotteet.size();i++) {
		if(tuotteet.get(i).getNimi()==nimi) {
			index=i;
			return tuotteet.get(index);
		}}
		return null;
	}

    // Ohjelmoi lisääTuote()
	public void lisaaTuote(Tuote tuote) {
		for(int i=0;i<tuotteet.size();i++) {
		if(tuotteet.get(i)==tuote) {
			return;
		}
		}
		tuotteet.add(tuote);
	}

    // Ohjelmoi poistaTuote()
	public boolean poistaTuote(int tuotenumero) {
		boolean temp=false;
		for(int i=0;i<tuotteet.size();i++) {
			if(tuotteet.get(i).getTuotenumero()==tuotenumero) {
				tuotteet.remove(i);
				temp=true;
				}
			}
		return temp;	
	}

    // Poistettava Tuote-olio pitää etsiä listasta tuotenumerolla,
    // koska poistojen jälkeen tuotenumero != listan indeksi

    // Ohjelmoi toString(), joka on merkkijonoesitys Valikoima-oliosta (eli kaikista tuotteista)
	public String toString() {
		String kaikki="";
		for(Tuote x:tuotteet) {
			kaikki=kaikki+x.getNimi()+"\n";
		}
		return kaikki;
	}
}
