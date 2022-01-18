package br.com.sprintBanco.bo;

import br.com.sprintBanco.beans.CartaoDebito;

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

}
