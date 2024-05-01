package br.com.luizromao.escola.academico;

import br.com.luizromao.escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import br.com.luizromao.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.luizromao.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.luizromao.escola.academico.dominio.events.PublicadorDeEventos;
import br.com.luizromao.escola.academico.infra.aluno.AlunosRepositorioEmMemoria;

public class MatricularAlunoPorLinhaDeComando {
	
	public static void main(String[] args) {
		String nome = "Luiz Romao";
		String cpf = "123.456.789-00";
		String email = "romao@email.com";
		
		MatricularAlunoDto dto = new MatricularAlunoDto(nome, cpf, email);
		
		PublicadorDeEventos publicador = new PublicadorDeEventos();
		publicador.adicionar(new LogDeAlunoMatriculado());
		
		MatricularAluno matricular = new MatricularAluno(new AlunosRepositorioEmMemoria(), publicador);
		
		matricular.executa(dto);
	}

}
