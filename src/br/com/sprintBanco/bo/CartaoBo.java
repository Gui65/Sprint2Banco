package br.com.sprintBanco.bo;

import java.util.UUID;

import br.com.sprintBanco.beans.Cartao;
import br.com.sprintBanco.beans.CartaoCredito;
import br.com.sprintBanco.beans.CartaoDebito;
import br.com.sprintBanco.beans.TipoBandeira;

public class CartaoBo {
	
	
	public Cartao ativaCartao(TipoBandeira bandeira, String senha) {

		Cartao cartao = new Cartao();
		
		cartao.setNumeroCartao(UUID.randomUUID().toString());
		cartao.setBandeiraCartao(bandeira);
		cartao.setSenhaCartao(senha);
		
		return cartao;

	}
}
