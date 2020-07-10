package Xadrez;

import tabuleiroGame.Position;

public class xadrezPosition {
	
	private Character coluna;
	private Integer linha;
	
	public xadrezPosition(Character coluna, Integer linha) {
		if((coluna < (char) 0b01100001) || (coluna > (char)(0b01100001 + 7)) || (linha < 1) || (linha > 8))
			throw new xadrezException("Erro na posi��o do tabuleiro, valores v�lidos s�o de a1 at� h8");
		
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
		//caso d� errado tentar esse new xadrezPosition((char)('a' +position.getColuna()), 8 -position.getLinha());
		//deu erro no c�digo anterior que era new xadrezPosition((char)('a' -position.getColuna()), 8 -position.getLinha());
		//j� sabia disso por isso deixei esse coment�rio de corre��o antes
	}
	
	@Override
	public final String toString() {
		return "" + coluna + linha;
	}

}
