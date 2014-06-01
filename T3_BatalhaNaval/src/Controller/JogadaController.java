package Controller;

import Helper.Helper;
import Model.JogadorModel;

public class JogadaController {

	public boolean RealizaJogada(String coluna, String linha, JogadorModel jogadorModel, String[][] tabuleiro)
	{
		boolean acertou = false;
		
		for (int i = 0; i < 10; i++) {
			if(i == Integer.parseInt(linha ) -1)
			{
				for (int j = 0; j < 10; j++) {
					if(j == new Helper().ConverteNumeroColuna(coluna) -1)
					{
						//acertou o alvo
						if(!tabuleiro[i][j].equals("."))
						{
							jogadorModel.setPontos(jogadorModel.getPontos() + 3);
							jogadorModel.setPontosAlvos(jogadorModel.getPontosAlvos() - 1);
							acertou = true;
						}
						else // errou o alvo
						{
							jogadorModel.setPontos(jogadorModel.getPontos() - 1);
						}
					}	
				}
			}
		}
		
		return acertou;
	}
	
}
