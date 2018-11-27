  /* Synthèse : calcul de combinaisons */
public class e22_calcul_combinaisons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, j, k ; /* i nombre de 10 centimes
		               * j nombre de 5 centimes
		               * k nombre de 2 centimes */
		int som ;     /* montant total */
		int nbf = 0 ;  /* nombre de facons de faire 1F */
		for (i=0 ; i<=10 ; i++) 
			for (j=0 ; j<=20 ; j++) 
				for (k=0 ; k<=50 ; k++) {
					som = 10*i + 5*j + 2*k ;
					if (som == 100) {
						nbf++ ;
						if (i != 0 && j != 0 && k != 0) {
						    System.out.println("1 F = " + k + " X 2c + " + j + " X 5c + " + i + " X 10c") ;
						}
						else if (i != 0 && j == 0 && k != 0) {
							System.out.println("1 F = " + k + " X 2c + " + i + " X 10c") ;
						}
						else if (i != 0 && j != 0 && k == 0) {
							System.out.println("1 F = " + j + " X 5c + " + i + " X 10c") ;
						}
						else if (i != 0 && j == 0 && k == 0) {
							System.out.println("1 F = " + i + " X 10c") ;
						}
						else if (i == 0 && j != 0 && k != 0) {
							System.out.println("1 F = " + k + " X 2c + " + j + " X 5c") ;
						}						
						else if (i == 0 && j == 0 && k != 0) {
							System.out.println("1 F = " + k + " X 2c ") ;
						}
						else if(i == 0 && j != 0 && k == 0) {
							System.out.println("1 F = " + j + " X 5c") ;
						}
						else {
							System.out.println(" Impossible !") ;
						}
				  }
		   }
		System.out.println("En tout, il y " + nbf + " facons de faire 1 F") ;
	 }
}
