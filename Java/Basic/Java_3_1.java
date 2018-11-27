
// nombre pair et impaire 


public class Java_3_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Scanner in = new java.util.Scanner(System.in) ;
		int N  = in.nextInt();
		int numberPair = 0, numberInpair = 0;
		while ( N != -1 ) {
			while (N <= 0 || N > 100000) {
				N = in.nextInt() ;
			}
			if ( N%2 == 0) {
			 numberPair++;				
			}
			else {
				numberInpair++ ;
			}
			N = in.nextInt();
			
//			while (N > 0 && N< 100000) {
//				if ( N%2 == 0) {
//					 numberPair++;				
//				}
//				else {
//					numberInpair++ ;
//				}
//				N = in.nextInt() ;
//			}
//			if (N == -1 ) {
//				break ;
//			}
//			else {
//				N = in.nextInt() ;
//			}
		}	
		System.out.println(numberInpair + " " + numberPair);
	}

}
