package br.com.sprintBanco.bo;

import java.util.UUID;

import br.com.sprintBanco.beans.CartaoDebito;

public class CartaoDebitoBo {

	public CartaoDebito ativaCartaoDebito(String bandeira, String senha, double limite) {

		CartaoDebito cartaoDebito = new CartaoDebito();

		cartaoDebito.setNumeroCartao(UUID.randomUUID().toString());
		cartaoDebito.setBandeiraCartao(bandeira);
		cartaoDebito.setSenhaCartao(senha);
		cartaoDebito.setLimitePorTransacao(limite);
		cartaoDebito.setCartaoAtivo(true);

		return cartaoDebito;

	}
	
}
