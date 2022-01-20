package br.com.sprintBanco.bo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.sprintBanco.beans.CartaoCredito;
import br.com.sprintBanco.beans.Compra;
import br.com.sprintBanco.beans.ContaCorrente;
import br.com.sprintBanco.beans.ContaPoupanca;

public class CartaoCreditoBo {

	public CartaoCredito ativaCartaoCredito(double limite) {
		CartaoCredito cartaoC = new CartaoCredito();

		cartaoC.setLimite(limite);
		cartaoC.setCartaoAtivo(true);
		cartaoC.setValorFatura(0);
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

	public boolean compraCredito(double valor, ContaCorrente contaC) {
		double limite = contaC.getCartao().getCartaoCredito().getLimite();
		if (limite >= valor) {
			double fatura = contaC.getCartao().getCartaoCredito().getValorFatura();
			limite -= valor;
			contaC.getCartao().getCartaoCredito().setLimite(limite);
			fatura += valor;
			contaC.getCartao().getCartaoCredito().setValorFatura(fatura);
			adicionaCompra(valor, contaC);
			return true;
		}else {
			return false;
		}

	}
	
	public String faturaCartao(ContaCorrente contaC) {
		SimpleDateFormat sdfComHora = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		List<Compra> listaCompras = contaC.getCartao().getCartaoCredito().getCompras();
		for(Compra compras : listaCompras) {
			String dataDaCompra = sdfComHora.format(compras.getDate());
			double valorDaCompra = compras.getValor();
			
			return "Compra realizada no dia" + dataDaCompra + " no Valor de R$" + valorDaCompra;
		}
		
		return "Valor da fatura: " + contaC.getCartao().getCartaoCredito().getValorFatura();
	}

	public void adicionaCompra(double valor, ContaCorrente contaC) {
		Compra compra = new Compra(valor, new Date());
		contaC.getCartao().getCartaoCredito().getCompras().add(compra);
	}
	
	public boolean compraCreditoPoupanca(double valor, ContaPoupanca contaP) {
		double limite = contaP.getCartao().getCartaoCredito().getLimite();
		if (limite >= valor) {
			double fatura = contaP.getCartao().getCartaoCredito().getValorFatura();
			limite -= valor;
			contaP.getCartao().getCartaoCredito().setLimite(limite);
			fatura += valor;
			contaP.getCartao().getCartaoCredito().setValorFatura(fatura);
			adicionaCompraPoupanca(valor, contaP);
			return true;
		}else {
			return false;
		}

	}
	
	public String faturaCartaoPoupanca(ContaPoupanca contaP) {
		SimpleDateFormat sdfComHora = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		List<Compra> listaCompras = contaP.getCartao().getCartaoCredito().getCompras();
		for(Compra compras : listaCompras) {
			String dataDaCompra = sdfComHora.format(compras.getDate());
			double valorDaCompra = compras.getValor();
			
			return "Compra realizada no dia" + dataDaCompra + " no Valor de R$" + valorDaCompra;
		}
		
		return "Valor da fatura: " + contaP.getCartao().getCartaoCredito().getValorFatura();
	}

	public void adicionaCompraPoupanca(double valor, ContaPoupanca contaP) {
		Compra compra = new Compra(valor, new Date());
		contaP.getCartao().getCartaoCredito().getCompras().add(compra);
	}
}
