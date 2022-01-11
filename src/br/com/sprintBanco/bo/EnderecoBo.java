package br.com.sprintBanco.bo;

import br.com.sprintBanco.beans.Endereco;

public class EnderecoBo {

	/*
	 * public boolean BuscarEndereco(String cep) {
	 * 
	 * }
	 */

	public Endereco CadastraEndereco(String logradouro, String numeroCasa, String cep, String bairro, String cidade,
			String estado) {

		Endereco endereco = new Endereco();

		endereco.setLogradouro(logradouro);
		endereco.setNumeroCasa(numeroCasa);
		endereco.setCep(cep);
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
		
		return endereco;

	}

}
