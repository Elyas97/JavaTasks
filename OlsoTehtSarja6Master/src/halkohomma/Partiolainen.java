package halkohomma;

/**
* @author Oma Nimesi
*/

public class Partiolainen extends Thread {
	Halkovarasto varasto;
	public boolean valmis=false;
	public Partiolainen(Halkovarasto varasto) {
		this.varasto=varasto;
	}
	public void run() {
		while(!valmis) {
			
			varasto.haeHalkoa((int)Math.random()*10+1);
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
	
	}
	 
}