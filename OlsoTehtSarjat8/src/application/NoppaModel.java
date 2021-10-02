package application;

public class NoppaModel implements Model.Noppa {
	private int sivulkm;
	private int heittoMaara;
	

public NoppaModel(int sivulkm) {
	this.sivulkm=sivulkm;
}
	@Override
	public int heitä() {
		heittoMaara++;
	int luku=(int)(Math.random() * sivulkm) + 1;
	return luku;
	}
	@Override
	public int getHeittoMaara() {
		return heittoMaara;
	}

}
