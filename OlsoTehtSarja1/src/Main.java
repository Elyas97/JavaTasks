import pokerikadet.Kasi;

import pokerikadet.Pakka;


/**
*
* @author Laita tähän oman nimesi ja päiväys
*/

public class Main {

    public static void main(String[] args) {
    	
    	// Luo pakka
    		
    		
    		
    	// Sekoita pakka
    		
    		
    	// Jaa käsi
    	

    	//Näytä (tulosta) käsi
  

    	// Tarkasta onko väri
    		boolean check=true;
    		while(check) {
    			Pakka toka=new Pakka();
    			toka.sekoita();
    			Kasi kasi=new Kasi(toka);
    			if(kasi.annaArvo()==2) {
    				System.out.println(kasi +"Löytyi väri"+". toistoja:" +kasi.kierrokset());
    				check=false;
    				break;
    			}
    		}
    
}
}