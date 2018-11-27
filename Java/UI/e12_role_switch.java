// Rôle de l'instruction switch
import java.util.Scanner ;
public class e12_role_switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n ;
		Scanner in = new Scanner(System.in);
		System.out.print("Votre numéro entier : ");
		n = in.nextInt();
		switch (n) {
		case 0 : System.out.println ("Nul") ;   
		case 1 :                                
		case 2 : System.out.println ("Petit") ; break ;
		case 3 :                                
		case 4 :                                
		case 5 : System.out.println ("Moyen") ; 
		default : System.out.println ("Grand") ;
		}
	}

}
// 0 1 4 10 -5