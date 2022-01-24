package br.com.sprintBanco.bo;

import java.util.Date;
import java.util.UUID;

import br.com.sprintBanco.beans.Apolice;
import br.com.sprintBanco.beans.Seguro;

public class ApoliceBo {

	public Apolice salvarApolice(Seguro seguro) {
		Apolice apolice = new Apolice();
		Date dataAtual = new Date();
		Date dataCarencia = new Date();
		dataCarencia.setDate(dataCarencia.getDate() + 15);
		apolice.setId(UUID.randomUUID().toString());
		apolice.setValorApolice(seguro.getValorAnual());
		apolice.setDescricaoCondicoes("O valor só poderá ser recuperado se o prazo de carência (15 dias) for cumprido");
		apolice.setSeguro(seguro);
		apolice.setDataAssinatura(dataAtual);
		apolice.setDataCarencia(dataCarencia);
		return apolice;
	}
}
