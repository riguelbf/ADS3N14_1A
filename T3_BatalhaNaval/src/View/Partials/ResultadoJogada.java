package View.Partials;

import Controller.TabuleiroController;
import Model.JogadorModel;

public class ResultadoJogada {

	public void ImprimeResultadoJogada(String coluna, String linha, JogadorModel jogadorModel,Boolean acertou, String[][] tabuleiro)
	{
		System.out.println("|==================== Resultado Jogada ============================|");
		
		new TabuleiroController().ImprimeTabuleiroJogadas(coluna , linha, acertou,tabuleiro);
		System.out.println(" Você  " + (acertou == true ? "acertou" : "errou"));
		System.out.println(" Pontos Restantes: " + jogadorModel.getPontos());
		
		System.out.println("|==================================================================|");
	}
}
