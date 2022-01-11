package br.com.sprintBanco.bo;

import java.util.UUID;

import br.com.sprintBanco.beans.Cliente;
import br.com.sprintBanco.beans.ContaPoupanca;

public class ContaPoupancaBo {

	public double AcrescentarRendimento() {

		ContaPoupanca contaPoupanca = new ContaPoupanca();

		double saldo;
		saldo = contaPoupanca.getSaldo() * 0.03;
		contaPoupanca.setSaldo(contaPoupanca.getSaldo() + saldo);
		return contaPoupanca.getSaldo();

	}

	public ContaPoupanca CriarContaPoupanca(Cliente cliente) {

		ContaPoupanca contaP = new ContaPoupanca();

		contaP.setIdConta(UUID.randomUUID().toString());
		contaP.setNumero(UUID.randomUUID().toString());
		contaP.setSaldo(0.0);
		contaP.setCliente(cliente);
		
		
		return contaP;

	}
}
