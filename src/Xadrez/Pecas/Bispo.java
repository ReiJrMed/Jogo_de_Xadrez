package Xadrez.Pecas;

import Xadrez.Cor;
import Xadrez.Peca_Xadrez;
import tabuleiroGame.Position;
import tabuleiroGame.Tabuleiro;

public class Bispo extends Peca_Xadrez{

	public Bispo(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);		
	}
	
	@Override
	public String toString() {
		return "B";
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinha()][getTabuleiro().getColuna()];
		
		Position p = new Position(0, 0);
		
		//Noroeste
		p.setValores(position.getLinha() -1, position.getColuna() -1);
		while(getTabuleiro().existPosition(p)) {
			if((!getTabuleiro().positionOcupada(p))) {
				  mat[p.getLinha()][p.getColuna()] = true;
				} else {
					if(existePecaAdversaria(p)) {
						mat[p.getLinha()][p.getColuna()] = true;
					}
				  break;
				}
			p.setValores(p.getLinha() -1, p.getColuna() -1);
		}
		
		//Nordeste
		p.setValores(position.getLinha() -1, position.getColuna() +1);
		while(getTabuleiro().existPosition(p)) {
			if((!getTabuleiro().positionOcupada(p))) {
				  mat[p.getLinha()][p.getColuna()] = true;
				} else {
					if(existePecaAdversaria(p)) {
						mat[p.getLinha()][p.getColuna()] = true;
					}
				  break;
				}
			p.setValores(p.getLinha() -1, p.getColuna() +1);
		}
				
		//Sudeste
		p.setValores(position.getLinha() +1, position.getColuna() +1);
		while(getTabuleiro().existPosition(p)) {
			if((!getTabuleiro().positionOcupada(p))) {
				  mat[p.getLinha()][p.getColuna()] = true;
				} else {
					if(existePecaAdversaria(p)) {
						mat[p.getLinha()][p.getColuna()] = true;
					}
				  break;
				}
			p.setValores(p.getLinha() +1, p.getColuna() +1);
		}		
		
		//Sudoeste
		p.setValores(position.getLinha() +1, position.getColuna() -1);
		while(getTabuleiro().existPosition(p)) {
			if((!getTabuleiro().positionOcupada(p))) {
			  mat[p.getLinha()][p.getColuna()] = true;
			} else {
				if(existePecaAdversaria(p)) {
					mat[p.getLinha()][p.getColuna()] = true;
				}
			  break;
			}
			p.setValores(p.getLinha() +1, p.getColuna() -1);
		}
		
		
		return mat;
	}	

}
