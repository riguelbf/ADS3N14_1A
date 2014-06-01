package View.Partials;

import java.util.Scanner;

import Controller.ContatoController;

public class RemoverContato {
	private static Scanner entradaDados = new Scanner(System.in);
	
	public String[] ImprimeFormularioRemoveContato()
	{
		String[] contatos = new ContatoController().ObtemListaDeContatos();
		boolean isRemovido = false;
		String opcaoSelecionada = "";
		
		
		while(!isRemovido)
		{
			System.out.println();
			System.out.println("=| Remover contato |=");
			System.out.println("=| Lista de Contatos |=");
			new ListaDeContatos().ImprimeListaContatos();
			System.out.print("=| Informe um código para remover o contato : ");
			System.out.print("Opção: ");
		    opcaoSelecionada = entradaDados.next().toString();
		    
			System.out.print("Opção: ");
			

			for (int i = 0; i < contatos.length; i++) {
				if(contatos[i].split(";")[0].toString().equals(opcaoSelecionada))
				{
					String[] contatosNovo = new String[contatos.length - 1];
					int posicao = 0;
					for (int j = 0; j < contatos.length; j++) {
						if(!contatos[j].split(";")[0].toString().equals(opcaoSelecionada) && j < contatos.length - 1)
						{
							contatosNovo[posicao] = contatos[j];
							posicao++;
						}
					}
					
					new ContatoController().AtualizaDb(contatosNovo);
					System.out.println("=| Contato removido com sucesso |=");
					return contatosNovo;
				}
			}
		}
		
		return contatos;
	}
}
