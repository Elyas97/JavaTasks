package halkohomma;

/**
* @author Oma Nimesi
*/

public class Halonhakkaaja extends Thread {
	Halkovarasto varasto;
	private boolean valmis=true;
	public Halonhakkaaja(Halkovarasto varasto) {
		this.varasto=varasto;
	}
	
	public void run() {
		while(valmis) {
			varasto.vieHalkoja((int)Math.random()*10+1);
			try {
				Thread.sleep(200);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	 
}