package kaynnista;
 
import java.util.Scanner;

import model.*;

public class TekstiMain {
	static IValuuttaDAO valuuttaDAO = new ValuuttaAccessObject();
	static Scanner scanner = new Scanner(System.in);

	public static void listaaValuutat() {
		
		for(int i=0;i<valuuttaDAO.readValuutat().length;i++) {
		System.out.println(valuuttaDAO.readValuutat()[i].getNimi()+". Vaihto Kurssi "+valuuttaDAO.readValuutat()[i].getVaihtokurssi()
				+". Tunnus:"+valuuttaDAO.readValuutat()[i].getTunnus()+"\n"); 
		}
		

	}

	public static void lisääValuutta(Valuutta valuutta) {
	
		valuuttaDAO.createValuutta(valuutta);

	}

	public static void päivitäValuutta(Valuutta valuutta) {
		if(valuuttaDAO.updateValuutta(valuutta)!=false)
		System.out.println("Päivitetty");
	}

	public static void poistaValuutta(String tunnus) {
		valuuttaDAO.deleteValuutta(tunnus);

	}

	public static void main(String[] args) {
		String nimi,tunnus;
		double vaihtokurssi=0;
		char valinta;
		final char CREATE = 'C', READ = 'R', UPDATE = 'U', DELETE = 'D', QUIT = 'Q';

		do {
			System.out.println("C: lisää uusi valuutta tietokantaan \n"
					+"R: Listaa tietokannassa olevien valuuttojien tiedot\n"
					+"U: Päivitä valuutan vaihtokurssi tietokannassa\n"
					+"D: Poista valutta tietokannasta\n"
					+"Q: lopetus");
			valinta = (scanner.nextLine().toUpperCase()).charAt(0);
			switch (valinta) {
			case CREATE:
				
				System.out.println("Valitsit: "+valinta);
				System.out.println("Syötä valuutan tunnus. (MAX 3 merikkiä)");
				tunnus=scanner.nextLine();
				System.out.println(".Syötä valuutan nimi");
				nimi=scanner.nextLine();
				System.out.println("Syötä valuutan vaihtokurssi. (esim 2.22)");
				try {
				 vaihtokurssi= Double.parseDouble(scanner.nextLine());
				}catch(NumberFormatException e) {
					System.out.println("Syötä numero, syötit "+vaihtokurssi);
				}
				if(vaihtokurssi==0) {
				break;
				}
				Valuutta lisäys=new Valuutta(tunnus,vaihtokurssi,nimi);
				lisääValuutta(lisäys);
				System.out.println("Lisätty tietokantaan");
				
				break;
			case READ:
				System.out.println("Valintasi: "+valinta);
				listaaValuutat();
				break;
			case UPDATE:
				System.out.println("Valitsit: "+valinta);
				System.out.println("Syötä päivitettävän valuutan tunnus. (MAX 3 merikkiä)");
				tunnus=scanner.nextLine();
				System.out.println(".Syötä valuutan uusi nimi");
				nimi=scanner.nextLine();
				System.out.println("Syötä valuutan uusi vaihtokurssi. (esim 2.22)");
				try {
				 vaihtokurssi= Double.parseDouble(scanner.nextLine());
				}catch(NumberFormatException e) {
					System.out.println("Syötä numero, syötit "+vaihtokurssi);
				}
				if(vaihtokurssi==0) {
				break;
				}
				Valuutta päivitys=new Valuutta(tunnus,vaihtokurssi,nimi);
				päivitäValuutta(päivitys);
				break;
			case DELETE:
				System.out.println("Valitsit: "+valinta);
				System.out.println("Syötä poistettavan valuutan tunnus. (MAX 3 merikkiä)");
				tunnus=scanner.nextLine();
				poistaValuutta(tunnus);
				break;
			case QUIT:
				System.out.println("Valintasi: "+valinta+". Poistutaan");
				System.exit(1);
				
				break;
			}
			
		} while (valinta != QUIT);
	}
}
