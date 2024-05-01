package br.com.luizromao.escola.academico.dominio.aluno;

import br.com.luizromao.escola.academico.dominio.aluno.vo.CPFVO;
import br.com.luizromao.escola.academico.dominio.aluno.vo.EmailVO;

public class FabricaDeAluno {
	
	private Aluno aluno;

	public FabricaDeAluno comNomeCPFEmail(String nome, String cpf, String email) {
		this.aluno = new Aluno(new CPFVO(cpf), nome, new EmailVO(email));
		return this;
	}
	
	public FabricaDeAluno comTelefone(String ddd, String numero) {
		this.aluno.adicionarTelefone(ddd, numero);
		return this;
	}
	
	public Aluno criar() {
		return this.aluno;
	}
	
}
