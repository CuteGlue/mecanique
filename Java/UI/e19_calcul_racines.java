// Synthèse : calcul d'une suite de racines carrées

import java.util.Scanner ;

public class e19_calcul_racines {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			Scanner in = new Scanner (System.in) ;
			System.out.print("donnez un nombre positif : ") ;
			double n = in.nextDouble() ;
			if (n > 0) {
				double r = Math.sqrt(n) ;
				System.out.println("sa racine carree est : " + r) ;
			}
			else if (n < 0 ) {
				System.out.println("svp positif ") ;
				continue ;
			}
			else {
				System.out.println("Arrêt !") ;
				break ;
			}
		}
		
		// 2nd do while
		double n, r ;
		do {
			
			Scanner in = new Scanner (System.in) ;
			System.out.print("donnez un nombre positif : ") ;
			n = in.nextDouble() ;
			if (n > 0) {
				r = Math.sqrt(n) ;
				System.out.println("sa racine carree est : " + r) ;
			}
			if (n < 0 ) {
				System.out.println("svp positif ") ;
				// continue ;
			}
		} while(n != 0);
			
	}

}
