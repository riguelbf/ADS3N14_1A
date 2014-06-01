package View.Partials;

import java.util.Scanner;

import Controller.ContatoController;
import Model.ContatoModel;

public class PesquisaContato {
	
	private static Scanner entradaDados = new Scanner(System.in);
	private ContatoModel model = new ContatoModel();
	private String opcaoSelecionada = "";
	int index = 0;
	
	public void ImprimeFormularioPesquisaContato(String[] contatos)
	{
		try {	
				while(index >= 0){
					ImprimeMenuPesquisa();
					
					switch (opcaoSelecionada) {
					case "0":
						index = -1;
						break;
					case "1":
						PesquisaContatoProximo(contatos);
						break;

					case "2":
						PesquisaContatoAnterior(contatos);
						break;
					
					case "3":
						PesquisaPorLetraInicial(contatos);
						break;

					default:
						System.out.println("Opção inexistente. Favor selecionar uma das opções disponiveis");
						System.out.println();
						System.out.println();
						ImprimeMenuPesquisa();
						break;
					}
				}
		} catch (Exception e) {
			// TODO: handle exception
		}   
	}

	private void PesquisaContatoProximo(String[] contatos) {
		if(index == contatos.length)
			index = 0;
		else
			index++;
		System.out.println("=======================================================");
		System.out.println("=| Dados do Contato |=");
		System.out.println("=| Código: " +  contatos[index].split(";")[0].toString());
		System.out.println("=| Nome: " +  contatos[index].split(";")[1].toString());
		System.out.println("=| Telefone: " + contatos[index].split(";")[2].toString());
		System.out.println("=======================================================");
	}

	private void PesquisaContatoAnterior(String[] contatos) {
		if(index == 0)
			index = contatos.length;
		else
			index--;
		
		System.out.println("=======================================================");
		System.out.println("=| Dados do Contato |=");
		System.out.println("=| Código: " +  contatos[index].split(";")[0].toString());
		System.out.println("=| Nome: " +  contatos[index].split(";")[1].toString());
		System.out.println("=| Telefone: " + contatos[index].split(";")[2].toString());
		System.out.println("=======================================================");
	}

	private void PesquisaPorLetraInicial(String[] contatos) {
		System.out.print("=  | Nome(ao menos 1ª letra) : ");
		this.model.setNome(entradaDados.next().toString());
		
		ContatoModel modelContato = new ContatoController().PesquisaContato(contatos,model.getNome());
		if(modelContato == null)
			System.out.println("=| Contato contato não encontrado |=");
		else
		{
			System.out.println("=| Dados do Contato |=");
			System.out.println("=| Nome: " + modelContato.getNome());
			System.out.println("=| Telefone: " + modelContato.getTelefone());
		}
	}

	private void ImprimeMenuPesquisa() {
		
		System.out.println();
		System.out.println("=| Pesquisa contato |=");
		System.out.println(" |  0  : Sair");
		System.out.println(" |  1  : Próximo contato");
		System.out.println(" |  2  : Contato Anterior");
		System.out.println(" |  3  : Pesquisa por letra inicial");
		System.out.print("Opção: ");
		opcaoSelecionada = entradaDados.next().toString();
	}
}
