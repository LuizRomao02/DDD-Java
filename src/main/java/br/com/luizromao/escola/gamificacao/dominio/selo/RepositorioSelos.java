package br.com.luizromao.escola.gamificacao.dominio.selo;

import java.util.List;

import br.com.luizromao.escola.academico.dominio.aluno.vo.CPFVO;

public interface RepositorioSelos {

	void adicionar(Selo selo);

	List<Selo> selosDoAlunoDeCPF(CPFVO cpf);
}
