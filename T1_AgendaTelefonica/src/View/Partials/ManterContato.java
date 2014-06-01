package View.Partials;

import java.util.Scanner;

import Model.ContatoModel;
import Controller.ContatoController;

public class ManterContato {
	
	private ContatoModel model = new ContatoModel();
	private Scanner entradaDados;
		
	public String[] ImprimeFormularioNovoContato(String[] contatos)
	{
		try {
				entradaDados = new Scanner(System.in);
				
				System.out.println();
				System.out.println("=| Novo contato |=");
				System.out.println("==================");
				System.out.print("=| Nome : ");
			    this.model.setNome(entradaDados.next().toString());
			    
			    System.out.print("=| Telefone : ");
			    this.model.setTelefone(entradaDados.next().toString());
			    
			    new ContatoController().SalvaContato(model);
			    System.out.println("=| Contato salvo com sucesso!! |=");
			    
		} catch (Exception e) {
			// TODO: handle exception
		}   
		
		return new ContatoController().ObtemListaDeContatos();
	}
}
