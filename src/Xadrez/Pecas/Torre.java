package Xadrez.Pecas;

import Xadrez.Cor;
import Xadrez.Peca_Xadrez;
import tabuleiroGame.Position;
import tabuleiroGame.Tabuleiro;

public class Torre extends Peca_Xadrez{

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);		
	}
	
	@Override
	public final String toString() {
		return "T";
	}
	
	@Override
	public final Boolean[][] movimentosPossiveis() {
		Boolean[][] mat = new Boolean[getTabuleiro().getLinha()][getTabuleiro().getColuna()];
		
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[i].length; j++) {
				mat[i][j] = false;					
			}
		}
		
		Position p = new Position(0, 0);
		
		//acima
		p.setValores(position.getLinha() -1, position.getColuna());
		while((getTabuleiro().existPosition(p)) && (!getTabuleiro().positionOcupada(p))) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() -1);
		}
		if((getTabuleiro().existPosition(p)) && (getTabuleiro().positionOcupada(p)))
			mat[p.getLinha()][p.getColuna()] = true;
		
		//esquerda
		p.setValores(position.getLinha(), position.getColuna() -1);
		while((getTabuleiro().existPosition(p)) && (!getTabuleiro().positionOcupada(p))) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() -1);
		}
		if((getTabuleiro().existPosition(p)) && (getTabuleiro().positionOcupada(p)))
			mat[p.getLinha()][p.getColuna()] = true;
		
		//direita
		p.setValores(position.getLinha(), position.getColuna() +1);
		while((getTabuleiro().existPosition(p)) && (!getTabuleiro().positionOcupada(p))) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() +1);
		}
		if((getTabuleiro().existPosition(p)) && (getTabuleiro().positionOcupada(p)))
			mat[p.getLinha()][p.getColuna()] = true;
		
		//acima
		p.setValores(position.getLinha() +1, position.getColuna());
		while((getTabuleiro().existPosition(p)) && (!getTabuleiro().positionOcupada(p))) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() +1);
		}
		if((getTabuleiro().existPosition(p)) && (getTabuleiro().positionOcupada(p)))
			mat[p.getLinha()][p.getColuna()] = true;
		
		return mat;
	}

}
