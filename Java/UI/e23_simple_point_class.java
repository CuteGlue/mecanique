// Création et utilisation d'une classe simple 
// un consttucteur recevant en argument le nom er l'abscisse d'un point
// une méthode affiche 
// une méthode translate effectuant une translation définie par la valeur de son arguments

class Point {
	public Point (char c, double x) {
		nom = c ;
		abs = x ;
	}
	public void affiche() {
		System.out.println("Point de nom " + nom + " abscisse " + abs) ;
	}
	public void translate(double dx) {
		abs += dx ;
	}
	private char nom ;
	private double abs ;
}

public class e23_simple_point_class {
	
	public static void main(String args[]) {
		
		Point a = new Point ('C', 2.5) ;
		a.affiche();
		Point b = new Point ('D', 5.25) ;
		b.affiche() ;
		b.translate(2.25) ;
		b.affiche();
	}
}
