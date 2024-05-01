package br.com.luizromao.escola.academico.aplicacao.aluno.matricular;

import br.com.luizromao.escola.academico.dominio.aluno.Aluno;
import br.com.luizromao.escola.academico.dominio.aluno.vo.CPFVO;
import br.com.luizromao.escola.academico.dominio.aluno.vo.EmailVO;

public class MatricularAlunoDto {

	private String nomeAluno;
	private String cpfAluno;
	private String emailAluno;
	
	public MatricularAlunoDto(String nomeAluno, String cpfAluno, String emailAluno) {
		this.nomeAluno = nomeAluno;
		this.cpfAluno = cpfAluno;
		this.emailAluno = emailAluno;
	}

	public Aluno criarAluno() {
		return new Aluno(new CPFVO(cpfAluno), nomeAluno, new EmailVO(emailAluno));
	}
	
}
