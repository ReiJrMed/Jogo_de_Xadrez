package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import Xadrez.Partida;
import Xadrez.Peca_Xadrez;
import Xadrez.xadrezException;
import Xadrez.xadrezPosition;

public class Program {

	public static void main(String[] args){		
		
		Scanner sc = new Scanner(System.in);
		Partida partida = new Partida();
		
		while(true) {
		  try {
			  InterfaceUsuario.clearScreen();
			  InterfaceUsuario.imprimeTabuleiro(partida.getPecas());
			  System.out.println();
			  System.out.print("Origem: ");
			  xadrezPosition origem = InterfaceUsuario.lerXadrezPosition(sc);
			  
			  boolean[][] movimentosPossiveis = partida.movimentosPeca(origem);
			  InterfaceUsuario.clearScreen();
			  InterfaceUsuario.imprimeTabuleiro(partida.getPecas(), movimentosPossiveis);
			  
			  System.out.println();
			  System.out.print("Destino: ");
			  xadrezPosition destino = InterfaceUsuario.lerXadrezPosition(sc);
			  
			  Peca_Xadrez pecaCapiturada = partida.moverPeca(origem, destino);
		  } catch(xadrezException e) {
			  System.out.println(e.getMessage());
			  sc.nextLine();
		  } catch(InputMismatchException e) {
			  System.out.println(e.getMessage());
			  sc.nextLine();
		  }
		}
	  
	}

}
