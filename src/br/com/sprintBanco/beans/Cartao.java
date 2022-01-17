package br.com.sprintBanco.beans;

public class Cartao {
	
	private String idCartao;
	private String numeroCartao;
	private String bandeiraCartao;
	private String senhaCartao;
	private String cartaoAtivo;
	
	
	//GET AND SET
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

	public String getBandeiraCartao() {
		return bandeiraCartao;
	}

	public void setBandeiraCartao(String bandeiraCartao) {
		this.bandeiraCartao = bandeiraCartao;
	}

	public String getSenhaCartao() {
		return senhaCartao;
	}

	public void setSenhaCartao(String senhaCartao) {
		this.senhaCartao = senhaCartao;
	}

	public String getCartaoAtivo() {
		return cartaoAtivo;
	}

	public void setCartaoAtivo(String cartaoAtivo) {
		this.cartaoAtivo = cartaoAtivo;
	}

}
