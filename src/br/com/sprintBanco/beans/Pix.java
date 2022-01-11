package br.com.sprintBanco.beans;

public class Pix {

	public String idPix;
	public TipoChavePix tipoChave;
	public double valor;
	public String data;
	public String conteudoChave;
	public boolean isAtivado = false;
	private ContaCorrente contaC;
	
	public ContaCorrente getContaC() {
		return contaC;
	}
	public void setContaC(ContaCorrente contaC) {
		this.contaC = contaC;
	}
	
}