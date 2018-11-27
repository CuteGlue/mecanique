
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*; // utile pour documentlistener

class MaFenetre117 extends JFrame implements DocumentListener {
	public MaFenetre117() {
		setTitle("Carres");
		setSize(400, 400);
		Container contenu = getContentPane();
		contenu.setLayout(new FlowLayout());

		labNombre = new JLabel(etiqNombre);
		contenu.add(labNombre);
		nombre = new JTextField(10);
		contenu.add(nombre);
		nombre.getDocument().addDocumentListener(this);
		labCarre = new JLabel(etiqCarre);
		contenu.add(labCarre);
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		actualise();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		actualise();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
	}

	public void actualise() {
		try {
			String texte = nombre.getText();
			int n = Integer.parseInt(texte);
			long carre = (long) n * (long) n;
			labCarre.setText(etiqCarre + carre);
		} catch (NumberFormatException ex) {
			// number.settext("") ; generait une exception
			labCarre.setText(etiqCarre);
		}
	}

	private JLabel labNombre;
	private JLabel labCarre;
	private JTextField nombre;
	static private String etiqNombre = "Nombre : ";
	static private String etiqCarre = "Carre : ";
	private JButton boutonCalcul;

}

public class eI17_permanente_champ_texte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaFenetre117 fen = new MaFenetre117();
		fen.setVisible(true);
	}

}
