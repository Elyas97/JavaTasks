package saikeet;

/**
* @author Oma Nimesi
*/

public class OmaSaie extends Thread {
	// Näkyvyysmääre private: näkyvät vain tähän luokkaan
	private int luku;
	private static int yhteisetAjokerrat = 0;

	// Kirjoita set- ja get-metodit staattisen muuttujan arvon asettamiseksi ja kysymiseksi
		
	
	public static int getYhteisetAjokerrat() {
		return yhteisetAjokerrat;
	}

	public static void setYhteisetAjokerrat(int yhteisetAjokerrat) {
		OmaSaie.yhteisetAjokerrat = yhteisetAjokerrat;
	}

	//Kirjoita parametriton konstruktori, joka ei tee mitään
	public OmaSaie() {
		luku=0;
	}

	// Kirjoita parametrillinen konstruktori, joka asettaa arvon instanssimuuttujalle luku
	public OmaSaie(int luku) {
		this.luku=luku;
	}
  
	// Kirjoita getterit ja setterit
	public int getLuku() {
		return luku;
	}

	public void setLuku(int luku) {
		this.luku = luku;
	}
  
	// Kirjoita metodi run(), joka kasvattaa kummankin muuttujan arvoa yhdellä  
	public void run() {
		this.luku=luku+1;
		OmaSaie.yhteisetAjokerrat=yhteisetAjokerrat+1;
	}
}
