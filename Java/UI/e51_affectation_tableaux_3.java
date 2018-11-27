
public class e51_affectation_tableaux_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char t1[] = { 'b', 'o', 'n', 'j', 'o', 'u', 'r' };
		char t2[] = { 'h', 'e', 'l', 'l', 'o' };
		char t3[] = { 'x', 'x', 'x', 'x' };
		t3 = t1;
		System.out.print("t1 = ");
		System.out.println(t1);
		System.out.print("t2 = ");
		System.out.println(t2);
		System.out.print("t3 = ");
		System.out.println(t3);
		t1 = t2;
		System.out.print("t1 = ");
		System.out.println(t1);
		System.out.print("t2 = ");
		System.out.println(t2);
		System.out.print("t3 = ");
		System.out.println(t3);
		t2 = t3;
		System.out.print("t1 = ");
		System.out.println(t1);
		System.out.print("t2 = ");
		System.out.println(t2);
		System.out.print("t3 = ");
		System.out.println(t3);
	}

}
