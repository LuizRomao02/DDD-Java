package br.com.luizromao.escola.academico.aplicacao.aluno.matricular;

import br.com.luizromao.escola.academico.dominio.aluno.Aluno;
import br.com.luizromao.escola.academico.dominio.aluno.AlunoMatriculado;
import br.com.luizromao.escola.academico.dominio.aluno.repository.AlunoRepositorio;
import br.com.luizromao.escola.academico.dominio.events.PublicadorDeEventos;

public class MatricularAluno {
	
	private final AlunoRepositorio repositorio;
	private final PublicadorDeEventos publicadorEventos;

	public MatricularAluno(AlunoRepositorio repositorio, PublicadorDeEventos publicadorEventos) {
		this.repositorio = repositorio;
		this.publicadorEventos = publicadorEventos;
	}
	
	// COMMAND
	public void executa(MatricularAlunoDto dados) {
		Aluno novo = dados.criarAluno();
		repositorio.matricular(novo);
		
		AlunoMatriculado evento = new AlunoMatriculado(novo.getCpf());
		publicadorEventos.publicar(evento);
		
	}

}
