package br.com.sprintBanco.beans;

import java.util.Date;

public class Compra {

	private double valor;
	private Date date;

	public Compra(double valor, Date date) {

		this.valor = valor;
		this.date = date;
		
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
