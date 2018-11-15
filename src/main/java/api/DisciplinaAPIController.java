package api;

import java.util.ArrayList;

import javax.inject.Inject;

import annotation.Public;
import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import dao.DisciplinaDAO;
import model.Disciplina;

@Controller
public class DisciplinaAPIController {

	
	private DisciplinaDAO disciplinas;
	private Result result;
	
	
	public DisciplinaAPIController() {
		this(null, null);
	}
	
	
	@Inject
	public DisciplinaAPIController(DisciplinaDAO disciplinas, Result result) {
		this.disciplinas = disciplinas;
		this.result = result;
	}
	
	
	@Public
	@Get("/disciplina/api/lista/professor/{id}")
	@Consumes({"application/json", "application/xml"})
	public void listaDisciplinasProfessor(long id) {
		ArrayList<Disciplina> listaDisciplinas = (ArrayList<Disciplina>) disciplinas.listarDisciplinasPorProfessor(id);
		result.use(Results.json()).withoutRoot().from(listaDisciplinas).serialize();
	}
	
	
	@Public
	@Get("/disciplina/api/detalha/professor/{id}")
	@Consumes({"application/json", "application/xml"})
	public void detalhaDisciplinaProfessor(long id) {
		Disciplina disciplina = disciplinas.pesquisarDisciplinaPorId(id);
		result.use(Results.json()).withoutRoot().from(disciplina).serialize();
	}
}