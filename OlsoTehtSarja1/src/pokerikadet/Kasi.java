package pokerikadet;
/**
*
* @author laita tähän nimesi ja päiväys
*/
import java.util.Arrays;

public class Kasi {
	
    final static int EIVÄRI = 0, EISUORA = 0, SUORA = 1, VÄRI = 2, VÄRISUORA = 3;
    static int kierrokset=0;
    // Näiden näkyvyys: pakkauksen sisällä (ei private, ei public)
    // Viittaus muista luokista muodossa Luokka.tunnus esim. Käsi.SUORA

    // Esittele instanssimuuttujat
    private Kortti[] kortit=new Kortti[5];
    private Pakka pakka;
    // Kirjoita konstruktori, joka saa parametrina Pakka-olion
    public Kasi(Pakka pakka) {
    	kierrokset++;
    	this.pakka=pakka;
    	for(int i=0;i<kortit.length;i++) {
    		kortit[i]=pakka.annaKortti();
    	}
    }
    public Kasi(Kortti kortti[]) {
    	this.kortit=kortti;
    }
    

    
    // Kirjoita toteutus metodille annaArvo()'
    public int annaArvo() {
    	int vari=2;
    for(int i=0;i<kortit.length-1;i++) {
    	if(kortit[i].getMaa()!=kortit[i+1].getMaa()) {
    			vari= 0;
    	}
    	}
    return vari;
    
 }
    public int kierrokset() {
    	return Kasi.kierrokset;
    }

    // Kirjoita toString()
    public String toString() {
    	String temp=" ";
		for(int i=0;i<kortit.length;i++) {
			temp=temp+ kortit[i].toString()+" ";
		}
    	return temp;
    }
}
