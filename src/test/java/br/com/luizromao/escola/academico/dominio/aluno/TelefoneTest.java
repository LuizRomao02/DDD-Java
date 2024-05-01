package br.com.luizromao.escola.academico.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.luizromao.escola.academico.dominio.aluno.vo.TelefoneVO;

class TelefoneTest {

	@Test
	void naoDeveriaCriarTelefoneComDDDsInvalidos() {
		assertThrows(IllegalArgumentException.class, () -> new TelefoneVO(null, "123456789"));
		assertThrows(IllegalArgumentException.class, () -> new TelefoneVO("", "123456789"));
		assertThrows(IllegalArgumentException.class, () -> new TelefoneVO("1", "123456789"));
	}

	@Test
	void naoDeveriaCriarTelefoneComNumerosInvalidos() {
		assertThrows(IllegalArgumentException.class, () -> new TelefoneVO("11", null));
		assertThrows(IllegalArgumentException.class, () -> new TelefoneVO("11", ""));
		assertThrows(IllegalArgumentException.class, () -> new TelefoneVO("11", "123"));
	}

	@Test
	void deveriaPermitirCriarTelefoneComDDDENumeroValidos() {
		String ddd = "11";
		String numero = "123456789";
		TelefoneVO telefone = new TelefoneVO(ddd, numero);
		
		assertEquals(ddd, telefone.getDdd());
		assertEquals(numero, telefone.getNumero());
	}

}
