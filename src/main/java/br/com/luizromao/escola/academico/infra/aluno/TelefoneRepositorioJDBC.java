package br.com.luizromao.escola.academico.infra.aluno;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.luizromao.escola.academico.dominio.aluno.repository.TelefoneRepositorio;
import br.com.luizromao.escola.academico.dominio.aluno.vo.TelefoneVO;

public class TelefoneRepositorioJDBC implements TelefoneRepositorio {

	@Override
	public void salvarTelefone(List<TelefoneVO> telefones, PreparedStatement ps) {
		try {
			for (TelefoneVO telefone : telefones) {
				ps.setString(1, telefone.getDdd());
				ps.setString(2, telefone.getNumero());
				ps.execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
