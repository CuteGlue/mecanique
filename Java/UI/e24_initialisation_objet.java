// Initialisation d'un objet 


class A {
	public A (int coeff) {
		nbre += coeff ;
		nbre += decal;
	}
	public void affiche() {
		System.out.println ("nbre = " + nbre + "  decal = " + decal) ;
	}
	private int nbre;
	private int decal;
}
public class e24_initialisation_objet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A(5) ;
		a.affiche() ;
	}

}
