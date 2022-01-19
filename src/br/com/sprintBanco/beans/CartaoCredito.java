package br.com.sprintBanco.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CartaoCredito extends Cartao {

	private double limite;
	private double valorFatura;
	private Date dataVencimento;
	private List<Compra> compras;

	public CartaoCredito() {

		this.setCartaoAtivo(false);
		this.setLimite(0.0);
		this.setValorFatura(0.0);
		this.compras = new ArrayList<Compra>();

	}

	// GET AND SET
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

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

}
