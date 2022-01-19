package br.com.sprintBanco.teste;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import br.com.sprintBanco.beans.Cartao;
import br.com.sprintBanco.beans.CartaoCredito;
import br.com.sprintBanco.beans.CartaoDebito;
import br.com.sprintBanco.beans.Cliente;
import br.com.sprintBanco.beans.Compra;
import br.com.sprintBanco.beans.ContaCorrente;
import br.com.sprintBanco.beans.ContaPoupanca;
import br.com.sprintBanco.beans.Endereco;
import br.com.sprintBanco.beans.Pix;
import br.com.sprintBanco.beans.TipoBandeira;
import br.com.sprintBanco.bo.CartaoBo;
import br.com.sprintBanco.bo.CartaoCreditoBo;
import br.com.sprintBanco.bo.CartaoDebitoBo;
import br.com.sprintBanco.bo.ClienteBo;
import br.com.sprintBanco.bo.ContaBo;
import br.com.sprintBanco.bo.ContaCorrenteBo;
import br.com.sprintBanco.bo.ContaPoupancaBo;
import br.com.sprintBanco.bo.EnderecoBo;
import br.com.sprintBanco.bo.PixBo;
import br.com.sprintBanco.utils.BancoDeDados;

public class Main {

	public static void main(String[] args) {

		Scanner ler = new Scanner(System.in);

		ClienteBo cadastrarCliente = new ClienteBo();
		EnderecoBo cadastrarEndereco = new EnderecoBo();
		ContaCorrenteBo cadastraContaC = new ContaCorrenteBo();
		ContaPoupancaBo cadastraContaP = new ContaPoupancaBo();
		CartaoDebitoBo ativarCartaoD = new CartaoDebitoBo();
		CartaoCreditoBo ativarCartaoC = new CartaoCreditoBo();
		ContaBo conta = new ContaBo();
		PixBo cadastrarPix = new PixBo();
		CartaoBo ativarCartao = new CartaoBo();

		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco();
		Pix pix = new Pix();
		ContaCorrente contaC = new ContaCorrente();
		ContaPoupanca contaP = new ContaPoupanca();
		Cartao cartao = new Cartao();
		CartaoDebito cartaoD = new CartaoDebito();
		CartaoCredito cartaoC = new CartaoCredito();

		String cpf, nome, dt, repete;
		int op;
		do {
			System.out.println("O que deseja fazer: ");
			System.out.println("1 - Cadastrar Nova Conta");
			System.out.println("2 - Entrar na sua conta Corrente!");
			System.out.println("3 - Entrar na sua conta Poupança!");
			op = ler.nextInt();
			switch (op) {
			case 1: // CADASTRA UM NOVO USUÁRIO
				int i;
				System.out.println("----------------------" + "\nCadastro de Cliente" + "\n----------------------");
				contaC = null;
				contaP = null;
				do {
					System.out.print("Digite seu CPF >>> ");
					// VALIDA O CPF
					cpf = ler.next();
					if (cadastrarCliente.validacaoCpf(cpf) == false) {
						System.out.println("CPF INVALÍDO.");
					} else {
						System.out.println("CPF VALIDO.");
					}
				} while (cadastrarCliente.validacaoCpf(cpf) == false);

				System.out.print("Digite seu NOME >>> ");
				ler.nextLine();
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

			case 2: // ENTRA EM UMA CONTA CORRENTE EXISTENTE
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
						System.out.println("|	1 - Sacar		|");
						System.out.println("|	2 - Depositar		|");
						System.out.println("|	3 - Transferir		|");
						System.out.println("|	4 - Consultar		|");
						System.out.println("|	5 - Cadastrar Pix	|");
						System.out.println("|	6 - Cartão		|");
						System.out.println("|	7 - Sair		|");

						System.out.println("----------------------");

						opcaoC = ler.nextInt();
						switch (opcaoC) {
						case 1: // Sacar Corrente
							System.out.println("Qual valor deseja sacar >>> ");
							v = ler.nextDouble();
							System.out.println(conta.sacarCorrente(v, contaC));
							break;
						case 2: // Depositar Corrente
							System.out.println("Qual valor deseja depositar >>> ");
							v = ler.nextDouble();
							conta.depositoCorrente(v, contaC);
							System.out.println("Deposito realizado com sucesso!");
							break;
						case 3: // Transferir Corrente
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
						case 4: // Consultar Corrente
							System.out.println("Valor: " + conta.consultaCorrente(contaC));
							System.out.println(conta.StatusTipoConta(contaC));
							break;
						case 5: // Cadastrar Pix
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
								contaC.setPix(pix);
								System.out.println("Cadastrado com sucesso");
								System.out.println("Seu tipo de chave é " + pix.tipoChave + "\nChave: "
										+ contaC.getPix().conteudoChave);

							} else {
								System.out.println("Opção invalida");
								continue;
							}
							break;
						case 6: // Cartao Corrente
							if (contaC.getCartao().isCartaoAtivo() == false) { // não tem um Cartão Ativo
								int ativar;
								System.out.println("Você não tem um cartão ativo");
								System.out.println("Deseja criar um ? \n1-Sim \n2-Nao");
								ativar = ler.nextInt();
								if (ativar == 1) {
									TipoBandeira bandeira = null;
									int opcaoBandeira;
									String senha;
									do {
										System.out.println("Selecione a bandeira que deseja o seu cartão: ");
										System.out.println("1 - MasterCard \n2 - Elo \n3 - Visa");
										opcaoBandeira = ler.nextInt();
										if (opcaoBandeira == 1) {
											bandeira = TipoBandeira.MASTERCARD;
										} else if (opcaoBandeira == 2) {
											bandeira = TipoBandeira.ELO;
										} else if (opcaoBandeira == 3) {
											bandeira = TipoBandeira.VISA;
										} else {
											System.out.println("Opção invalída");
										}
									} while (opcaoBandeira < 1 || opcaoBandeira > 3);
									System.out.println("Digite uma senha (APENAS NÚMEROS)");
									senha = ler.next();
									cartao = ativarCartao.ativaCartao(bandeira, senha);
									contaC.setCartao(cartao);

								} else { // Fim ativarCartao
									continue;
								}

							} else { // Tem um Cartão ativo

								System.out.println("------------------" + "\nMENU CARTÃO" + "\n---------------------");
								System.out.println("1 - Cartão de crédito");
								System.out.println("2 - Cartão de Débito");
								System.out.println("3 - Informações do Cartão");

								int opcao = ler.nextInt();
								if (opcao == 1) {
									System.out.println(
											"------------------" + "\nFUNÇÃO CRÉDITO" + "\n---------------------");
									System.out.println("1 - Habilitar Cartão de Crédito");
									System.out.println("2 - Exibir limite");
									System.out.println("3 - Ajustar limite");
									System.out.println("4 - Exibir fatura"); // Não sei como fazer ainda
									System.out.println("5 - Desabilitar Cartão de crédito");
									System.out.println("6 - Comprar");
									int opcaoCredito = ler.nextInt();

									if (opcaoCredito == 1) { // Ativa Função crédito
										if (contaC.getCartao().getCartaoCredito().isCartaoAtivo() == true) {
											System.out.println("Função Credito já esta ativada");
										} else {
											System.out.println("Digite seu limite do cartão de crédito ");
											int limite = ler.nextInt();
											cartaoC = ativarCartaoC.ativaCartaoCredito(limite);
											contaC.getCartao().setCartaoCredito(cartaoC);
										}
									} else if (opcaoCredito == 2) {
										// Caso estiver ativado, mostra o limite
										if (contaC.getCartao().getCartaoCredito().isCartaoAtivo() == true) {
											System.out.println("Limite Cartão de crédito: "
													+ contaC.getCartao().getCartaoCredito().getLimite());
										} else {
											System.out.println("Função desativada");
										}
									} else if (opcaoCredito == 3) {
										if (contaC.getCartao().getCartaoCredito().isCartaoAtivo() == true) {
											System.out.println("Digite o novo valor: ");
											double limite = ler.nextDouble();
											System.out.println(ativarCartaoC.alterarLimiteCredito(cartaoC, limite));
										} else {
											System.out.println("Função desativada");
										}

									} else if (opcaoCredito == 4) {
										if (contaC.getCartao().getCartaoCredito().isCartaoAtivo()) {
											SimpleDateFormat sdfComHora = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
											List<Compra> listaCompras = contaC.getCartao().getCartaoCredito()
													.getCompras();
											for (Compra compras : listaCompras) {
												String dataDaCompra = sdfComHora.format(compras.getDate());
												double valorDaCompra = compras.getValor();

												System.out.println("Compra realizada no dia " + dataDaCompra
														+ " no Valor de R$" + valorDaCompra);
											}

											System.out.println("Valor da fatura: "
													+ contaC.getCartao().getCartaoCredito().getValorFatura());
										} else {
											System.out.println("Função desativada");
										}

									} else if (opcaoCredito == 5) {
										if (contaC.getCartao().getCartaoCredito().isCartaoAtivo() == true) {
											System.out.println(ativarCartaoC.desativarCartaoCredito(cartaoC));
										} else {
											System.out.println("Já está desativada");
										}
									} else if (opcaoCredito == 6) {
										if (contaC.getCartao().getCartaoCredito().isCartaoAtivo()) {
											System.out.println("Digite o valor da compra: ");
											double valor = ler.nextDouble();
											boolean retorno = ativarCartaoC.compraCredito(valor, contaC);
											if (retorno) {
												System.out.println("Compra efetuada com sucesso!");
											} else {
												System.out.println("Limite atingido \nSeu limite atual é: "
														+ contaC.getCartao().getCartaoCredito().getLimite());
											}
										}
									}
								} else if (opcao == 2) { // MENU DEBITO
									System.out.println(
											"------------------" + "\nFUNÇÃO DEBITO" + "\n---------------------");
									System.out.println("1 - Habilitar Cartão de Debito");
									System.out.println("2 - Exibir limite");
									System.out.println("3 - Ajustar limite");
									System.out.println("4 - Exibir extrato"); // Não sei como fazer ainda
									System.out.println("5 - Desabilitar Cartão de debito");
									int opcaoDebito = ler.nextInt();

									if (opcaoDebito == 1) { // Ativa função debito
										if (contaC.getCartao().getCartaoDebito().isCartaoAtivo() == true) {
											System.out.println("Função Debito já esta ativada");
										} else {
											System.out.println("Digite seu limite por transação: ");
											int limite = ler.nextInt();
											cartaoD = ativarCartaoD.ativaCartaoDebito(limite);
											contaC.getCartao().setCartaoDebito(cartaoD);
										}

									} else if (opcaoDebito == 2) {
										if (contaC.getCartao().getCartaoDebito().isCartaoAtivo() == true) {
											System.out.println("Limite por transação: "
													+ contaC.getCartao().getCartaoDebito().getLimitePorTransacao());
										} else {
											System.out.println("Função desativada");
										}
									} else if (opcaoDebito == 3) {
										if (contaC.getCartao().getCartaoDebito().isCartaoAtivo() == true) {
											System.out.println("Digite o novo valor: ");
											double limite = ler.nextDouble();
											System.out.println(ativarCartaoD.alterarLimiteDebito(cartaoD, limite));
										} else {
											System.out.println("Função desativada");
										}
									} else if (opcaoDebito == 5) {
										if (contaC.getCartao().getCartaoDebito().isCartaoAtivo() == true) {
											System.out.println(ativarCartaoD.desativarCartaoDebito(cartaoD));
										} else {
											System.out.println("Já está desativada");
										}
									}

								} else if (opcao == 3) { // Ver informações do Cartão
									System.out.println("Numero do Cartão: " + contaC.getCartao().getNumeroCartao());
									System.out.println("Bandeira: " + contaC.getCartao().getBandeiraCartao());
									System.out.println("Senha: " + contaC.getCartao().getSenhaCartao());
									System.out.println(
											"Função crédito: " + contaC.getCartao().getCartaoCredito().isCartaoAtivo());
									System.out.println(
											"Função debito: " + contaC.getCartao().getCartaoDebito().isCartaoAtivo());
								} else {
									System.out.println("Opção invalída");
								}
							} // Fim Menu Cartao(Se ativo)
						}
					} while (opcaoC != 7);
				}
				break;
			case 3: // ENTRA EM UMA CONTA POUPANÇA EXISTENTE

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
						System.out.println("5 - Cartão");
						System.out.println("6 - Sair");
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
						case 5:
							if (contaP.getCartao().isCartaoAtivo() == false) { // não tem um Cartão poupança Ativo
								int ativar;
								System.out.println("Você não tem um cartão ativo");
								System.out.println("Deseja criar um ? \n1-Sim \n2-Nao");
								ativar = ler.nextInt();
								if (ativar == 1) {
									TipoBandeira bandeira = null;
									int opcaoBandeira;
									String senha;
									do {
										System.out.println("Selecione a bandeira que deseja o seu cartão: ");
										System.out.println("1 - MasterCard \n2 - Elo \n3 - Visa");
										opcaoBandeira = ler.nextInt();
										if (opcaoBandeira == 1) {
											bandeira = TipoBandeira.MASTERCARD;
										} else if (opcaoBandeira == 2) {
											bandeira = TipoBandeira.ELO;
										} else if (opcaoBandeira == 3) {
											bandeira = TipoBandeira.VISA;
										} else {
											System.out.println("Opção invalída");
										}
									} while (opcaoBandeira < 1 || opcaoBandeira > 3);
									System.out.println("Digite uma senha (APENAS NÚMEROS)");
									senha = ler.next();
									cartao = ativarCartao.ativaCartao(bandeira, senha);
									contaP.setCartao(cartao);

								} else { // Fim ativarCartao
									continue;
								}

							} else { // Tem um Cartão ativo

								System.out.println("------------------" + "\nMENU CARTÃO" + "\n---------------------");
								System.out.println("1 - Cartão de crédito");
								System.out.println("2 - Cartão de Débito");
								System.out.println("3 - Informações do Cartão");
								int opcao = ler.nextInt();

								if (opcao == 1) { // MENU CRÉDITO
									System.out.println(
											"------------------" + "\nFUNÇÃO CRÉDITO" + "\n---------------------");
									System.out.println("1 - Habilitar Cartão de Crédito");
									System.out.println("2 - Exibir limite");
									System.out.println("3 - Ajustar limite");
									System.out.println("4 - Exibir fatura"); // Não sei como fazer ainda
									System.out.println("5 - Desabilitar Cartão de crédito");
									int opcaoCredito = ler.nextInt();

									if (opcaoCredito == 1) { // Ativa Função crédito
										if (contaP.getCartao().getCartaoCredito().isCartaoAtivo() == true) {
											System.out.println("Função Credito já esta ativada");
										} else {
											System.out.println("Digite seu limite do cartão de crédito ");
											int limite = ler.nextInt();
											cartaoC = ativarCartaoC.ativaCartaoCredito(limite);
											contaP.getCartao().setCartaoCredito(cartaoC);
										}
									} else if (opcaoCredito == 2) { // Exibe o limite
										// Caso estiver ativado, mostra o limite
										if (contaP.getCartao().getCartaoCredito().isCartaoAtivo() == true) {
											System.out.println("Limite Cartão de crédito: "
													+ contaP.getCartao().getCartaoCredito().getLimite());
										} else {
											System.out.println("Função desativada");
										}
									} else if (opcaoCredito == 3) { // Altera o limite
										if (contaP.getCartao().getCartaoCredito().isCartaoAtivo() == true) {
											System.out.println("Digite o novo valor: ");
											double limite = ler.nextDouble();
											System.out.println(ativarCartaoC.alterarLimiteCredito(cartaoC, limite));
										} else {
											System.out.println("Função desativada");
										}

									} else if (opcaoCredito == 5) { // Desativa função
										if (contaP.getCartao().getCartaoCredito().isCartaoAtivo() == true) {
											System.out.println(ativarCartaoC.desativarCartaoCredito(cartaoC));
										} else {
											System.out.println("Já está desativada");
										}
									}
								} else if (opcao == 2) { // MENU DEBITO
									System.out.println(
											"------------------" + "\nFUNÇÃO DEBITO" + "\n---------------------");
									System.out.println("1 - Habilitar Cartão de Debito");
									System.out.println("2 - Exibir limite");
									System.out.println("3 - Ajustar limite");
									System.out.println("4 - Exibir extrato"); // Não sei como fazer ainda
									System.out.println("5 - Desabilitar Cartão de debito");
									int opcaoDebito = ler.nextInt();

									if (opcaoDebito == 1) { // Ativa função debito
										if (contaP.getCartao().getCartaoDebito().isCartaoAtivo() == true) {
											System.out.println("Função Debito já esta ativada");
										} else {
											System.out.println("Digite seu limite por transação: ");
											int limite = ler.nextInt();
											cartaoD = ativarCartaoD.ativaCartaoDebito(limite);
											contaP.getCartao().setCartaoDebito(cartaoD);
										}

									} else if (opcaoDebito == 2) {
										if (contaP.getCartao().getCartaoDebito().isCartaoAtivo() == true) {
											System.out.println("Limite por transação: "
													+ contaP.getCartao().getCartaoDebito().getLimitePorTransacao());
										} else {
											System.out.println("Função desativada");
										}
									} else if (opcaoDebito == 3) {
										if (contaP.getCartao().getCartaoDebito().isCartaoAtivo() == true) {
											System.out.println("Digite o novo valor: ");
											double limite = ler.nextDouble();
											System.out.println(ativarCartaoD.alterarLimiteDebito(cartaoD, limite));
										} else {
											System.out.println("Função desativada");
										}
									} else if (opcaoDebito == 5) {
										if (contaP.getCartao().getCartaoDebito().isCartaoAtivo() == true) {
											System.out.println(ativarCartaoD.desativarCartaoDebito(cartaoD));
										} else {
											System.out.println("Já está desativada");
										}
									}

								} else if (opcao == 3) { // Ver informações do Cartão
									System.out.println("Numero do Cartão: " + contaP.getCartao().getNumeroCartao());
									System.out.println("Bandeira: " + contaP.getCartao().getBandeiraCartao());
									System.out.println("Senha: " + contaP.getCartao().getSenhaCartao());
									System.out.println(
											"Função crédito: " + contaP.getCartao().getCartaoCredito().isCartaoAtivo());
									System.out.println(
											"Função debito: " + contaP.getCartao().getCartaoDebito().isCartaoAtivo());
								} else {
									System.out.println("Opção invalída");
								}
							} // Fim Menu Cartao(Se ativo)

						}
					} while (opcaoP != 6);
					break;
				}
			}

		} while (op != 4);

	}
}
