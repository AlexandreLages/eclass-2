package api;

import javax.inject.Inject;

import annotation.Public;
import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import dao.UsuarioDAO;
import model.Aluno;
import model.Professor;
import model.Usuario;
import session.UsuarioLogado;

@Controller
public class UsuarioAPIController {

	private UsuarioLogado usuarioLogado;
	private UsuarioDAO usuarios;
	private Result result;
	
	
	public UsuarioAPIController() {
		this(null, null, null);
	}
	
	
	@Inject
	public UsuarioAPIController(UsuarioDAO usuarios, Result result, UsuarioLogado usuarioLogado) {
		this.usuarios = usuarios;
		this.result = result;
		this.usuarioLogado = usuarioLogado;
	}
	
	
	@Public
	@Post("/usuario/api/login")
	@Consumes({"application/json", "application/xml"})
	public void login(String email, String senha) {
		Usuario usuario = usuarios.pesquisarUsuarioPorEmailESenha(email, senha);
		if(usuario != null) {
			usuarioLogado.login(usuario);
			if(usuario instanceof Professor) {
				result.use(Results.json()).withoutRoot().from(usuario).exclude("senha").serialize();
			} else if(usuario instanceof Aluno) {
				result.use(Results.json()).withoutRoot().from(usuario).exclude("senha").serialize();
			}
		}
	}
	
	
	@Public
	@Post("/usuario/responsavel/api/login")
	@Consumes({"application/json", "application/xml"})
	public void login(String cpf) {
		Usuario usuario = usuarios.pesquisarUsuarioPorEmail(cpf);
		if(usuario != null) {
			usuarioLogado.login(usuario);
			result.use(Results.json()).withoutRoot().from(usuario).exclude("senha").serialize();
		}
	}
}