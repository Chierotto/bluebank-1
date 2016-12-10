package bluebank.jdbc.modelo;

import bluebank.jdbc.dao.ContaDao;

public class Conta {

	private int agencia;
	private int conta;
	private double saldo;
	
  public int getAgencia() {
	return agencia;
  }
  public int getConta() {
		return conta;
  }
  public double getSaldo() {
	return saldo;
  }
  public void setAgencia(int agencia) {
	this.agencia = agencia;
  }
  public void setConta(int conta) {
	this.conta = conta;
  }
  public void setSaldo(double saldo) {
	this.saldo = saldo;
  }

  public void transfere(Conta contadestino, double valor){
	  

	
	 try{
	  
	  existeConta(); 
	  
	  contadestino.existeConta();
	  
	  
	  saca(valor);
      
	  
	  contadestino.deposita(valor); 
	  
	 }catch (IllegalArgumentException e) {
		 throw new IllegalArgumentException(e.getMessage());
	} 
      
  }
  
  public void saca(double valor){
	  
	  buscaSaldo();
	  
	  if (this.saldo < valor ){
		  throw new IllegalArgumentException("Saldo Insuficiente");
	  }

	  this.saldo -= valor;
	  
	  ContaDao dao = new ContaDao(); 
	  
	  dao.AlteraSaldo(this.agencia, this.conta, this.saldo);
	  
  }
  
  public void deposita(double valor){
	   
	  buscaSaldo();
	  
	  this.saldo += valor;
	  
	  ContaDao dao = new ContaDao(); 
	  
	  dao.AlteraSaldo(this.agencia, this.conta, this.saldo);
	  
  }
  
  public void existeConta(){
	
	ContaDao dao = new ContaDao();  
	    
	if (dao.ExisteConta(this.agencia, this.conta) == 0) {
		throw new IllegalArgumentException("Conta invalida");
	}
		  
  }
  
  public void buscaSaldo(){
	 try{
	   	existeConta();
	 }catch (IllegalArgumentException e) {
		 System.out.println(e.getMessage());
	} 
	    
	ContaDao dao = new ContaDao();
	
	this.saldo = dao.BuscaSaldo(this.agencia, this.conta);
	
	    
  }  

}
