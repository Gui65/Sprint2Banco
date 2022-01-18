package br.com.sprintBanco.bo;

import br.com.sprintBanco.beans.CartaoCredito;
import br.com.sprintBanco.beans.CartaoDebito;

public class CartaoCreditoBo {

	public CartaoCredito ativaCartaoCredito(double limite) {
		CartaoCredito cartaoC = new CartaoCredito();

		cartaoC.setLimite(limite);
		cartaoC.setCartaoAtivo(true);

		return cartaoC;
	}
	
	public String desativarCartaoCredito(CartaoCredito cartaoC) {

		cartaoC.setCartaoAtivo(false);
		
		return "Função credito desativada";
	}
	
	public String alterarLimiteCredito(CartaoCredito cartaoC, double limite) {
		
		cartaoC.setLimite(limite);
		
		return "Valor alterado com sucesso";
	}

}
