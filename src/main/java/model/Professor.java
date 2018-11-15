package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id_usuario")
public class Professor extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public String curriculo;
	
	
	public Professor(String nome, String usuario, String email, String senha, String tipo) {
		super(nome, usuario, email, senha, tipo);
	}
	
	
	public Professor() {
		super();
	}
	
	
	public String getCurriculo() {
		return curriculo;
	}

	
	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}
}