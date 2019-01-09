package dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;

import model.Mensagem;

@RequestScoped
public class MensagemDAO {

	@Inject private Session session;

	@SuppressWarnings("unchecked")
	public List<Mensagem> listarTodas(){
		return this.session.createCriteria(Mensagem.class)
				.list();
	}
	
	
	public void inserirMensagem(Mensagem mensagem) {
		try {
			this.session.save(mensagem);
		} catch (Exception e) {
			System.out.println("Erro ao tentar salvar mensagem: " + e.getStackTrace());
		}
	}
}