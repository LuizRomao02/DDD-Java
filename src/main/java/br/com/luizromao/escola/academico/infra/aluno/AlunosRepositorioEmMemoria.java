package br.com.luizromao.escola.academico.infra.aluno;

import java.util.ArrayList;
import java.util.List;

import br.com.luizromao.escola.academico.dominio.aluno.Aluno;
import br.com.luizromao.escola.academico.dominio.aluno.exception.AlunoNaoEncontradoException;
import br.com.luizromao.escola.academico.dominio.aluno.repository.AlunoRepositorio;
import br.com.luizromao.escola.academico.dominio.aluno.vo.CPFVO;

public class AlunosRepositorioEmMemoria implements AlunoRepositorio {

	private List<Aluno> matriculados = new ArrayList<>();
	
	@Override
	public void matricular(Aluno aluno) {
		this.matriculados.add(aluno);
	}

	@Override
	public Aluno buscarPorCPF(CPFVO cpf) {
		return this.matriculados.stream()
				.filter(a -> a.getCpf().equals(cpf.getNumero()))
				.findFirst()
				.orElseThrow(() -> new AlunoNaoEncontradoException(cpf));
	}

	@Override
	public List<Aluno> listarTodosAlunosMatriculados() {
		return this.matriculados;
	}

}
