import saikeet.Juoksija;
import saikeet.OmaSaie;

/**
* @author Oma Nimesi
*/

public class JuoksijaMain {
	public static void main(String[] args) {

	// Luo ja käynnistä Juoksija-säie
		Juoksija omaSaie=new Juoksija();
		omaSaie.start();
		
	// Odota jonkun aikaa: Thread.sleep()
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	// Pysäytä säie
	omaSaie.lopeta();
	
	// Hae ja tulosta juostujen kerrosten määrä
	System.out.println(omaSaie.getKierrokset());
	
	}
}
