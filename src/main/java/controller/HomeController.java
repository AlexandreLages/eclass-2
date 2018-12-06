package controller;

import javax.inject.Inject;

import annotation.Public;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import util.MensagemUtil;

@Controller
public class HomeController {

	@Inject MensagemUtil MensagemUtil;
	
	@Public
	@Get("/")
	public void home() {
		MensagemUtil.enviaNotificacoes();
	}
}