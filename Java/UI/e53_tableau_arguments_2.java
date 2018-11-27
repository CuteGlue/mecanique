
// 
class UtilTab {
	static double somme(double[] t) {
		double s = 0.;
		for (int i = 0; i < t.length; i++) {
			s += t[i];
		}
		return s;
	}

	static double[] incre(double[] t, double a) {
		for (int i = 0; i < t.length; i++) {
			t[i] += a;
		}
		return t;
	}

	static void affiche(double[] t) {
		for (int i = 0; i < t.length; i++) {
			System.out.print(t[i] + " ");
		}
		System.out.println(" ]");
	}
}

public class e53_tableau_arguments_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] t1 = { 1.25, 2.5, 3.5, 5.0 };
		System.out.print("t1 = [ ");
		UtilTab.affiche(t1);
		System.out.println("somme de t1 = " + UtilTab.somme(t1));
		double addition = 1.25;
		double[] t2 = UtilTab.incre(t1, addition);
		System.out.println("t2 = t1 + " + addition);
		System.out.print("t2 = [ ");
		UtilTab.affiche(t2);
		System.out.println("somme de t2 = t1 + " + t1.length + " x " + addition + " = " + UtilTab.somme(t2));

	}

}
