package br.com.luizromao.escola.gamificacao.infra.selo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.luizromao.escola.academico.dominio.aluno.vo.CPFVO;
import br.com.luizromao.escola.gamificacao.dominio.selo.RepositorioSelos;
import br.com.luizromao.escola.gamificacao.dominio.selo.Selo;

public class SelosRepositorioEmMemoria implements RepositorioSelos {

	private List<Selo> selos = new ArrayList<>();

	@Override
	public void adicionar(Selo selo) {
		this.selos.add(selo);
	}

	@Override
	public List<Selo> selosDoAlunoDeCPF(CPFVO cpf) {
		return this.selos.stream().filter(s -> s.getCpfDoAluno().equals(cpf)).collect(Collectors.toList());
	}

}
