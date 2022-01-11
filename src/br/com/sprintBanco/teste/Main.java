package br.com.sprintBanco.teste;

import java.util.Scanner;

import br.com.sprintBanco.beans.Cliente;
import br.com.sprintBanco.beans.Conta;
import br.com.sprintBanco.beans.ContaCorrente;
import br.com.sprintBanco.beans.ContaPoupanca;
import br.com.sprintBanco.beans.Endereco;
import br.com.sprintBanco.bo.ClienteBo;
import br.com.sprintBanco.bo.ContaBo;
import br.com.sprintBanco.bo.ContaCorrenteBo;
import br.com.sprintBanco.bo.ContaPoupancaBo;
import br.com.sprintBanco.bo.EnderecoBo;
import br.com.sprintBanco.utils.BancoDeDados;

public class Main {

	public static void main(String[] args) {

		String cpf, nome, dt, repete;

		Scanner ler = new Scanner(System.in);

		ClienteBo cadastrarCliente = new ClienteBo();
		EnderecoBo cadastrarEndereco = new EnderecoBo();
		ContaCorrenteBo cadastraContaC = new ContaCorrenteBo();
		ContaPoupancaBo cadastraContaP = new ContaPoupancaBo();
		ContaBo conta = new ContaBo();

		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco();
		ContaCorrente contaC = new ContaCorrente();
		ContaPoupanca contaP = new ContaPoupanca();

		contaC = null;
		contaP = null;

		int op;
		do {
			System.out.println("O que deseja fazer: ");
			System.out.println("1 - Cadastrar Nova Conta");
			System.out.println("2 - Entrar na sua conta Corrente!");
			System.out.println("3 - Entrar na sua conta Poupança!");
			op = ler.nextInt();
			switch (op) {
			case 1:
				do {
					int i;
					System.out.println("----------------------" + "\nCadastro de Cliente" + "\n----------------------");
					System.out.print("Digite seu CPF >>> ");
					ler.nextLine();
					cpf = ler.nextLine();
					System.out.print("Digite seu NOME >>> ");
					nome = ler.nextLine();
					System.out.print("Informe sua Data de Nascimento >>> ");
					dt = ler.nextLine();

					String log, numCasa, cep, bairro, cidade, estado;

					System.out.print("Digite seu Logradouro >>> ");
					log = ler.nextLine();
					System.out.print("Digite o Nº da sua casa >>> ");
					numCasa = ler.nextLine();
					System.out.print("Informe seu CEP >>> ");
					cep = ler.nextLine();
					System.out.print("Digite seu Bairro >>> ");
					bairro = ler.nextLine();
					System.out.print("Digite sua Cidade >>> ");
					cidade = ler.nextLine();
					System.out.print("Informe seu Estado >>> ");
					estado = ler.nextLine();

					endereco = cadastrarEndereco.CadastraEndereco(log, numCasa, cep, bairro, cidade, estado);
					cliente = cadastrarCliente.CadastrarDados(cpf, nome, dt, endereco);
					System.out.print("Olá " + cliente.getNome() + " Deseja criar uma conta: "
							+ "\n1-Conta Corrente \n2-Conta Poupança");
					i = ler.nextInt();
					if (i == 1) {
						contaC = cadastraContaC.CriarContaCorrente(cliente);
						System.out.println("Numero: " + contaC.getNumero());
					} else if (i == 2) {
						contaP = cadastraContaP.CriarContaPoupanca(cliente);
					}
					System.out.println("Deseja criar outra conta? (S/N)");
					repete = ler.next();
				} while (repete.equals("S"));
				System.out.println("Conta criada com sucesso!");
				System.out.println("Seja bem vindo " + cliente.getNome());
				break;

			case 2:
				int opcao;

				System.out.print("Digite o número da sua conta >>>");
				String numeroConta = ler.next();
				contaC = (ContaCorrente) BancoDeDados.buscaContaCorrentePorNumero(numeroConta);

				if (contaC == null) {
					System.out.println("Você não tem uma conta corrente!");
				} else {
					do {
						double v;
						System.out.println(
								"LOGADO COM SUCESSO! \nSeja Bem vindo novamente: " + contaC.getCliente().getNome());
						System.out.println("-------------------" + "\nMENU CONTA CORRENTE" + "\n---------------------");
						System.out.println("1 - Sacar");
						System.out.println("2 - Depositar");
						System.out.println("3 - Transferir");
						System.out.println("4 - Consultar");
						System.out.println("5 - Sair");

						opcao = ler.nextInt();
						switch (opcao) {
						case 1:
							System.out.println("Qual valor deseja sacar >>> ");
							v = ler.nextDouble();
							System.out.println(conta.sacarCorrente(v, contaC));
							break;
						case 2:
							System.out.println("Qual valor deseja depositar >>> ");
							v = ler.nextDouble();
							conta.depositoCorrente(v, contaC);
							System.out.println("Deposito realizado com sucesso!");
							break;
						case 3:
							int escolha;
							String numeroContaRecebe;
							System.out.println("Qual valor deseja transferir >>> ");
							v = ler.nextDouble();
							System.out.println("Deseja transferir para uma conta tipo: \n1-Corrente \n2-Poupança");
							escolha = ler.nextInt();
							if (escolha == 1) {
								System.out.println("Digite o número da conta que quer transferir: ");
								numeroContaRecebe = ler.next();
								ContaCorrente contaRecebe = (ContaCorrente) BancoDeDados
										.buscaContaCorrentePorNumero(numeroContaRecebe);
								System.out.println(conta.transferirCorrente(v, contaC, contaRecebe));
								System.out.println("Transferido com sucesso para "+ contaRecebe.getCliente().getNome());
							}

							break;
						case 4:
							System.out.println("Valor: " + conta.consultaCorrente(contaC));
							break;
						}
					} while (opcao != 5);
				}
				break;
			case 3:
				if (contaP == null) {
					System.out.println("Você não tem uma conta poupança!");
				} else {
					do {
						double v;
						System.out.println("-------------------" + "\nMENU CONTA POUPANÇA" + "\n---------------------");
						System.out.println("1 - Sacar");
						System.out.println("2 - Depositar");
						System.out.println("3 - Transferir para conta Corrente");
						System.out.println("4 - Consultar");
						System.out.println("5 - Sair");
						opcao = ler.nextInt();
						switch (opcao) {
						case 1:
							System.out.println("Qual valor deseja sacar >>> ");
							v = ler.nextDouble();
							System.out.println(conta.sacarPoupanca(v, contaP));
							break;
						case 2:
							System.out.println("Qual valor deseja depositar >>> ");
							v = ler.nextDouble();
							conta.depositoPoupanca(v, contaP);
							System.out.println("Deposito realizado com sucesso!");
							break;
						case 3:
							System.out.println("Qual valor deseja transferir >>> ");
							v = ler.nextDouble();
							System.out.println(conta.transferirPoupanca(v, contaP, contaC));
							break;
						case 4:
							System.out.println("Valor: " + conta.consultaPoupanca(contaP));
							break;
						}
					} while (opcao != 4);
					break;
				}
			}

		} while (op != 3);

	}
}
