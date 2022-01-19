package br.com.sprintBanco.bo;

import java.util.UUID;

import br.com.sprintBanco.beans.Cartao;
import br.com.sprintBanco.beans.Cliente;
import br.com.sprintBanco.beans.ContaCorrente;
import br.com.sprintBanco.utils.BancoDeDados;

public class ContaCorrenteBo {

	public double DescontarTaxa(ContaCorrente contaC) {

		double saldo;
		saldo = contaC.getSaldo() * 0.0045;
		contaC.setSaldo(contaC.getSaldo() - saldo);
		return contaC.getSaldo();
	}

	public ContaCorrente CriarContaCorrente(Cliente cliente) {

		ContaCorrente contaC = new ContaCorrente();
		Cartao cartao = new Cartao();

		contaC.setIdConta(UUID.randomUUID().toString());
		contaC.setNumero(UUID.randomUUID().toString());
		contaC.setSaldo(0.0);
		contaC.setCliente(cliente);
		contaC.setCartao(cartao);

		BancoDeDados.insereContaCorrente(contaC.getNumero(), contaC);

		return contaC;

	}

}
