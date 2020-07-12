package Xadrez.Pecas;

import Xadrez.Cor;
import Xadrez.Peca_Xadrez;
import tabuleiroGame.Position;
import tabuleiroGame.Tabuleiro;

public class Cavalo extends Peca_Xadrez{

	public Cavalo(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);		
	}
	
	@Override
	public final String toString() {
		return "C";
	}
	
	private boolean podeMover(Position position) {
		Peca_Xadrez p = (Peca_Xadrez) getTabuleiro().peca(position);
		return ((p == null) || (p.getCor() != getCor()));
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinha()][getTabuleiro().getColuna()];
		
		Position p = new Position(0, 0);
		
		p.setValores(position.getLinha() -2, position.getColuna() -1);
		if((getTabuleiro().existPosition(p)) && (podeMover(p)))
			mat[p.getLinha()][p.getColuna()] = true;
		
		p.setValores(position.getLinha() +2, position.getColuna() -1);
		if((getTabuleiro().existPosition(p)) && (podeMover(p)))
		   mat[p.getLinha()][p.getColuna()] = true;
	
		p.setValores(position.getLinha() -1, position.getColuna() -2);
		if((getTabuleiro().existPosition(p)) && (podeMover(p)))
			mat[p.getLinha()][p.getColuna()] = true;
		
		p.setValores(position.getLinha() +1, position.getColuna() +2);
		if((getTabuleiro().existPosition(p)) && (podeMover(p)))
			mat[p.getLinha()][p.getColuna()] = true;
		
		p.setValores(position.getLinha() -2, position.getColuna() +1);
		if((getTabuleiro().existPosition(p)) && (podeMover(p)))
			mat[p.getLinha()][p.getColuna()] = true;
		
		p.setValores(position.getLinha() +2, position.getColuna() +1);
		if((getTabuleiro().existPosition(p)) && (podeMover(p)))
			mat[p.getLinha()][p.getColuna()] = true;
		
		p.setValores(position.getLinha() +1, position.getColuna() -2);
		if((getTabuleiro().existPosition(p)) && (podeMover(p)))
			mat[p.getLinha()][p.getColuna()] = true;
		
		p.setValores(position.getLinha() -1, position.getColuna() +2);
		if((getTabuleiro().existPosition(p)) && (podeMover(p)))
			mat[p.getLinha()][p.getColuna()] = true;
						
		return mat;
	}

}