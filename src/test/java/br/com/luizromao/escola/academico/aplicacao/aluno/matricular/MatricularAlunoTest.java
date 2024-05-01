package br.com.luizromao.escola.academico.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.luizromao.escola.academico.dominio.aluno.Aluno;
import br.com.luizromao.escola.academico.dominio.aluno.vo.CPFVO;
import br.com.luizromao.escola.academico.dominio.events.PublicadorDeEventos;
import br.com.luizromao.escola.academico.infra.aluno.AlunosRepositorioEmMemoria;

class MatricularAlunoTest {

	@Test
	void alunoDeveriaSerPersistido() {
		AlunosRepositorioEmMemoria repositorio = new AlunosRepositorioEmMemoria();
		
		MatricularAluno useCase = new MatricularAluno(repositorio, new PublicadorDeEventos());
		
		MatricularAlunoDto dados = new MatricularAlunoDto("Fulano", "123.456.789-00", "fulano@email.com");
		useCase.executa(dados);
		
		Aluno encontrado = repositorio.buscarPorCPF(new CPFVO("123.456.789-00"));
		
		assertEquals("Fulano", encontrado.getNome());
		assertEquals(new CPFVO("123.456.789-00"), encontrado.getCpf());
		assertEquals("fulano@email.com", encontrado.getEmail());
	}

}
