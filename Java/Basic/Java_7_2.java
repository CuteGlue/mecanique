
// nombre parfait
public class Java_7_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Java_7_2().run();

	}

	public void run() {
		java.util.Scanner in = new java.util.Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		cherchePerfectNumber(a, b);
	}

	public boolean perfectNumber(int N) {
		int somme = 1;
		int j = 2;
		boolean res = false;
		while (j < N) {
			while (N % j == 0) {
				somme += j;
				j++;
			}
			j++;
		}
		if (somme == N && somme > 3) {
			res = true;
		}
		return res;
	}

	public void cherchePerfectNumber(int n, int m) {
		java.util.Scanner in = new java.util.Scanner(System.in);
		while (n < 0 || m > 1000 || m < n) {
			n = in.nextInt();
			m = in.nextInt();
		}
		String res = "";
		for (int i = n; i <= m; i++) {
			if (perfectNumber(i)) {
				res += i + " ";
			}
		}
		System.out.println(res.trim());

	}

}
