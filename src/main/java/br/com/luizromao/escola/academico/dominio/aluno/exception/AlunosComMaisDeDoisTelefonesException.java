package br.com.luizromao.escola.academico.dominio.aluno.exception;

public class AlunosComMaisDeDoisTelefonesException extends RuntimeException {

	private static final long serialVersionUID = 7096333405969607474L;

	public AlunosComMaisDeDoisTelefonesException() {
		super("O aluno ja possui telefones cadastrados na base");

	}
}
