package api;

import javax.inject.Inject;

import annotation.Public;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import dao.DisciplinaDAO;
import model.Disciplina;

@Controller
public class AlunoAPIController {

	private DisciplinaDAO disciplinaDAO;
	private Result result;
	
	
	public AlunoAPIController() {
		this(null, null);
	}
	
	
	@Inject
	public AlunoAPIController(Result result, DisciplinaDAO disciplinaDAO) {
		this.result = result;
		this.disciplinaDAO = disciplinaDAO;
	}
	
	
	@Public
	@Get("/aluno/api/lista/disciplina/{id}")
	public void listarAlunoDisciplina(long id) {
		Disciplina disciplina = disciplinaDAO.pesquisarDisciplinaPorId(id);
		result.use(Results.json()).withoutRoot().from(disciplina.getAlunos()).exclude("senha").serialize();
	}
}