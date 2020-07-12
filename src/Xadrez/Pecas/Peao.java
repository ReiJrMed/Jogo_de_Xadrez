package Xadrez.Pecas;

import Xadrez.Cor;
import Xadrez.Partida;
import Xadrez.Peca_Xadrez;
import tabuleiroGame.Position;
import tabuleiroGame.Tabuleiro;

public class Peao extends Peca_Xadrez{
	
	private Partida partida;

	public Peao(Tabuleiro tabuleiro, Cor cor, Partida partida) {
		super(tabuleiro, cor);
		this.partida = partida;
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
			
			//Movimento especial en Passant Peão Branco
			if(position.getLinha() == 3) {
				
				Position esquerda = new Position(position.getLinha(), position.getColuna() -1);
				boolean enPassant = false;
				if((existePecaAdversaria(esquerda)) && (getTabuleiro().existPosition(esquerda)))
				  enPassant = partida.getEnPassant().contains((Peca_Xadrez)getTabuleiro().peca(esquerda));
				
				if(enPassant){
					if(!getTabuleiro().positionOcupada(new Position(esquerda.getLinha() -1, esquerda.getColuna()))) {
					   mat[esquerda.getLinha() -1][esquerda.getColuna()] = true;
					}
				}
				
				Position direita = new Position(position.getLinha(), position.getColuna() +1);
				enPassant = false;
				if((existePecaAdversaria(direita)) && (getTabuleiro().existPosition(direita)))
					  enPassant = partida.getEnPassant().contains((Peca_Xadrez)getTabuleiro().peca(direita));
					
				if(enPassant){
					if(!getTabuleiro().positionOcupada(new Position(direita.getLinha() -1, direita.getColuna()))) {
					     mat[direita.getLinha() -1][direita.getColuna()] = true;
					}
				}
			}
			
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
			
			//Movimento especial en Passant Peão Preto
			if(position.getLinha() == 4) {
				
				Position esquerda = new Position(position.getLinha(), position.getColuna() -1);
				boolean enPassant = false;
				if((existePecaAdversaria(esquerda)) && (getTabuleiro().existPosition(esquerda)))
				  enPassant = partida.getEnPassant().contains((Peca_Xadrez)getTabuleiro().peca(esquerda));
				
				if(enPassant){
					if(!getTabuleiro().positionOcupada(new Position(esquerda.getLinha() +1, esquerda.getColuna()))) {
					   mat[esquerda.getLinha() +1][esquerda.getColuna()] = true;
					}
				}
				
				Position direita = new Position(position.getLinha(), position.getColuna() +1);
				enPassant = false;
				if((existePecaAdversaria(direita)) && (getTabuleiro().existPosition(direita)))
					  enPassant = partida.getEnPassant().contains((Peca_Xadrez)getTabuleiro().peca(direita));
					
				if(enPassant){
					if(!getTabuleiro().positionOcupada(new Position(direita.getLinha() +1, direita.getColuna()))) {
					   mat[direita.getLinha() +1][direita.getColuna()] = true;
					}
				}
			}
						
		}
		
		return mat;
	}
	
	@Override
    public String toString() {
		return "p";
	}
	
}
