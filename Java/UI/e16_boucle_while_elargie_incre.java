// Boucle while, opératuers d'affectation élargie er d'incrémentation[1]
public class e16_boucle_while_elargie_incre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int n, p ;
	    
	    n = 0 ;
	    while (n<=5) {
	    	n++ ;
	    	System.out.println ("A : n = " + n) ;
	    }
	    
	    n = p = 0 ;
	    System.out.println ();
	    System.out.println ("Now n = " + n + "  p = " + p) ;
	    while(n<=8) {
	    	n += p++ ;
	    	System.out.println ("B : n = " + n + "  p = " + p) ;
	    }
	    
	    n = p = 0 ;
	    System.out.println ();
	    System.out.println ("Now n = " + n + "  p = " + p) ;
	    while(n<=8) {
	    	n += ++p ;
	    	System.out.println ("C : n = " + n + "  p = " + p) ;
	    }
	    
	    n = p = 0 ;
	    System.out.println ();
	    System.out.println ("Now n = " + n + "  p = " + p) ;
	    while (p<=5) {
	    	n += p++ ;
	    	System.out.println ("D : n = " + n + "  p = " + p) ;
	    }
	    	
	    	
	    n = p = 0 ;
	    System.out.println ();
	    System.out.println ("Now n = " + n + "  p = " + p) ;
	    while (p<=5) {
	    	n += ++p ;
	    	System.out.println ("E : n = " + n + "  p = " + p) ;
	    }
	    
	    }

}
// (++p) = p ; (p++) = p-1
