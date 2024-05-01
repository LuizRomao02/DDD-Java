package br.com.luizromao.escola.academico.dominio.aluno;

import java.util.ArrayList;
import java.util.List;

import br.com.luizromao.escola.academico.dominio.aluno.exception.AlunosComMaisDeDoisTelefonesException;
import br.com.luizromao.escola.academico.dominio.aluno.vo.CPFVO;
import br.com.luizromao.escola.academico.dominio.aluno.vo.EmailVO;
import br.com.luizromao.escola.academico.dominio.aluno.vo.TelefoneVO;

//AGGREGATE ROOT
public class Aluno {
	
	private CPFVO cpf;
	private String nome;
	private EmailVO email;
	private List<TelefoneVO> telefones = new ArrayList<>();
	private String senha;
	
	public Aluno(CPFVO cpf, String nome, EmailVO email) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}

	//invariante
	public void adicionarTelefone(String ddd, String numero) {
		if(telefones.size() > 1) {
			throw new AlunosComMaisDeDoisTelefonesException();
		}
		this.telefones.add(new TelefoneVO(ddd, numero));
	}
	
	public CPFVO getCpf() {
		return cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email.getEndereco();
	}
	
	public List<TelefoneVO> getTelefones() {
		return telefones;
	}

	public String getSenha() {
		return senha;
	}
	
}
