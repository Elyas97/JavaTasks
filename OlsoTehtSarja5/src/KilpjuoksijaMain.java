import saikeet.Kilpajuoksija;
public class KilpjuoksijaMain {

	public static void main(String[] args) {
		Kilpajuoksija test=new Kilpajuoksija();
		test.run();
		try {
			test.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Kilpailija lopetti"+test.getAika());

	}

}
