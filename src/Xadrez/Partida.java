package Xadrez;

import Xadrez.Pecas.Rei;
import Xadrez.Pecas.Torre;
import tabuleiroGame.Tabuleiro;


public class Partida {
	
	private Tabuleiro tabuleiro;
	
	public Partida() {
		this.tabuleiro = new Tabuleiro(8, 8);
		Inicio();
	}
	
	public Peca_Xadrez[][] getPecas(){
		Peca_Xadrez[][] mat = new Peca_Xadrez[tabuleiro.getLinha()][tabuleiro.getColuna()];
		for(int i = 0; i < tabuleiro.getLinha(); i++) {
			for(int j = 0; j < tabuleiro.getColuna(); j++) {
				mat[i][j] = (Peca_Xadrez) tabuleiro.peca(i, j);
			}
		}
		return mat;
	}
	
	private void posicionarPecaXadrez(Character coluna, Integer linha, Peca_Xadrez peca) {
		tabuleiro.posicionarPeca(peca, (new xadrezPosition(coluna, linha)).toPosition());
	}
	
	private void Inicio() {
		posicionarPecaXadrez('c', 1, new Torre(tabuleiro, Cor.BRANCA));
		posicionarPecaXadrez('c', 2, new Torre(tabuleiro, Cor.BRANCA));
		posicionarPecaXadrez('d', 2, new Torre(tabuleiro, Cor.BRANCA));
		posicionarPecaXadrez('e', 2, new Torre(tabuleiro, Cor.BRANCA));
		posicionarPecaXadrez('e', 1, new Torre(tabuleiro, Cor.BRANCA));
		posicionarPecaXadrez('d', 1, new Rei(tabuleiro, Cor.BRANCA));

		posicionarPecaXadrez('c', 7, new Torre(tabuleiro, Cor.PRETA));
		posicionarPecaXadrez('c', 8, new Torre(tabuleiro, Cor.PRETA));
		posicionarPecaXadrez('d', 7, new Torre(tabuleiro, Cor.PRETA));
		posicionarPecaXadrez('e', 7, new Torre(tabuleiro, Cor.PRETA));
		posicionarPecaXadrez('e', 8, new Torre(tabuleiro, Cor.PRETA));
		posicionarPecaXadrez('d', 8, new Rei(tabuleiro, Cor.PRETA));		
	}

}
