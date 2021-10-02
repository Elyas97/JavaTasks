package sharedXY;

/**
* @author Oma Nimesi
*/

public class SharedXY {

	private int x;
	private int y;

	// Kirjoita konstruktori, joka asettaa muuttujille alkuarvot
	public SharedXY(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	// Kirjoita metodi swap(), joka vaihtaa arvot keskenään
	public synchronized void swap() {
		int temp=x;
		x=y;
		y=temp;
		System.out.println(""+x+" "+y);
	}
	public synchronized int getX() {
		return x;
	}

	

	public synchronized int getY() {
		return y;
	}
	public synchronized boolean compareXY() {
		boolean onkoSama=false;
		if(x==y) {
		onkoSama= true;
		}
		return onkoSama;
		
	}


	
	 
}