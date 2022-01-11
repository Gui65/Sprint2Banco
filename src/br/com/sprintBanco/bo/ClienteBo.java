package br.com.sprintBanco.bo;

import java.util.UUID;

import br.com.sprintBanco.beans.Cliente;
import br.com.sprintBanco.beans.Endereco;
import br.com.sprintBanco.beans.TipoCliente;

public class ClienteBo {

	public Cliente CadastrarDados(String cpf, String nome, String dataNascimento, Endereco endereco) {

		Cliente cliente = new Cliente();

		cliente.setIdCliente(UUID.randomUUID().toString());
		cliente.setCpf(cpf);
		cliente.setNome(nome);
		cliente.setDataNascimento(dataNascimento);
		cliente.setTipo(TipoCliente.COMUM);
		cliente.setEndereco(endereco);

		return cliente;

	}

	
}
