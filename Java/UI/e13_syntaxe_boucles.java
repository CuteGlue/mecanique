// Syntaxe des boucles
import java.util.Scanner ;
public class e13_syntaxe_boucles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1 ;
		do {
			n++ ;
			System.out.println (n) ;
		}while (n < 5) ;

		do {
			Scanner in = new Scanner (System.in) ;
			System.out.print("votre numéro entier : ");
			n = in.nextInt() ;
			System.out.println (n) ;
		} while (n != 10); 
			
		// while(true); while(false);


	}

}
