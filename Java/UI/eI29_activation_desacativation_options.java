
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class FenMenu extends JFrame implements ActionListener {
	public FenMenu() {
		setTitle("Menus");
		setSize(300, 130);

		/* creation barre des menus */
		barreMenus = new JMenuBar();
		setJMenuBar(barreMenus);

		/* creation menu Ficher et ses options */
		fichier = new JMenu("Fichier");
		barreMenus.add(fichier);
		ouvrir = new JMenuItem("Ouvrir");
//		ouvrir = ajoute (fichier,"TEST", this) ;
		fichier.add(ouvrir);
		ouvrir.addActionListener(this);
		sauvegarder = new JMenuItem("Sauvegarder");
		fichier.add(sauvegarder);
		sauvegarder.addActionListener(this);
		fermer = new JMenuItem("Fermer");
		fichier.add(fermer);
		fermer.addActionListener(this);

		/* creation menu Edition et ses options */
		edition = new JMenu("Editon");
		barreMenus.add(edition);
		copier = new JMenuItem("Copier");
		edition.add(copier);
		copier.addActionListener(this);
		coller = new JMenuItem("Coller");
		edition.add(coller);
		coller.addActionListener(this);

		/* etat initial : pas de fichier ouvert, pas d'info copie */
		fichierOuvert = false;
		infoCopiee = false;
		nomFichier = null;
		ouvrir.setEnabled(true);
		sauvegarder.setEnabled(false);
		fermer.setEnabled(false);
		copier.setEnabled(true);
		coller.setEnabled(false);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if (source == ouvrir) {
			String nom = JOptionPane.showInputDialog(this, "nom fichier a ouvrir");
			if ((nom == null) || (nom.equals(""))) {
				return;
			}
			if (fichierOuvert) {
				System.out.println("On ferme " + nomFichier);
			}
			nomFichier = nom;
			fichierOuvert = true;
			System.out.println("On ouvre " + nomFichier);
		}

		if (source == fermer) {
			System.out.println("On ferme " + nomFichier);
			fichierOuvert = false;
		}

		if (source == sauvegarder) {
			System.out.println(" On sauvegarder " + nomFichier);
		}

		if (source == copier) {
			System.out.println("Copie d'information");
			infoCopiee = true;
		}

		if (source == coller) {
			System.out.println("Collage d'information");
			infoCopiee = false;
		}

		/* activation - desactivation des options */
		copier.setEnabled(true); // par secrite
		coller.setEnabled(infoCopiee);
		ouvrir.setEnabled(true); // par securite
		sauvegarder.setEnabled(fichierOuvert);
		fermer.setEnabled(fichierOuvert);
	}

	private JMenuBar barreMenus;
	private JMenu fichier, edition;
	private JMenuItem ouvrir, sauvegarder, fermer, copier, coller;
	private boolean fichierOuvert, infoCopiee;
	private String nomFichier;
}

public class eI29_activation_desacativation_options {

	public static void main(String[] args) {
		FenMenu fen = new FenMenu();
		fen.setVisible(true);

	}

}
