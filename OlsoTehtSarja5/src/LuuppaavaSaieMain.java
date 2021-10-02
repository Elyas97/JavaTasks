import saikeet.LuuppaavaSaie;

/**
* @author Oma Nimesi
*/

public class LuuppaavaSaieMain {
	public static void main(String[] args) {

    // Luo säie
		LuuppaavaSaie minunSaie=new LuuppaavaSaie(3);
	
	// Tulosta aluksi kierrettyjen kierrosten lukumäärä
		System.out.println(minunSaie.getKierretytKierrokset());
		
	// Käynnistä säie
		minunSaie.start();
	
	// Odota säikeen päättymistä
		try {
			minunSaie.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	// Tulosta lopuksi säikeen kiertämien kierrosten lukumäärä
		System.out.println(minunSaie.getKierretytKierrokset());
	
	}
}
