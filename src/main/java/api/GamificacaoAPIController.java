package api;

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
public class GamificacaoAPIController {

	@Inject private DisciplinaDAO disciplinaDAO;
	@Inject private Result result;
	
	
	@Public
	@Get("/gamificacao/api/ranking/disciplina/{id}")
	public void rankingDisciplina(long id) {
		Disciplina disciplina = disciplinaDAO.pesquisarDisciplinaPorId(id);
		ArrayList<AlunoRanking> ranking = new ArrayList<>();
		int posicao = 0;
		int xp = 12;
		for(Aluno a : disciplina.getAlunos()) {
			AlunoRanking alunoRanking = new AlunoRanking(a.getNome(), posicao, xp, a.getId());
			ranking.add(alunoRanking);
			xp = xp - 2;
		}
		result.use(Results.json()).withoutRoot().from(ranking).serialize();
	}
}