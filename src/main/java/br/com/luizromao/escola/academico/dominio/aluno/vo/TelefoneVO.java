package br.com.luizromao.escola.academico.dominio.aluno.vo;

public class TelefoneVO {
	
	private String ddd;
	private String numero;

	public TelefoneVO(String ddd, String numero) {
		if (ddd == null || numero == null) {
			throw new IllegalArgumentException("DDD e Numero sao obrigatorios!");
		}

		if (!ddd.matches("\\d{2}")) {
			throw new IllegalArgumentException("DDD invalido!");
		}
		
		if (!numero.matches("\\d{8}|\\d{9}")) {
			throw new IllegalArgumentException("Numero invalido!");
		}
		
		this.ddd = ddd;
		this.numero = numero;
	}

	public String getDdd() {
		return ddd;
	}
	
	public String getNumero() {
		return numero;
	}

}
