package controller;

import java.util.List;

import javax.inject.Inject;

import annotation.Public;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import model.AlunoRanking;
import util.GamificacaoUtil;

@Controller
public class GamificacaoController {

	
	@Inject private Result result;
	@Inject private GamificacaoUtil gamificacaoUtil;
	
	
	@Public
	@Get("/gamificacao/ranking/disciplina/{id}")
	public void rankingDisciplina(long id) {
		List<AlunoRanking> ranking = gamificacaoUtil.getRanking(id);
		result.include("idDisciplina", id);
		result.include("lider", ranking.get(0));
		result.include("ranking", ranking);
	}
}