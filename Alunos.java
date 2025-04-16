package cadastroDeAlunos;

public class Alunos {

	String nome;
	int idade;
	double nota;
	
	public Alunos (String nome, int idade, double nota) {
		this.nome = nome;
		this.idade = idade;
		this.nota = nota;
	}
	
	public String getnome() {
		return nome;
	}
	
	public int getidade(){
		return idade;
	}
	
	public double getnota() {
		return nota;
	}
	
	public void exibirAluno() {
		System.out.println("Nome Aluno: " + nome + "\nIdade: " + idade + "\nNota final: " + nota);
	}
	
	
	
}
