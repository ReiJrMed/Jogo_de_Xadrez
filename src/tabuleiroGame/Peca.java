package tabuleiroGame;

public class Peca {
	
	protected Position position;
	private Tabuleiro tabuleiro;
	
	public Peca(Position position) {
		this.position = position;
	}
	
	protected Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

}
