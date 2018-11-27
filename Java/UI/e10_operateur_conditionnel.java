// Opérateur conditionnel

public class e10_operateur_conditionnel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10, p = 5, q = 10 ;
		n = p = q = 5 ;
		n += p += q ;
		System.out.println(" A : n = " + n + "  p = " + p + "  q = " + q ) ;  //    15 10 5
		q = n < p ? n++ : p++ ;
		System.out.println(" B : n = " + n + "  p = " + p + "  q = " + q ) ;
		
		q = n > p ? n++ : p++ ;
		System.out.println(" C : n = " + n + "  p = " + p + "  q = " + q ) ;
		//  ???? "????"

	}

}
