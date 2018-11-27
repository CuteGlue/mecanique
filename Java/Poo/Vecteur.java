
// VECTEUR



package homework1;
import java.util.Scanner;

public class Vecteur {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		Fraction a = new Fraction(in.nextInt(),in.nextInt());
		Fraction b = new Fraction(in.nextInt(),in.nextInt());
		a.print();
		b.print();
		a.plus(b).print();
		a.multiply(b).plus(new Fraction(5, 6)).print();
		a.print();
		b.print();
		in.close();
	}
}

class Fraction {
	private int x ;
	private int y ; 

	Fraction(int x, int y) {
				
		if (x==0 && y !=0) {
			this.x = 0 ;
			this.y = 0 ;
		}
		else if (y == 0) {
			System.out.println("ERROR, y cant be 0 !");
		}
		else {
			int g = 0 ;
			while(g != 1) {
				g = gcd(x,y) ;
				x = x / g ;
				y = y / g ;
			}
			this.x = x ;
			this.y = y ;
		}	
	}
		

	public double toDouble() {
		return 1.0*this.x/this.y ;
	};
	public void print() {
		if (x==0) {
			System.out.println(0) ;
		}
		else if (y==1) {
			System.out.println(1) ;
		}
		else {
			System.out.printf("%d/%d%n",x,y) ;
		}		
	}

	public Fraction plus(Fraction f) {
		Fraction F = new Fraction(this.x * f.y + this.y * f.x , this.y * f.y);
		return F;
	}

	public Fraction multiply(Fraction f) {
		Fraction F = new Fraction(this.x * f.x , this.y * f.y) ;
		return F ;
	}
	
	private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
