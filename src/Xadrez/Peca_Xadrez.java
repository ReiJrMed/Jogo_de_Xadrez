package Xadrez;

import tabuleiroGame.Peca;
import tabuleiroGame.Position;
import tabuleiroGame.Tabuleiro;

public abstract class Peca_Xadrez extends Peca{
	
	private Cor cor;

	public Peca_Xadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}
	
	protected Boolean existePecaAdversaria(Position position) {
		Peca_Xadrez p = (Peca_Xadrez) getTabuleiro().peca(position);
		return (p != null) && (p.getCor() != cor);
	}	
	
}
