
package suorakulmiot;
/**
 *
 * @author Elyas Addawe
 */

// Kirjoita tähän yleiskommentit

public class Testi {

    public static void main(String[] args) {

    // Kirjoita tähän testaamisessa tarvitsemasi lauseet
    	NaytonSuorakulmio naytto=new NaytonSuorakulmio(225,120,800,30);
    	System.out.println(naytto);
    	System.out.println(naytto.mahtuu(1024, 768));
    	Suorakulmio suorakulmio=new Suorakulmio(80,40);
    	System.out.println(suorakulmio+" ala:"+suorakulmio.ala());

    }
}
