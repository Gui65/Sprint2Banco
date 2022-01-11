package br.com.sprintBanco.utils;

import java.util.HashMap;
import java.util.Map;

import br.com.sprintBanco.beans.Conta;
import br.com.sprintBanco.beans.ContaCorrente;

public class BancoDeDados {
	
	private static Map<String, ContaCorrente> BANCO_DE_DADOS = new HashMap<String, ContaCorrente>();
	
	public static Conta buscaContaPorNumero(String numeroConta) {
		ContaCorrente conta = BancoDeDados.BANCO_DE_DADOS.get(numeroConta);
		if(conta == null) {
			System.out.println("Conta não encontrada");
			return null;
		}
		return conta;
	}
	
	public static void insereConta(String numeroConta, ContaCorrente conta) {
		BancoDeDados.BANCO_DE_DADOS.put(numeroConta, conta);
	}
}
