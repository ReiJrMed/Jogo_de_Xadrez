package Xadrez.Pecas;

import Xadrez.Cor;
import Xadrez.Partida;
import Xadrez.Peca_Xadrez;
import tabuleiroGame.Position;
import tabuleiroGame.Tabuleiro;

public class Rei extends Peca_Xadrez{
	
	private Partida partida;

	public Rei(Tabuleiro tabuleiro, Cor cor, Partida partida) {
		super(tabuleiro, cor);
		this.partida = partida;
	}
	
	@Override
	public final String toString() {
		return "r";
	}
	
	private boolean torreAptaRoque(Position position) {
		Peca_Xadrez p = (Peca_Xadrez)getTabuleiro().peca(position);
		return (p != null) && (p instanceof Torre) && (p.getCor() == getCor()) && (p.getQuantMovimentos() == 0);
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
		
		//Movimento especial ROQUE
		if((getQuantMovimentos() == 0) && (!partida.getCheck())) {
			//ROQUE do lado do Rei (ROQUE pequeno)
			Position pTorre1 = new Position(position.getLinha(), position.getColuna() +3);
			if(torreAptaRoque(pTorre1)) {
				Position p1 = new Position(position.getLinha(), position.getColuna() +1);
				Position p2 = new Position(position.getLinha(), position.getColuna() +2);
				if((getTabuleiro().peca(p1) == null) && (getTabuleiro().peca(p2) == null)) {
					mat[position.getLinha()][position.getColuna() +2] = true;
				}
			}
			//ROQUE do lado da Rainha (ROQUE GRANDE)
			Position pTorre2 = new Position(position.getLinha(), position.getColuna() -4);
			if(torreAptaRoque(pTorre2)) {
				Position p1 = new Position(position.getLinha(), position.getColuna() -1);
				Position p2 = new Position(position.getLinha(), position.getColuna() -2);
				Position p3 = new Position(position.getLinha(), position.getColuna() -3);
				if((getTabuleiro().peca(p1) == null) && (getTabuleiro().peca(p2) == null) && (getTabuleiro().peca(p3) == null)) {
					mat[position.getLinha()][position.getColuna() -2] = true;
				}
			}	
		}
						
		return mat;
	}

}