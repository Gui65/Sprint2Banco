package br.com.sprintBanco.bo;

import br.com.sprintBanco.beans.CartaoDebito;

public class CartaoDebitoBo {

	public CartaoDebito ativaCartaoDebito(double limite) {
		CartaoDebito cartaoD = new CartaoDebito();
		
		cartaoD.setLimitePorTransacao(limite);
		cartaoD.setCartaoAtivo(true);

		return cartaoD;
	}

}
