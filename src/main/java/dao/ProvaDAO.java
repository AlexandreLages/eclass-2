package dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.Prova;

@RequestScoped
public class ProvaDAO {

	private Session session;
	
	
	public ProvaDAO() {
		this(null);
	}
	
	
	@Inject
	public ProvaDAO(Session session) {
		this.session = session;
	}
	
	
	public void inserirProva(Prova prova) {
		try {
			this.session.save(prova);
		} catch (Exception e) {
			System.out.println("Erro ao tentar salvar prova: " + e.getStackTrace());
		}
	}

	
	@SuppressWarnings("unchecked")
	public List<Prova> listarProvasDisciplina(long id){
		return this.session.createCriteria(Prova.class)
				.add(Restrictions.eq("disciplina.id", id))
				.list();
	}


	public Prova pesquisarProvaPorId(long id) {
		Prova p = (Prova) session.createCriteria(Prova.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
		return p;
	}
}