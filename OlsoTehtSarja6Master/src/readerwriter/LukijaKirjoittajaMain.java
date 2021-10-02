package readerwriter;

public class LukijaKirjoittajaMain {
	public static void main(String[] args) {
		IntSailio sailio = new IntSailio();

		Kirjoittaja kirjoittaja = new Kirjoittaja(sailio);
		Lukija lukija = new Lukija(sailio);

		kirjoittaja.start();
		lukija.start();
		
		// Kokeile ensin kuinka sujuu yhdellä kirjoittajalla ja yhdellä lukijalla
		 
		// Luo sitten vielä kaksi uutta lukijaa, eli kokeile tilannetta,
		// jossa on yksi kirjoittajasäie ja kolme lukijasäiettä
		Lukija lukija2=new Lukija(sailio);
		Lukija lukija3=new Lukija(sailio);
		lukija2.start();
		lukija3.start();
		
		// main-säie kuolee pois, mutta sen luomat säikeet jatkavat
	}
}
