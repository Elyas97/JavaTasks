package model;

import java.util.ArrayList;

public class Valuuttakone implements IValuuttakone {
	Valuutta[] valuutat=new Valuutta[4];
	public Valuuttakone() {
		valuutat[0]=new Valuutta("Euroopan euro",1.0);
		valuutat[1]=new Valuutta("Ruotsin kruunu",9.4780);
		valuutat[2]=new Valuutta("Norjan kruunu",8.9018);
		valuutat[3]=new Valuutta("Yhdysvaltain dollari",1.0629);
	}
	public String[] getVaihtoehdot() {
	String[] valuuttaTaulu=new String[valuutat.length];
	for(int i=0;i<valuuttaTaulu.length;i++) {
		valuuttaTaulu[i]=valuutat[i].getNimi();
	}
	return valuuttaTaulu;
	}

	@Override
	public double muunna(int mistäIndeksi, int mihinIndeksi, double määrä) {

		double tulos=määrä/(valuutat[mistäIndeksi].getVaihtokurssi());
		tulos*=valuutat[mihinIndeksi].getVaihtokurssi();
		return tulos;
	}

}
