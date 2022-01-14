package br.com.sprintBanco.utils;

import java.util.HashMap;
import java.util.Map;

import br.com.sprintBanco.beans.Conta;
import br.com.sprintBanco.beans.ContaCorrente;
import br.com.sprintBanco.beans.ContaPoupanca;

public class BancoDeDados {

	// ARMAZENA APENAS CONTAS CORRENTES
	private static Map<String, ContaCorrente> BANCO_DE_DADOS_CORRENTE = new HashMap<String, ContaCorrente>();

	public static ContaCorrente buscaContaCorrentePorNumero(String numeroConta) {
		ContaCorrente contaC = BancoDeDados.BANCO_DE_DADOS_CORRENTE.get(numeroConta);
		if (contaC == null) {
			System.out.println("Conta não encontrada");
			return null;
		}
		return contaC;
	}

	public static void insereContaCorrente(String numeroConta, ContaCorrente contaC) {
		BancoDeDados.BANCO_DE_DADOS_CORRENTE.put(numeroConta, contaC);
	}

	public static ContaCorrente buscaContaCorrentePorPix(String chavePix) { //BUSCA UM VALOR QUE É INSERIDO
		ContaCorrente contaC = new ContaCorrente();
		contaC = null;
		
		for (Map.Entry<String, ContaCorrente> entry : BANCO_DE_DADOS_CORRENTE.entrySet()) {

			ContaCorrente value = entry.getValue();
			
			if(value.getPix().conteudoChave.equals(chavePix)) { //CORRE O HASHMAP ATÉ ENCONTRAR O VALOR
				contaC = value;
				break;
			}
		}
		
		return contaC;
	}

	// ARMAZENA APENAS CONTAS POUPANÇAS
	private static Map<String, ContaPoupanca> BANCO_DE_DADOS_POUPANCA = new HashMap<String, ContaPoupanca>();

	public static ContaPoupanca buscaContaPoupancaPorNumero(String numeroConta) {
		ContaPoupanca contaP = BancoDeDados.BANCO_DE_DADOS_POUPANCA.get(numeroConta);
		if (contaP == null) {
			System.out.println("Conta não encontrada");
			return null;
		}
		return contaP;
	}

	public static void insereContaPoupanca(String numeroConta, ContaPoupanca contaP) {
		BancoDeDados.BANCO_DE_DADOS_POUPANCA.put(numeroConta, contaP);
	}
}
