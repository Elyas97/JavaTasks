package valtiot;

/**
* @author laita tähän nimesi ja päiväys
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ValtioMain {

	public static void main(String[] args) {

		// Valtioiden käsittelyssä tarvittavat muuttujat ja
		// HashMap-olio Valtio-olioiden tallentamiseksi
		Valtio valtio;
		String nimi = null;
		String pääkaupunki;
		int asukasluku=0;
		HashMap<String, Valtio> valtiot = new HashMap<>();
		final String TIEDOSTONIMI = "valtiot.dat";
		
		Scanner näppis = new Scanner(System.in);
		
		/* Jos tiedosto on olemassa, lue HashMap sieltä 
		valtiot = TiedostonKäsittely.lueTiedosto(TIEDOSTONIMI);
		if (valtiot == null) {
			valtiot = new HashMap<>();
		}
		*/
		
		// Lue valtioiden tietoja ja lisää valtioita HashMapiin, 
		// kunnes syötteenä annetaan tyhjä 
		String userInput="";
		do {
			System.out.println("Syötä valtion nimi");
			userInput=näppis.nextLine();
			if(userInput.equalsIgnoreCase(nimi)) {
				System.out.println("Olet jo syöttänyt Valtion nimen");
				break;
			}
			if(userInput.isBlank()) {
				System.out.println("Syötteesi on tyhjä");
				break;
			}
			nimi=userInput;
			
			System.out.println("Syötä valtion pääkaupunki");
			userInput=näppis.nextLine();
			if(userInput.equalsIgnoreCase(nimi)) {
				System.out.println("Olet jo syöttänyt Pääkaupungin nimen");
				break;
			}
			if(userInput.isBlank()) {
				System.out.println("Syötteesi on tyhjä");
				break;
			}
			pääkaupunki=userInput;
			
			System.out.println("Syötä asukasluku");
			userInput=näppis.nextLine();
			if(userInput.isBlank()) {
				System.out.println("Syötteesi on tyhjä");
				break;
			}
			try {
			asukasluku=Integer.parseInt(userInput);
			}
			catch(NumberFormatException e) {
				System.out.println("Syötteesi"+userInput+". Ei ole kelvollinen asukasluvulle");
			}
			valtiot.put(nimi, new Valtio(nimi, pääkaupunki, asukasluku));

		} while (nimi.length() != 0);
		
        // Tulosta HashMapin sisältö, käytä for-each- rakennetta
		System.out.println("HashMapissa nyt seuraavat valtiot:");
	    for (HashMap.Entry<String, Valtio>x:valtiot.entrySet() ) {
	         System.out.println(x.getKey()+" "+x.getValue());
	      }

		// Kirjoita HashMap tiedostoon
		TiedostonKasittely.kirjoitaTiedosto(TIEDOSTONIMI, valtiot);
    
		näppis.close();	
	}
}
