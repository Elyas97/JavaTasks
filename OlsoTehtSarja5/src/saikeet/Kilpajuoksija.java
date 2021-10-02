package saikeet;

import java.util.Random;

/**
* @author Oma Nimesi
*/

public class Kilpajuoksija extends Thread {
	private int numero; 				 // juoksijan numero

	private final int MATKA = 400; 		 // juostava matka, tässä vakio
	private double aika; 				 // sekunteina
	int valiaika=50;
	int juostu=0;
	Random r = new Random();
	private static int seuraavaNumero=1; // luokkamuuttuja juoksijoiden numeroimiseksi
	public Kilpajuoksija() {
		this.numero=seuraavaNumero;
		seuraavaNumero++;
	}
	public int getNumero() {
		return numero;
	}
	// Tee tälle muuttujalle set-metodi
	

	public static int getSeuraavaNumero() {
		return seuraavaNumero;
	}

	public static void setSeuraavaNumero(int seuraavaNumero) {
		Kilpajuoksija.seuraavaNumero = seuraavaNumero;
	}

	@Override
	public void run(){

	// Ohjelmoi toisto, jossa
	// - käytät satunnaislukugeneraattoria 10 metrin juoksuajan saamiseksi
	// - odotat ko. ajan
	// - tulostat väliaikatiedon 50 metrin välein
	
	while(juostu<MATKA) {
		
		double randomValue = 1.07575 + (1.375 - 1.07575) * r.nextDouble();
		aika=aika+randomValue;
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		juostu=juostu+10;
		if(juostu==valiaika) {
			System.out.println("Juoksija "+numero+". Juoksi "+ juostu+" metriä. Aika:"+aika);
			valiaika=valiaika+50;
		}
	}
	}

	public double getAika(){
		 	
		return aika; 
	}
}
