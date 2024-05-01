package br.com.luizromao.escola.academico.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.luizromao.escola.academico.dominio.aluno.vo.CPFVO;
import br.com.luizromao.escola.academico.dominio.aluno.vo.EmailVO;

class AlunoTest {

	private Aluno aluno;

	@BeforeEach
	void beforeEach() {
		this.aluno = new Aluno(new CPFVO("123.456.789-00"), "Fulano da Silva", new EmailVO("fulano@email.com"));
	}

	@Test
	void deveriaPermitirAdicionar1Telefone() {
		this.aluno.adicionarTelefone("11", "99999999");
		assertEquals(1, this.aluno.getTelefones().size());
	}

	@Test
	void deveriaPermitirAdicionar2Telefones() {
		this.aluno.adicionarTelefone("11", "99999999");
		this.aluno.adicionarTelefone("11", "88888888");
		assertEquals(2, this.aluno.getTelefones().size());
	}

	@Test
	void naoDeveriaPermitirAdicionar3Telefones() {
		assertThrows(IllegalArgumentException.class, () -> {
			this.aluno.adicionarTelefone("11", "99999999");
			this.aluno.adicionarTelefone("11", "88888888");
			this.aluno.adicionarTelefone("11", "77777777");
		});
	}

}
