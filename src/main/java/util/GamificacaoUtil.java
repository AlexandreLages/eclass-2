package util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.inject.Inject;

import dao.DisciplinaDAO;
import model.Aluno;
import model.AlunoRanking;
import model.Disciplina;

public class GamificacaoUtil {

	
	@Inject private DisciplinaDAO disciplinaDAO;
	
	
	public List<AlunoRanking> getRanking(long id) {
		Disciplina disciplina = disciplinaDAO.pesquisarDisciplinaPorId(id);
		
		ArrayList<AlunoRanking> ranking = new ArrayList<>();
		List<AlunoRanking> rankingAuxiliar = new ArrayList<>();
		
		Random random = new Random();
		AlunoRanking aux = null;
		
		for(Aluno a : disciplina.getAlunos()) {
			AlunoRanking alunoRanking = new AlunoRanking(a.getNome(), 0, random.nextInt(20), a.getId());
			ranking.add(alunoRanking);
		}
		
		
		for(int i = 0; i < ranking.size(); i++) {
			for(int j = 0; j < ranking.size() - 1; j++) {
				if(ranking.get(j).getXp() < ranking.get(j + 1).getXp()) {
					aux = ranking.get(j);
					ranking.set(j, ranking.get(j + 1));
					ranking.set(j+1, aux);
				}
			}
		}
		
		
		if(disciplina.getAlunosRanking() < ranking.size()) {
			rankingAuxiliar = ranking.subList(0, disciplina.getAlunosRanking());
		} else {
			return ranking;
		}
		
		return rankingAuxiliar;
	}
}