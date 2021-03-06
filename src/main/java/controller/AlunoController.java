package controller;

import javax.inject.Inject;

import annotation.Permission;
import annotation.Public;
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
public class AlunoController {

	private UsuarioLogado usuarioLogado;
	private UsuarioDAO usuarios;
	private DisciplinaDAO disciplinaDAO;
	private Result result;
	
	
	protected AlunoController() {
		this(null, null, null, null);
	}
	
	
	@Inject
	public AlunoController(UsuarioDAO usuarios, Result result, UsuarioLogado usuarioLogado, DisciplinaDAO disciplinaDAO) {
		this.usuarios = usuarios;
		this.result = result;
		this.usuarioLogado = usuarioLogado;
		this.disciplinaDAO = disciplinaDAO;
	}
	
	
	@Public
	@Get("/aluno/cadastrar")
	public void cadastrar() {
		
	}
	
	
	@Public
	@Post("/aluno/cadastrar")
	public void cadastrar(Aluno aluno, String confirmarSenha) {
		if(usuarios.pesquisarUsuarioPorEmail(aluno) == false && usuarios.pesquisarUsuarioPorUsuario(aluno) == false) {
			if(aluno.getSenha().equals(confirmarSenha) == false) {
				result.include("error", "<strong>Erro!</strong> As senhas não coincidem");
				result.redirectTo(HomeController.class).home();
			}
			aluno.setTipo("aluno");
			usuarios.inserirUsuario(aluno);
			result.include("success", "<strong>Sucesso!</strong> Conta criada com sucesso");
			result.redirectTo(HomeController.class).home();
		} else {
			result.include("error", "<strong>Erro!</strong> Já existe uma conta com esses dados");
			result.redirectTo(HomeController.class).home();
		}
	}

	
	@Permission
	@Get("/aluno/principal")
	public void principal() {
		if((usuarioLogado.getUsuario() instanceof Aluno) == false) {
			result.redirectTo(UsuarioController.class).login();
		}
	}
	
	
	@Permission
	@Get("/aluno/lista/disciplina/{id}")
	public void listarAlunoDisciplina(long id) {
		if((usuarioLogado.getUsuario() instanceof Professor) == false) {
			result.include("error", "Você não tem permissão para acessar esse recurso");
			result.redirectTo(UsuarioController.class).login();
		}
		Disciplina disciplina = disciplinaDAO.pesquisarDisciplinaPorId(id);
		result.include("disciplina", disciplina);
		result.include("alunos", disciplina.getAlunos());
	}
	
	
	@Permission
	@Get("/aluno/lista/{id}")
	public void listarAlunos(long id) {
		if((usuarioLogado.getUsuario() instanceof Aluno) == false) {
			result.include("error", "Você não tem permissão para acessar esse recurso");
			result.redirectTo(UsuarioController.class).login();
		}
		Disciplina disciplina = disciplinaDAO.pesquisarDisciplinaPorId(id);
		result.include("disciplina", disciplina);
		result.include("alunos", disciplina.getAlunos());
	}
	
	
	@Permission
	@Get("/aluno/lista/pai/{id}")
	public void listarAlunosPai(long id) {
		if((usuarioLogado.getUsuario() instanceof Pai) == false) {
			result.include("error", "Você não tem permissão para acessar esse recurso");
			result.redirectTo(UsuarioController.class).login();
		}
		Pai pai = (Pai) usuarios.pesquisarUsuarioPorId(id);
		result.include("filhos", pai.getFilhos());
	}
}