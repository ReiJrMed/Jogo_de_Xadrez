package Xadrez.Pecas;

import Xadrez.Cor;
import Xadrez.Peca_Xadrez;
import tabuleiroGame.Position;
import tabuleiroGame.Tabuleiro;

public class Rei extends Peca_Xadrez{

	public Rei(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);		
	}
	
	@Override
	public final String toString() {
		return "r";
	}
	
	private boolean podeMover(Position position) {
		Peca_Xadrez p = (Peca_Xadrez) getTabuleiro().peca(position);
		return ((p == null) || (p.getCor() != getCor()));
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinha()][getTabuleiro().getColuna()];
		
		Position p = new Position(0, 0);
		
		//acima
		p.setValores(position.getLinha() -1, position.getColuna());
		if((getTabuleiro().existPosition(p)) && (podeMover(p)))
			mat[p.getLinha()][p.getColuna()] = true;
		
		//abaixo
		p.setValores(position.getLinha() +1, position.getColuna());
		if((getTabuleiro().existPosition(p)) && (podeMover(p)))
		   mat[p.getLinha()][p.getColuna()] = true;
	
		//esquerda
		p.setValores(position.getLinha(), position.getColuna() -1);
		if((getTabuleiro().existPosition(p)) && (podeMover(p)))
			mat[p.getLinha()][p.getColuna()] = true;
		
		//direita
		p.setValores(position.getLinha(), position.getColuna() +1);
		if((getTabuleiro().existPosition(p)) && (podeMover(p)))
			mat[p.getLinha()][p.getColuna()] = true;
		
		//Noroeste
		p.setValores(position.getLinha() -1, position.getColuna() -1);
		if((getTabuleiro().existPosition(p)) && (podeMover(p)))
			mat[p.getLinha()][p.getColuna()] = true;
		
		//Nordeste
		p.setValores(position.getLinha() -1, position.getColuna() +1);
		if((getTabuleiro().existPosition(p)) && (podeMover(p)))
			mat[p.getLinha()][p.getColuna()] = true;
		
		//Sudoeste
		p.setValores(position.getLinha() +1, position.getColuna() -1);
		if((getTabuleiro().existPosition(p)) && (podeMover(p)))
			mat[p.getLinha()][p.getColuna()] = true;
		
		//sudeste
		p.setValores(position.getLinha() +1, position.getColuna() +1);
		if((getTabuleiro().existPosition(p)) && (podeMover(p)))
			mat[p.getLinha()][p.getColuna()] = true;
						
		return mat;
	}

}