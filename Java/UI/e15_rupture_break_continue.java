// Rupture de séquence avec break et continue
public class e15_rupture_break_continue {
	
	public static void main(String[] args) {
		int n = 0 ;
		do {
			if (n%2 == 0) {
				System.out.println("n = " + n + " est pair") ;
				n += 3 ;
				System.out.println("n = " + n) ;
				continue;
			}
			if (n%3 == 0 ) {
				System.out.println("n = " + n + " est multipe de 3 ") ;
				n += 5 ;
				System.out.println("n = " + n) ;
			}
			if (n%5 == 0 ) {
				System.out.println("n = " + n + " est multipe de 5 ") ;
				break;
			}
			n += 1 ;
			System.out.println("n = " + n) ;
		} while(true) ;
	}

}
