
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

class Fenetre113 extends JFrame implements ActionListener{
	public Fenetre113(String libelles[]) {
		
	}
	public void actionPerformed(ActionEvent e) {
		
	}
	private String libelles[] ;
}

public class eI13_case_cocher_nombre_quelconquee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String libelles[] = {"Cercle", "Rectangle", "Triangle", "Pentagone", "Ellipse", "Carre" } ;
		new Fenetre113(libelles).setVisible(true) ;
	}

}
