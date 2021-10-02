import kahvila.*;

/**
 *
 * @author Laita tähän oma nimesi ja päiväys
 */

public class Main {

    public static void main(String[] args) {

    // Esittele tarvittavat muuttujat.
    	Valikoima valikoima;
    	Tuote tuote;

    // Luo kolme tuotetta.
    	tuote=new Tuote("Juusto",1);
    	Tuote tuote2=new Tuote("liha",3.5);
    	Tuote tuote3=new Tuote("kala",5);

    // Lisää ne valikoimaan.
    	valikoima=new Valikoima();
    	valikoima.lisaaTuote(tuote);
    	valikoima.lisaaTuote(tuote2);
    	valikoima.lisaaTuote(tuote3);

    // Tulosta valikoima.
    	System.out.println(valikoima);

    // Poista siitä yksi tuote.
    	valikoima.poistaTuote(3);

    // Tulosta muuttunut valikoima.
    	System.out.println(valikoima);
    // Luo tilaus.
    	Tilaus tilaus=new Tilaus();

    // Luo kaksi tilausriviä.
    	Tilausrivi tilaukset=new Tilausrivi(valikoima,1,3);
    	Tilausrivi tilaukset2=new Tilausrivi(valikoima,2,3);
    // Lisää tilausrivit tilaukseen.
        tilaus.lisaaRiviTilaukseen(tilaukset);
        tilaus.lisaaRiviTilaukseen(tilaukset2);
    

    // Lisää tilaus kahvilan tilauslistaan.
        Kahvila kahvila=new Kahvila(valikoima);
        kahvila.lisaaTilaus(tilaus);

    // Luo toinenkin tilaus tilausriveineen.
        Tilaus tilaus2=new Tilaus();
        Tilausrivi tilaukset3=new Tilausrivi(valikoima,1,4);
        Tilausrivi tilaukset4=new Tilausrivi(valikoima,2,6);
        tilaus2.lisaaRiviTilaukseen(tilaukset3);
        tilaus2.lisaaRiviTilaukseen(tilaukset4);
        kahvila.lisaaTilaus(tilaus2);

    // Tulosta kaikki kahvilan tilaukset.
        System.out.println(kahvila);

    }
}
