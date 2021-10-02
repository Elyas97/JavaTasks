
import saikeet.Kilpajuoksija;

/**
* @author Oma nimesi
*/

public class KilpailuMain {

	private static int KILPAILIJALKM = 8;
	
	public static void main(String[] args) {
		// Luo taulukko juoksijoita varten
		Kilpajuoksija[] juoksijat=new Kilpajuoksija[8];
		
		// Luo juoksijasäikeet
	
		// Pistä poppoo juoksemaan
		for(int i=0;i<juoksijat.length;i++) {
			juoksijat[i]=new Kilpajuoksija();
			juoksijat[i].start();
			
		}

		// Odota, että kaikki juoksijasäikeet lopettavat
		for(Kilpajuoksija x:juoksijat) {
			try {
				x.join();
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
		
		}
		System.out.println("Kilpailu on ohi, onnea voittajalle.");
	}
}
