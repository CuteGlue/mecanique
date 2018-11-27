// Opérateur d'incrémentation, de décrémentation er d'affectation élargie
public class e08_opérateurs_in_decrémentation_affectation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, j, n, a ;
		i = 0 ; a = i++ ;
		System.out.println("A : i = " + i + "  a = " + a ) ; // i = i +1; n = i
		i = 10 ; n = ++ i;
		System.out.println("B : i = " + i + "  n = " + n ) ;  // i = i+1   n= i+1 
		i = 20 ; j = 5 ; n = i++ * ++j ;
		System.out.println("C : i = " + i + "  j = " + j + "  n = " + n + " " + (i++)+ " " + i + " " + (++i) + " " +i) ; // 21 6 105
		i = 15; n = i +=3 ;
		System.out.println("D : i = " + i + "  n = " + n) ;    // 15 18
		i = 3; j = 5; n = i *= --j;
		System.out.println("E : i = " + i + "  j = " + j + "  n = " + n) ;  // 3 5 12

	}

}
// i++ 和 ++i 之后 i的值都要加1  但是i++ 的值为 i加1之前的值  ++i 的值为i