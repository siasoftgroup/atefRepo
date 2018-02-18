package siasoft.module1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import siasoft.util.connecteur;

/**
 * @author Boussaid
 *
 */
public class filtre extends automobile {
	private String gas;

	public filtre() {
		super();
		this.gas = "aucun ";
	}

	public filtre(String cons, String color, int comp, String fair, String fgasoil, String fhuile) {
		super(cons, color, comp);
		this.gas = fgasoil;
		System.out.println(
				cons + " filtre a air :" + fair + " , filtre a huile : " + fhuile + " , filtre a gasoil : " + this.gas);

	}

	public String affiche() {
		String str = super.toString() + "-- filtre a gasoil:" + this.gas + ".";
		return str;
	}

	public String affiche(String b) {
		String str = "merci " + b + " pour le filtre :" + this.gas;
		return str;
	}

	public void user() throws ClassNotFoundException, SQLException {
		Statement st = connecteur.getConnection();
		String rq = "select * from clients ";
		ResultSet rs = st.executeQuery(rq);
		while (rs.next()) {
			String att1 = rs.getString(2);
			String att2 = rs.getString(3);
			int att3 = rs.getInt(4);
			System.out.println("client :" + att1 + " de " + att2 + " ,avec numero tel :" + att3);

		}
	}

	// if(rs.next()) b=true);
	// else b=false;
public void ajoutuser(String nom, String adr,int num) throws SQLException, ClassNotFoundException 
{
	 
	String rq1="";
	Statement stb = connecteur.getConnection();
	 rq1="INSERT INTO clients(int,nom,adresse,tel,matricule,credit,acompte) VALUES(100"+nom+","+adr+","+num+")";
	stb.executeUpdate(rq1);
	System.out.println("ajout client avec success. ");
	
	
	
}

}
