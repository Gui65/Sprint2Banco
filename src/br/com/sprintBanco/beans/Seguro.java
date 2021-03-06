package br.com.sprintBanco.beans;

import java.util.Date;

public class Seguro {

	private String id;
	private String nome;
	private String regras;
	private double valorAnual;
	private TipoSeguro tipoSeguro;
	private Date dataSeguro;
	
	public double getValorAnual() {
		return valorAnual;
	}

	public void setValorAnual(double valorAnual) {
		this.valorAnual = valorAnual;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRegras() {
		return regras;
	}

	public void setRegras(String regras) {
		this.regras = regras;
	}

	public TipoSeguro getTipoSeguro() {
		return tipoSeguro;
	}

	public void setTipoSeguro(TipoSeguro tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}

	public Date getDataSeguro() {
		return dataSeguro;
	}

	public void setDataSeguro(Date dataSeguro) {
		this.dataSeguro = dataSeguro;
	}
	
	

}
