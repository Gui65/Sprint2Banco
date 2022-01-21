package br.com.sprintBanco.bo;

import java.util.UUID;

import br.com.sprintBanco.beans.Seguro;

public class ApoliceBo {

	public Seguro seguroMorte() {
		Seguro seguroMorte = new Seguro();

		seguroMorte.setId(UUID.randomUUID().toString());
		seguroMorte.setNome("Morte");
		seguroMorte.setValorAnual(36.00);

		return seguroMorte;
	}

	public Seguro seguroInvalidez() {
		Seguro seguroInvalidez = new Seguro();

		seguroInvalidez.setId(UUID.randomUUID().toString());
		seguroInvalidez.setNome("Invalidez");
		seguroInvalidez.setValorAnual(26.00);

		return seguroInvalidez;
	}

	public Seguro seguroDesemprego() {
		Seguro seguroDesemprego = new Seguro();

		seguroDesemprego.setId(UUID.randomUUID().toString());
		seguroDesemprego.setNome("Desemprego");
		seguroDesemprego.setValorAnual(16.00);

		return seguroDesemprego;
	}
	
	
}
