package bluebank.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
	     try {
	    	 DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	         return DriverManager.getConnection(
	         "jdbc:mysql://us-cdbr-iron-east-04.cleardb.net/ad_e6f755e8301ba6d", "b75ebf0e443ad0", "edd20cce");
	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }
	     
	     
	     
	 }	
	
}
