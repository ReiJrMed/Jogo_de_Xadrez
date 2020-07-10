package Xadrez;

import tabuleiroGame.Peca;
import tabuleiroGame.Tabuleiro;

public class Peca_Xadrez extends Peca{
	
	private Cor cor;

	public Peca_Xadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}
	
}
