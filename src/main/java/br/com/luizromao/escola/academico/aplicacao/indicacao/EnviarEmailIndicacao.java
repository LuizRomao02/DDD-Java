package br.com.luizromao.escola.academico.aplicacao.indicacao;

import br.com.luizromao.escola.academico.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {
	
	void enviarPara(Aluno indicado);

}
