package tabuleiroGame;

public abstract class Peca {
	
	protected Position position;
	private Tabuleiro tabuleiro;
	
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	
	public abstract boolean[][] movimentosPossiveis();
	
	public Boolean movimentoPossivel(Position position) {
		return movimentosPossiveis()[position.getLinha()][position.getColuna()];
	}
	
	public boolean algumMovimentoPossivel() {
		boolean[][] mat = movimentosPossiveis();
		
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat[i].length; j++) {
				if(mat[i][j])
					return true;
			}
		}
		return false;
	}

}
