
public class Attrapeur {
	public void attrapeControlle() {
		Lanceur l = new Lanceur();
		try {
			System.out.println("Je rentre dans le try");
			l.lanceControlle();
			System.out.println("Fin try");
		} catch (ArithmeticException e) {
			System.out.println("Je rentre dans le catch ArithmeticException");
			e.printStackTrace();
			System.out.println("Fin catch ArithmeticException");
		} catch (Exception e) {
			System.out.println("Je rentre dans le catch Exception");
			e.printStackTrace();
			System.out.println("Fin catch Exception" + e.getMessage());
		}
	}
	
	public int attrapeSansControle() {
		Lanceur l = new Lanceur();
		try {
			System.out.println("Je rentre dans le try");
			l.lanceSansControle();
			System.out.println("Fin try");
			return 1;
		}
		catch (Exception error){
			System.out.println("Je rentre dans le catch");
			error.printStackTrace();
			l.lanceControlle();
			System.out.println("Fin catch");
			return 0;
		}
		finally {
			System.out.println("Je suis dans le finally");
			return 666;
		}
	}
}
