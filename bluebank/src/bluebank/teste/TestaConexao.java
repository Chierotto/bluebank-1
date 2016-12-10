package bluebank.teste;

import java.sql.Connection;
import java.sql.SQLException;
import bluebank.jdbc.ConnectionFactory;

/**
 * @author gchiero
 *
 */
public class TestaConexao {
	
	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();
		System.out.println("Conexão aberta!");
		connection.close();

	}

}
	