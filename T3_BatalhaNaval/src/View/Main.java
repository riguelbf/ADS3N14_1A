package View;

import java.util.Random;

import Controller.TabuleiroController;
import Model.JogadorModel;
import Model.TabuleiroModel.TipoTabuleiro;
import View.Partials.Jogada;

public class Main {

	
	private static JogadorModel jogadorModel = new JogadorModel();
	
	public static void main(String arg[]){
	
		String[][] tabuleiroInicial = ObtemTabuleiroInicial();
		String[][] tabuleiroReultadoJogadas = ObtemTabuleiroLimpo();
		while(jogadorModel.getPontos() > 0)
		{
			new Jogada().ImprimeOpcaoJogada(jogadorModel,tabuleiroInicial,tabuleiroReultadoJogadas);
			if(jogadorModel.getPontosAlvos() == 0)
			{
				System.out.println("******************** Você venceu, acertou todos os alvos *********************");
				break;
			}
			else if(jogadorModel.getPontos() == 0)
			{
				System.out.println("******************** Você perdeu, acabaram seus pontos ***********************");
				break;
			}		
		}
	}
	
	private static String[][] ObtemTabuleiroInicial()

	{
		String[][] tabuleiro = null;
		switch (new Random().nextInt(5) + 1) {
		case 1:
			tabuleiro = new TabuleiroController().ObtemTabuleiro(TipoTabuleiro.TipoA);
			break;
		case 2:
			tabuleiro = new TabuleiroController().ObtemTabuleiro(TipoTabuleiro.TipoB);
			break;
		case 3:
			tabuleiro = new TabuleiroController().ObtemTabuleiro(TipoTabuleiro.TipoC);
			break;
		case 4:
			tabuleiro = new TabuleiroController().ObtemTabuleiro(TipoTabuleiro.TipoD);
			break;
		case 5:
			tabuleiro = new TabuleiroController().ObtemTabuleiro(TipoTabuleiro.TipoE);
			break;

		default:
			break;
		}
		
		return tabuleiro;
	}
	
	private static String[][] ObtemTabuleiroLimpo()
	{
		String[][] tabuleiroLimpo = new String[10][10]; 
				
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				tabuleiroLimpo[i][j] = ".";
			}
		}
		
		return tabuleiroLimpo;
	}
}
