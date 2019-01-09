package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Mensagem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	@NotNull
	private String mensagem;
	
	
	@NotNull
	private String tipo;
	
	
	public Mensagem(long id, String mensagem, String tipo) {
		this.id = id;
		this.mensagem = mensagem;
		this.tipo = tipo;
	}
	
	
	public Mensagem(String mensagem, String tipo) {
		this.mensagem = mensagem;
		this.tipo = tipo;
	}
	
	
	public Mensagem() {
		super();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}