package br.com.sprintBanco.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import br.com.sprintBanco.beans.Apolice;
import br.com.sprintBanco.beans.Seguro;

public class ApoliceBo {

	public Apolice salvarApolice(List <Seguro> seguro) {
		Apolice apolice = new Apolice();
		Date dataAtual = new Date();
		Date dataCarencia = new Date();
		
		apolice.setSeguro(seguro);
		dataCarencia.setDate(dataCarencia.getDate() + 15);
		apolice.setId(UUID.randomUUID().toString());
		Double valor = 0.0;
		for(int i = 0; i < seguro.size(); i++) {
			valor += seguro.get(i).getValorAnual();
		}
		apolice.setValorApolice(valor);
		apolice.setDescricaoCondicoes("O valor só poderá ser recuperado se o prazo de carência (15 dias) for cumprido");
		apolice.setDataAssinatura(dataAtual);
		apolice.setDataCarencia(dataCarencia);
		
		return apolice;
	}
	
	public Apolice cancelarSeguro() {
		Apolice apolice = new Apolice();
		return apolice;
	}
}
