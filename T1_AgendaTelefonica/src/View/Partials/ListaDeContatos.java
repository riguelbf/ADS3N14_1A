package View.Partials;

import Controller.ContatoController;
import Helper.Helper;

public class ListaDeContatos {
	
	public String[] ImprimeListaContatos()
	{	 
		String[] contatos = new ContatoController().ObtemListaDeContatos();
		
		Helper help = new Helper();
		System.out.println();
		System.out.println("=|Lista de Contatos|=");
		System.out.println("|==== Código ====|========= Nome ========|===== Telefone =====|");
		for (int i = 0; i < contatos.length; i++) {
			
			String codigoContato = contatos[i].split(";")[0].toString();
			String nomeContato = contatos[i].split(";")[1].toString();
			String telefoneContato = contatos[i].split(";")[2].toString();
			System.out.println("| " +  help.PreencheStringDireita(codigoContato, " ", 15 - codigoContato.length()) +
							   "| " +  help.PreencheStringDireita(nomeContato, " ", 22 - nomeContato.length()) +
							   "| " +  help.PreencheStringDireita(telefoneContato, " ", 19 - telefoneContato.length()) );
		}
		System.out.println("===========================================================|");
		System.out.println();
		
		return contatos;
	}
}
