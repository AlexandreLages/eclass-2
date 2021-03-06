package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Disciplina implements Serializable {

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
	private String escola;
	
	
	@NotNull
	private String turma;
	
	
	@NotNull
	private String turno;
	
	
	@NotNull
	private String serie;
	
	
	private Double media;
	
	
	private int alunosRanking;
	
	
	private Double notaMaxima;
	
	
	@ManyToOne
	@JoinColumn(name = "id_professor")
	private Professor professor;
	
	
	@ManyToMany
	@JoinTable(name="disciplinas_alunos", joinColumns= {@JoinColumn(name="disciplina_id")}, inverseJoinColumns= {@JoinColumn(name="aluno_id")})
	private List<Aluno> alunos = new ArrayList<>();
	
	
	@OneToMany(mappedBy = "disciplina", targetEntity = Prova.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Prova> provas;


	public Disciplina(long id, String nome, String escola, String turma, String turno, String serie,
			Professor professor, List<Aluno> alunos) {
		super();
		this.id = id;
		this.nome = nome;
		this.escola = escola;
		this.turma = turma;
		this.turno = turno;
		this.serie = serie;
		this.professor = professor;
		this.alunos = alunos;
	}
	
	
	public Disciplina() {
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


	public String getEscola() {
		return escola;
	}


	public void setEscola(String escola) {
		this.escola = escola;
	}


	public String getTurma() {
		return turma;
	}


	public void setTurma(String turma) {
		this.turma = turma;
	}


	public String getTurno() {
		return turno;
	}


	public void setTurno(String turno) {
		this.turno = turno;
	}


	public String getSerie() {
		return serie;
	}


	public void setSerie(String serie) {
		this.serie = serie;
	}


	public Professor getProfessor() {
		return professor;
	}


	public void setProfessor(Professor professor) {
		this.professor = professor;
	}


	public List<Aluno> getAlunos() {
		return alunos;
	}


	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}


	public Double getMedia() {
		return media;
	}


	public void setMedia(Double media) {
		this.media = media;
	}


	public int getAlunosRanking() {
		return alunosRanking;
	}


	public void setAlunosRanking(int alunosRanking) {
		this.alunosRanking = alunosRanking;
	}


	public Double getNotaMaxima() {
		return notaMaxima;
	}


	public void setNotaMaxima(Double notaMaxima) {
		this.notaMaxima = notaMaxima;
	}


	public List<Prova> getProvas() {
		return provas;
	}


	public void setProvas(List<Prova> provas) {
		this.provas = provas;
	}
}