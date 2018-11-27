//import java.e23_simple_point_class.Point ;
import java.util.Scanner ;

// Méthode d'accès aux champs privés
// import Point ;
class Pointt {
	public Pointt (int abs, int ord) {
		x = abs ;   // abscisse  横坐标
		y = ord ;   // ordonnée  纵坐标
	}
	public void deplace(int dx, int dy) {
		x += dx ;
		y += dy ;
	}
	public void affiche() {
		System.out.println(" Je suis un point de coordonnes (" + x + " , " + y + ")") ;
	}
	private int x ;
	private int y ;
}
public class e27_accès_champ_privé {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pointt a ;
		a = new Pointt(3,5) ; a.affiche() ;
		a.deplace(1, 1) ;    a.affiche() ;
		Pointt b = new Pointt(6,8) ;   b.affiche() ;
		b.deplace(1, 1) ;            b.affiche() ;
		Point d = new Point('C', 2.3f) ;
		d.affiche() ;
	}

}
