
// Primes
public class Java_4_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		java.util.Scanner in = new java.util.Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		boolean isPrime;
		int N = 0, sum = 0;
		for (int i = 2;; i++) {
			isPrime = false;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = true;
					break;
				}
			}
			if (!isPrime) {
				N++;
				if (N >= n) {
					sum += i;
				}
			}
			if (N >= m) {
				break;
			}
		}
		System.out.println(sum);

	}

}
