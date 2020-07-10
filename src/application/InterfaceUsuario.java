package application;

import Xadrez.Peca_Xadrez;

public class InterfaceUsuario {
	
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
			sb.append(((char) (0b01100001 + i)) + " "); 
			/*imprimindo caracteres em ordem alfab�tica usando c�digo bin�rio com a m�scara para bin�rio 0b
			 * sendo que 01100001 se refere ao caractere 'a' e soma-se a ele i para obter os caracteres posteriores
			 * nesse caso para imprimir � necess�rio o cast para char*/
		}
		System.out.print(sb.toString());		
	}
	
	public static void imprimePeca(Peca_Xadrez peca) {
		if(peca == null) 
			System.out.print("-");
		else
			System.out.print(peca);
		
		System.out.print(" ");		
	}
	

}
