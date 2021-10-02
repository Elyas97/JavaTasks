package pokerikadet;

import java.util.Collections;

/**
*
* @author Elyas Addawe 15.1.2021
*/
public class Pakka {

     final static int KORTTILKM = 53;
	// Näiden näkyvyys: pakkauksen sisällä (ei private, ei public)
    // Viittaus muista luokista Luokka.tunnus, esim. Pakka.KORTTILKM

    // Esittele instanssimuuttujat
     private Kortti[] kortit;
     Kortti kortti;
     int temp=1;
     int vuorossa=0;

    // Kirjoita konstruktori, joka alustaa pakan Kortti-olioilla
     public Pakka(){
    	 
    	 kortit =new Kortti[KORTTILKM];
    	 for(int maa=kortti.HERTTA;maa<=kortti.PATA;maa++) {
    		for(int numerot=1;numerot<=13;numerot++) {
    		 kortit[temp]=new Kortti(maa,numerot);
    		 temp++;
    		 }
    		 
    		 
    	 }
    	 
    	
    	}
     public String toString() {
    	
    	return "the amount is "+kortit.length;
     }

    // Kirjoita metodi sekoita()
     //tuli tuplia korjaa bugi;
     public void sekoita() {
    	 for(int i =1;i<kortit.length;i++) {
    	int randomi=(int)(Math.random()*52)+1;
    	Kortti temp=kortit[randomi];
    	kortit[randomi]=kortit[i]; 
    	kortit[i]=temp;//vaihtuu paikat
 }
    	
    		 
     }
     
     

    // Kirjoita metodi annaKortti()
     public Kortti annaKortti() {
    	if(vuorossa>52) {
    		vuorossa=0;
    		
    	
    	}
    	 vuorossa++;
    	return kortit[vuorossa];
    	 
		
    	}
}
