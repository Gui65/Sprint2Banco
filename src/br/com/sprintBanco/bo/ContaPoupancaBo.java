package br.com.sprintBanco.bo;

import java.util.UUID;

import br.com.sprintBanco.beans.Cartao;
import br.com.sprintBanco.beans.Cliente;
import br.com.sprintBanco.beans.ContaPoupanca;
import br.com.sprintBanco.utils.BancoDeDados;

public class ContaPoupancaBo {

	public double AcrescentarRendimento(ContaPoupanca contaP) {

		double saldo;
		saldo = contaP.getSaldo() * 0.03;
		contaP.setSaldo(contaP.getSaldo() + saldo);
		return contaP.getSaldo();

	}

	public ContaPoupanca CriarContaPoupanca(Cliente cliente) {

		ContaPoupanca contaP = new ContaPoupanca();
		Cartao cartao = new Cartao();

		contaP.setIdConta(UUID.randomUUID().toString());
		contaP.setNumero(UUID.randomUUID().toString());
		contaP.setSaldo(0.0);
		contaP.setCliente(cliente);
		contaP.setCartao(cartao);

		BancoDeDados.insereContaPoupanca(contaP.getNumero(), contaP);

		return contaP;

	}
}
