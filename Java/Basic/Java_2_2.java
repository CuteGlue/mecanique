
// Signaux

public class Java_2_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		java.util.Scanner in = new java.util.Scanner(System.in) ;
		int RS = in.nextInt(),  R,S ;
		String str1, str2;
		R = RS / 10;
		S = RS % 10;
		
		switch (R) {
			case 1 : 
				str1 = "Unreadable" ;
				break ;
			case 2 : 
				str1 = "Barely readable, occasional words distinguishable" ;
				break ;
			case 3 : 
				str1 = "Readable with considerable difficulty" ;
				break ;
			case 4 : 
				str1 = "Readable with practically no difficulty" ;
				break ;
			case 5 : 
				str1 = "Perfectly readable" ;
				break ;
			default :
				str1 = "error" ;
		}
		
		switch (S) {
			case 1 :
				str2 = "Faint signals, barely perceptible" ;
				break ;
			case 2 :
				str2 = "Very weak signals" ;
				break ;
			case 3 :
				str2 = "Weak signals" ;
				break ;
			case 4 :
				str2 = "Fair signals" ;
				break ;
			case 5 :
				str2 = "Fairly good signals" ;
				break ;
			case 6 :
				str2 = "Good signals" ;
				break ;
			case 7 :
				str2 = "Moderately strong signals" ;
				break ;
			case 8 :
				str2 = "Strong signals" ;
				break ;
			case 9 :
				str2 = "Extremely strong signals" ;
				break ;
			default :
				str2 = "error" ;			
		}
		
		System.out.println(str2 + ", " + str1.toLowerCase() + ".");
		
	}

}
