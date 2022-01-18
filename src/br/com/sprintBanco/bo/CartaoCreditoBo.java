package br.com.sprintBanco.bo;

import br.com.sprintBanco.beans.CartaoCredito;

public class CartaoCreditoBo {

	public CartaoCredito ativaCartaoCredito(double limite) {
		CartaoCredito cartaoC = new CartaoCredito();

		cartaoC.setLimite(limite);
		cartaoC.setCartaoAtivo(true);

		return cartaoC;
	}

}
