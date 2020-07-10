package application;

import java.util.Scanner;

import Xadrez.Partida;
import Xadrez.Peca_Xadrez;
import Xadrez.xadrezPosition;

public class Program {

	public static void main(String[] args){		
		
		Scanner sc = new Scanner(System.in);
		Partida partida = new Partida();
		
		while(true) {
		  InterfaceUsuario.imprimeTabuleiro(partida.getPecas());
		  System.out.println();
		  System.out.print("Origem: ");
		  xadrezPosition origem = InterfaceUsuario.lerXadrezPosition(sc); 
		  
		  System.out.println();
		  System.out.print("Destino: ");
		  xadrezPosition destino = InterfaceUsuario.lerXadrezPosition(sc);
		  
		  Peca_Xadrez pecaCapiturada = partida.moverPeca(origem, destino);
		  
		}
	  
	}

}
