package application;

import Model.Noppa;
import controller.Controller;

public class NoppaController implements controller.Controller {
	NoppaGUI noppagui;
	Noppa noppa=new NoppaModel(6);
	public NoppaController(NoppaGUI noppaGUI2) {
		this.noppagui=noppaGUI2;
	}
	
	@Override
	public void NopanHeitto() {
		// TODO Auto-generated method stub
		String heitot="Nopista tuli ";
		int sum = 0;
		for (int i=0;i<5;i++) {
			int luku=noppa.heitä();
	 heitot=heitot+","+luku;
	 	sum =sum+luku;
		}
		heitot=heitot+". Summa:"+sum;
	int heittomaara=noppa.getHeittoMaara();

	noppagui.setNoppa(heitot,heittomaara);
		
	}

}
