package br.com.sprintBanco.bo;

import java.util.UUID;

import br.com.sprintBanco.beans.CartaoDebito;
import br.com.sprintBanco.beans.TipoBandeira;

public class CartaoDebitoBo {

	public CartaoDebito ativaCartaoDebito(TipoBandeira bandeira, String senha, double limite) {

		CartaoDebito cartaoDebito = new CartaoDebito();

		cartaoDebito.setNumeroCartao(UUID.randomUUID().toString());
		cartaoDebito.setBandeiraCartao(bandeira);
		cartaoDebito.setSenhaCartao(senha);
		cartaoDebito.setLimitePorTransacao(limite);
		cartaoDebito.setCartaoAtivo(true);

		return cartaoDebito;

	}
	
}
