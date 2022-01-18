package br.com.sprintBanco.beans;

public class Cartao {

	private String idCartao;
	private String numeroCartao;
	private TipoBandeira bandeiraCartao;
	private String senhaCartao;
	private boolean cartaoAtivo = false;
	private CartaoDebito cartaoDebito;
	private CartaoCredito cartaoCredito;
	
	
	
	// GET AND SET
	public String getIdCartao() {
		return idCartao;
	}

	public void setIdCartao(String idCartao) {
		this.idCartao = idCartao;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public TipoBandeira getBandeiraCartao() {
		return bandeiraCartao;
	}

	public void setBandeiraCartao(TipoBandeira bandeiraCartao) {
		this.bandeiraCartao = bandeiraCartao;
	}

	public String getSenhaCartao() {
		return senhaCartao;
	}

	public void setSenhaCartao(String senhaCartao) {
		this.senhaCartao = senhaCartao;
	}

	public boolean isCartaoAtivo() {
		return cartaoAtivo;
	}

	public void setCartaoAtivo(boolean cartaoAtivo) {
		this.cartaoAtivo = cartaoAtivo;
	}

	public CartaoDebito getCartaoDebito() {
		return cartaoDebito;
	}

	public void setCartaoDebito(CartaoDebito cartaoDebito) {
		this.cartaoDebito = cartaoDebito;
	}

	public CartaoCredito getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(CartaoCredito cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

}
