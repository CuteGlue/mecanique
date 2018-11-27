
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FenBouDyn extends JFrame implements ActionListener {

	public FenBouDyn(int nBoutMax) {
		setTitle("Creation - suppression de boutons (max " + nBoutMax + ")");
		setSize(500, 180);
		setLocation(1325, 400);
		Container contenu = getContentPane();
		creation = new JButton("CREATION");
		contenu.add(creation, "North");
		creation.addActionListener(this);

		suppresion = new JButton("SUPPRESION");
		contenu.add(suppresion, "South");
		suppresion.addActionListener(this);

		pan = new JPanel();
		contenu.add(pan); // au centre par defaut
		boutons = new JButton[nBoutMax];
		boutSelec = new boolean[nBoutMax];
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();

		if (source == creation) {
			boutons[nBout] = new JButton("BOUTON" + (nBout + 1));
			boutons[nBout].setBackground(Color.yellow);
			boutSelec[nBout] = false;
			pan.add(boutons[nBout]);
			boutons[nBout].addActionListener(this);
			pan.validate(); // pour forcer le recalcul par le gestionnaire
			nBout++;
		}

		if (source == suppresion) {
			for (int i = 0; i < nBout; i++) {
				if (boutSelec[i]) {
					pan.remove(boutons[i]);
				}
				pan.validate();
			}
		}
		for (int i = 0; i < nBout; i++) {
			if (source == boutons[i]) {
				if (boutSelec[i]) {
					boutSelec[i] = false;
					boutons[i].setBackground(Color.yellow);
				} else {
					boutSelec[i] = true;
					boutons[i].setBackground(Color.red);
				}
			}
		}
	}

	private JButton creation, suppresion;
	private JPanel pan;
	private JButton boutons[];
	private boolean boutSelec[];
	private static int nBout = 0;
}

public class eI05_synthese_creation_suppression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FenBouDyn fen = new FenBouDyn(50);
		fen.setVisible(true);
	}

}
