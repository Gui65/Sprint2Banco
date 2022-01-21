package br.com.sprintBanco.bo;

import java.util.UUID;

import br.com.sprintBanco.beans.Apolice;
import br.com.sprintBanco.beans.Seguro;

public class ApoliceBo {

	public Apolice salvarApolice(Seguro seguro) {
		Apolice apolice = new Apolice();
		
		apolice.setId(UUID.randomUUID().toString());
		apolice.setValorApolice(seguro.getValorAnual());
		apolice.setDescricaoCondicoes("O valor só poderá ser recuperado se o prazo de carência (15 dias) for cumprido");
		apolice.setSeguro(seguro);
		return apolice;
	}
}
