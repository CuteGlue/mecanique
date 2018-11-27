// Synthèse : calcul de la valeur d'une série
// calcule 1 + 1/2 + 1/3 + ... + 1/n
import java.util.Scanner; ;
public class e20_synthese_serie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, n ;
		float som ;
		do{
			
			Scanner in = new Scanner (System.in) ;
			System.out.print("Donnez votre numéro de terms :") ;
			n = in.nextInt() ;	
			for (i=1, som=0 ; i <= n ; i++) {
				som += (float)1/i ;
			}
			if (som == 0) {
				System.out.println("end of boucle") ;
				break ;
				}
			else {
			    System.out.println("Somme finale est " + som) ;
			}
		} while(n > 1);

	}
}
