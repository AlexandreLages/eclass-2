package controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import dao.ConquistaDAO;
import model.Conquista;

@Controller
public class ConquistaController {

	@Inject ConquistaDAO conquistas;
	
	//@Public
	//@Get("/conquista/cadastrar")
	public void cadatrarConquistas() {
		List<Conquista> listaConquistas = new ArrayList<>();
		
		listaConquistas.add(new Conquista("Aluno Nota 10", "Você recebeu essa conquista por tirar mais uma 10 na disciplina. Parabéns!!!", "conquista_1.jpg", 1));
		listaConquistas.add(new Conquista("Aluno Superação", "Parabéns, você conseguiu conquistar a superação!!!", "conquista_2.jpg", 2));
		
		for(Conquista c : listaConquistas) {
			conquistas.inserirConquista(c);
		}
	}
}