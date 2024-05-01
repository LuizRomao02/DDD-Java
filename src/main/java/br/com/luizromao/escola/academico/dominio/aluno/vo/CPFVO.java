package br.com.luizromao.escola.academico.dominio.aluno.vo;

public class CPFVO {

	private String numero;

	public CPFVO(String numero) {
		if (numero == null || !numero.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
			throw new IllegalArgumentException("CPF invalido!");
		}
		this.numero = numero;
	}
	
	public String getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		return numero;
	}
	
	
}
