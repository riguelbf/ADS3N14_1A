package View.Partials;

import java.util.Scanner;

import Controller.JogadaController;
import Model.JogadorModel;

public class Jogada {
	
	private static Scanner entradaDados = new Scanner(System.in);
	String coluna = "", linha = "";
	
	public void ImprimeOpcaoJogada(JogadorModel jogadorModel, String[][] tabuleiro,String[][] tabuleiroLimpo)
	{
		System.out.println("|===== Sua vez de jogar =====|");
		System.out.print("| Coluna : ");
		coluna = entradaDados.next();
		System.out.println();
		
		System.out.print("| Linha : ");
		linha = entradaDados.next();
		
		boolean acertou =  new JogadaController().RealizaJogada(coluna , linha, jogadorModel, tabuleiro);
		new ResultadoJogada().ImprimeResultadoJogada(coluna , linha, jogadorModel,acertou,tabuleiroLimpo);
	}
}
