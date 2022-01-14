package br.com.sprintBanco.teste;

import java.util.Scanner;

import br.com.sprintBanco.beans.Cliente;
import br.com.sprintBanco.beans.Conta;
import br.com.sprintBanco.beans.ContaCorrente;
import br.com.sprintBanco.beans.ContaPoupanca;
import br.com.sprintBanco.beans.Endereco;
import br.com.sprintBanco.beans.Pix;
import br.com.sprintBanco.bo.ClienteBo;
import br.com.sprintBanco.bo.ContaBo;
import br.com.sprintBanco.bo.ContaCorrenteBo;
import br.com.sprintBanco.bo.ContaPoupancaBo;
import br.com.sprintBanco.bo.EnderecoBo;
import br.com.sprintBanco.bo.PixBo;
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
		PixBo cadastrarPix = new PixBo();

		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco();
		Pix pix = new Pix();
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
				int i;
				System.out.println("----------------------" + "\nCadastro de Cliente" + "\n----------------------");
				do {
					System.out.print("Digite seu CPF >>> ");
					ler.nextLine();
					cpf = ler.nextLine();
					if (cadastrarCliente.validacaoCpf(cpf) == false) {
						System.out.println("CPF INVALÍDO. DIGITE NOVAMENTE: ");
					} else {
						System.out.println("CPF VALIDO.");
					}
				} while (cadastrarCliente.validacaoCpf(cpf) == false);
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
						+ "\n1-Conta Corrente \n2-Conta Poupança \n");
				i = ler.nextInt();
				if (i == 1) {
					contaC = cadastraContaC.CriarContaCorrente(cliente);
					System.out.println("Numero da sua conta: " + contaC.getNumero());

					System.out.println("Deseja criar uma conta poupança? (S/N)");
					repete = ler.next();
					if (repete.equals("S")) {
						contaP = cadastraContaP.CriarContaPoupanca(cliente);
						System.out.println("Numero da sua conta: " + contaP.getNumero());
					}
				} else if (i == 2) {
					contaP = cadastraContaP.CriarContaPoupanca(cliente);
					System.out.println("Numero da sua conta: " + contaP.getNumero());
					System.out.println("Deseja criar uma conta corrente? (S/N)");
					repete = ler.next();
					if (repete.equals("S")) {
						contaC = cadastraContaC.CriarContaCorrente(cliente);
						System.out.println("Numero da sua conta: " + contaP.getNumero());
					}
				}

				System.out.println("Conta criada com sucesso!");
				System.out.println("Seja bem vindo " + cliente.getNome());
				break;

			case 2:
				int opcaoC;

				System.out.print("Digite o número da sua conta >>> ");
				String numeroContaC = ler.next();
				contaC = (ContaCorrente) BancoDeDados.buscaContaCorrentePorNumero(numeroContaC);

				if (contaC == null) {
					System.out.println("Você não tem uma conta corrente!");
				} else {
					System.out.println(
							"LOGADO COM SUCESSO! \nSeja Bem vindo novamente: " + contaC.getCliente().getNome());
					do {
						double v;
						System.out.println("-------------------" + "\nMENU CONTA CORRENTE" + "\n---------------------");
						System.out.println("1 - Sacar");
						System.out.println("2 - Depositar");
						System.out.println("3 - Transferir");
						System.out.println("4 - Consultar");
						System.out.println("5 - Cadastrar Pix");
						System.out.println("6 - Sair");

						opcaoC = ler.nextInt();
						switch (opcaoC) {
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
							System.out
									.println("Deseja transferir para uma conta tipo: \n1-Corrente \n2-Poupança \3-PIX");
							escolha = ler.nextInt();
							if (escolha == 1) {
								System.out.println("Digite o número da conta que quer transferir: ");
								numeroContaRecebe = ler.next();
								ContaCorrente contaRecebe = (ContaCorrente) BancoDeDados
										.buscaContaCorrentePorNumero(numeroContaRecebe);
								System.out.println(conta.transferirCorrente(v, contaC, contaRecebe));
								System.out
										.println("Transferido com sucesso para " + contaRecebe.getCliente().getNome());
							} else if (escolha == 2) {
								System.out.println("Digite o número da conta que quer transferir: ");
								numeroContaRecebe = ler.next();
								ContaPoupanca contaRecebe = (ContaPoupanca) BancoDeDados
										.buscaContaPoupancaPorNumero(numeroContaRecebe);
								System.out.println(conta.transferirCorrentePoupanca(v, contaC, contaRecebe));
								System.out
										.println("Transferido com sucesso para " + contaRecebe.getCliente().getNome());
							} else if (escolha == 3) {
								System.out.println("Digite Pix: ");
								numeroContaRecebe = ler.next();
								ContaCorrente contaRecebe = BancoDeDados.buscaContaCorrentePorPix(numeroContaRecebe);
								System.out.println(conta.transferirCorrente(v, contaC, contaRecebe));
								System.out
										.println("Transferido com sucesso para " + contaRecebe.getCliente().getNome());
							}

							break;
						case 4:
							System.out.println("Valor: " + conta.consultaCorrente(contaC));
							System.out.println(conta.StatusTipoConta(contaC));
							break;
						case 5:
							int opPix;
							System.out.println(
									"Deseja cadastrar uma chave do tipo: \n1-Email \n2-CPF \n3-TELEFONE \n4-ALEÁTORIA");
							opPix = ler.nextInt();
							if (opPix >= 1 && opPix <= 4) {
								if (opPix == 1) {
									String email;
									System.out.print("Digite seu email >>> ");
									email = ler.next();

									pix = cadastrarPix.cadastraPixEmail(email);

								} else if (opPix == 2) {
									pix = cadastrarPix.cadastraPixCpf(contaC);

								} else if (opPix == 3) {
									String telefone;
									System.out.print("Digite seu telefone >>> ");
									telefone = ler.next();

									pix = cadastrarPix.cadastraPixTelefone(telefone);
								} else if (opPix == 4) {
									pix = cadastrarPix.cadastraPixAleatorio();
								}
								System.out.println("Cadastrado com sucesso");
								System.out.println(
										"Seu tipo de chave é " + pix.tipoChave + "\nChave: " + contaC.getPix());
								contaC.setPix(pix);
							} else {
								System.out.println("Opção invalida");
								continue;
							}
						}
					} while (opcaoC != 6);
				}
				break;
			case 3:
				int opcaoP;

				System.out.print("Digite o número da sua conta >>>");
				String numeroContaP = ler.next();
				contaP = (ContaPoupanca) BancoDeDados.buscaContaPoupancaPorNumero(numeroContaP);

				if (contaP == null) {
					System.out.println("Você não tem uma conta poupança!");
				} else {
					System.out.println(
							"LOGADO COM SUCESSO! \nSeja Bem vindo novamente: " + contaC.getCliente().getNome());
					do {
						double v;
						System.out.println("-------------------" + "\nMENU CONTA POUPANÇA" + "\n---------------------");
						System.out.println("1 - Sacar");
						System.out.println("2 - Depositar");
						System.out.println("3 - Transferir para conta Corrente");
						System.out.println("4 - Consultar");
						System.out.println("5 - Sair");
						opcaoP = ler.nextInt();
						switch (opcaoP) {
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
							int escolha;
							String numeroContaRecebe;
							System.out.println("Qual valor deseja transferir >>> ");
							v = ler.nextDouble();
							System.out.println("Deseja transferir para uma conta tipo: \n1-Poupança \n2-Corrente");
							escolha = ler.nextInt();
							if (escolha == 1) {
								System.out.println("Digite o número da conta que quer transferir: ");
								numeroContaRecebe = ler.next();
								ContaPoupanca contaRecebe = (ContaPoupanca) BancoDeDados
										.buscaContaPoupancaPorNumero(numeroContaRecebe);
								System.out.println(conta.transferirPoupanca(v, contaP, contaRecebe));
								System.out
										.println("Transferido com sucesso para " + contaRecebe.getCliente().getNome());
							} else if (escolha == 2) {
								System.out.println("Digite o número da conta que quer transferir: ");
								numeroContaRecebe = ler.next();
								ContaCorrente contaRecebe = (ContaCorrente) BancoDeDados
										.buscaContaCorrentePorNumero(numeroContaRecebe);
								System.out.println(conta.transferirPoupancaCorrente(v, contaP, contaRecebe));
								System.out
										.println("Transferido com sucesso para " + contaRecebe.getCliente().getNome());
							}
							break;
						case 4:
							System.out.println("Valor: " + conta.consultaPoupanca(contaP));
							System.out.println(conta.StatusTipoContaPoupanca(contaP));
							break;
						}
					} while (opcaoP != 4);
					break;
				}
			}

		} while (op != 3);

	}
}
