package valtiot;

/**
* @author laita tähän nimesi ja päiväys
*/

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TiedostonKasittely{
 
	// Kirjoittaa tiedostoon yhden HashMap-olio, jossa Valtio-olioita
	public static void kirjoitaTiedosto(String tiedostoNimi, HashMap<String, Valtio> valtiot) {
		
		// Avaa FileOutputStream-tulostusvirta tiedostoon ja
		// Luo objektivirta tiedostoon kirjoittamista varten

		try (FileOutputStream virta = new FileOutputStream(tiedostoNimi);
			ObjectOutputStream valtioTiedosto = new ObjectOutputStream(virta) ;){

			// Kirjoita HashMap objektivirtaan  
			valtioTiedosto.writeObject(valtiot);
			valtioTiedosto.close();
			
			System.out.println("Tiedot tallennettu (HashMap) tiedostoon " + tiedostoNimi);
		} catch (IOException ex) {
			System.out.println(tiedostoNimi + "-tiedostoon tallentaminen ei onnistunut");
		}
		// try-with-resources sulkee lopuksi resurssit automaattisesti
	}

	/* Lukee tiedostosta HashMap-olion, jossa Valtio-olioita
     * Palauttaa HashMapin tai null, jos listaa ei pystytä muodostamaan
	 */
	@SuppressWarnings("unchecked")
	public static HashMap<String, Valtio> lueTiedosto(String tiedostoNimi) {
		HashMap<String, Valtio> valtiot=null;

		// Avaa FileInputStream-lukuvirta tiedostoon ja
		// Luo objektivirta tiedostosta lukemista varten
		try (FileInputStream virta = new FileInputStream(tiedostoNimi);
			ObjectInputStream valtioTiedosto = new ObjectInputStream(virta);){

			// Lue tiedoston sisältö
			valtiot=  (HashMap<String, Valtio>) valtioTiedosto.readObject();
			System.out.println("Tiedot haettu tiedostosta " + tiedostoNimi);
		
		} catch (FileNotFoundException ex) {
			System.out.println("Tiedostoa " + tiedostoNimi + " ei ole olemassa.");
			
		} catch (Exception ex) {
			System.out.println(tiedostoNimi + "-tiedostosta (HashMap) lukeminen ei onnistunut.");
			
		}
		return valtiot;
	}

}
