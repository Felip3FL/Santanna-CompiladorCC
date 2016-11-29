package objeto.exemplos._interface;

import java.util.Comparator;

public class ComparaPorNomeEIdade implements Comparator<Amigo> {
	@Override
	public int compare(Amigo amigo1, Amigo amigo2) {
		int resposta = amigo1.getNome().compareTo(amigo2.getNome());
		
		if(resposta == 0) 
			resposta = amigo2.getIdade() - amigo1.getIdade();
		
		return resposta;
	}
}
