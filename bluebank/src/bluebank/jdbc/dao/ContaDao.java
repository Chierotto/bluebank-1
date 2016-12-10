package bluebank.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bluebank.jdbc.ConnectionFactory;


public class ContaDao {
	
	private Connection connection;
	   
	public ContaDao() {
	  this.connection = new ConnectionFactory().getConnection();
	}	

	public int ExisteConta(int agencia, int conta){
		try{
			PreparedStatement stmt = this.connection.
	                 prepareStatement("select count(1) existe from conta where agencia = ? and conta = ?");
		    
			stmt.setLong(1,agencia);
		    stmt.setLong(2,conta);
				
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			
			int existe = rs.getInt("existe");
			
			rs.close();
			stmt.close();
			connection.close();
			
			return existe; 
			
			
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}	
		
	}
	
	
	public double BuscaSaldo(int agencia, int conta){
		
		try{
			PreparedStatement stmt = this.connection.
	                 prepareStatement("select saldo from conta where agencia = ? and conta = ?");
			
	       stmt.setLong(1,agencia);
	       stmt.setLong(2,conta);
			
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
						
			double saldo = rs.getDouble("saldo");
			
			rs.close();
			stmt.close();
			connection.close();
			return saldo;  			
			
			
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
				
	}
	
	public void AlteraSaldo(int agencia, int conta, double saldo){
		try{
			PreparedStatement stmt = this.connection.
	                 prepareStatement("update conta set saldo = ? where agencia = ? and conta = ?");
			
		   stmt.setDouble(1,saldo);	
	       stmt.setLong(2,agencia);
	       stmt.setLong(3,conta);
			
		   stmt.execute();
		   stmt.close();	  			
		   connection.close();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
	
}
