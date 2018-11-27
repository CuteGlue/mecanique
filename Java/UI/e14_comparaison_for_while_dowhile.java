// Comparaison entre for , while et do while 
import java.util.Scanner ;
public class e14_comparaison_for_while_dowhile {
	
	public static void main(String[] args) {
		int  i, n, som ;
		// for
		System.out.println("Résultat pour boucle for : ") ;
		som = 0 ;
		for (i=0 ; i<4 ; i++) {
		Scanner in = new Scanner (System.in) ;
		System.out.print("Donnrz l'entier " + (i+1) + " : ");
		n = in.nextInt() ;
		som += n ;
		}
		System.out.println("Somme des ces " + i + " valeurs : " + som) ;
		// while
		som = 0 ;
		System.out.println("Résultat pour boucle while : ") ;
		i = 0 ;
		while( i< 4) {
			Scanner in = new Scanner (System.in) ;
			System.out.print("Donnez l'entier " + (i+1) + " : ") ;
			n = in.nextInt();
			som += n ;
			i++ ;
		}
		System.out.println("Somme des ces " + i + " valeurs : " +som) ;
		// do ... while
		System.out.println("Résultat pour boucle do while : ") ;
		som = 0 ;
		i = 0 ;
		do {
			Scanner in = new Scanner (System.in) ;
			System.out.print("Donner l'entier " + (i+1) + " : ") ;
			n = in.nextInt() ;
			som += n ;
			i++ ;
		} while(i < 4) ;
		System.out.println("Somme des ces " + i + " valeurs : " + som) ;
		
		
	}
	

}
