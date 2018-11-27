// Syntaxe de if et de switch
public class e11_if_switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b, n, max, p ;
		// groupe 1
		a = 1; b = 2;
		if (a < b) {
			System.out.println(" ascendant") ;
		}
		else {
			System.out.println(" non ascendant") ;
		}
		// groupe 2
		if (a < b) {
			System.out.println(" ascendant") ;
			max = b ;
		}
		// groupe 3
		n = 2 ;
		switch (n) {
		case 1 : System.out.println(" petit ") ; break ;
		case 2 : System.out.println(" limite ") ; break ;
		}
		// groupe 4
		n = 19 ;
		final int LIMITE = 20 ;
		switch(n) {
		case LIMITE-1 : System.out.println(" un peu trop petit ") ; break ;
		case LIMITE : System.out.println(" OK ") ; break ;
		case LIMITE+1 : System.out.println(" un peu trop grand ") ; break ;
		}
		

	}

}
