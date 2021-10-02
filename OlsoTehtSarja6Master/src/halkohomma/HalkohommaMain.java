package halkohomma;

/**
* @author Oma Nimesi
*/

public class HalkohommaMain { 
	public static void main(String args[]) {
	
	// Luo Halkovarasto
		Halkovarasto varasto=new Halkovarasto();
	// Luo useita Halonhakkaaja-säikeitä
		Halonhakkaaja hakkaaja=new Halonhakkaaja(varasto);
		Halonhakkaaja hakkaaja2=new Halonhakkaaja(varasto);
		Halonhakkaaja hakkaaja3=new Halonhakkaaja(varasto);
		Halonhakkaaja hakkaaja4=new Halonhakkaaja(varasto);
		hakkaaja.setName("1 hakkaja");
		hakkaaja2.setName("2 hakkaja");
		hakkaaja3.setName("3 hakkaja");
		hakkaaja4.setName("4 hakkaja");
		hakkaaja.start();
		hakkaaja2.start();
		hakkaaja3.start();
		hakkaaja4.start();
	// Luo useita Partiolainen säikeitä
		Partiolainen partio=new Partiolainen(varasto);
		Partiolainen partio2=new Partiolainen(varasto);
		Partiolainen partio3=new Partiolainen(varasto);
		Partiolainen partio4=new Partiolainen(varasto);
		partio.setName("1 Partio");
		partio2.setName("2 Partio");
		partio3.setName("3 Partio");
		partio4.setName("4 Partio");
		partio.start();
		partio2.start();
		partio3.start();
		partio4.start();
		
	// Tämä main() saa lopettaa.

	}
}