package cadastroDeAlunos;

import java.util.Scanner;

public class Escola {

	public static void main(String[] args) {

		int opcoes;
		Scanner imput = new Scanner(System.in); // Criado apenas uma vez

		String usuario = "Rian";
		int senha = 123;
		String usuarioLogar;
		int senhaLogar;
		System.out.println("Digite o usuario: ");
		usuarioLogar = imput.next().trim();
		System.out.println("Digite a senha: ");
		senhaLogar = imput.nextInt();

		Alunos[] aluno = new Alunos[30];
		int totalAluno = 0;

		if (usuario.equalsIgnoreCase(usuarioLogar) && senha == senhaLogar) {

			while (true) {
				System.out.println();
				System.out.println("Escolha uma das opções:");
				System.out.println("1° - Cadastrar aluno com nome, idade e nota final.");
				System.out.println("2° - Listar todos os alunos cadastrados.");
				System.out.println("3° - Buscar aluno pelo nome.");
				System.out.println("4° - Mostrar média geral da turma.");
				System.out.println("5° - Remover aluno pelo nome.");
				System.out.println("6° - Sair do sistema.");

				opcoes = imput.nextInt();
				imput.nextLine();

				switch (opcoes) {
				case 1:
					System.out.println("Nome do Aluno");
					String nome = imput.nextLine().trim();
					System.out.println("Idade: ");
					int idade = imput.nextInt();
					System.out.println();
					System.out.println("Nota Final: ");
					double nota = imput.nextDouble();
					imput.nextLine(); // Limpa buffer
					aluno[totalAluno] = new Alunos(nome, idade, nota);
					totalAluno++;
					System.out.println("Aluno cadastrado com sucesso!");
					break;
				case 2:
					if (totalAluno == 0) {
						System.out.println("Nenhum Aluno Cadastrado!");
					} else {
						for (int i = 0; i < totalAluno; i++) {
							aluno[i].exibirAluno();
						}
						break;
					}
					break;
				case 3:
					System.out.println("Nome do Aluno?");
					String nomeA = imput.next().trim();
					boolean resultado = true;
					for (int i = 0; i < aluno.length; i++) {
						if (aluno[i].getnome().equalsIgnoreCase(nomeA) == resultado) {
							aluno[i].exibirAluno();
							resultado = true;
							break;
						}
					}

					break;
				case 4:
					double somaNotas = 0;
					if (totalAluno == 0) {
						System.out.println("Atribui alunos!");
					} else {
						for (int i = 0; i < totalAluno; i++) {
							somaNotas += aluno[i].getnota();

						}

						double media = somaNotas / totalAluno;
						System.out.printf("Média da turma: %.2f\n", media);
					}

					break;
				case 5:
					System.out.println("Nome do aluno que deseja remover:");
					String nomeRemover = imput.nextLine().trim(); // lê o nome
					boolean removido = false;

					for (int i = 0; i < totalAluno; i++) {
						if (aluno[i].getnome().equalsIgnoreCase(nomeRemover)) {
							// "Remove" o aluno deslocando os próximos para trás
							for (int j = i; j < totalAluno - 1; j++) {
								aluno[j] = aluno[j + 1]; // move os próximos para a posição anterior
							}
							aluno[totalAluno - 1] = null; // limpa a última posição
							totalAluno--; // diminui o total de alunos cadastrados
							removido = true;
							System.out.println("Aluno removido com sucesso.");
							break;
						}
					}

					if (!removido) {
						System.out.println("Aluno não encontrado.");
					}
					break;
				case 6:
					System.out.println("Encerrando o sistema...");
					imput.close(); // Fecha aqui, apenas quando sair
					return;
				default:
					System.out.println("Opção inválida!");
				}
			}
		} else {
			System.out.println("Senha ou usuario invalido!");
		}
	}
}
