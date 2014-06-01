package Helper;

public class Helper {
	
	public String PreencheStringDireita(String texto,String caracter, int qtdCaracteres){
		
		String novoTexto = texto;
		for (int i = 0; i < qtdCaracteres; i++) {
			novoTexto += caracter; 
		}
		
		return novoTexto;
	}
}
