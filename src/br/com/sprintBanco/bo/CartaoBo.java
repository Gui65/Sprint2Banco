package br.com.sprintBanco.bo;

import java.util.UUID;

import br.com.sprintBanco.beans.Cartao;
import br.com.sprintBanco.beans.CartaoCredito;
import br.com.sprintBanco.beans.CartaoDebito;
import br.com.sprintBanco.beans.ContaCorrente;
import br.com.sprintBanco.beans.TipoBandeira;
import br.com.sprintBanco.utils.BancoDeDados;

public class CartaoBo {
	
	
	public Cartao ativaCartao(TipoBandeira bandeira, String senha) {

		Cartao cartao = new Cartao();
		CartaoDebito cartaoD = new CartaoDebito();
		CartaoCredito cartaoC = new CartaoCredito();
		
		cartao.setNumeroCartao(UUID.randomUUID().toString());
		cartao.setBandeiraCartao(bandeira);
		cartao.setSenhaCartao(senha);
		cartao.setCartaoAtivo(true);
		cartao.setCartaoDebito(cartaoD);
		cartao.setCartaoCredito(cartaoC);
		
		return cartao;

	}
}
