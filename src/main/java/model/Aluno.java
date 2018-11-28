package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id_usuario")
public class Aluno extends Usuario implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@ManyToMany(mappedBy = "alunos")
	private List<Disciplina> disciplinas = new ArrayList<>();
	
	
	@ManyToMany
	@JoinTable(name="alunos_pais", joinColumns= {@JoinColumn(name="aluno_id")}, inverseJoinColumns= {@JoinColumn(name="pai_id")})
	private List<Pai> pais = new ArrayList<>();

	
	public Aluno(String nome, String usuario, String email, String senha, String tipo) {
		super(nome, usuario, email, senha, tipo);
	}
	
	
	public Aluno() {
		super();
	}

	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	
	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	
	public List<Pai> getPais() {
		return pais;
	}
	
	
	public void setPais(List<Pai> pais) {
		this.pais = pais;
	}
}