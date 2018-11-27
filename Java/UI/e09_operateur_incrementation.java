// Opérateur d'incrémentation et d'affectation élargie
public class e09_operateur_incrementation {
	
	public static void main(String[] args) {
		byte b ;
		short p ;
		char c ;
		int n ;
		float x ;
		//          char > byte > short > int(+)
		// c = c + 1    // erreur  char != int
		// c++          //  ok     char(c + 1)
		// c += 3       //   ok   char c+3
 		// b += c       //   ok   byte
		// p += b       //  ok   short 
		// p = p + b    //  erreur   short != int
		// n += x       //   ok int (n+x)
		// n = n + x    // erreur    int != float
		// x++          // ok  float
	}

}
