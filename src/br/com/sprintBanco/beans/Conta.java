package br.com.sprintBanco.beans;

public class Conta {

	protected String idConta;
	protected String numero;
	protected double saldo;
	protected Cliente cliente;
	protected TipoCliente tipo;
	protected Pix pix;
	protected Cartao cartao;
	
	public TipoCliente getTipo() {
		return tipo;
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}

	public Pix getPix() {
		return pix;
	}

	public void setPix(Pix pix) {
		this.pix = pix;
	}

	public String getIdConta() {
		return idConta;
	}

	public void setIdConta(String idConta) {
		this.idConta = idConta;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	
	
}
