
class Point73 {
	public Point73(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void deplace(double dx, double dy) {
		x += dx;
		y += dy;
	}

	public void affiche() {
		System.out.println("Point de coordonnees " + x + " " + y);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	private double x, y;
}

class Cercle73 extends Point73 {

	public Cercle73(double x, double y, double r) {
		super(x, y);
		this.r = r;
		// TODO Auto-generated constructor stub
	}

	public void deplaceCentre(double dx, double dy) {
		super.deplace(dx, dy);
	}

	public void changeRayon(double r) {
		this.r = r;
	}

	public Point73 getCentre() {
		Point73 centre = new Point73(getX(), getY());
		return centre;
	}

	public void affiche() {
		System.out.println("Cercle de centre " + super.getX() + " " + super.getY() + " et de rayon " + r);
	}

	private double r;

}

public class e73_synthese_comparaison_heritage_mebre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cercle73 c = new Cercle73(3, 8, 2.5);
		c.affiche();
		c.deplaceCentre(1, 0.5);
		c.changeRayon(5.25);
		c.affiche();
		Point73 a = c.getCentre(); 
		a.affiche();

	}

}
