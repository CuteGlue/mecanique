
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MaFenetre115 extends JFrame implements ActionListener {
	public MaFenetre115() {
		setTitle("Carres");
		setSize(400, 400);
		Container contenu = getContentPane();
		contenu.setLayout(new FlowLayout());
		labNombre = new JLabel(etiqNombre) ;
		contenu.add(labNombre);
		nombre = new JTextField(10);
		contenu.add(nombre);
		boutonCalcul = new JButton("CALCUL");
		contenu.add(boutonCalcul);
		boutonCalcul.addActionListener(this);
		labCarre = new JLabel(etiqCarre);
		contenu.add(labCarre);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == boutonCalcul)
			try {
				String texte = nombre.getText();
				int n = Integer.parseInt(texte);
				long carre = (long) n * (long) n;
				labCarre.setText(etiqCarre + carre);
			} catch (NumberFormatException ex) {
				nombre.setText("");
				labCarre.setText(etiqCarre);
			}
	}

	private JLabel labNombre;
	private JLabel labCarre;
	private JTextField nombre;
	static private String etiqNombre = "Bombre : ";
	static private String etiqCarre = "Carre : ";
	private JButton boutonCalcul;
}

public class eI15_champs_texte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaFenetre115 fen = new MaFenetre115();
		fen.setVisible(true);
	}

}
