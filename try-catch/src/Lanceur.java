
public class Lanceur {

	public void lanceControlle() throws Exception {
		try {
			System.out.println("Dans Lanceur, debut try");
			throw new Exception("____Ceci est le message de lexception");
		} catch (Exception e) {
			System.out.println("Dans Lanceur, debut catch");
			throw e;
		}
	}
	
	public void lanceSansControle() {
		System.out.println("Dans Lanceur, debut");
		int a = 0, b = 2;
		int c = b/a;
		System.out.println("Dans Lanceur, fin");
	}
}
