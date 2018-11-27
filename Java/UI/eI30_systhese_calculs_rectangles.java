
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Scanner ;

class FenCalculs extends JFrame implements ActionListener {

	public FenCalculs() {
		setTitle("CALCULS sur des rectangles");
		setSize(400, 300);
//		setLayout(null);
		setLocation(1325, 450);
		
		/* creation barre des menus */
		barreMenus = new JMenuBar();
		barreMenus.setBackground(Color.green) ;
		setJMenuBar(barreMenus);
		/* creation menus dimension */
		dimensions = new JMenu("Dimensions");
		calculs = new JMenu("Calculs");
		barreMenus.add(dimensions);
		barreMenus.add(calculs);

		longeur = ajoute(dimensions, "Nouvelle longeur", this);
		largeur = ajoute(dimensions, "Nouvelle largeur", this);
		infos = ajoute(dimensions, "Dimensions actuelles", this);
		perimetre = ajoute(calculs, "Perimetre", this);
		aire = ajoute(calculs, "Aire", this);

	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if (source == longeur) {
			int n=lire("Donner la longeur") ;
			if (n>0) {
				L = n ;
			}
		}
		if (source == largeur) {
			int n = lire("Donner la largeur") ;
			l = n;
		}
		if (source == perimetre) {
			JOptionPane.showMessageDialog(null, "Perimetre = " + (2*(L+l)));
		}
		if (source == aire) {
			JOptionPane.showMessageDialog(null,  "Aire = " + (L*l));
		}
		if (source == infos) {
			JOptionPane.showMessageDialog(null,"Longeur = " + L+" , " + "Largeur = "  + l) ;
		}
	}
	
	private static JMenuItem ajoute(JMenu menu, String libelle, ActionListener ecouteur) {
		// TODO Auto-generated method stub
		JMenuItem option = new JMenuItem(libelle);
		menu.add(option);
		option.addActionListener(ecouteur);
		return option;
	}
	
	private static int lire(String question) {
		/* ici on demande une valeur jusqu'a ce qu'elle soit correct */
		/* c'est - a - dire entière et positive */
		boolean correct = false ;
		int valeur = 0 ;
		do {
			String rep = JOptionPane.showInputDialog(null, question) ;
			if (rep == null) {
				break ;
			}
			try {
				valeur = Integer.parseInt(rep) ;
				if (valeur > 0) {
					correct = true ;
				}
			}
			catch( NumberFormatException ex ) {
				
			}
			if (!correct) {
				JOptionPane.showMessageDialog(null,  "Valeur incorrecte ");
			}
		}while(true) ;
		return valeur ;
	}

	private JMenuBar barreMenus;
	private JMenu dimensions, calculs;
	private JMenuItem longeur, largeur, infos, perimetre, aire;
	private int l = 0, L = 0;
}

public class eI30_systhese_calculs_rectangles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FenCalculs fen = new FenCalculs();
		fen.setVisible(true);

	}

}
