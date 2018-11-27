
/*
 * C'est mon premier calculatrice, just do it !
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MaFenetre200 extends JFrame implements ActionListener {
	public MaFenetre200() {
		setTitle("My First Calculator");
		setSize(400, 500);
		// boutons
		Container contenu = getContentPane();
		// 计算面板

		pan = new JPanel();
		pan.setPreferredSize(new Dimension(380, 28));
		pan.setBackground(Color.white);

		contenu.add(pan);
		contenu.setLayout(new FlowLayout());

		Bouton0 = new JButton(" 0 ");
		Bouton0.addActionListener(this);
		contenu.add(Bouton0);
		Bouton1 = new JButton(" 1 ");
		Bouton1.addActionListener(this);
		contenu.add(Bouton1);
		Bouton2 = new JButton(" 2 ");
		Bouton2.addActionListener(this);
		contenu.add(Bouton2);
		Bouton3 = new JButton(" 3 ");
		Bouton3.addActionListener(this);
		contenu.add(Bouton3);
		Bouton4 = new JButton(" 4 ");
		Bouton4.addActionListener(this);
		contenu.add(Bouton4);
		Bouton5 = new JButton(" 5 ");
		Bouton5.addActionListener(this);
		contenu.add(Bouton5);
		Bouton6 = new JButton(" 6 ");
		Bouton6.addActionListener(this);
		contenu.add(Bouton6);
		Bouton7 = new JButton(" 7 ");
		Bouton7.addActionListener(this);
		contenu.add(Bouton7);
		Bouton8 = new JButton(" 8 ");
		Bouton8.addActionListener(this);
		contenu.add(Bouton8);
		Bouton9 = new JButton(" 9 ");
		Bouton9.addActionListener(this);
		contenu.add(Bouton9);
		Boutonplus = new JButton(" + ");
		Boutonplus.addActionListener(this);
		contenu.add(Boutonplus);
		Boutonmoins = new JButton(" - ");
		Boutonmoins.addActionListener(this);
		contenu.add(Boutonmoins);
		Boutonmul = new JButton(" x ");
		Boutonmul.addActionListener(this);
		contenu.add(Boutonmul);
		Boutondivi = new JButton(" ÷ ");
		Boutondivi.addActionListener(this);
		contenu.add(Boutondivi);
		Boutonequal = new JButton(" = ");
		Boutonequal.addActionListener(this);
		contenu.add(Boutonequal);
		Boutonclear = new JButton("  clear  ");
		Boutonclear.addActionListener(this);
		contenu.add(Boutonclear);
		Boutonpoint = new JButton(" . ");
		Boutonpoint.addActionListener(this);
		contenu.add(Boutonpoint);

		contenu.setBackground(Color.green);
		

		affiche = new JLabel(" " + " ");
		pan.add(affiche);

	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		resultat = ((JButton) source).getText();
		affiche.setText(" " + resultat + " ");
	}

	public void action(String resultat) {
		
		switch (operateur) {
		case '+':
			value = v1 + v2;
			break;
		case '-':
			value = v1 - v2;
			break;
		case 'x':
			value = v1 * v2;
			break;
		case '÷':
			value = v1 / v2;
			break;
		}
		affiche.setText(affiche.getText() + "value" + " ");
	}

	private JButton Bouton0, Bouton1, Bouton2, Bouton3, Bouton4, Boutonequal;
	private JButton Bouton5, Bouton6, Bouton7, Bouton8, Bouton9, Boutonpoint;
	private JButton Boutonplus, Boutonmoins, Boutonmul, Boutondivi, Boutonclear;
	private JPanel pan;
	private String resultat;
	private JLabel affiche;
	private double v1, v2, value;
	private char operateur;
}

public class e200_mycalculatrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaFenetre200 fen = new MaFenetre200();
		fen.setLocation(1300, 350);
		fen.setVisible(true);
	}

}
