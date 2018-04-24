package siasoft.module1;

public class automobile {

	public String constructeur;
	public String couleur;
	public int compteur;
	
	 public automobile(String cons,String color,int comp){
		    System.out.println("description d'une aotomobile !");          
		    constructeur = cons;
		    couleur = color;
		    compteur = comp;
		  }
	
	public automobile() {
		// TODO Auto-generated constructor stub
		System.out.println("description voiture");
	}

	@Override
	public String toString() {
	
		return "automobile [constructeur=" + constructeur + ", couleur=" + couleur + ", compteur=" + compteur + "]\"";
	}
	public String getConstructeur() {
		return constructeur;
	}
	public void setConstructeur(String constructeur) {
		this.constructeur = constructeur;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public int getCompteur() {
		return compteur;
	}
	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}
	
}
