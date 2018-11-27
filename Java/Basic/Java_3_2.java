
// value spécilalisé

public class Java_3_2{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner in = new java.util.Scanner(System.in) ;
		int N = -1;
		while ( N < 0 || N > 1000000) {
			N = in.nextInt();
		}
		int M = N;
		int count = 0 ;
		while ( M != 0) {
			M = M/ 10 ;
			count++ ;
		}
		int sum = 0 , A = 0;
		for ( int i=0 ; i < count ; i++) {
			A = N % (int)Math.pow(10,i+1) ;
			N = N / 10 ;
			if ( A%2 == (i+1)%2 ) {
				sum += (int)Math.pow(2,i) ;
			}
		}
		System.out.println(sum);

	}
}