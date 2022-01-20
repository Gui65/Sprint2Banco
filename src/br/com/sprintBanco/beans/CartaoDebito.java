package br.com.sprintBanco.beans;

import java.util.ArrayList;
import java.util.List;

public class CartaoDebito extends Cartao{

	private double limitePorTransacao;
	private List<Compra> compras;
	
	public CartaoDebito() {
		
		this.setLimitePorTransacao(0.0);
		this.setCartaoAtivo(false);
		this.compras = new ArrayList<Compra>();
	}

	//GET AND SET
	public double getLimitePorTransacao() {
		return limitePorTransacao;
	}

	public void setLimitePorTransacao(double limitePorTransacao) {
		this.limitePorTransacao = limitePorTransacao;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	
	
}
