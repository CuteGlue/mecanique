
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import javax.swing.event.*;

class Fenetre111 extends JFrame implements ActionListener {
	
	public static Color[] couleurs = { Color.yellow, Color.red, Color.blue, Color.green, Color.black, Color.cyan };

	public Fenetre111() {
		setTitle("Ardoise magique");
		setSize(400, 180);
		Container contenu = getContentPane();

		pan = new Panneau();
		pan.addMouseListener(pan);
		contenu.add(pan);

		boutNouv = new JButton("Nouvelle ligne");
		contenu.add(boutNouv, "North");
		boutNouv.addActionListener(this);

		boutEff = new JButton("Effacer");
		contenu.add(boutEff, "South");
		boutEff.addActionListener(this);

		boutCoul = new JButton("");
		contenu.add(boutCoul, "West");
		boutCoul.addActionListener(this);
		boutCoul.setBackground(couleurs[numCoul]);
		pan.setCoul(couleurs[numCoul]);

	}

	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource() == boutCoul) {
			numCoul++;
			if (numCoul >= couleurs.length) {
				numCoul = 0;
			}
			boutCoul.setBackground(couleurs[numCoul]);
			pan.setCoul(couleurs[numCoul]);
		}
		if (e.getSource() == boutNouv) {
			pan.getnouvelleLigne();
		}
		if (e.getSource() == boutEff) {
			pan.efface();
		}

	}
	
	private Panneau pan;
	private JButton boutNouv, boutEff, boutCoul;
	private int numCoul = 0;

}


class Panneau extends JPanel implements MouseListener {



	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		enCours = false;
	}

	public void setCoul(Color couleur) {
		this.couleur = couleur;
	}

	public void getnouvelleLigne() {
		enCours = false;
	}

	public void efface() {
		repaint();
	}

	public void mouseClicked(MouseEvent e) {
		xFin = e.getX();
		yFin = e.getY();
		if (enCours) {
			Graphics g = getGraphics();
			g.setColor(couleur);
			g.drawLine(xDeb, yDeb, xFin, yFin);
			g.dispose();
		}
		xDeb = xFin;
		yDeb = yFin;
		enCours = true;
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	private Color couleur;
	private boolean enCours = false;
	private int xDeb, yDeb, xFin, yFin;
}

public class eI11_synthese_ardoise {

	public static void main(String[] args) {
		Fenetre111 fen = new Fenetre111();
		fen.setVisible(true);

	}

}
