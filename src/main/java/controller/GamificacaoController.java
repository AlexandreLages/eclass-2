package controller;

import java.util.ArrayList;

import javax.inject.Inject;

import annotation.Public;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import dao.DisciplinaDAO;
import model.Aluno;
import model.AlunoRanking;
import model.Disciplina;

@Controller
public class GamificacaoController {

	
	@Inject private DisciplinaDAO disciplinaDAO;
	@Inject private Result result;
	
	
	@Public
	@Get("/gamificacao/ranking/disciplina/{id}")
	public void rankingDisciplina(long id) {
		Disciplina disciplina = disciplinaDAO.pesquisarDisciplinaPorId(id);
		ArrayList<AlunoRanking> ranking = new ArrayList<>();
		int posicao = 1;
		for(Aluno a : disciplina.getAlunos()) {
			AlunoRanking alunoRanking = new AlunoRanking(a.getNome(), posicao, 0, a.getId());
			ranking.add(alunoRanking);
			posicao = posicao + 1;
		}
		result.use(Results.json()).withoutRoot().from(ranking).serialize();
	}
}