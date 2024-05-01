package br.com.luizromao.escola.academico.dominio.aluno.exception;

import br.com.luizromao.escola.academico.dominio.aluno.vo.CPFVO;

public class AlunoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = -2110535213263888752L;

	public AlunoNaoEncontradoException(CPFVO cpf) {
		super("Aluno nao encontrado com CPF: " + cpf.getNumero());
	}

}
