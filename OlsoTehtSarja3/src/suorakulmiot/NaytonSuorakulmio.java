
package suorakulmiot;
/**
 *
 * @author Elyas Addawe
 */

// Kirjoita tähän yleiskommentit

public class NaytonSuorakulmio extends Suorakulmio {
private int x;
private int y;
public NaytonSuorakulmio(int x,int y,int leveys,int korkeus) {
	super(leveys,korkeus);
	this.x=x;
	this.y=y;
	
}
public boolean mahtuu(int leveys,int korkeus) {
;	int kokoLeveys=x+super.getLeveys();
	int kokoKorkeus=y+super.getKorkeus();
	if(kokoLeveys>leveys) {
		return false;
	}
	if(kokoKorkeus>korkeus) {
		return false;
		
	} 
	return true;
}

public String toString() {
	return "x="+x+", y="+y+", " + super.toString();
}

}
