
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Fenetre106 extends JFrame implements ActionListener {

	public static Dimension dimPetieBouton = new Dimension(70, 30);
	public static Dimension dimGrosBouton = new Dimension(110, 30);

	public Fenetre106() {
		setTitle("Gros et Petits Boutons");
		setSize(500, 200);
		setLocation(1325, 400);

		Container contenu = getContentPane();
		contenu.setBackground(Color.green);

		grosBouton = new JButton("GROS BOUTON");
		grosBouton.setBackground(Color.cyan);
		petitBouton = new JButton("PETIT BOUTON");
		petitBouton.setBackground(Color.cyan);
		contenu.add(grosBouton, "North");
		contenu.add(petitBouton, "South");
		grosBouton.addActionListener(this);
		petitBouton.addActionListener(this);

		pan = new JPanel();
		pan.setBackground(Color.yellow);
		contenu.add(pan); // au centre par defaut
	}

	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();
		if (source == grosBouton) {
			JButton bouton = new JButton(etiqCompt);
			pan.add(bouton);
			bouton.addActionListener(new EcoutGrosBouton(pan, etiqCompt));
			bouton.setPreferredSize(dimGrosBouton);
			pan.validate();
		}

		if (source == petitBouton) {
			JButton bouton = new JButton("Petie");
			pan.add(bouton);
			bouton.addActionListener(new EcoutPetitBouton(pan));
			bouton.setPreferredSize(dimPetieBouton);
			pan.validate();
		}

	}

	private JButton grosBouton, petitBouton;
	private JPanel pan;
	private static String etiqCompt = "COMPTE = ";
}

class EcoutGrosBouton implements ActionListener {
	static int nMaxClis = 5;

	public EcoutGrosBouton(JPanel pan, String etiqCompt) {
		nActions = 0;
		this.pan = pan;
		this.etiqCompt = etiqCompt;
	}

	public void actionPerformed(ActionEvent e) {
		JButton bouton = (JButton) e.getSource();
		nActions++;
		if (nActions >= nMaxClis) {
			pan.remove(bouton);
			pan.validate();
		} else {
			bouton.setText(etiqCompt + nActions);
		}
	}

	private String etiqCompt;
	private int nActions;
	private JPanel pan;

}

class EcoutPetitBouton implements ActionListener {
	public EcoutPetitBouton(JPanel pan) {
		this.pan = pan;
	}

	public void actionPerformed(ActionEvent e) {
		JButton bouton = (JButton) e.getSource();
		pan.remove(bouton);
		pan.validate();
	}

	private JPanel pan;
}

public class eI06_synthese_creation_suppresion_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fenetre106 fen = new Fenetre106();
		fen.setVisible(true);
	}

}
