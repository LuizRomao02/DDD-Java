package br.com.luizromao.escola.academico.dominio.aluno.repository;

import java.sql.PreparedStatement;
import java.util.List;

import br.com.luizromao.escola.academico.dominio.aluno.vo.TelefoneVO;

public interface TelefoneRepositorio {

	void salvarTelefone(List<TelefoneVO> telefones, PreparedStatement ps);
}
