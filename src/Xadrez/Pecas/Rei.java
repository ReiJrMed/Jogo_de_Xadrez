package Xadrez.Pecas;

import Xadrez.Cor;
import Xadrez.Peca_Xadrez;
import tabuleiroGame.Tabuleiro;

public class Rei extends Peca_Xadrez{

	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);		
	}
	
	@Override
	public final String toString() {
		return "r";
	}

	@Override
	public final Boolean[][] movimentosPossiveis() {
		Boolean[][] mat = new Boolean[getTabuleiro().getLinha()][getTabuleiro().getColuna()];
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[i].length; j++) {
				mat[i][j] = false;					
			}
		}
		return mat;
	}

}