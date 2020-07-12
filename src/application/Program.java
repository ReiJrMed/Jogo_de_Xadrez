package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Xadrez.Partida;
import Xadrez.Peca_Xadrez;
import Xadrez.xadrezException;
import Xadrez.xadrezPosition;


public class Program {

	public static void main(String[] args){		
		
		Scanner sc = new Scanner(System.in);
		Partida partida = new Partida();
		List<Peca_Xadrez> pecasCapturadas = new ArrayList<>();
		
		while(!partida.getCheckmate()) {
		  try {
			  InterfaceUsuario.clearScreen();
			  InterfaceUsuario.imprimePartida(partida, pecasCapturadas);
			  System.out.println();
			  System.out.print("Origem: ");
			  xadrezPosition origem = InterfaceUsuario.lerXadrezPosition(sc);

			  boolean[][] movimentosPossiveis = partida.movimentosPeca(origem);
			  InterfaceUsuario.clearScreen();
			  InterfaceUsuario.imprimeTabuleiro(partida.getPecas(), movimentosPossiveis, partida);

			  System.out.println();
			  System.out.print("Destino: ");
			  xadrezPosition destino = InterfaceUsuario.lerXadrezPosition(sc);
			  Peca_Xadrez pecaCapiturada = null;
						  
			  pecaCapiturada = partida.moverPeca(origem, destino);
			
			  if(pecaCapiturada != null)
				  pecasCapturadas.add(pecaCapiturada);

			  if(partida.getPeaoPromovido() != null) {
				  String tipo;
					  do {
						  System.out.print("Informe que tipo de peça o peão será promovido (R/T/C/B)?");
						  tipo = sc.nextLine();  
					  } while((!tipo.equalsIgnoreCase("R")) && (!tipo.equalsIgnoreCase("T")) && (!tipo.equalsIgnoreCase("C")) && (!tipo.equalsIgnoreCase("B")));

					  partida.Promover(tipo);
				  }				  
						  
		  } catch(xadrezException e) {
			  System.out.println(e.getMessage());
			  sc.nextLine();
		  } catch(InputMismatchException e) {
			  System.out.println(e.getMessage());
			  sc.nextLine();
		  } catch(RuntimeException e) {
			  System.out.println(e.getMessage());
			  e.printStackTrace();
			  sc.nextLine();			  
		  }
		  
		}
		
		 InterfaceUsuario.clearScreen();
		 InterfaceUsuario.imprimePartida(partida, pecasCapturadas);
	  
	}

}
