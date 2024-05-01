package br.com.luizromao.escola.academico.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.luizromao.escola.academico.dominio.aluno.vo.EmailVO;

class EmailTest {

	@Test
	void naoDeveriaCriarEmailsComEnderecosInvalidos() {
		assertThrows(IllegalArgumentException.class, () -> new EmailVO(null));
		assertThrows(IllegalArgumentException.class, () -> new EmailVO(""));
		assertThrows(IllegalArgumentException.class, () -> new EmailVO("emailinvalido"));
	}

	@Test
	void deveriaPermitirCriarEmailComEnderecoValido() {
		String endereco = "fulano@alura.com.br";
		EmailVO email = new EmailVO(endereco);
		
		assertEquals(endereco, email.getEndereco());
	}

}
