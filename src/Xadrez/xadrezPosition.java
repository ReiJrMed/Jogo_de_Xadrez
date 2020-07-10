package Xadrez;

import tabuleiroGame.Position;

public class xadrezPosition {
	
	private Character coluna;
	private Integer linha;
	
	public xadrezPosition(Character coluna, Integer linha) {
		if((coluna < (char) 0b01100001) || (coluna > (char)(0b01100001 + 7)) || (linha < 1) || (linha > 8))
			throw new xadrezException("Erro na posição do tabuleiro, valores válidos são de a1 até h8");
		
		this.coluna = coluna;
		this.linha = linha;
	}

	public Character getColuna() {
		return coluna;
	}
	
	public Integer getLinha() {
		return linha;
	}
	
	protected Position toPosition() {
		return new Position(8 -linha, coluna - 'a');
	}
	
	protected static xadrezPosition fromXadrezPosition(Position position) {
		return new xadrezPosition((char)('a' +position.getColuna()), 8 -position.getLinha());
		//return new xadrezPosition((char)('a' -position.getColuna()), 8 -position.getLinha());
		//caso dê errado tentar esse new xadrezPosition((char)('a' +position.getColuna()), 8 -position.getLinha());
		//deu erro no código anterior que era new xadrezPosition((char)('a' -position.getColuna()), 8 -position.getLinha());
		//já sabia disso por isso deixei esse comentário de correção antes
	}
	
	@Override
	public final String toString() {
		return "" + coluna + linha;
	}

}
