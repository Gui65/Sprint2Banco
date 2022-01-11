package br.com.sprintBanco.bo;

import java.util.UUID;

import br.com.sprintBanco.beans.ContaCorrente;
import br.com.sprintBanco.beans.Pix;
import br.com.sprintBanco.beans.TipoChavePix;

public class PixBo {

	public Pix cadastraPixEmail(String email) {

		Pix pix = new Pix();

		pix.tipoChave = TipoChavePix.EMAIL;
		pix.idPix = UUID.randomUUID().toString();
		pix.conteudoChave = email;
		pix.isAtivado = true;

		return pix;
	}

	public Pix cadastraPixCpf(ContaCorrente contaC) {

		Pix pix = new Pix();

		pix.tipoChave = TipoChavePix.CPF;
		pix.idPix = UUID.randomUUID().toString();
		pix.conteudoChave = contaC.getCliente().getCpf();
		pix.isAtivado = true;

		return pix;
	}

	public Pix cadastraPixTelefone(String telefone) {

		Pix pix = new Pix();

		pix.tipoChave = TipoChavePix.TELEFONE;
		pix.idPix = UUID.randomUUID().toString();
		pix.conteudoChave = telefone;
		pix.isAtivado = true;

		return pix;
	}
	
	public Pix cadastraPixAleatorio() {
		
		Pix pix = new Pix();

		pix.tipoChave = TipoChavePix.ALEATORIO;
		pix.idPix = UUID.randomUUID().toString();
		pix.conteudoChave = UUID.randomUUID().toString();
		pix.isAtivado = true;

		return pix;
	}
}
