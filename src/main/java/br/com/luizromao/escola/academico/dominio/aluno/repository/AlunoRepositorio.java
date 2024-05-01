package br.com.luizromao.escola.academico.dominio.aluno.repository;

import java.util.List;

import br.com.luizromao.escola.academico.dominio.aluno.Aluno;
import br.com.luizromao.escola.academico.dominio.aluno.vo.CPFVO;

public interface AlunoRepositorio {
	
	void matricular(Aluno aluno);
	
	Aluno buscarPorCPF(CPFVO cpf);
	
	List<Aluno> listarTodosAlunosMatriculados();

}
