package br.com.sprintBanco.beans;

public class CartaoDebito extends Cartao{

	private double limitePorTransacao;
	
	
	public CartaoDebito() {
		
		this.setLimitePorTransacao(0.0);
		this.setCartaoAtivo(false);
		
	}

	//GET AND SET
	public double getLimitePorTransacao() {
		return limitePorTransacao;
	}

	public void setLimitePorTransacao(double limitePorTransacao) {
		this.limitePorTransacao = limitePorTransacao;
	}
	
	
}
