package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@NotNull
	private String nome;
	
	
	@NotNull
	private String usuario;
	
	
	@NotNull
	private String email;
	
	
	@NotNull
	private String senha;
	
	
	@NotNull
	private String tipo;
	
	
	private String token;
	

	public Usuario(String nome, String usuario, String email, String senha, String tipo) {
		this.nome = nome;
		this.usuario = usuario;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
	}
	
	
	public Usuario() {
		super();
	}

	
	public long getId() {
		return id;
	}

	
	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getNome() {
		return nome;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getUsuario() {
		return usuario;
	}

	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	
	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getSenha() {
		return senha;
	}

	
	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}
}