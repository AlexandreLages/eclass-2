package model;

public class AlunoRanking {

	private String nome;
	private int posicao;
	private int xp;
	private long id;
	
	
	public AlunoRanking(String nome, int posicao, int xp, long id) {
		super();
		this.nome = nome;
		this.posicao = posicao;
		this.xp = xp;
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getPosicao() {
		return posicao;
	}


	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}


	public int getXp() {
		return xp;
	}


	public void setXp(int xp) {
		this.xp = xp;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
}