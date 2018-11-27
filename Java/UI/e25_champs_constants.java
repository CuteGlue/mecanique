class ChCt {
	public ChCt (float r) {
		x = r;
	}
	public void affiche() {
		System.out.println(" 2 * " + x + " = " + 2*x) ;
	}
	public void addition(float m) {
		x += m ;
	}
	private float x;
	private final int n = 10 ;
	private final int p  = 0;
	
}
public class e25_champs_constants {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChCt a = new ChCt (5.23f) ;
		a.affiche() ;
		a.addition(0.23f) ;
		a.affiche() ;
	}

}
