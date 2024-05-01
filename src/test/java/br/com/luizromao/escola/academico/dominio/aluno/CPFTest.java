package br.com.luizromao.escola.academico.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.luizromao.escola.academico.dominio.aluno.vo.CPFVO;

class CPFTest {

	@Test
	void naoDeveriaCriarCPFComNumerosInvalidos() {
		assertThrows(IllegalArgumentException.class, () -> new CPFVO(null));
		assertThrows(IllegalArgumentException.class, () -> new CPFVO(""));
		assertThrows(IllegalArgumentException.class, () -> new CPFVO("12345678900"));
	}

	@Test
	void deveriaPermitirCriarCPFComNumeroValido() {
		String numero = "123.456.789-00";
		CPFVO cpf = new CPFVO(numero);
		
		assertEquals(numero, cpf.getNumero());
	}

}
