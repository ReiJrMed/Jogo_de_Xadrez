package tabuleiroGame;

public class Tabuleiro {
	
	private Integer linha, coluna;
	private Peca[][] pecas;
	
	public Tabuleiro(Integer linha, Integer coluna) {
		
		if((linha < 1) || (coluna < 1)) {
			throw new tabuleiroGameException("Erro ao criar tabuleiro: É necessário haver mais de uma linha e mais de uma coluna.");
		}
		
		this.linha = linha;
		this.coluna = coluna;
		pecas = new Peca[linha][coluna];
	}

	public Integer getLinha() {
		return linha;
	}

	
	public Integer getColuna() {
		return coluna;
	}

	public Peca peca(Integer linha, Integer coluna) {
		if(!existPosition(linha, coluna))
			throw new tabuleiroGameException("Posição inexistente no tabuleiro.");
		
		return pecas[linha][coluna];
	}
	
	public Peca peca(Position position) {
		if(!existPosition(position))
			throw new tabuleiroGameException("Posição inexistente no tabuleiro.");
		
		return pecas[position.getLinha()][position.getColuna()];
	}
	
	public void posicionarPeca(Peca peca, Position position) {
		if(positionOcupada(position))
			throw new tabuleiroGameException("Já existe uma peça na posição " + position);
		
		pecas[position.getLinha()][position.getColuna()] = peca;
		peca.position = position;
	}
	
	public Peca removePeca(Position position) {
		if(!existPosition(position))
			throw new tabuleiroGameException("Posição inexistente no tabuleiro.");
		
		if(peca(position) == null)
			return null;
		
		Peca aux = peca(position);
		aux.position = null;
		pecas[position.getLinha()][position.getColuna()] = null;
		return aux;
	}
	
	public Boolean existPosition(Integer linha, Integer coluna) {
		return (linha >= 0) && (linha < this.linha ) && (coluna >= 0) && (coluna < this.coluna);
	}
	
	public Boolean existPosition(Position position) {
		return existPosition(position.getLinha(), position.getColuna());
	}
	
	public Boolean positionOcupada(Position position) {
		if(!existPosition(position))
			throw new tabuleiroGameException("Posição inexistente no tabuleiro.");
		
		return peca(position) != null;
	}
	
	public Boolean positionOcupada(Integer linha, Integer coluna) {
		if(!existPosition(linha, coluna))
			throw new tabuleiroGameException("Posição inexistente no tabuleiro.");
		
		return peca(linha, coluna) != null;
	}

}
