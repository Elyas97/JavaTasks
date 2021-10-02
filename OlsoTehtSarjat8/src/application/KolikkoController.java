package application;

public class KolikkoController implements controller.Controller {
	KolikkoGUI kolikkogui;
	NoppaModel noppa=new NoppaModel(2);
	
	public KolikkoController(KolikkoGUI kolikkogui) {
		this.kolikkogui=kolikkogui;
	}
	@Override
	public void NopanHeitto() {
	int luku=noppa.heitä();
	int maara=noppa.getHeittoMaara();
	String tulos="";
	if(luku==1) {
		tulos="Klaava";
	}else {
		tulos="Kruunu";
	}
	kolikkogui.naytaTulos(tulos, maara);
		
	}
	

}
