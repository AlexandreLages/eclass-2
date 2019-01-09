package api;

import javax.inject.Inject;

import annotation.Public;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import util.GamificacaoUtil;

@Controller
public class GamificacaoAPIController {

	
	@Inject private GamificacaoUtil gamificacaoUtil;
	@Inject private Result result;
	
	
	@Public
	@Get("/gamificacao/api/ranking/disciplina/{id}")
	public void rankingDisciplina(long id) {
		result.use(Results.json()).withoutRoot().from(gamificacaoUtil.getRanking(id)).serialize();
	}
}