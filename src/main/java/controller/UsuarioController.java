package controller;

import javax.inject.Inject;

import annotation.Public;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import dao.UsuarioDAO;
import model.Aluno;
import model.Professor;
import model.Usuario;
import session.UsuarioLogado;

@Controller
public class UsuarioController {

	
	private UsuarioDAO usuarios;
	private UsuarioLogado usuarioLogado;
	private Result result;
	
	
	protected UsuarioController() {
		this(null, null, null);
	}
	
	
	@Inject
	public UsuarioController(UsuarioDAO usuarios, UsuarioLogado usuarioLogado, Result result) {
		this.usuarios = usuarios;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
	}
	
	
	@Public
	@Get("/usuario/login")
	public void login() {
		
	}
	
	
	@Public
	@Post("/usuario/login")
	public void login(String email, String senha) {
		Usuario logando = usuarios.pesquisarUsuarioPorEmailESenha(email, senha);
		if(logando != null) {
			if(logando instanceof Professor) {
				usuarioLogado.login(logando);
				result.redirectTo(ProfessorController.class).principal();
			} else if(logando instanceof Aluno) {
				usuarioLogado.login(logando);
				result.redirectTo(AlunoController.class).principal();
			}
		}
	}
	
	
	@Public
	@Get("/usuario/logout")
	public void logout() {
		usuarioLogado.logout();
		result.redirectTo(HomeController.class).home();
	}
}