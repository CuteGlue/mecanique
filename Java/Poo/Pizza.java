
public class Pizza {

	private String type;
	private double prix;
	private String taille;

	public Pizza(String type, double prix, String taille) {
		this.type = type;
		this.prix = prix;
		this.taille = taille;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	public void setType(String type) {
		this.type = type;
	}

	public double getPrix() {
		return prix;
	}

	public String getType() {
		return type;
	}
	public String getTaille() {
		return taille;
	}

	public void afficheInformation() {
		System.out.println("Type = " + this.type + " Taille = " + this.taille + " Prix = " + this.prix);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pizza P1 = new Pizza("Fromage", 12, "Grand");
		P1.afficheInformation();
		P1.setPrix(10);
		System.out.println(P1.getPrix()) ;
	}

}
