
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Fenetre109 extends JFrame implements ActionListener {

	public Fenetre109() {
		setTitle("Dessin et Couleurs");
		setSize(300, 150);
		setLocation(1325, 400);

		Container contenu = getContentPane();
		pan = new Panneau109();
		contenu.add(pan);

		CoulFond = new JButton("Couleur fond");
		CoulTrait = new JButton("Couleur trait");
		contenu.add(CoulFond, "North");
		contenu.add(CoulTrait, "South");
		CoulFond.addActionListener(this);
		CoulTrait.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == CoulFond) {
			pan.changeCoulFond();
		}
		if (source == CoulTrait) {
			pan.changeCoulTrait();
		}
	}

	private Panneau109 pan;
	private JButton CoulFond, CoulTrait;

}

class Panneau109 extends JPanel {

	final Color[] couleurs = { Color.yellow, Color.red, Color.green, Color.cyan, Color.white, Color.gray, Color.pink,
			Color.blue };

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(couleurs[numCoulFond]);
		setForeground(couleurs[numCoulTrait]);
		Dimension dim = getSize();
		int x = 5, y = 5;
		int l = dim.width, h = dim.height;
		// tracer du rectangle
		g.drawLine(x, y, l - x, y);
		g.drawLine(x, y, x, h - y);
		g.drawLine(l - x, y, l - x, h - y);
		g.drawLine(x, h - y, l - x, h - y);
		// tracer des diagonales
		g.drawLine(x, y, l - x, h - y);
		g.drawLine(x, h - y, l - x, y);
	}

	public void changeCoulFond() {
		numCoulFond++;
		if (numCoulFond >= couleurs.length) {
			numCoulFond = 0;
		}
		repaint();
	}

	public void changeCoulTrait() {
		numCoulTrait++;
		if (numCoulTrait >= couleurs.length) {
			numCoulTrait = 0;
		}
		repaint();
	}

	private int numCoulFond = 0, numCoulTrait = 1;
}

public class eI09_synthese_dessin_permanent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fenetre109 fen = new Fenetre109();
		fen.setVisible(true);

	}

}
