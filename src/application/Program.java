package application;

import Xadrez.Partida;

public class Program {

	public static void main(String[] args){		
		Partida partida = new Partida();
		InterfaceUsuario.imprimeTabuleiro(partida.getPecas());
	}

}
