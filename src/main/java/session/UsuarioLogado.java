package session;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import model.Usuario;

@SessionScoped
@Named("usuarioLogado")
public class UsuarioLogado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Usuario usuario;
	
	
	public void login(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public void logout() {
		this.usuario = null;
	}
	
	
	public boolean isLogado() {
		return this.usuario != null;
	}
	
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	
	public String getNome() {
		return this.usuario.getNome();
	}
	
	
	public String getEmail() {
		return this.usuario.getEmail();
	}
}