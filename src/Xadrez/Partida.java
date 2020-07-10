package Xadrez;

import Xadrez.Pecas.Rei;
import Xadrez.Pecas.Torre;
import tabuleiroGame.Position;
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
	
	private void Inicio() {
		tabuleiro.posicionarPeca(new Torre(tabuleiro, Cor.BRANCA), new Position(0,0));
		tabuleiro.posicionarPeca(new Rei(tabuleiro, Cor.PRETA), new Position(7,4));
		tabuleiro.posicionarPeca(new Rei(tabuleiro, Cor.BRANCA), new Position(0,4));
	}

}
