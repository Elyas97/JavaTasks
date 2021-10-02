import java.util.Scanner;

/**
* @author laita tähän nimesi ja päiväys
*/

public class Poikkeus {

	public static void main(String[] args) {

	    System.out.println("Tehtävä 1: Poikkeuksen testaaminen");
	    	
		// Esittele tarvittavat muuttujat
	    
	    Scanner scanner=new Scanner(System.in);
	   String userInput = null;
	   int age = 0;
	   while(true) {
		// Ohjelmoi try-catch-lohko 
		try {
			System.out.println("Anna ikäsi");
			userInput=scanner.nextLine();
			age=Integer.parseInt(userInput);
			System.out.println("Vuoden päästä olet jo "+age+" vuotias");
			break;
		}
		catch(NumberFormatException e){
			System.out.println("Antamasi ikä "+userInput+". Ei kelvannut.Syötä numero");
		}
	    // Kysy ikä ja lue se merkkijonomuuttujaan

	    // Tee muunnos  
		// - jos muunnos onnistuu, näytä tulos ja lopeta
		// - jos syntyy poikkeus, anna virheilmoitus
		
		// Poikkeustilanteessa ikää on kysyttävä vielä uudelleen, 
		// joten tarvitset kaiken ympärille vielä toistorakenteen 
	   }
	}
}
