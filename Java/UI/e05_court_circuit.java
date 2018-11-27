// Opérateurs logiques à " court circuit "

public class e05_court_circuit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 10, j = 5 ;
		// j++;
		// System.out.println(j++) ;
		if (i<5 && j++<10) {
			System.out.println("&&1 vrai") ;
		}
		else {
			System.out.println("&&1 faux") ; 
		}
		System.out.println("i = " + i + "  j = " + j) ; // &&  si le premier peut determiner le resultat , on n'a pas besion de 2nd
		
		if (i<5 & j++<10) {
			System.out.println("& vrai") ;
		}
		else {
			System.out.println("& faux") ;
		}
		System.out.println("i = " + i + "  j = " + j) ;  // & tous les conditions
		
		if (i<15 && j++<10) {
			System.out.println("&&2 vrai");
		}
		else {
			System.out.println("&&2 faux") ;
		}
		System.out.println("i = " + i + "  j = " + j) ;   // le 2ème condition fonctionne
		
		if (i<15 || j++<10) {
			System.out.println("|| vrai") ;
		}
		else {
			System.out.println("|| faux") ;
		}
		System.out.println("i = " + i + "  j = " + j) ;  // 2ème ne fonctionnne
		
		if (i<15 | j++<10) {
			System.out.println("| vrai") ;
		}
		else {
			System.out.println("| faux") ;
		}
		System.out.println("i = " + i + "  j = " + j) ;   // 2ème fonctionne
		
	}

}
