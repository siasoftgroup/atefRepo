package siasoft.module1;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Boussaid
 *
 */
public class main {

	
	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		automobile auto = new automobile("wolswaguen", "rouge", 320);
		auto.toString();

		/* instanciation */
		filtre f = new filtre(" fiat", "bleu", 220, "ga620", "m605", "z213");

		/* surcharge */
		System.out.println(f.affiche());
		System.out.println(f.affiche(" misfat"));

		/* recuperation des donnees apartir de BD */
		f.user();
		 Scanner sc = new Scanner(System.in);
		 System.out.println("Saisissez nom client : ");
		    String nom = sc.nextLine();
		    System.out.println("Saisissez adresse client : ");
		    String adr = sc.nextLine();
		    System.out.println("Saisissez nemero de telephone client : ");
		    int tel = sc.nextInt();
		    f.ajoutuser(nom,adr,tel);
	}

}
