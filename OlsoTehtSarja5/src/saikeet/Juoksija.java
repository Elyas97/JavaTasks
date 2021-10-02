package saikeet;

/**
* @author Oma Nimesi
*/

public class Juoksija extends Thread {
	private volatile boolean jatkuu = true;
	private int kierrokset = 0;
// Kirjoita kierrokset-muuttujan getteri
	
	public int getKierrokset() {
		return this.kierrokset;
	}

	public void setKierrokset(int kierrokset) {
		this.kierrokset = kierrokset;
	}

	@Override
	public void run(){
		while(jatkuu){
			System.out.println(kierrokset);
		try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		kierrokset++;
		

		}
	}
	
	public boolean isJuoksemassa() {
		return jatkuu;
	}

	// Kun juokseminen halutaan lopettaa, joku toinen säie kutsuu 
	// lopeta()-metodia.
	public void lopeta(){
		 this.jatkuu=false;
	}
}
