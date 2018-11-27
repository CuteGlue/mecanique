
// creation de boutons et choix d'un gestionnaire flowlayout

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;;

class Fenboutons extends JFrame {

	public Fenboutons(int nBout) {
		setTitle("BOUTONS");
		setSize(400, 400);
		Container contenu = getContentPane();
		contenu.setLayout(new FlowLayout());
		for (int i = 0; i < nBout; i++) {
			unBouton = new JButton("BOUTON" + (i + 1));
			contenu.add(unBouton);
		}
	}

	private JButton unBouton;
}

public class eI03_creation_bouton_flowlayout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Combien de boutons ? ");
		Scanner in = new Scanner(System.in);
		int nBoutons = in.nextInt();
		Fenboutons fen = new Fenboutons(nBoutons);
		fen.setVisible(true);
	}

}
