
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class FenRect extends JFrame implements ActionListener {
	
	public FenRect(Color[] couleurs, String[] nomsCouleurs) {
		setTitle(" Couleurs de fond et de forme");
		setSize(400, 300);
		this.couleurs = couleurs ;
		this.nomsCouleurs = nomsCouleurs ;
		setLocation(1325, 400);

		/* creation de barmenus */
		barreMenus = new JMenuBar();
		barreMenus.setBackground(Color.green);
		setJMenuBar(barreMenus);

		/* creation menu et ses menus desendants */
		couleur = new JMenu("Couleur");
		barreMenus.add(couleur);
		menuCouleurFond = new JMenu("Fond");
		menuCouleurForme = new JMenu("Forme");
		couleur.add(menuCouleurFond);
		couleur.add(menuCouleurForme);

		/* creation des menus items */
		nbCouleurs = couleurs.length;
		optionsCouleurFond = new JMenuItem[nbCouleurs];
		optionsCouleurForme = new JMenuItem[nbCouleurs];
		for (int i = 0; i < nbCouleurs; i++) {
			optionsCouleurFond[i] = new JMenuItem(nomsCouleurs[i]);
			optionsCouleurFond[i].addActionListener(this);
			menuCouleurFond.add(optionsCouleurFond[i]);
			optionsCouleurForme[i] = new JMenuItem(nomsCouleurs[i]);
			optionsCouleurForme[i].addActionListener(this);
			menuCouleurForme.add(optionsCouleurForme[i]);
		}

		panneau = new Panneau132(this);
		getContentPane().add(panneau);
	}


	public void actionPerformed(ActionEvent e) {
	
		Object source = e.getSource();
		for (int i = 0; i < nbCouleurs; i++) {
			if (source == optionsCouleurFond[i]) {
				couleurFond = couleurs[i];
			}
			if (source == optionsCouleurForme[i]) {
				couleurForme = couleurs[i];
			}
		}
		panneau.repaint(); // pour forcer a repeindre l'ensemble de la fenetre
	}

	public Color getCouleurFond() {
		return couleurFond;
	}

	public Color getCouleurForme() {
		return couleurForme;
	}

	private Color[] couleurs;
	private String[] nomsCouleurs;
	private JMenuBar barreMenus;
	private Panneau132 panneau;
	private JMenu couleur, menuCouleurFond, menuCouleurForme;
	private JMenuItem[] optionsCouleurFond, optionsCouleurForme;
	private int nbCouleurs;
	private Color couleurFond = Color.white, couleurForme = Color.black;
}

class Panneau132 extends JPanel {
	public static int x = 90, y = 60, largeur = 200, hauteur = 120;

	public Panneau132(FenRect fen) {
		this.fen = fen;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(fen.getCouleurFond());
		g.setColor(fen.getCouleurForme());
		g.fillRect(x, y, largeur, hauteur);
	}

	private FenRect fen;

}

public class eI32_synthese_menus_composes {

	private static Color[] couleurs = { Color.yellow, Color.red, Color.blue, Color.pink, Color.green };
	private static String[] nomsCouleurs = { "jaune", "rouge", "bleu", "rose", "vert" };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FenRect fen = new FenRect(couleurs, nomsCouleurs);
		fen.setVisible(true);
	}

}
