package model;

/**
 * @author Oma nimesi
 */

public class Valuuttakone implements IValuuttakone {
	Valuutta[] valuutat;
	public Valuuttakone() {
		IValuuttaDAO valuuttaDAO = new ValuuttaAccessObject();
		this.valuutat=valuuttaDAO.readValuutat();
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
