import java.util.Scanner ;
public class Pizzeria {

	public Pizza listPizza[];
	private int count;
	private double total;

	public Pizzeria() {
		listPizza = new Pizza[6];
		count = 0;
		this.total = 0;
	}

	public void ajoutePizza(Pizza P) {
		listPizza[count] = P;
		count++;
	}

	public void afficheall() {
		for (int i = 0; i < count; i++) {
			listPizza[i].afficheInformation();
		}
	}

	public void commande(Pizza P, double n) {
		Boite B = new Boite(P.getTaille());
		double res = P.getPrix() * n + B.getBoiteprix() * n;
		this.total += res;
	}

	public double getTotal() {
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pizza P1 = new Pizza("Fromage", 12, "Grand");
		Pizza P2 = new Pizza("Fromage", 8, "Petit");
		Pizza P3 = new Pizza("Vegetale", 12, "Grand");
		Pizza P4 = new Pizza("Vegetale", 8, "Petit");
		Pizza P5 = new Pizza("Chorizo", 12, "Grand");
		Pizza P6 = new Pizza("Chorizo", 8, "Petit");

		Pizzeria Pisadian = new Pizzeria();
		Pisadian.ajoutePizza(P1);
		Pisadian.ajoutePizza(P2);
		Pisadian.ajoutePizza(P3);
		Pisadian.ajoutePizza(P4);
		Pisadian.ajoutePizza(P5);
		Pisadian.ajoutePizza(P6);

		Pisadian.afficheall();
		
		Pisadian.commande(P1, 1);
		Pisadian.commande(P6, 10);
		Pisadian.commande(P5, 10);


		
		
//		while (true) {
//
//			Scanner in = new Scanner(System.in);
//			System.out.println("Entre votre type de Pizza: ");
//			String nom = in.nextLine();
//			System.out.println("Entre taille de Pizza: ");
//			String size = in.nextLine();
//			System.out.println("Entre nombre de Pizza: ");
//			double N = in.nextDouble();
//			Pizza P = new Pizza(nom,12,size);
//			Pisadian.commande(P, N);
//			break ;
//		}
		
		

		System.out.println("total = " + Pisadian.getTotal() + " euros");

	}

}
