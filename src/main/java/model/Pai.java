package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(name = "id_usuario")
public class Pai extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@ManyToMany(mappedBy = "pais")
	private List<Aluno> filhos = new ArrayList<>();
	
	
	public Pai(String nome, String usuario, String email, String senha, String tipo) {
		super(nome, usuario, email, senha, tipo);
	}
	
	
	public Pai() {
		super();
	}


	public List<Aluno> getFilhos() {
		return filhos;
	}


	public void setFilhos(List<Aluno> filhos) {
		this.filhos = filhos;
	}
}