package br.com.sprintBanco.bo;

import java.util.HashMap;
import java.util.UUID;

import br.com.sprintBanco.beans.Seguro;
import br.com.sprintBanco.beans.TipoSeguro;

public class SeguroBo {

	public HashMap<TipoSeguro, Seguro> popularSeguros() {

		// Seguro Morte
		HashMap<TipoSeguro, Seguro> retorno = new HashMap();
		Seguro seguroMorte = new Seguro();
		seguroMorte.setNome("Morte");
		seguroMorte.setValorAnual(36.00);
		seguroMorte.setTipoSeguro(TipoSeguro.MORTE);
		seguroMorte.setId(UUID.randomUUID().toString());
		String regrasMorte = "\ni .Indenização por despesas médico-hospitalares, ou por perda parcial ou total do funcionamento dos membros ou órgãos;"
				+ "\nii. Reembolso de custos em diagnóstico de doenças graves, como infarto, acidente vascular cerebral e câncer"
				+ "\niii. Assistência funeral, para você e a sua família."
				+ "\niv. O valor do seguro individual é de R$36,00 ao ano.";
		seguroMorte.setRegras(regrasMorte);

		// seguro invalidez
		Seguro seguroInvalidez = new Seguro();
		seguroInvalidez.setNome("Invalidez");
		seguroInvalidez.setValorAnual(26.00);
		seguroInvalidez.setTipoSeguro(TipoSeguro.INVALIDEZ);
		seguroInvalidez.setId(UUID.randomUUID().toString());
		String regrasInvalidez = "\ni. Invalidez parcial: ocorre quando há uma perda parcial das funções. Por exemplo, uma pessoa que sofre um acidente e perda a visão em um só dos olhos."
				+ "\nii. Invalidez total: ocorre quando há uma perda total das funções. Intuitivamente, um bom exemplo seria o caso onde a pessoa sofre um acidente e perde a visão em ambos os olhos."
				+ "\niii. O valor do seguro individual é de R$26,00 ao ano.";
		seguroInvalidez.setRegras(regrasInvalidez);

		// seguro Desemprego
		Seguro seguroDesemprego = new Seguro();
		seguroDesemprego.setNome("Desemprego");
		seguroDesemprego.setValorAnual(16.00);
		seguroDesemprego.setTipoSeguro(TipoSeguro.DESEMPREGO);
		seguroDesemprego.setId(UUID.randomUUID().toString());
		String regrasDesemprego = "\ni. Necessário trabalhar com registro CLT, com o tempo mínimo de estabilidade de 12 meses."
				+ "\nii. Válido apenas para desligamento involuntários e sem justa causa."
				+ "\niii. Não é valido em caso de demissão em massa (10% ou mais de demissões simultâneas) ou falência/encerramento das atividades."
				+ "\niv. O valor do seguro individual é de R$16,00 ao ano.";
		seguroDesemprego.setRegras(regrasDesemprego);

		retorno.put(TipoSeguro.MORTE, seguroMorte);
		retorno.put(TipoSeguro.INVALIDEZ, seguroInvalidez);
		retorno.put(TipoSeguro.DESEMPREGO, seguroDesemprego);

		return retorno;

	}
}
