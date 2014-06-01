package Controller;

import Helper.Helper;
import Model.TabuleiroModel;
import Model.TabuleiroModel.TipoTabuleiro;

public class TabuleiroController {
	
	private String[][] Tabuleiro(String tabuleiro)
	{
		String[][] tabuleiroFinal = new String[10][10];
		
		int posicao = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				tabuleiroFinal[i][j] = String.valueOf(tabuleiro.charAt(posicao)) ;
				posicao++;
			}
		}
		
		return tabuleiroFinal;
	}

	public String[][] ObtemTabuleiro(final TipoTabuleiro tipoTabuleiro)
	{
		String tabuleiro = "";
		
		switch (tipoTabuleiro) {
		case TipoA :
			tabuleiro = new TabuleiroModel().TabuleiroA();
			break;
		case TipoB :
			tabuleiro = new TabuleiroModel().TabuleiroB();
			break;
		case TipoC :
			tabuleiro = new TabuleiroModel().TabuleiroC();
			break;
		case TipoD :
			tabuleiro = new TabuleiroModel().TabuleiroD();
			break;
		case TipoE :
			tabuleiro = new TabuleiroModel().TabuleiroE();
			break;
		}
		
		return this.Tabuleiro(tabuleiro);
	}

	public void ImprimeTabuleiro(String[][] tabuleiro)
	{	
		System.out.println(" ABCDEFGHIJ");
		for (int i = 0; i < 10; i++) {
			System.out.print(i + 1);
			for (int j = 0; j < 10; j++) {
				System.out.print(tabuleiro[i][j]);
			}
			
			System.out.println();
		}
	}
	
	public void ImprimeTabuleiroJogadas(String coluna, String linha, boolean acertou, String[][] tabuleiroLimpo)
	{
		
		for (int i = 0; i < 10; i++) {
			if(i == Integer.parseInt(linha) -1)
			{
				for (int j = 0; j < 10; j++) {
					if(j == new Helper().ConverteNumeroColuna(coluna)-1)
					{
						//acertou o alvo
						if(acertou)
						{
							tabuleiroLimpo[i][j] = "O";
						}
						else // errou o alvo
						{
							tabuleiroLimpo[i][j] = "-";
						}
					}
				}
			}
		}
		
		new TabuleiroController().ImprimeTabuleiro(tabuleiroLimpo);
	}
}
