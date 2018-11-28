package controller;

import java.util.List;

import javax.inject.Inject;

import annotation.Permission;
import annotation.Public;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import dao.UsuarioDAO;
import model.Aluno;
import model.Pai;
import session.UsuarioLogado;

@Controller
public class PaiController {

	
	@Inject private UsuarioLogado usuarioLogado;
	@Inject private UsuarioDAO usuarios;
	@Inject private Result result;
	
	
	@Public
	@Get("/pai/cadastrar")
	public void cadastrar() {
		
	}
	
	
	@Public
	@Post("/pai/cadastrar")
	public void cadastrar(Pai pai, String confirmarSenha) {
		if(usuarios.pesquisarUsuarioPorEmail(pai) == false && usuarios.pesquisarUsuarioPorUsuario(pai) == false) {
			if(pai.getSenha().equals(confirmarSenha) == false) {
				result.include("error", "As senhas não coincidem");
				result.redirectTo(HomeController.class).home();
			}
			pai.setTipo("pai");
			usuarios.inserirUsuario(pai);
			result.include("error", "Conta criada com sucesso");
			result.redirectTo(HomeController.class).home();
		} else {
			result.include("error", "Já existe uma conta com esses dados");
			result.redirectTo(HomeController.class).home();
		}
	}


	@Permission
	@Get("/pai/principal")
	public void principal() {
		if((usuarioLogado.getUsuario() instanceof Pai) == false) {
			result.redirectTo(UsuarioController.class).login();
		}
	}
	
	
	@Permission
	@Get("/pai/relacionar/{id}")
	public void relacionarAluno(long id) {
		if((usuarioLogado.getUsuario() instanceof Pai) == false) {
			result.include("error", "Você não tem permissão para acessar esse recurso");
			result.redirectTo(UsuarioController.class).login();
		}
		result.include("idPai", id);
	}
	
	
	@Permission
	@Post("/pai/relacionar")
	public void relacionarAluno(long idPai, String email) {
		Aluno aluno = (Aluno) usuarios.pesquisarUsuarioPorEmail(email);
		Pai pai = (Pai) usuarios.pesquisarUsuarioPorId(idPai);
		List<Pai> pais = aluno.getPais();
		pais.add(pai);
		aluno.setPais(pais);
		usuarios.atualizarUsuario(aluno);
		result.include("mensagem", "Aluno relacionado com sucesso");
		result.redirectTo(PaiController.class).principal();
	}
}