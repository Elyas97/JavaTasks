import saikeet.OmaSaie;

/**
 * @author Oma nimesi
 */

public class OmaSaieMain {

	// Säiettä testaava pääohjelma
	public static void main(String[] args) throws InterruptedException {
		OmaSaie saie;
		System.out.println("Säiepääohjelma");

		// Luo OmaSaie alkuarvolla 15
		saie=new OmaSaie(15);
		
		// Tulosta alkuarvot
		System.out.println("Alkuarvot ovat " + saie.getLuku() + ", " + OmaSaie.getYhteisetAjokerrat());
		
		// Käynnistä säie ja odota sen päättymistä
		saie.start();
		saie.join();

		// Tulosta uudet arvot
		System.out.println("Uudet arvot ovat " + saie.getLuku() + ", " + OmaSaie.getYhteisetAjokerrat());

		// Luo uusi OmaSaie alkuarvolla 2020
		OmaSaie saie2=new OmaSaie(2020);
		// Tulosta alkuarvot
		System.out.println("Alkuarvot ovat " + saie2.getLuku() + ", " + OmaSaie.getYhteisetAjokerrat());

		// Käynnistä säie ja odota sen päättymistä
		saie2.start();
		saie2.join();

		// Tulosta uudet arvot
		System.out.println("Uudet arvot ovat " + saie2.getLuku() + ", " + OmaSaie.getYhteisetAjokerrat());

	}

}
