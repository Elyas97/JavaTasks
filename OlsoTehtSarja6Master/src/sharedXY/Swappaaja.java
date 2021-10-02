package sharedXY;

/**
* @author Oma Nimesi
*/

public class Swappaaja extends Thread{
	 SharedXY sharexy;
	 private boolean done=true;
	// Kirjoita konstruktori
	public Swappaaja(SharedXY sharexy) {
		this.sharexy=sharexy;
	}
	 
	// Kirjoita metodi run()
	public void run() {
		while(sharexy.compareXY()!=true) {
			sharexy.swap();
	}
		System.out.println("Samat"+sharexy.getX()+","+sharexy.getY());
		System.exit(0);
		
	}
	 
}