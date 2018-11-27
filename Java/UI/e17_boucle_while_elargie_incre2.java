// Boucle while, opérateurs d'affectation élatgie et d'incrémantation[2]
public class e17_boucle_while_elargie_incre2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, p ;
		n = p = 0 ;
		while(n < 5) n += 2 ; p++ ;
		System.out.println (" A : n = " + n + "  p = " + p) ;
		
		n = p =0;
		while(n < 5) { n+= 2; p++ ;}
		System.out.println (" B : n = " + n + "  p = " + p) ;

	}

}
