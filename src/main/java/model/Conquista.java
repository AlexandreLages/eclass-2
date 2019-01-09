package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Conquista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public Conquista(String nome, String mensagem, String imagem, int prioridade) {
		super();
		this.nome = nome;
		this.mensagem = mensagem;
		this.imagem = imagem;
		this.prioridade = prioridade;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@NotNull
	private String nome;
	
	
	@NotNull
	private String mensagem;
	
	
	@NotNull
	private String imagem;
	
	
	@NotNull
	private int prioridade;


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


	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public String getImagem() {
		return imagem;
	}


	public void setImagem(String imagem) {
		this.imagem = imagem;
	}


	public int getPrioridade() {
		return prioridade;
	}


	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
}