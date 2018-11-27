
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MaFenetre118 extends JFrame implements ActionListener {

	private static String texteN = "n = ";
	private static String texteSomme = "Serie = ";

	public MaFenetre118() {
		setTitle("Serie Harmonique");
		setSize(400, 400);
		Container contenu = getContentPane();
		pan = new JPanel();
		contenu.add(pan);

		boutonPlus = new JButton("N++");
		boutonPlus.addActionListener(this);
		contenu.add(boutonPlus, "North");

		boutonMoins = new JButton("N--");
		boutonPlus.addActionListener(this);
		contenu.add(boutonMoins, "South");

		n = 0;
		somme = 0.;
		ValeurN = new JLabel(texteN + n + " ");
		pan.add(ValeurN);
		ValeurSomme = new JLabel(texteSomme + somme);
		pan.add(ValeurSomme);
	}

	public void actionPerformed(ActionEvent e) {
		// Object source = e.getSource() ;
		if (e.getSource() == boutonPlus) {
			n++;
			somme += 1. / n;
		}
		if (e.getSource() == boutonMoins && n > 0) {
			somme -= 1. / n;
			n--;
		}
		ValeurN.setText(texteN + n + " ");
		ValeurSomme.setText(texteSomme + somme);
	}

	private JPanel pan;
	private JButton boutonPlus;
	private JButton boutonMoins;
	private JLabel ValeurN;
	private JLabel ValeurSomme;
	private int n;
	private double somme;
}

public class eI18_synthese_serie_harmonique {

	public static void main(String[] args) {
		MaFenetre118 fen = new MaFenetre118();
		fen.setVisible(true);
	}

}
