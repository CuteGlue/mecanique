
// afficher une pendule indiquant l'heure fournie par le biais de deux champs de texte
// et validé par un bouton "Mise à l'heure" :

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;

class MaFenetre extends JFrame implements ActionListener {

	public MaFenetre() {
		setTitle("PENDULE");
		setSize(400, 400);
		Container contenu = getContentPane();
		panControles = new JPanel();
		contenu.add(panControles, "North");
		saisieHeures = new JTextField(4);
		panControles.add(saisieHeures);
		etiqHeures = new JLabel(" Heures");
		panControles.add(etiqHeures);
		saisieMinutes = new JTextField(4);
		panControles.add(saisieMinutes);
		etiqMinutes = new JLabel(" Minutes");
		panControles.add(etiqMinutes);
		ok = new JButton(" Mise a l'heure");
		panControles.add(ok);
		ok.addActionListener(this);
		panPendule = new PanPendule(this);
		contenu.add(panPendule);
		panPendule.setBackground(Color.green);
	}

	public int getMinutes() {
		return minutes;
	}

	public int getHeures() {
		return heures;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int h;
		int m;
		if (e.getSource() == ok) {
			try {
				String chHeures = saisieHeures.getText();
				h = Integer.parseInt(chHeures);
			} catch (NumberFormatException ex) {
				h = -1;
				saisieHeures.setText("");
			}
			try {
				String chMinutes = saisieMinutes.getText();
				m = Integer.parseInt(chMinutes);
			} catch (NumberFormatException ex) {
				m = -1;
				saisieMinutes.setText("");
			}
			if ((h >= 0) && (h < 24) && (m >= 0) && (m < 60)) {
				heures = h;
				minutes = m;
				repaint();
			} else {
				saisieMinutes.setText("" + minutes);
				saisieHeures.setText("" + heures);
			}
		}

	}

	private JPanel panControles;
	private PanPendule panPendule;
	private JTextField saisieHeures, saisieMinutes;
	private JLabel etiqHeures, etiqMinutes;
	private JButton ok;
	private int minutes = 0, heures = 0;
}

class PanPendule extends JPanel {
	public PanPendule(MaFenetre fen) {
		this.fen = fen;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Dimension dim = getSize();
		int largeur = dim.width;
		int hauteur = dim.height;
		boolean panTropLarge = (largeur > hauteur);
		int xCentre = largeur / 2;
		int yCentre = hauteur / 2;
		int rayon;
		if (panTropLarge) {
			rayon = hauteur / 2 - 20;
		} else {
			rayon = largeur / 2 - 20;
		}

		g.drawOval(xCentre - rayon, yCentre - rayon, 2 * rayon, 2 * rayon);
		int minutes = fen.getMinutes();
		double angle = Math.PI / 2 * (1. - minutes / 15.);
		g2.setStroke(new BasicStroke(3));
		g.drawLine(xCentre, yCentre, (int) (xCentre + rayon * Math.cos(angle)),
				(int) (yCentre - rayon * Math.sin(angle)));
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.drawString("12", xCentre - 8, yCentre - rayon - 5);
		// g.drawString("|", xCentre-8, yCentre - rayon+12) ;
		g.drawString("- 3", xCentre + rayon - 8, yCentre);
		g.drawString("6", xCentre, yCentre + rayon + 16);
		g.drawString("9 -", xCentre - rayon - 12, yCentre);
		int heures = fen.getHeures();
		angle = Math.PI / 2 * (1. - heures / 3. - minutes / 180.);
		g.drawLine(xCentre, yCentre, (int) (xCentre + rayon / 2. * Math.cos(angle)),
				(int) (yCentre - rayon / 2. * Math.sin(angle)));
	}

	private MaFenetre fen;
}

public class eI20_synthese_pendule {

	public static void main(String args[]) {
		MaFenetre fen = new MaFenetre();
		fen.setVisible(true);
	}

}
