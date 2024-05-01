package br.com.luizromao.escola.academico.infra;

public interface CifradorDeSenha {

	String cifrarSenha(String senha);

	boolean validarSenhaCifrada(String senhaCifrada, String senha);
}
