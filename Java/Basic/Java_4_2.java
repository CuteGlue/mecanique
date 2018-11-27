
// lire nombres 
public class Java_4_2 {

	public static void main(String[] args) {
		
		java.util.Scanner in = new java.util.Scanner(System.in) ;
		int limite = 100000 , N = limite + 1 ;
		while( N < -limite || N > limite ) {
			N = in.nextInt() ;		
		}
		

		String str = "";
		String res = "" ;
		
		if (N < 0) {
			res += "fu ";
			N = -N ;
		}
		if (N==0) {
			res = "ling";
		}
				
		int M = N, count = 0 ;
		while ( M != 0) {
			M = M/ 10 ;
			count++ ;
		}
		count -= 1 ;
		
		int n = 0;
		while( count >= 0) {
			n = N/(int)Math.pow(10, count) ;
			N = N%(int)Math.pow(10, count) ;	
			switch (n) {
				case 0:
					str = "ling";
					break;
				case 1:
					str = "yi";
					break;
				case 2:
					str = "er";
					break;
				case 3:
					str = "san" ;
					break ;
				case 4:
					str = "si";
					break;
				case 5:
					str = "wu";
					break;
				case 6:
					str = "liu";
					break;
				case 7:
					str = "qi";
					break;
				case 8:
					str = "ba";
					break;
				case 9:
					str = "jiu";
					break;
				case -1:
					str = "fu";
					break;
				default :
					str = "" ;
					break ;
						
			}
			count--;
			if(count == -1) {
				res += str;
			}
			else {
				res += str + " ";
			}	
		}
	
		System.out.println(res) ;
	}

}
