package br.com.luizromao.escola.academico.infra.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.luizromao.escola.academico.dominio.aluno.Aluno;
import br.com.luizromao.escola.academico.dominio.aluno.exception.AlunoNaoEncontradoException;
import br.com.luizromao.escola.academico.dominio.aluno.repository.AlunoRepositorio;
import br.com.luizromao.escola.academico.dominio.aluno.repository.TelefoneRepositorio;
import br.com.luizromao.escola.academico.dominio.aluno.vo.CPFVO;
import br.com.luizromao.escola.academico.dominio.aluno.vo.EmailVO;

public class AlunosRepositorioJDBC implements AlunoRepositorio {

	private final Connection connection;
	private final TelefoneRepositorio telefoneRepository;
	
	public AlunosRepositorioJDBC(Connection connection) {
		this.connection = connection;
		this.telefoneRepository = null;
	}

	@Override
	public void matricular(Aluno aluno) {
		try {
			String sql = "INSERT INTO ALUNO VALUES(?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, aluno.getCpf().getNumero());
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getEmail());
			ps.execute();
			
			sql = "INSERT INTO TELEFONE VALUES(?, ?)";
			ps = connection.prepareStatement(sql);
			
			telefoneRepository.salvarTelefone(aluno.getTelefones(), ps);
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Aluno buscarPorCPF(CPFVO cpf) {
		try {
			String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, cpf.getNumero());

			ResultSet rs = ps.executeQuery();
			boolean encontrou = rs.next();
			
			if (!encontrou) {
				throw new AlunoNaoEncontradoException(cpf);
			}

			String nome = rs.getString("nome");
			EmailVO email = new EmailVO(rs.getString("email"));
			Aluno encontrado = new Aluno(cpf, nome, email);
			Long id = rs.getLong("id");
			
			sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
			ps = connection.prepareStatement(sql);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				String numero = rs.getString("numero");
				String ddd = rs.getString("ddd");
				encontrado.adicionarTelefone(ddd, numero);
			}
			
			return encontrado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Aluno> listarTodosAlunosMatriculados() {
		try {
			String sql = "SELECT id, cpf, nome, email FROM ALUNO";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Aluno> alunos = new ArrayList<>();
			
			while (rs.next()) {
				CPFVO cpf = new CPFVO(rs.getString("cpf"));
				String nome = rs.getString("nome");
				EmailVO email = new EmailVO(rs.getString("email"));
				Aluno aluno = new Aluno(cpf, nome, email);
				Long id = rs.getLong("id");
				
				sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
				PreparedStatement psTelefone = connection.prepareStatement(sql);
				
				psTelefone.setLong(1, id);
				ResultSet rsTelefone = psTelefone.executeQuery();
				
				while (rsTelefone.next()) {
					String numero = rsTelefone.getString("numero");
					String ddd = rsTelefone.getString("ddd");
					aluno.adicionarTelefone(ddd, numero);
				}
			
				alunos.add(aluno);
			}
			
			return alunos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
