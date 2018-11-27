
// check prime

public class Java_7_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Java_7_1().run();
	}

	final int N = 100000;

	public void run() {
		java.util.Scanner in = new java.util.Scanner(System.in);
		int[] P = prime();
		check(P, in.nextInt());
	}

	public int[] prime() {
		boolean[] isPrime = new boolean[N];
		for (int i = 0; i < isPrime.length; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; i < isPrime.length; i++) {
			if (isPrime[i]) {
				for (int k = 2; k * i < isPrime.length; k++) {
					isPrime[k * i] = false;
				}
			}
		}
		int count = 0;
		for (int i = 2; i < isPrime.length; i++) {
			if (isPrime[i]) {
				count++;
			}
		}
		int[] a = new int[count];
		int j = 0;
		for (int i = 2; i < isPrime.length; i++) {
			if (isPrime[i]) {
				a[j] = i;
				j++;
			}
		}
		return a;
	}

	public void check(int[] P, int value) {
		String res = Integer.toString(value) + "=" ;
		java.util.Scanner in = new java.util.Scanner(System.in);
		while (value < 2 || value > N) {
			value = in.nextInt();
		}
		boolean inside = false;
		for (int i : P) {
			if (i == value) {
				inside = true;
				break;
			}
		}
		if (inside) {
			res += value;
		} else {
			int j = 0;
			while (value != 1) {
				while (value % P[j] == 0) {
					value = value / P[j];
					res += Integer.toString(P[j]) + 'x';
				}
				j++;
			}
			res =  res.substring(0, res.length()-1) ;
			
		}
		System.out.println(res);

	}

}
