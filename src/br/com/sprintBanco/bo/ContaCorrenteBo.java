package br.com.sprintBanco.bo;

import java.util.UUID;

import br.com.sprintBanco.beans.Cliente;
import br.com.sprintBanco.beans.ContaCorrente;
import br.com.sprintBanco.utils.BancoDeDados;

public class ContaCorrenteBo {

	public double DescontarTaxa() {
		ContaCorrente contaCorrente = new ContaCorrente();
		double saldo;
		saldo = contaCorrente.getSaldo() * 0.045;
		contaCorrente.setSaldo(contaCorrente.getSaldo() - saldo);		
		return contaCorrente.getSaldo();
	}
	
	public ContaCorrente CriarContaCorrente(Cliente cliente) {
		
		ContaCorrente contaC = new ContaCorrente();
		
		contaC.setIdConta(UUID.randomUUID().toString());
		contaC.setNumero(UUID.randomUUID().toString());
		contaC.setSaldo(0.0);
		contaC.setCliente(cliente);
		
		BancoDeDados.insereConta(contaC.getNumero(), contaC);
		
		return contaC;
		
	}

}
