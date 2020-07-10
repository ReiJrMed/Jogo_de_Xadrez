package tabuleiroGame;

public class Tabuleiro {
	
	private Integer linha, coluna;
	private Peca[][] pecas;
	
	public Tabuleiro(Integer linha, Integer coluna) {
		this.linha = linha;
		this.coluna = coluna;
		pecas = new Peca[linha][coluna];
	}

	public Integer getLinha() {
		return linha;
	}

	public void setLinha(Integer linha) {
		this.linha = linha;
	}

	public Integer getColuna() {
		return coluna;
	}

	public void setColuna(Integer coluna) {
		this.coluna = coluna;
	}
	
	public Peca peca(Integer linha, Integer coluna) {
		return pecas[linha][coluna];
	}
	
	public Peca peca(Position position) {
		return pecas[position.getLinha()][position.getColuna()];
	}
	
	public void posicionarPeca(Peca peca, Position position) {
		pecas[position.getLinha()][position.getColuna()] = peca;
		peca.position = position;
	}

}
