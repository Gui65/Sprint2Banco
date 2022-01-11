package br.com.sprintBanco.bo;

import br.com.sprintBanco.beans.Cliente;
import br.com.sprintBanco.beans.Conta;
import br.com.sprintBanco.beans.ContaCorrente;
import br.com.sprintBanco.beans.ContaPoupanca;
import br.com.sprintBanco.beans.TipoCliente;
import br.com.sprintBanco.utils.BancoDeDados;

public class ContaBo {

	// Metodos para conta corrente
	public String sacarCorrente(double valor, ContaCorrente contaC) {
		if (valor <= contaC.getSaldo()) {
			contaC.setSaldo(contaC.getSaldo() - valor);
			return "Saque Realizado com Sucesso! " + contaC.getSaldo();
		} else {
			return "Saldo insuficiente " + contaC.getSaldo();
		}
	}

	public String transferirCorrente(double valor, ContaCorrente contaC, ContaCorrente contaRecebe) {
		if(contaRecebe != null) {
			if (valor <= contaC.getSaldo()) {
			contaRecebe.setSaldo(contaRecebe.getSaldo() + valor);
			contaC.setSaldo(contaC.getSaldo() - valor);
			return "Transferência realizada com sucesso!";
		} else {
			return "Saldo insuficiente " + contaC.getSaldo();
		}
	}else {
		return "Conta não existe";
	}
}

	public double depositoCorrente(double valor, ContaCorrente contaC) {
		contaC.setSaldo(contaC.getSaldo() + valor);
		
		BancoDeDados.insereContaCorrente(contaC.getNumero(), contaC);
		return contaC.getSaldo();
	}

	public double consultaCorrente(ContaCorrente contaC) {
		return contaC.getSaldo();
	}

	// Metodos para conta Poupanca
	public String sacarPoupanca(double valor, ContaPoupanca contaP) {
		if (contaP.getSaldo() > valor) {
			contaP.setSaldo(contaP.getSaldo() - valor);
			return "Saque Realizado com Sucesso! " + contaP.getSaldo();
		} else {
			return "Saldo insuficiente " + contaP.getSaldo();
		}
	}

	public String transferirPoupanca(double valor, ContaPoupanca contaP, ContaCorrente contaC) {
		if (contaC != null) {
			if (valor <= contaP.getSaldo()) {
				contaC.setSaldo(contaC.getSaldo() + valor);
				contaP.setSaldo(contaP.getSaldo() - valor);
				return "Transferência realizada com sucesso!";
			} else {
				return "Saldo insuficiente " + contaC.getSaldo();
			}
		} else {
			return "Você não tem uma conta corrente";
		}
	}

	public double depositoPoupanca(double valor, ContaPoupanca contaP) {
		contaP.setSaldo(contaP.getSaldo() + valor);
		return contaP.getSaldo();
	}

	public double consultaPoupanca(ContaPoupanca contaP) {
		return contaP.getSaldo();
	}

	public String StatusTipoConta(ContaCorrente contaC) {

		if (contaC.getSaldo() <= 5000) {
			contaC.getCliente().setTipo(TipoCliente.COMUM);
		} else if (contaC.getSaldo() <= 10000) {
			contaC.getCliente().setTipo(TipoCliente.SUPER);
		} else {
			contaC.getCliente().setTipo(TipoCliente.PREMIUM);
		}
		return "Seu tipo de conta é " + contaC.getCliente().getTipo();
	}
}