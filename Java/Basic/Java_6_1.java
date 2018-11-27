
// lire une phase

public class Java_6_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		java.util.Scanner in = new java.util.Scanner(System.in) ;
		
		String str = in.nextLine();		
		str = str.trim() ;
		String[] res = str.split("[\\s.]+") ;	
		//Sepeate with space and . same time, dont forget +, i dont konw why.
		str = "" ;
		for (int i=0; i<res.length ;i++) {
			str += res[i].length() + " " ;
		}
		System.out.println(str.trim());
	}

}
