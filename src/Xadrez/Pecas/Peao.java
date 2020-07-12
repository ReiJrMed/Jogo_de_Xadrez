package Xadrez.Pecas;

import Xadrez.Cor;
import Xadrez.Peca_Xadrez;
import tabuleiroGame.Position;
import tabuleiroGame.Tabuleiro;

public class Peao extends Peca_Xadrez{

	public Peao(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);		
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinha()][getTabuleiro().getColuna()];
		Position p = new Position(0, 0);
		
		if(getCor() == Cor.BRANCA) {
			p.setValores(position.getLinha() -1, position.getColuna());
			if((getTabuleiro().existPosition(p)) && (!getTabuleiro().positionOcupada(p)))
				mat[p.getLinha()][p.getColuna()] = true;
			
			p.setValores(position.getLinha() -2, position.getColuna());
			Position p2 = new Position(position.getLinha() -1, position.getColuna());
			if((getTabuleiro().existPosition(p)) && (!getTabuleiro().positionOcupada(p)) && (getTabuleiro().existPosition(p2)) && (!getTabuleiro().positionOcupada(p2)) && (getQuantMovimentos() == 0))
				mat[p.getLinha()][p.getColuna()] = true;
				
			p.setValores(position.getLinha() -1, position.getColuna() -1);
			if((getTabuleiro().existPosition(p)) && (existePecaAdversaria(p)))
				mat[p.getLinha()][p.getColuna()] = true;
			
			p.setValores(position.getLinha() -1, position.getColuna() +1);
			if((getTabuleiro().existPosition(p)) && (existePecaAdversaria(p)))
				mat[p.getLinha()][p.getColuna()] = true;
			
		} else {
			p.setValores(position.getLinha() +1, position.getColuna());
			if((getTabuleiro().existPosition(p)) && (!getTabuleiro().positionOcupada(p)))
				mat[p.getLinha()][p.getColuna()] = true;
			
			p.setValores(position.getLinha() +2, position.getColuna());
			Position p2 = new Position(position.getLinha() +1, position.getColuna());
			if((getTabuleiro().existPosition(p)) && (!getTabuleiro().positionOcupada(p)) && (getTabuleiro().existPosition(p2)) && (!getTabuleiro().positionOcupada(p2)) && (getQuantMovimentos() == 0))
				mat[p.getLinha()][p.getColuna()] = true;
				
			p.setValores(position.getLinha() +1, position.getColuna() -1);
			if((getTabuleiro().existPosition(p)) && (existePecaAdversaria(p)))
				mat[p.getLinha()][p.getColuna()] = true;
			
			p.setValores(position.getLinha() +1, position.getColuna() +1);
			if((getTabuleiro().existPosition(p)) && (existePecaAdversaria(p)))
				mat[p.getLinha()][p.getColuna()] = true;
						
		}
		
		return mat;
	}
	
	@Override
    public String toString() {
		return "p";
	}
	
}
