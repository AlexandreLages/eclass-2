package util;

import java.util.ArrayList;
import java.util.List;

import dao.ConquistaDAO;
import model.Conquista;


public class ConquistaUtil {
	
	public static void main(String[] args) {
		ConquistaDAO conquistas = new ConquistaDAO();
		
		List<Conquista> listaConquistas = new ArrayList<>();
		
		listaConquistas.add(new Conquista("Aluno Nota 10", "Você recebeu essa conquista por tirar mais uma 10 na disciplina. Parabéns!!!", "conquista_1.jpg", 1));
		listaConquistas.add(new Conquista("Aluno Superação", "Parabéns, você conseguiu conquistar a superação!!!", "conquista_2.jpg", 2));
		
		for(Conquista c : listaConquistas) {
			conquistas.inserirConquista(c);
		}
	}
}