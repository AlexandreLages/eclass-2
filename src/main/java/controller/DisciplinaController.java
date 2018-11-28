package controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import annotation.Permission;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import dao.DisciplinaDAO;
import dao.UsuarioDAO;
import model.Aluno;
import model.Disciplina;
import model.Pai;
import model.Professor;
import session.UsuarioLogado;

@Controller
public class DisciplinaController {

	
	private UsuarioLogado usuarioLogado;
	private DisciplinaDAO disciplinas;
	private UsuarioDAO usuarioDAO;
	private Result result;
	
	
	public DisciplinaController() {
		this(null, null, null, null);
	}
	
	
	@Inject
	public DisciplinaController(UsuarioLogado usuarioLogado, DisciplinaDAO disciplinas, Result result, UsuarioDAO usuarioDAO) {
		this.usuarioLogado = usuarioLogado;
		this.disciplinas = disciplinas;
		this.result = result;
		this.usuarioDAO = usuarioDAO;
	}
	
	
	@Permission
	@Get("/disciplina/cadastrar")
	public void cadastrarDisciplina() {
		if(usuarioLogado.getUsuario() instanceof Aluno) {
			result.redirectTo(UsuarioController.class).login();
		}
	}
	
	
	@Permission
	@Post("/disciplina/cadastrar")
	public void cadastrarDisciplina(Disciplina disciplina, long id) {
		Professor professor = (Professor) usuarioDAO.pesquisarUsuarioPorId(id);
		disciplina.setProfessor(professor);
		disciplinas.inserirDisciplina(disciplina);
		result.include("mensagem", "Disciplina adicionada com sucesso");
		result.redirectTo(DisciplinaController.class).listaDisciplinasProfessor(id);;
	}
	
	
	@Permission
	@Get("/disciplina/lista/professor/{id}")
	public void listaDisciplinasProfessor(long id) {
		if(usuarioLogado.getUsuario() instanceof Aluno || usuarioLogado.getUsuario().getId() != id) {
			result.include("error", "Você não tem permissão para acessar esse recurso");
			result.redirectTo(UsuarioController.class).login();
		}
		ArrayList<Disciplina> listaDisciplinas = (ArrayList<Disciplina>) disciplinas.listarDisciplinasPorProfessor(id);
		result.include("disciplinas", listaDisciplinas);
	}
	
	
	@Permission
	@Get("/disciplina/lista/aluno/{id}")
	public void listaDisciplinasAluno(long id) {
		if(usuarioLogado.getUsuario() instanceof Professor || usuarioLogado.getUsuario().getId() != id) {
			result.include("error", "Você não tem permissão para acessar esse recurso");
			result.redirectTo(UsuarioController.class).login();
		}
		Aluno aluno = (Aluno) usuarioDAO.pesquisarUsuarioPorId(id);
		result.include("disciplinas", aluno.getDisciplinas());
	}
	
	
	@Permission
	@Get("/disciplina/lista/filho/{id}")
	public void listaDisciplinasFilho(long id) {
		if(usuarioLogado.getUsuario() instanceof Pai == false) {
			result.include("error", "Você não tem permissão para acessar esse recurso");
			result.redirectTo(UsuarioController.class).login();
		}
		Aluno aluno = (Aluno) usuarioDAO.pesquisarUsuarioPorId(id);
		result.include("disciplinas", aluno.getDisciplinas());
	}
	
	
	@Permission
	@Get("/disciplina/relacionar/{id}")
	public void relacionarAluno(long id) {
		if((usuarioLogado.getUsuario() instanceof Professor) == false) {
			result.include("error", "Você não tem permissão para acessar esse recurso");
			result.redirectTo(UsuarioController.class).login();
		}
		result.include("idDisciplina", id);
	}
	
	
	@Permission
	@Post("/disciplina/relacionar")
	public void relacionarAluno(long idDisciplina, String email) {
		Aluno aluno = (Aluno) usuarioDAO.pesquisarUsuarioPorEmail(email);
		Disciplina disciplina = disciplinas.pesquisarDisciplinaPorId(idDisciplina);
		List<Aluno> alunos = disciplina.getAlunos();
		alunos.add(aluno);
		disciplina.setAlunos(alunos);
		disciplinas.atualizarDisciplina(disciplina);
		result.include("mensagem", "Aluno relacionado com sucesso");
		result.redirectTo(ProfessorController.class).principal();
	}
	
	
	@Permission
	@Get("/disciplina/professor/detalha/{id}")
	public void detalhaDisciplinaProfessor(long id) {
		if((usuarioLogado.getUsuario() instanceof Professor) == false) {
			result.include("error", "Você não tem permissão para acessar esse recurso");
			result.redirectTo(UsuarioController.class).login();
		}
		Disciplina disciplina = disciplinas.pesquisarDisciplinaPorId(id);
		result.include("disciplina", disciplina);
	}
	
	
	@Permission
	@Get("/disciplina/aluno/detalha/{id}")
	public void detalhaDisciplinaAluno(long id) {
		if((usuarioLogado.getUsuario() instanceof Aluno) == false) {
			result.include("error", "Você não tem permissão para acessar esse recurso");
			result.redirectTo(UsuarioController.class).login();
		}
		Disciplina disciplina = disciplinas.pesquisarDisciplinaPorId(id);
		result.include("disciplina", disciplina);
	}
	
	
	@Permission
	@Get("/disciplina/pai/detalha/{id}")
	public void detalhaDisciplinaFilho(long id) {
		if((usuarioLogado.getUsuario() instanceof Pai) == false) {
			result.include("error", "Você não tem permissão para acessar esse recurso");
			result.redirectTo(UsuarioController.class).login();
		}
		Disciplina disciplina = disciplinas.pesquisarDisciplinaPorId(id);
		result.include("disciplina", disciplina);
	}
}