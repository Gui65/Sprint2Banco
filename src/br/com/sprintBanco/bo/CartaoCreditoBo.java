package br.com.sprintBanco.bo;

import java.util.UUID;

import br.com.sprintBanco.beans.CartaoCredito;
import br.com.sprintBanco.beans.TipoBandeira;

public class CartaoCreditoBo {

	public CartaoCredito ativarCartaoCredito(TipoBandeira bandeira, String senha, double limite) {

		CartaoCredito cartaoCredito = new CartaoCredito();
		
		cartaoCredito.setNumeroCartao(UUID.randomUUID().toString());
		cartaoCredito.setBandeiraCartao(bandeira);
		cartaoCredito.setSenhaCartao(senha);
		cartaoCredito.setLimite(limite);
		cartaoCredito.setCartaoAtivo(true);

		return cartaoCredito;
		
	}
}
