package saikeet;

/**
* @author Oma Nimesi
*/

public class LuuppaavaSaie extends Thread {

	// Pakkaustason näkyvyys
    int pyydetytKierrokset;
    int kierretytKierrokset;

	// Kirjoita parametrillinen konstruktori, joka asettaa pyydetyt kierrokset
    public LuuppaavaSaie (int pyydetytKierrokset) {
    	this.pyydetytKierrokset=pyydetytKierrokset;
    }
	
	// Kirjoita getteri kierretyille kierroksille
    public int getKierretytKierrokset() {
		return kierretytKierrokset;
	}

	public void setKierretytKierrokset(int kierretytKierrokset) {
		this.kierretytKierrokset = kierretytKierrokset;
	}
	
	// Kirjoita metodi run(), jossa säie kiertää toistossa pyydetyt kierrokset
	// kertaa siten, että kierrettyjen kierrosten loppuarvoksi jää toiston päätyttyä 
	// kierretyt kierrokset. Sen tulee olla lopuksi siis sama kuin pyydetyt kierrokset. 
	// Tulosta jokaisella kierroksella kierroksen numero. 
	public void run() {
		while(pyydetytKierrokset>0) {
			kierretytKierrokset++;
			pyydetytKierrokset--;
			System.out.println(kierretytKierrokset+"kierros");
			
		}
	} 
}
