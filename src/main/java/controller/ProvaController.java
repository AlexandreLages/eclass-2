package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;

import annotation.Permission;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import dao.DisciplinaDAO;
import dao.ProvaDAO;
import model.Disciplina;
import model.Prova;

@Controller
public class ProvaController {

	private ProvaDAO provas;
	private DisciplinaDAO disciplinaDAO;
	private Result result;
	
	
	public ProvaController() {
		this(null, null, null);
	}
	
	
	@Inject
	public ProvaController(DisciplinaDAO disciplinaDAO, Result result, ProvaDAO provas) {
		this.disciplinaDAO = disciplinaDAO;
		this.result = result;
		this.provas = provas;
	}
	
	
	@Permission
	@Get("/prova/cadastrar/{id}")
	public void cadastrar(long id) {		
		result.include("disciplina", disciplinaDAO.pesquisarDisciplinaPorId(id));
	}
	
	
	@Permission
	@Post("/prova/cadastrar")
	public void cadastrar(Prova prova, long id, String data) {
		Disciplina disciplina = disciplinaDAO.pesquisarDisciplinaPorId(id);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			prova.setDataDeRealizacao(sdf.parse(data));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		prova.setDisciplina(disciplina);
		provas.inserirProva(prova);
		result.include("success", "Prova cadastrada com sucesso!");
		result.redirectTo(ProvaController.class).listaProvasDisciplinaProfessor(id);
	}
	
	
	@Permission
	@Get("/prova/lista/disciplina/{id}")
	public void listaProvasDisciplinaProfessor(long id) {
		List<Prova> listaProvas = provas.listarProvasDisciplina(id);
		result.include("provas", listaProvas);
		result.include("disciplina", disciplinaDAO.pesquisarDisciplinaPorId(id));
	}
	
	
	@Permission
	@Get("/prova/professor/detalha/{id}")
	public void detalhaProvaDisciplinaProfessor(long id) {
		Prova prova = provas.pesquisarProvaPorId(id);
		result.include("prova", prova);
	}
}