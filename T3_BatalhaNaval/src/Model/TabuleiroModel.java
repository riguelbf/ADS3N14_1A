package Model;

public class TabuleiroModel {
	
	public enum TipoTabuleiro
	{
		TipoA,
		TipoB,
		TipoC,
		TipoD,
		TipoE
	}
	
	public String TabuleiroA()
	{
		String tab;
		
		tab  = ".P........";
		tab += ".P......S.";
		tab += ".P........";
		tab += ".P........";
		tab += ".P....D...";
		tab += "......D...";
		tab += "......D...";
		tab += "......D...";
		tab += "..FFF.....";
		tab += "......TT..";

		return tab;
	}
	
	public String TabuleiroB(){
		String tab;

		tab  = ".DDDD.....";
		tab += ".....F....";
		tab += ".....F....";
		tab += ".....F....";
		tab += "..........";
		tab += "..........";
		tab += "...TT.....";
		tab += "..PPPPP...";
		tab += "......S...";
		tab += "..........";
		
		return tab;
	}
	
	public String TabuleiroC(){
		String tab;
		
		tab  = "..PPPPP...";
		tab += "..........";
		tab += "..FFF.....";
		tab += "..........";
		tab += "..........";
		tab += "..DDDD....";
		tab += "..........";
		tab += "S.........";
		tab += ".....TT...";
		tab += "..........";
		
		return tab;
	}
	
	public String TabuleiroD(){
		String tab;
		
		tab =  ".D........";
		tab += ".D.TT.....";
		tab += ".D........";
		tab += ".D........";
		tab += "...S......";
		tab += ".P........";
		tab += ".P...FFF..";
		tab += ".P........";
		tab += ".P........";
		tab += ".P........";
		
		return tab;
	}
	
	public String TabuleiroE(){
		String tab = "";
		
		tab  = ".S........";
		tab += "..........";
		tab += ".T........";
		tab += ".T........";
		tab += "...D......";
		tab += ".P.D......";
		tab += ".P.D.FFF..";
		tab += ".P.D......";
		tab += ".P........";
		tab += ".P........";
		
		return tab;
	}
}
