package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id_usuario")
public class Aluno extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Aluno(String nome, String usuario, String email, String senha, String tipo) {
		super(nome, usuario, email, senha, tipo);
	}
	
	public Aluno() {
		super();
	}
}