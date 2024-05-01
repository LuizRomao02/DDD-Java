package br.com.luizromao.escola.academico.dominio.aluno;

import java.time.format.DateTimeFormatter;

import br.com.luizromao.escola.academico.dominio.events.Evento;
import br.com.luizromao.escola.academico.dominio.events.Ouvinte;

public class LogDeAlunoMatriculado extends Ouvinte {

	@Override
	public void reageAo(Evento evento) {
		String momentoFormatado = evento.momento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		System.out.println(String.format("Aluno com CPF %s matriculado em: %s",
				((AlunoMatriculado) evento).getCpfAluno(), momentoFormatado));
	}

	@Override
	protected boolean deveProcessar(Evento evento) {
		return evento instanceof AlunoMatriculado;
	}

}
