
public class e49_affectation_tableaux_1 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
			int t1[] = {1, 2, 3, 5, 6, 6, 6} ;
			int t2[] = new int[4] ;
			for (int i=0 ; i<4 ; i++)
			{
				t2[i] = 2*i ;
			}
			t2 = t1 ;
			for (int i=0 ; i<4 ; i++)
			{
				System.out.println(t2[i]) ;
			}
			

	}

}
