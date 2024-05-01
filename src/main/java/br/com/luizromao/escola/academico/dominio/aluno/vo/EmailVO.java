package br.com.luizromao.escola.academico.dominio.aluno.vo;

public class EmailVO {
	
	private String endereco;

	public EmailVO(String endereco) {
		if (endereco == null || !endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
			throw new IllegalArgumentException("E-mail invalido!");
		}
		this.endereco = endereco;
	}
	
	public String getEndereco() {
		return endereco;
	}

}
