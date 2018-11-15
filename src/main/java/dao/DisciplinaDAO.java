package dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.Disciplina;

@RequestScoped
public class DisciplinaDAO {

	private Session session;
	
	
	public DisciplinaDAO() {
		this(null);
	}
	
	@Inject
	public DisciplinaDAO(Session session) {
		this.session = session;
	}
	
	
	public void inserirDisciplina(Disciplina disciplina) {
		try {
			this.session.save(disciplina);
		} catch (Exception e) {
			System.out.println("Erro ao tentar salvar disciplina");
		}
	}
	
	
	public void atualizarDisciplina(Disciplina disciplina) {
		try {
			this.session.update(disciplina);
		} catch(Exception e) {
			System.out.println("Erro ao tentar atualizar disciplina");
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Disciplina> listarDisciplinasPorProfessor(long id){
		return this.session.createCriteria(Disciplina.class)
				.add(Restrictions.eq("professor.id", id))
				.list();
	}
	
	
	public Disciplina pesquisarDisciplinaPorId(long id) {
		Disciplina d = (Disciplina) session.createCriteria(Disciplina.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
		return d;
	}
}