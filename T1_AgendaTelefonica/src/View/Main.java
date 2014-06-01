package View;

import java.util.Scanner;

import View.Partials.EncerraAplicacao;
import View.Partials.ListaDeContatos;
import View.Partials.ManterContato;
import View.Partials.Menu;
import View.Partials.PesquisaContato;
import View.Partials.RemoverContato;
import Controller.ContatoController;


public class Main {
	private static Scanner entradaDados;

	public static void main(String arg[]){  
       
		String opcaoSelecionada = "X";
		String[] contatos = new ContatoController().ObtemListaDeContatos();
		entradaDados = new Scanner(System.in);
		
		while (opcaoSelecionada != "") {
		       
		       new Menu().ImprimeMenu();
		       opcaoSelecionada = entradaDados.next().toString();
		       
		       switch (opcaoSelecionada) {
				
		       case "0":
		    	   //sai da aplicacao;
					break;
				case "1":
					contatos = new ManterContato().ImprimeFormularioNovoContato(contatos);
					break;
				case "2":
					contatos = new RemoverContato().ImprimeFormularioRemoveContato();
					break;
				case "3":
					contatos = new ListaDeContatos().ImprimeListaContatos();
					break;
				case "4":
					 new PesquisaContato().ImprimeFormularioPesquisaContato(contatos);
					break;
				default:
					System.out.println("Opção inexistente. Favor selecionar uma das opções disponiveis");
					System.out.println();
					System.out.println();
				}			
		       
		       //sai da aplicacao
		       if(opcaoSelecionada.equals("0"))
		       {   
		    	   entradaDados.close();
		    	   break;
		       }   
		}      
		
		new EncerraAplicacao().EscreveMensagemFimAplicacao();
		System.exit(1);
    }
}
