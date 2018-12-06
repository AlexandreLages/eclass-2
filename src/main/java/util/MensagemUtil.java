package util;

import java.util.ArrayList;
import java.util.Random;

import javax.inject.Inject;

import dao.MensagemDAO;
import dao.UsuarioDAO;
import model.Aluno;
import model.Mensagem;

public class MensagemUtil {

	@Inject private UsuarioDAO usuarioDAO;
	@Inject private MensagemDAO mensagemDAO;
	
	public void enviaNotificacoes() {
		try {
			new Thread() {
				@Override
			    public void run() {
					ArrayList<Aluno> alunos = usuarioDAO.listarAlunos();
					ArrayList<Mensagem> mensagens = (ArrayList<Mensagem>) mensagemDAO.listarTodas();
					int faixa = (int) mensagemDAO.listarTodas().size();
					for(Aluno a : alunos) {
						Random gerador = new Random();
						int numeroMensagem = gerador.nextInt(faixa);
						String mensagem = mensagens.get(numeroMensagem).getMensagem();
						System.out.println("Aluno: " + a.getNome() + "/Mensagem: " + mensagem);
						if(a.getToken() != null && mensagem != null) {
							NotificacaoUtil.montarNotificacao(a.getToken(), mensagem);
						}
					}
			    }
			};
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}