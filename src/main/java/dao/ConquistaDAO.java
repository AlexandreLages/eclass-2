package dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;

import model.Conquista;

@RequestScoped
public class ConquistaDAO {

	private Session session;
	
	
	public ConquistaDAO() {
		this(null);
	}
	
	
	@Inject
	public ConquistaDAO(Session session) {
		this.session = session;
	}
	
	
	public void inserirConquista(Conquista conquista) {
		try {
			this.session.save(conquista);
		} catch (Exception e) {
			System.out.println("Erro ao tentar salvar conquista: " + e.getStackTrace());
		}
	}
}