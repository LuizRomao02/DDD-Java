package br.com.luizromao.escola.gamificacao.dominio.selo;

import br.com.luizromao.escola.academico.dominio.aluno.vo.CPFVO;

public class Selo {

	private CPFVO cpfDoAluno;
	private String nome;

	public Selo(CPFVO cpfDoAluno, String nome) {
		super();
		this.cpfDoAluno = cpfDoAluno;
		this.nome = nome;
	}

	public CPFVO getCpfDoAluno() {
		return cpfDoAluno;
	}

	public String getNome() {
		return nome;
	}
}
