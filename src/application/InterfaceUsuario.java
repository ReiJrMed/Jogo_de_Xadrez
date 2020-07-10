package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import Xadrez.Cor;
import Xadrez.Peca_Xadrez;
import Xadrez.xadrezPosition;

public class InterfaceUsuario {
	
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

		public static final String ANSI_RESET = "\u001B[0m";
		public static final String ANSI_BLACK = "\u001B[30m";
		public static final String ANSI_RED = "\u001B[31m";
		public static final String ANSI_GREEN = "\u001B[32m";
		public static final String ANSI_YELLOW = "\u001B[33m";
		public static final String ANSI_BLUE = "\u001B[34m";
		public static final String ANSI_PURPLE = "\u001B[35m";
		public static final String ANSI_CYAN = "\u001B[36m";
		public static final String ANSI_WHITE = "\u001B[37m";

		public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
		public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
		public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
		public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
		public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
		public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
		public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
		public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
		
		//código copiado para usar no console
	
     public static xadrezPosition lerXadrezPosition(Scanner sc) {
    	 try {
    		 String s = sc.nextLine();
    		 Character coluna = s.charAt(0);
    		 Integer linha = Integer.parseInt(s.substring(1));
    		 return new xadrezPosition(coluna, linha);
    	 } catch(RuntimeException e) {
    		 throw new InputMismatchException("Erro ao ler a posição. Valores válidos são do intervalo a1 até h8.");
    	 }	 
    	 /*while (s.length() != 2){
    		 s = sc.nextLine();
    	 }*/   	 
     }	
	
	 public static void imprimeTabuleiro(Peca_Xadrez[][] pecas) {
		for(int i = 0; i < pecas.length; i++) {
			System.out.print((pecas.length -i) + " ");
			for(int j = 0; j < pecas[i].length; j++) {
				imprimePeca(pecas[i][j]);
			}
			System.out.println();
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		for(int i = 0; i < pecas.length; i++) {
			sb.append(((char) ('a' + i)) + " "); //imprimir caracteres em ordem alfabética
			
			//sb.append(((char) (0b01100001 + i)) + " "); 
			/*imprimindo caracteres em ordem alfabética usando código binário com a máscara para binário 0b
			 * sendo que 01100001 se refere ao caractere 'a' e soma-se a ele i para obter os caracteres posteriores
			 * nesse caso para imprimir é necessário o cast para char*/
		}
		System.out.print(sb.toString());		
	}
	
	public static void imprimePeca(Peca_Xadrez peca) {
		if(peca == null) 
			System.out.print("-");
		else {
            if (peca.getCor() == Cor.BRANCA)
                System.out.print(ANSI_WHITE + peca + ANSI_RESET);//método para colorir a peça console
            else 
                System.out.print(ANSI_YELLOW + peca + ANSI_RESET);//método para colorir a peça console 
        }
		
		System.out.print(" ");		
	}
	

}
