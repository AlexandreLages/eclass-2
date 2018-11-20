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
import dao.UsuarioDAO;
import model.Aluno;
import model.Disciplina;

@Controller
public class DisciplinaAPIController {

	
	private UsuarioDAO usuarioDAO;
	private DisciplinaDAO disciplinas;
	private Result result;
	
	
	public DisciplinaAPIController() {
		this(null, null, null);
	}
	
	
	@Inject
	public DisciplinaAPIController(DisciplinaDAO disciplinas, Result result, UsuarioDAO usuarioDAO) {
		this.disciplinas = disciplinas;
		this.result = result;
		this.usuarioDAO = usuarioDAO;
	}
	
	
	/**
	 *
	 * @param id que identifica o usuario professor que deve ter suas disciplinas listadas
	 */
	@Public
	@Get("/disciplina/api/lista/professor/{id}")
	@Consumes({"application/json", "application/xml"})
	public void listaDisciplinasProfessor(long id) {
		ArrayList<Disciplina> listaDisciplinas = (ArrayList<Disciplina>) disciplinas.listarDisciplinasPorProfessor(id);
		result.use(Results.json()).withoutRoot().from(listaDisciplinas).serialize();
	}
	
	
	/**
	 *
	 * @param id que identifica o usuario aluno que deve ter suas disciplinas listadas
	 */
	@Public
	@Get("/disciplina/api/lista/aluno/{id}")
	@Consumes({"application/json", "application/xml"})
	public void listaDisciplinasAluno(long id) {
		Aluno aluno = (Aluno) usuarioDAO.pesquisarUsuarioPorId(id); 
		result.use(Results.json()).withoutRoot().from(aluno.getDisciplinas()).serialize();
	}
	
	
	@Public
	@Get("/disciplina/api/detalha/professor/{id}")
	@Consumes({"application/json", "application/xml"})
	public void detalhaDisciplinaProfessor(long id) {
		Disciplina disciplina = disciplinas.pesquisarDisciplinaPorId(id);
		result.use(Results.json()).withoutRoot().from(disciplina).serialize();
	}
	
	
	@Public
	@Get("/disciplina/api/detalha/aluno/{id}")
	@Consumes({"application/json", "application/xml"})
	public void detalhaDisciplinaAluno(long id) {
		Disciplina disciplina = disciplinas.pesquisarDisciplinaPorId(id);
		result.use(Results.json()).withoutRoot().from(disciplina).recursive().serialize();
	}
}