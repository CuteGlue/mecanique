// Température F vers C

public class Java_1 {
	
	public static void main(String[] args) {
		
		int C,F;
		java.util.Scanner in = new java.util.Scanner(System.in) ;
		F = in.nextInt() ;
		C = (int)((F - 32) *5* 1.0 / 9);
		System.out.println(C);
		
	}

}
