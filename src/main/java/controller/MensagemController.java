package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import annotation.Public;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import dao.MensagemDAO;
import dao.UsuarioDAO;
import model.Aluno;
import model.Mensagem;
import util.NotificacaoUtil;

@Controller
public class MensagemController {

	@Inject private UsuarioDAO usuarioDAO;
	@Inject private MensagemDAO mensagemDAO;
	@Inject private Result result;
	
	
	@Public
	@Get("/mensagem/cadastrar")
	public void cadastrarMensagens() {
		List<Mensagem> listaMensagens = new ArrayList<>();
		
		//Alert
		listaMensagens.add(new Mensagem("Dê uma olhada em suas novas conquistas?", "alerta"));
		listaMensagens.add(new Mensagem("Você já deu olhada em suas conquistas? Veja se você não possui novas.", "alerta"));
		
		//Nota Máxima
		listaMensagens.add(new Mensagem("Parabéns, você conseguiu atingir a nota máxima. Continue assim!!!", "nota_maxima"));
		
		//Maior Nota
		listaMensagens.add(new Mensagem("Você foi o campeão da rodada, tirou a maior nota da prova!!!", "maior_nota"));
		
		//Incentivo
		listaMensagens.add(new Mensagem("E aí, Vamos ser campeões da rodada? Dispare nas conquistas", "incentivo"));
		
		for(Mensagem m : listaMensagens) {
			mensagemDAO.inserirMensagem(m);
		}
	}
	
	
	@Public
	@Get("/mensagem/lista")
	public void listarTodas() {
		List<Mensagem> mensagens = mensagemDAO.listarTodas();
		result.use(Results.json()).withoutRoot().from(mensagens).serialize();
	}
	
	
	@Public
	@Get("/mensagem/enviar")
	public void enviarMensagens() {
		ArrayList<Aluno> alunos = usuarioDAO.listarAlunos();
		ArrayList<Mensagem> mensagens = (ArrayList<Mensagem>) mensagemDAO.listarTodas();
		System.out.println("Entrou aqui");
		int faixa = (int) mensagemDAO.listarTodas().size();
		for(Aluno a : alunos) {
			Random gerador = new Random();
			int numeroMensagem = gerador.nextInt(faixa);
			String mensagem = mensagens.get(numeroMensagem).getMensagem();
			
			if(a.getToken() != null && mensagem != null) {
				System.out.println("Aluno: " + a.getNome() + "/Mensagem: " + mensagem);
				NotificacaoUtil.montarNotificacao(a.getToken(), mensagem);
			}
		}
	}
}