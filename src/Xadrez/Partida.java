package Xadrez;

import Xadrez.Pecas.Rei;
import Xadrez.Pecas.Torre;
import tabuleiroGame.Peca;
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
	
	public Peca_Xadrez moverPeca(xadrezPosition origem, xadrezPosition destino) {
		Position origin = origem.toPosition();
		Position destiny = destino.toPosition();
		validarPositionOrigem(origin);
		Peca pecaCapturada = processoMovimento(origin, destiny);
		return (Peca_Xadrez) pecaCapturada;
	}
	
	private Peca processoMovimento(Position origin, Position destiny) {
		Peca p = tabuleiro.removePeca(origin);
		Peca pecaCapturada = tabuleiro.removePeca(destiny);
		tabuleiro.posicionarPeca(p, destiny);
		return pecaCapturada;
	}
	
	private void validarPositionOrigem(Position origin) {
		if(!tabuleiro.positionOcupada(origin))
			throw new xadrezException("N�o h� pe�a nesta posi��o do tabuleiro.");
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
