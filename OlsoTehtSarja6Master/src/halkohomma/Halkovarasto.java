package halkohomma;

/**
* @author Oma Nimesi
*/

public class Halkovarasto extends Thread {
	public final int MAKSIMIHALKO =100;
	public int halkojenmaara=0;
	public synchronized void  vieHalkoja(int halkojenmaara) {
		while(this.halkojenmaara+halkojenmaara>MAKSIMIHALKO) {
			try {
				System.out.println("Odota"+Thread.currentThread().getName()+". Ei mahdu");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.halkojenmaara=this.halkojenmaara+halkojenmaara;
		System.out.println(""+Thread.currentThread().getName()+". Vienyt "+halkojenmaara+" halkoa");
		notifyAll();
	}
	public synchronized int haeHalkoa(int halkoja) {
		while(this.halkojenmaara-halkoja<0) {
			System.out.println("Odota"+Thread.currentThread().getName()+". Ei riittävästi halkoja");
			try {
				wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		this.halkojenmaara=this.halkojenmaara-halkoja;
		System.out.println(""+Thread.currentThread().getName()+". Ottanut "+halkojenmaara+" halkoa");
		notifyAll();
		return halkoja;
	}
	 
	 
}