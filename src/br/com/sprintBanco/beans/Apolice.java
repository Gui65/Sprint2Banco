package br.com.sprintBanco.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Apolice {

	private String id;
	private double valorApolice;
	private String descricaoCondicoes;
	private Date dataAssinatura;
	private Date dataCarencia;
	private List <Seguro> seguro;

	public Apolice() {
		List <Seguro> listaSeguro = new ArrayList();
		setSeguro(listaSeguro);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getValorApolice() {
		return valorApolice;
	}

	public void setValorApolice(double valorApolice) {
		this.valorApolice = valorApolice;
	}

	public String getDescricaoCondicoes() {
		return descricaoCondicoes;
	}

	public void setDescricaoCondicoes(String descricaoCondicoes) {
		this.descricaoCondicoes = descricaoCondicoes;
	}

	public Date getDataCarencia() {
		return dataCarencia;
	}

	public void setDataCarencia(Date dataCarencia) {
		this.dataCarencia = dataCarencia;
	}

	public List<Seguro> getSeguro() {
		return seguro;
	}

	public void setSeguro(List<Seguro> seguro) {
		this.seguro = seguro;
	}

	public Date getDataAssinatura() {
		return dataAssinatura;
	}

	public void setDataAssinatura(Date dataAssinatura) {
		this.dataAssinatura = dataAssinatura;
	}

}
