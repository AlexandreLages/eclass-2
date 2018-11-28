package dao;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import model.Usuario;

@RequestScoped
public class UsuarioDAO {

	
	private Session session;
	
	
	protected UsuarioDAO() {
		this(null);
	}
	
	
	@Inject
	public UsuarioDAO(Session session) {
		this.session = session;
	}
	
	
	public void inserirUsuario(Usuario usuario) {
		try {
			this.session.save(usuario);
		} catch(Exception e) {
			System.out.println("Erro ao tentar salvar usuário");
		}
	}
	
	
	public void atualizarUsuario(Usuario usuario) {
		try {
			this.session.update(usuario);
		} catch(Exception e) {
			System.out.println("Erro ao tentar atualizar usuário");
		}
	}


	public boolean pesquisarUsuarioPorEmail(Usuario usuario){
		Usuario u = (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("email", usuario.getEmail()))
				.uniqueResult();
		return u != null;
	}
	
	
	public Usuario pesquisarUsuarioPorEmail(String email){
		Usuario u = (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("email", email))
				.uniqueResult();
		return u;
	}


	public boolean pesquisarUsuarioPorUsuario(Usuario usuario) {
		Usuario u = (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("usuario", usuario.getUsuario()))
				.uniqueResult();
		return u != null;
	}


	public Usuario pesquisarUsuarioPorEmailESenha(String email, String senha) {
		Usuario u = (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("email", email))
				.add(Restrictions.eq("senha", senha))
				.uniqueResult();
		return u;
	}


	public Usuario pesquisarUsuarioPorId(long id) {
		Usuario u = (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("id", id))
				.uniqueResult();
		return u;
	}
}