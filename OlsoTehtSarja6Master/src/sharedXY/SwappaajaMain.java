package sharedXY;

/**
* @author Elyas
*/

public class SwappaajaMain {
	 public static void main(String args[]) {
		// Luo yhteiskäyttöinen tietorakenneolio
		 SharedXY testi=new SharedXY(5,10);
	
		
		// Luo useita Swappaaja-säikeitä
		 Swappaaja swap1 = new Swappaaja(testi);
		 Swappaaja swap2 = new Swappaaja(testi);
		 Swappaaja swap3 = new Swappaaja(testi);
		 Swappaaja swap4 = new Swappaaja(testi);
		 swap1.start();
		 swap2.start();
		 swap3.start();
		 swap4.start();
	 }
}