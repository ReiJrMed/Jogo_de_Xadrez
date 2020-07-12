package Xadrez;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Xadrez.Pecas.Bispo;
import Xadrez.Pecas.Cavalo;
import Xadrez.Pecas.Peao;
import Xadrez.Pecas.Rainha;
import Xadrez.Pecas.Rei;
import Xadrez.Pecas.Torre;
import tabuleiroGame.Peca;
import tabuleiroGame.Position;
import tabuleiroGame.Tabuleiro;


public class Partida {
	
	private Tabuleiro tabuleiro;
	private Integer turno;
	private Cor turnoJogador;
	private boolean check;
	private boolean checkmate;
	
	private List<Peca_Xadrez> possible_enPassant = new ArrayList<>();
	private List<Peca> pecasCapturadas = new ArrayList<>();
	private List<Peca> pecasTabuleiro = new ArrayList<>();
	
	public Partida() {
		this.tabuleiro = new Tabuleiro(8, 8);
		Inicio();
	}
	
	public Cor getTurnoJogador() {
		return turnoJogador;
	}
	
	public Integer getTurno() {
		return turno;
	}
	
	public boolean getCheck() {
		return check;
	}
	
	public boolean getCheckmate() {
		return checkmate;
	}
	
	public List<Peca_Xadrez> getEnPassant() {
		return possible_enPassant;
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
	
	private Cor oponente(Cor cor) {
		return (cor == Cor.BRANCA) ? Cor.PRETA : Cor.BRANCA;
	}
	
	private Peca_Xadrez rei(Cor cor) {
		List<Peca> pecasCor = pecasTabuleiro.stream().filter(x -> (((Peca_Xadrez)x).getCor() == cor)).collect(Collectors.toList());
		
		for(Peca p : pecasCor) {
			if(p instanceof Rei)
				return (Peca_Xadrez)p;
		}
		
		throw new IllegalStateException("Não existe apeça rei da cor " + cor + " no tabuleiro");
	}
	
	private boolean testeCheck(Cor cor) {
		Position reiPosition = rei(cor).getPosicaoXadrez().toPosition();
		List<Peca> oponentePecas = pecasTabuleiro.stream().filter(x -> (((Peca_Xadrez)x).getCor() == oponente(cor))).collect(Collectors.toList());
	    for(Peca p : oponentePecas) {
	    	boolean[][] mat = p.movimentosPossiveis();
	    	if(mat[reiPosition.getLinha()][reiPosition.getColuna()])
	    		return true;
	    }
	    return false;
	}
	
	private boolean testeCheckmate(Cor cor) {
	    if(!testeCheck(cor))
	    	return false;
		
	    List<Peca> pecasCor = pecasTabuleiro.stream().filter(x -> (((Peca_Xadrez)x).getCor() == cor)).collect(Collectors.toList());
	    
	    for(Peca p : pecasCor) {
	    	boolean[][] mat = p.movimentosPossiveis();
	    	for(int i = 0; i < mat.length; i++) {
	    		for(int j = 0; j < mat[i].length; j++) {
	    			if(mat[i][j]) {
	    				Position origin = ((Peca_Xadrez)p).getPosicaoXadrez().toPosition();
	    				Position destiny = new Position(i, j);
	    				Peca pecaCapturada = processoMovimento(origin, destiny);
	    				boolean TesteCheque = testeCheck(cor);
	    				desfazerProcessoMovimento(origin, destiny, pecaCapturada);
	    				if(!TesteCheque)
	    					return false;
	    			}
	    		}
	    	}
	    }
	    return true;	    
	}
	
	public boolean[][] movimentosPeca(xadrezPosition origem){
		Position origin = origem.toPosition();
		validarPositionOrigem(origin);
		return tabuleiro.peca(origin).movimentosPossiveis();		
	}
	
	public Peca_Xadrez moverPeca(xadrezPosition origem, xadrezPosition destino) {
		Position origin = origem.toPosition();
		Position destiny = destino.toPosition();
		validarPositionOrigem(origin);
		validarPositionDestino(origin, destiny);
		Peca pecaCapturada = processoMovimento(origin, destiny);
		
		if(testeCheck(turnoJogador)) {
			desfazerProcessoMovimento(origin, destiny, pecaCapturada);
			throw new xadrezException("Você não pode se colocar em check.");
		}
		
		Peca_Xadrez pecaMovida = (Peca_Xadrez)tabuleiro.peca(destiny);
		
		check = (testeCheck(oponente(turnoJogador))) ? true : false;
		
		if(testeCheckmate(oponente(turnoJogador)))
			checkmate = true;
		else		
		  proximoTurno();
		
		if((pecaMovida instanceof Peao) && ((destiny.getLinha() == (origin.getLinha() +2)) || ((destiny.getLinha() == (origin.getLinha() -2))))){
			possible_enPassant.add(pecaMovida);
		}
		
		return (Peca_Xadrez) pecaCapturada;
	}
	
	private Peca processoMovimento(Position origin, Position destiny) {
		Peca_Xadrez p = (Peca_Xadrez)tabuleiro.removePeca(origin);
		p.plusQuantMovimentos();
		Peca pecaCapturada = tabuleiro.removePeca(destiny);
		
		if(pecaCapturada != null) {
			pecasCapturadas.add(pecaCapturada);
			pecasTabuleiro.remove(pecaCapturada);
		}
		
		//Jogada especial ROQUE do lado do Rei (ROQUE pequeno)
		if((p instanceof Rei) && (destiny.getColuna() == (origin.getColuna() +2))) {
			Position pOriginTorre = new Position(origin.getLinha(), origin.getColuna() +3);
			Position pDestinyTorre = new Position(origin.getLinha(), origin.getColuna() +1);
			Peca_Xadrez torre = (Peca_Xadrez)tabuleiro.removePeca(pOriginTorre);
			tabuleiro.posicionarPeca(torre, pDestinyTorre);
			torre.plusQuantMovimentos();
		}
		
		//Jogada especial ROQUE do lado da Rainha (ROQUE GRANDE)
		if((p instanceof Rei) && (destiny.getColuna() == (origin.getColuna() -2))) {
			Position pOriginTorre = new Position(origin.getLinha(), origin.getColuna() -4);
			Position pDestinyTorre = new Position(origin.getLinha(), origin.getColuna() -1);
			Peca_Xadrez torre = (Peca_Xadrez)tabuleiro.removePeca(pOriginTorre);
			tabuleiro.posicionarPeca(torre, pDestinyTorre);
			torre.plusQuantMovimentos();
		}
		
		//Jogada especial en Passant
		if(p instanceof Peao) {
			if((destiny.getColuna() != origin.getColuna()) && (pecaCapturada == null)) {
				Position peaoCapturado;
				if(p.getCor() == Cor.BRANCA)
					peaoCapturado = new Position(destiny.getLinha() +1, destiny.getColuna());
				else
					peaoCapturado = new Position(destiny.getLinha() -1, destiny.getColuna());
				
				pecaCapturada = tabuleiro.removePeca(peaoCapturado);
				pecasCapturadas.add(pecaCapturada);
				pecasTabuleiro.remove(pecaCapturada);
			}
		}
		
		tabuleiro.posicionarPeca(p, destiny);
		return pecaCapturada;
	}
	
	private void desfazerProcessoMovimento(Position origem, Position destino, Peca pecaCapturada) {
		Peca_Xadrez p = (Peca_Xadrez)tabuleiro.removePeca(destino);
		p.minusQuantMovimentos();
		tabuleiro.posicionarPeca(p, origem);
		
		if(pecaCapturada != null) {
			tabuleiro.posicionarPeca(pecaCapturada, destino);
			pecasCapturadas.remove(pecaCapturada);
			pecasTabuleiro.add(pecaCapturada);
		}
		
		//Jogada especial ROQUE do lado do Rei (ROQUE pequeno)
		if((p instanceof Rei) && (destino.getColuna() == (origem.getColuna() +2))) {
			Position pOriginTorre = new Position(origem.getLinha(), origem.getColuna() +3);
			Position pDestinyTorre = new Position(origem.getLinha(), origem.getColuna() +1);
			Peca_Xadrez torre = (Peca_Xadrez)tabuleiro.removePeca(pDestinyTorre);
			tabuleiro.posicionarPeca(torre, pOriginTorre);
			torre.plusQuantMovimentos();
		}
				
		//Jogada especial ROQUE do lado da Rainha (ROQUE GRANDE)
		if((p instanceof Rei) && (destino.getColuna() == (origem.getColuna() -2))) {
			Position pOriginTorre = new Position(origem.getLinha(), origem.getColuna() -4);
			Position pDestinyTorre = new Position(origem.getLinha(), origem.getColuna() -1);
			Peca_Xadrez torre = (Peca_Xadrez)tabuleiro.removePeca(pDestinyTorre);
			tabuleiro.posicionarPeca(torre, pOriginTorre);
			torre.plusQuantMovimentos();
		}
		
		//Jogada especial en Passant
		if(p instanceof Peao) {
			if((destino.getColuna() != origem.getColuna()) && (possible_enPassant.contains(pecaCapturada))) {
				Peca_Xadrez peaoCapturado = (Peca_Xadrez)tabuleiro.removePeca(destino);
				Position peaoRecolocar;
				if(p.getCor() == Cor.BRANCA)
					peaoRecolocar = new Position(3, destino.getColuna());
				else
					peaoRecolocar = new Position(4, destino.getColuna());
				
				tabuleiro.posicionarPeca(peaoCapturado, peaoRecolocar);				
			}
		}
	}
	
	private void validarPositionOrigem(Position origin) {
		if(!tabuleiro.positionOcupada(origin))
			throw new xadrezException("Não há peça nesta posição do tabuleiro.");
		
		if(turnoJogador != (((Peca_Xadrez)tabuleiro.peca(origin)).getCor()))
			throw new xadrezException("A peça escolhida não é sua.");
				
		if(!tabuleiro.peca(origin).algumMovimentoPossivel())
			throw new xadrezException("Não há movimentos possíveis para a peça escolhida.");
	}
	
	private void validarPositionDestino(Position origem, Position destino) {
		if(!tabuleiro.peca(origem).movimentoPossivel(destino)) 
			throw new xadrezException("A peça escolhida não pode ser movida para posição de destino.");		
	}
	
	private void posicionarPecaXadrez(Character coluna, Integer linha, Peca_Xadrez peca) {
		tabuleiro.posicionarPeca(peca, (new xadrezPosition(coluna, linha)).toPosition());
		pecasTabuleiro.add(peca);
	}
	
	private void proximoTurno() {
		turno++;
		turnoJogador = (turnoJogador == Cor.BRANCA) ? Cor.PRETA : Cor.BRANCA;
	}
	
	private void Inicio() {
		turno = 1;
		turnoJogador = Cor.BRANCA;
		
		posicionarPecaXadrez('a', 1, new Torre(tabuleiro, Cor.BRANCA));
		posicionarPecaXadrez('b', 1, new Cavalo(tabuleiro, Cor.BRANCA));
		posicionarPecaXadrez('c', 1, new Bispo(tabuleiro, Cor.BRANCA));
		posicionarPecaXadrez('d', 1, new Rainha(tabuleiro, Cor.BRANCA));
		posicionarPecaXadrez('e', 1, new Rei(tabuleiro, Cor.BRANCA, this));
		posicionarPecaXadrez('f', 1, new Bispo(tabuleiro, Cor.BRANCA));
		posicionarPecaXadrez('g', 1, new Cavalo(tabuleiro, Cor.BRANCA));
		posicionarPecaXadrez('h', 1, new Torre(tabuleiro, Cor.BRANCA));
				
		for(int i = 0; i < tabuleiro.getColuna(); i++) {
			posicionarPecaXadrez((char)('a' +i), 2, new Peao(tabuleiro, Cor.BRANCA, this));
		}

		posicionarPecaXadrez('a', 8, new Torre(tabuleiro, Cor.PRETA));
		posicionarPecaXadrez('b', 8, new Cavalo(tabuleiro, Cor.PRETA));
		posicionarPecaXadrez('c', 8, new Bispo(tabuleiro, Cor.PRETA));
		posicionarPecaXadrez('d', 8, new Rainha(tabuleiro, Cor.PRETA));
		posicionarPecaXadrez('e', 8, new Rei(tabuleiro, Cor.PRETA, this));
		posicionarPecaXadrez('f', 8, new Bispo(tabuleiro, Cor.PRETA));
		posicionarPecaXadrez('g', 8, new Cavalo(tabuleiro, Cor.PRETA));
		posicionarPecaXadrez('h', 8, new Torre(tabuleiro, Cor.PRETA));
			
		for(int i = 0; i < tabuleiro.getColuna(); i++) {
			posicionarPecaXadrez((char)('a' +i), 7, new Peao(tabuleiro, Cor.PRETA, this));
		}		
		
	}

}
