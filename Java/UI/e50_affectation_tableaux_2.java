
public class e50_affectation_tableaux_2 {

	public static void main(String[] args) {
		final int N = 4;
		int t1[] = new int[N];
		int t2[] = new int[N];
		for (int i = 0; i < N; i++) {
			t1[i] = i + 1;
		}
		for (int i = 0; i < N; i++) {
			t2[i] = 2 * i + 1;
		}
		// affichage des valeurs de t1 et t2
		System.out.print("t1 = ");
		for (int i = 0; i < N; i++) {
			System.out.print(t1[i] + " ");
		}
		System.out.println();
		System.out.print("t2 = ");
		for (int i = 0; i < N; i++) {
			System.out.print(t2[i] + " ");
		}
		System.out.println();

		t1 = t2;
		t1[3] = 400;
		for (int i = 0; i < 4; i++) {
			System.out.println("t1 = " + t1[i] + "    t2 = " + t2[i]);
		}

	}
}
