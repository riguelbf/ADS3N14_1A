package Controller;

import Model.ContatoModel;
import DAO.ContatoDAO;


public class ContatoController {

	public String[] ObtemListaDeContatos()
	{
		return new ContatoDAO().LerArquivo();
	}
	
	public boolean SalvaContato(ContatoModel model)
	{
		return new ContatoDAO().EscreveArquivo(model);
	}
	
	public boolean RemoveContato(ContatoModel model)
	{
		return new ContatoDAO().RemoveDado(model);
	}
	
	public boolean EditaContato(ContatoModel model)
	{
		return new ContatoDAO().EditaArquivo(model);
	}
	
	public ContatoModel PesquisaContato(String[] contatos,String nomeContato)
	{
		for (int i = 0; i < contatos.length; i++) {
			if(contatos[i].toString().toUpperCase().split(";")[1].charAt(0) == nomeContato.toUpperCase().charAt(0))
			{
				ContatoModel model = new ContatoModel();
				model.setId(contatos[i].toString().split(";")[0].toString());
				model.setNome(contatos[i].toString().split(";")[1].toString());
				model.setTelefone(contatos[i].toString().split(";")[2].toString());
				return model;
			}	
		}
		return null;
	}
	
	public void AtualizaDb(String[] contatos)
	{
		new ContatoDAO().AtualizaArquivo(contatos);
	}
}
