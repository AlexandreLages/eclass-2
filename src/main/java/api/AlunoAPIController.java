package api;

import javax.inject.Inject;

import annotation.Public;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import dao.DisciplinaDAO;
import dao.UsuarioDAO;
import model.Disciplina;
import model.Pai;

@Controller
public class AlunoAPIController {

	private UsuarioDAO usuarios;
	private DisciplinaDAO disciplinaDAO;
	private Result result;
	
	
	public AlunoAPIController() {
		this(null, null, null);
	}
	
	
	@Inject
	public AlunoAPIController(Result result, DisciplinaDAO disciplinaDAO, UsuarioDAO usuarios) {
		this.result = result;
		this.disciplinaDAO = disciplinaDAO;
		this.usuarios = usuarios;
	}
	
	
	@Public
	@Get("/aluno/api/lista/disciplina/{id}")
	public void listarAlunoDisciplina(long id) {
		Disciplina disciplina = disciplinaDAO.pesquisarDisciplinaPorId(id);
		result.use(Results.json()).withoutRoot().from(disciplina.getAlunos()).exclude("senha").serialize();
	}
	
	
	@Public
	@Get("/aluno/api/lista/pai/{id}")
	public void listarAlunosPai(long id) {
		Pai pai = (Pai) usuarios.pesquisarUsuarioPorId(id);
		result.use(Results.json()).withoutRoot().from(pai.getFilhos()).serialize();
	}
}