package br.com.sprintBanco.beans;

public class CartaoCredito extends Cartao{

	private double limite;
	private double valorFatura;
	
	//GET AND SET
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
	public double getValorFatura() {
		return valorFatura;
	}
	public void setValorFatura(double valorFatura) {
		this.valorFatura = valorFatura;
	}
	
	
}
