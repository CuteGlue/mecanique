
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Fenetre112 extends JFrame implements ActionListener, ItemListener {
	public Fenetre112() {

		setTitle("Cases a cocher");
		setSize(300, 140);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(1325, 400);
		Container contenu = getContentPane();

		// Deux Boutons
		boutRaz = new JButton("RAZ");
		boutRaz.setBackground(Color.yellow);
		// boutRaz.setIcon(new ImageIcon("scopexx15.png"));
		contenu.add(boutRaz, "North");
		boutRaz.addActionListener(this);

		boutEtat = new JButton("Etat");
		boutEtat.setBackground(Color.yellow);
		contenu.add(boutEtat, "South");
		boutEtat.addActionListener(this);

		pan = new JPanel();
		pan.setBackground(Color.green);
		contenu.add(pan);
		cercle = new JCheckBox("Cercle");
		cercle.setBackground(Color.red);
		rectangle = new JCheckBox("Rectangle");
		rectangle.setBackground(Color.red);
		triangle = new JCheckBox("Triangle");
		triangle.setBackground(Color.red);

		pan.add(cercle);
		pan.add(rectangle);
		pan.add(triangle);

		cercle.addActionListener(this);
		cercle.addItemListener(this);
		rectangle.addActionListener(this);
		rectangle.addItemListener(this);
		triangle.addActionListener(this);
		triangle.addItemListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == boutRaz) {
			cercle.setSelected(false);
			rectangle.setSelected(false);
			triangle.setSelected(false);
		}
		if (source == boutEtat) {
			System.out.println("Cases Selectionnes : ");
			if (cercle.isSelected()) {
				System.out.print(" cercle ");
			}
			if (rectangle.isSelected()) {
				System.out.print(" rectangle ");
			}
			if (triangle.isSelected()) {
				System.out.print(" triangle ");
			}
		}
		if (source == cercle) {
			System.out.println(" Action case cercle ");
		}
		if (source == rectangle) {
			System.out.println(" Action case rectangle ");
		}
		if (source == triangle) {
			System.out.println(" Action case triangle ");
		}

	}

	public void itemStateChanged(ItemEvent e) {
		Object source = e.getSource() ;
		if (source == cercle) {
			System.out.println(" Item case cercle ");
		}
		if (source == rectangle) {
			System.out.println(" Item case rectangle ");
		}
		if (source == triangle) {
			System.out.println(" Item case triangle ");
		}
	}

	private JButton boutRaz, boutEtat;
	private JPanel pan;
	private JCheckBox cercle, rectangle, triangle;
}

public class eI12_case_cocher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Fenetre112 fen = new Fenetre112();
		// fen.setVisible(true);
		new Fenetre112().setVisible(true);
	}

}
