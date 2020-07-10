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
	public boolean[][] movimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinha()][getTabuleiro().getColuna()];
				
		Position p = new Position(0, 0);
		
		//acima
		p.setValores(position.getLinha() -1, position.getColuna());
		while(getTabuleiro().existPosition(p)) {
			if((!getTabuleiro().positionOcupada(p))) {
				  mat[p.getLinha()][p.getColuna()] = true;
				} else {
					if(existePecaAdversaria(p)) {
						mat[p.getLinha()][p.getColuna()] = true;
					}
				  break;
				}
			p.setLinha(p.getLinha() -1);
		}
		
		//esquerda
		p.setValores(position.getLinha(), position.getColuna() -1);
		while(getTabuleiro().existPosition(p)) {
			if((!getTabuleiro().positionOcupada(p))) {
				  mat[p.getLinha()][p.getColuna()] = true;
				} else {
					if(existePecaAdversaria(p)) {
						mat[p.getLinha()][p.getColuna()] = true;
					}
				  break;
				}
			p.setColuna(p.getColuna() -1);
		}
				
		//direita
		p.setValores(position.getLinha(), position.getColuna() +1);
		while(getTabuleiro().existPosition(p)) {
			if((!getTabuleiro().positionOcupada(p))) {
				  mat[p.getLinha()][p.getColuna()] = true;
				} else {
					if(existePecaAdversaria(p)) {
						mat[p.getLinha()][p.getColuna()] = true;
					}
				  break;
				}
			p.setColuna(p.getColuna() +1);
		}		
		
		//acima
		p.setValores(position.getLinha() +1, position.getColuna());
		while(getTabuleiro().existPosition(p)) {
			if((!getTabuleiro().positionOcupada(p))) {
			  mat[p.getLinha()][p.getColuna()] = true;
			} else {
				if(existePecaAdversaria(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
				}
			  break;
			}
			p.setLinha(p.getLinha() +1);
		}
		
		
		return mat;
	}

}
