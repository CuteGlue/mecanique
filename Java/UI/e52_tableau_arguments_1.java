
public class e52_tableau_arguments_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int N = 4;
		int[] t1 = new int[N];
		int[] t2 = new int[N];
		for (int i = 0; i < N; i++) {
			t1[i] = i + 1;
		}
		for (int i = 0; i < N; i++) {
			t2[i] = 2 * i;
		}
		// affichage des valeurs de t1 et t2
		affiche(t1, 't', 1);
		affiche(t2, 't', 2);
		// System.out.println((byte)(56)) ;

	}

	static void affiche(int[] t, char c, int n) {
		System.out.print(c);
		System.out.print(n + " = ");
		for (int i = 0; i < t.length; i++) {
			System.out.print(t[i] + " ");
		}
		System.out.println();
	}

}
