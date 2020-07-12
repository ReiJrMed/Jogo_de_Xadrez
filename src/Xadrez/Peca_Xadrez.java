package Xadrez;

import tabuleiroGame.Peca;
import tabuleiroGame.Position;
import tabuleiroGame.Tabuleiro;

public abstract class Peca_Xadrez extends Peca{
	
	private Cor cor;
	private int quantMovimentos;

	public Peca_Xadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}
	
	protected Boolean existePecaAdversaria(Position position) {
		Peca_Xadrez p = (Peca_Xadrez)getTabuleiro().peca(position);
		return (p != null) && (p.getCor() != cor);
	}
	
	public xadrezPosition getPosicaoXadrez() {
		return xadrezPosition.fromXadrezPosition(position);
	}
	
	public int getQuantMovimentos() {
		return quantMovimentos;
	}
	
	public void plusQuantMovimentos() {
		quantMovimentos++;
	}
	
	public void minusQuantMovimentos() {
		quantMovimentos--;
	}
	
}
