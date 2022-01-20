package br.com.sprintBanco.bo;

import java.util.Date;

import br.com.sprintBanco.beans.CartaoDebito;
import br.com.sprintBanco.beans.Compra;
import br.com.sprintBanco.beans.ContaCorrente;
import br.com.sprintBanco.beans.ContaPoupanca;

public class CartaoDebitoBo {

	public CartaoDebito ativaCartaoDebito(double limite) {
		CartaoDebito cartaoD = new CartaoDebito();

		cartaoD.setLimitePorTransacao(limite);
		cartaoD.setCartaoAtivo(true);

		return cartaoD;
	}

	public String desativarCartaoDebito(CartaoDebito cartaoD) {

		cartaoD.setCartaoAtivo(false);

		return "Função debito desativada";
	}

	public String alterarLimiteDebito(CartaoDebito cartaoD, double limite) {

		cartaoD.setLimitePorTransacao(limite);

		return "Valor alterado com sucesso";
	}

	public String compraDebito(double valor, ContaCorrente contaC) {

		if (valor <= contaC.getSaldo()) {
			if (valor < contaC.getCartao().getCartaoDebito().getLimitePorTransacao()) {
				contaC.setSaldo(contaC.getSaldo() - valor);
				adicionaCompra(valor, contaC);
				return "Compra efetuada com sucesso!";
			} else {
				return "Valor excedeu seu limite";
			}
		} else {
			return "Saldo insuficiente, seu saldo é: " + contaC.getSaldo();
		}
	}

	public void adicionaCompra(double valor, ContaCorrente contaC) {
		Compra compra = new Compra(valor, new Date());
		contaC.getCartao().getCartaoDebito().getCompras().add(compra);
	}

	public String compraDebitoPoupanca(double valor, ContaPoupanca contaP) {

		if (valor <= contaP.getSaldo()) {
			if (valor < contaP.getCartao().getCartaoDebito().getLimitePorTransacao()) {
				contaP.setSaldo(contaP.getSaldo() - valor);
				adicionaCompraPoupanca(valor, contaP);
				return "Compra efetuada com sucesso!";
			} else {
				return "Valor excedeu seu limite";
			}
		} else {
			return "Saldo insuficiente, seu saldo é: " + contaP.getSaldo();
		}

	}

	public void adicionaCompraPoupanca(double valor, ContaPoupanca contaP) {
		Compra compra = new Compra(valor, new Date());
		contaP.getCartao().getCartaoDebito().getCompras().add(compra);
	}

}
