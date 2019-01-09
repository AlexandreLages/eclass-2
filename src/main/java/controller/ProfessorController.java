package controller;

import javax.inject.Inject;

import annotation.Permission;
import annotation.Public;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import dao.UsuarioDAO;
import model.Professor;
import session.UsuarioLogado;

@Controller
public class ProfessorController {

	private UsuarioLogado usuarioLogado;
	private UsuarioDAO usuarios;
	private Result result;
	
	
	protected ProfessorController() {
		this(null, null, null);
	}
	
	
	@Inject
	public ProfessorController(UsuarioDAO usuarios, Result result, UsuarioLogado usuarioLogado) {
		this.usuarios = usuarios;
		this.result = result;
		this.usuarioLogado = usuarioLogado;
	}
	
	
	@Public
	@Get("/professor/cadastrar")
	public void cadastrar() {
		
	}
	
	
	@Public
	@Post("/professor/cadastrar")
	public void cadastrar(final Professor professor, String confirmarSenha) {
		if(usuarios.pesquisarUsuarioPorEmail(professor) == false && usuarios.pesquisarUsuarioPorUsuario(professor) == false) {
			if(professor.getSenha().equals(confirmarSenha) == false) {
				result.include("error", "<strong>Erro!</strong> As senhas não coincidem");
				result.redirectTo(HomeController.class).home();
			}
			professor.setTipo("professor");
			usuarios.inserirUsuario(professor);
			result.include("success", "<strong>Sucesso!</strong> Conta criada com sucesso");
			result.redirectTo(HomeController.class).home();
		} else {
			result.include("error", "<strong>Erro!</strong> Já existe uma conta com esses dados");
			result.redirectTo(HomeController.class).home();
		}
	}

	
	@Permission
	@Get("/professor/principal")
	public void principal() {
		if((usuarioLogado.getUsuario() instanceof Professor) == false) {
			result.redirectTo(UsuarioController.class).login();
		}
	}
}