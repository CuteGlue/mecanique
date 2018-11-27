// Synthèse : dessin d'un triangle en mode texte
import java.util.Scanner ;
public class e21_dessin_etoile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, j, n, m ;
		final char etoile = '*' ;
		Scanner in = new Scanner (System.in) ;
		System.out.print(" combien de lignes ? ") ;
		n = in.nextInt() ;
		for (i=1 ; i <= n ; i++) {
			for (j =1 ; j <= n-i ; j++) {
				System.out.print(" ") ;
			}
			for (j =1 ; j <= 2*i-1 ; j++) {
				System.out.print(etoile) ;
			}
			for (j =1 ; j <= n-i ; j++) {
				System.out.print(" ") ;
			}
			System.out.println() ;
		}

	}

}
