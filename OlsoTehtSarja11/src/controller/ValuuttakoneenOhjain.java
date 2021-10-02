package controller;

import model.IValuuttakone;
import model.Valuuttakone;
import view.IValuuttakoneenUI;
import view.ValuuttakoneenGUI;

public class ValuuttakoneenOhjain implements IValuuttakoneenOhjain {
private ValuuttakoneenGUI ui;
private Valuuttakone models;
	public ValuuttakoneenOhjain(ValuuttakoneenGUI ui, Valuuttakone models) {
	this.ui=ui;
	this.models=models;
}

	@Override
	public void muunnos() {
	int lahtoindeksi=ui.getLähtöIndeksi();
	int kohdeindeksi=ui.getKohdeIndeksi();
	double maara=ui.getMäärä();
	double tulos=models.muunna(lahtoindeksi, kohdeindeksi, maara);
	ui.setTulos(tulos);

	}

	@Override
	public String[] getValuutat() {
		String[] kaikkiValuutat=models.getVaihtoehdot();
		return kaikkiValuutat;
	}

}
