
// polynôme
public class Java_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		java.util.Scanner in = new java.util.Scanner(System.in);
		int m, n;
		int[] expo = new int[101];
		int[] coef = new int[101];
		String res = "";

		for (int i = 0; i < 2; i++) {
			do {
				n = 101;
				m = 0;
				while (n > 100) {
					n = in.nextInt();
					m = in.nextInt();
				}

				expo[n] = n;
				coef[n] += m;

			} while (n != 0);
		}

		for (int j = 100; j > -1; j--) {
			m = coef[j];
			n = expo[j];
			if (m > 0) {
				if (n == 0) {
					res += "+" + m;
				} else if (n == 1) {
					if (m == 1) {
						res += "+" + "x";
					} else {
						res += "+" + m + "x";
					}
				} else {
					if (m == 1) {
						res += "+" + "x" + n;
					} else {
						res += "+" + m + "x" + n;
					}
				}
			} else if (m < 0) {
				if (n == 0) {
					res += m;
				} else if (n == 1) {
					if (m == -1) {
						res += "-" + "x";
					} else {
						res += m + "x";
					}
				} else {
					if (m == -1) {
						res += "-" + "x" + n;
					} else {
						res += m + "x" + n;
					}
				}
			} else {
				res += "";
			}
		}
		if (res.length() == 0) {
			res = "0";
		} else {
			char first = res.charAt(0);
			if (first == '+') {
				res = res.substring(1);
			} 
		}
		System.out.println(res) ;
	}
}
