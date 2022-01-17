package br.com.sprintBanco.beans;

public class CartaoDebito extends Cartao{

	private double limitePorTransacao;
	
	//GET AND SET
	public double getLimitePorTransacao() {
		return limitePorTransacao;
	}

	public void setLimitePorTransacao(double limitePorTransacao) {
		this.limitePorTransacao = limitePorTransacao;
	}
	
	
}
