package br.com.luizromao.escola.academico.dominio.aluno;

import java.time.LocalDateTime;

import br.com.luizromao.escola.academico.dominio.aluno.vo.CPFVO;
import br.com.luizromao.escola.academico.dominio.events.Evento;

public class AlunoMatriculado implements Evento{

	private final CPFVO cpfAluno;
	private final LocalDateTime momento;
	
	public AlunoMatriculado(CPFVO cpfAluno) {
		super();
		this.cpfAluno = cpfAluno;
		this.momento = LocalDateTime.now();
	}

	@Override
	public LocalDateTime momento() {
		return this.momento;
	}

	public CPFVO getCpfAluno() {
		return cpfAluno;
	}

}
