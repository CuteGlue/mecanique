
// BJT vers UTC
public class Java_2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner in = new java.util.Scanner(System.in);
		int time = -1;
		int a, b, c, d;
		while (time > 2359 || time < 0) {
			// System.out.println("entrer : ") ;
			time = in.nextInt();
			if ((time % 100) / 10 > 5) {
				time = -1;
			}
		}

		int t = time - 800;
		if (t < 0) {
			t = t + 2400;
		}
		System.out.println(t);

	}

}
