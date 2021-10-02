package kahvila;

/**
 *
 * @author Oma Nimesi
 */
public class Tilausrivi {

    // Esittele instanssimuuttujat
	private Tuote tuote;
	private int maara;
    // Ohjelmoi kolmen parametrin konstruktori 
	public Tilausrivi(Valikoima valikoima,int tuotenumero,int maara) {
		this.tuote=valikoima.getTuote(tuotenumero);
		this.maara=maara;
	}
         
    // Ohjelmoi annaSumma()
	public double annaSumma() {
		return tuote.getHinta()*maara;
	}
	
    // Ohjelmoi toString(), joka palautta merkkijonoesityksen Tilausrivi-oliosta
	public String toString() {
		return ""+tuote+" Tuotteiden määrä:"+ maara+". Hinta:"+annaSumma();
	}
}
