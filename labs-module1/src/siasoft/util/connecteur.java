package siasoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class connecteur {
	    public static Statement getConnection () throws ClassNotFoundException, SQLException {
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection cnx =DriverManager.getConnection("jdbc:mysql://127.0.0.1/sad","root","");
	        Statement st= cnx.createStatement();
	        return st;
	    }

}
