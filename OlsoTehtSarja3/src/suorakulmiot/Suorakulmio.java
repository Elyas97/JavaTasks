
package suorakulmiot;
/**
 *
 * @author Elyas Addawe
 */
 
// Kirjoita tähän yleiskommentit

public class Suorakulmio {
	private int leveys;
	private int korkeus;
	public Suorakulmio(int leveys,int korkeus) {
		this.leveys=leveys;
		this.korkeus=korkeus;
	}
	public Suorakulmio() {
		
	}
	
	public void setLeveys(int leveys) {
		this.leveys=leveys;
	}
	public void setKorkeus(int korkeus) {
		this.korkeus=korkeus;
	}
	
	public int getLeveys() {
		return leveys;
	}
	public int getKorkeus() {
		return korkeus;
	}
	public int ala() {
    return leveys*korkeus;
	}
	public String toString() {
		return "leveys="+leveys+", "+"korkeus="+korkeus;
	}
    
}
