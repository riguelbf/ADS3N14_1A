package DAO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Model.ContatoModel;


public class ContatoDAO {
	
	public String caminhoArquivoDb;
	
	public ContatoDAO()
	{
		this.caminhoArquivoDb = new File("").getAbsolutePath() + "\\src\\DataBase\\dbAgendaTelefonica.txt";
	}
	
	public ContatoModel ObterContatoPorNome(String nomeContato)
	{
		String[] contatos = this.LerArquivo();
		for (int i = 0; i < contatos.length; i++) {
			if(contatos[i].toString().split(";")[1].toString().equals(nomeContato))
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
	
	public String[] LerArquivo(){
		
		String[] listaContatos = null;
		try{ 
			 int qtdLinhasArquivo = ObterQuantidadeDeLinhas();
			 listaContatos = new String[qtdLinhasArquivo];
	         BufferedReader br = new BufferedReader(new FileReader(caminhoArquivoDb));
	         
	         for (int i = 0; i < qtdLinhasArquivo; i++) {
	        	 listaContatos[i] = br.readLine().toString();
			}
	         
	         br.close();
	         
		} catch (FileNotFoundException e) {  
            System.out.println("Arquivo não encontrado ...");  
            System.exit(1);  
        } catch (IOException e) {  
            System.out.println("Erro durante a leitura do arquivo ...");  
            System.exit(1);  
        }  
		
		return listaContatos;
	}
	
	public boolean EscreveArquivo(ContatoModel model){
		try{ 
			 BufferedWriter bw = new BufferedWriter(new FileWriter(this.caminhoArquivoDb,true));
	         
	         bw.write(ObterNovoId() +";"+ model.getNome() +";"+ model.getTelefone());
	         bw.close();
	         return true;
	         
		} catch (FileNotFoundException e) {  
          System.out.println("Arquivo não encontrado ...");  
          System.exit(1);  
      } catch (IOException e) {  
          System.out.println("Erro durante a leitura do arquivo ...");  
          System.exit(1);  
      } 
		return false;
	}
	
	public boolean EditaArquivo(ContatoModel model){
	
		String[] listaContatos = null;
		
		try{ 
	         int qtdRegistrosArquivo = ObterQuantidadeDeLinhas();
	         BufferedReader br = new BufferedReader(new FileReader(this.caminhoArquivoDb));
	         listaContatos = new String[qtdRegistrosArquivo];
	         
	         for (int i = 0; i <= qtdRegistrosArquivo; i++) {
	        	 String linha = br.readLine().toString();
	        	 if(linha.split(";")[0].toString().equals(model.getId()))
	        		 listaContatos[i] =	 model.getId() +";"+ model.getNome() +";"+ model.getTelefone();
	        	 else
	        		 listaContatos[i] = br.readLine().toString();
			}
	         
	         br.close();
	         
			 BufferedWriter bw = new BufferedWriter(new FileWriter(this.caminhoArquivoDb));
	         
			 for (int i = 0; i < listaContatos.length; i++) {
				 bw.append(listaContatos[0].toString() +";"+ listaContatos[1].toString() +";"+ listaContatos[2].toString());
			}
	         
	         bw.close();
	         return true;
	         
		} catch (FileNotFoundException e) {  
            System.out.println("Arquivo não encontrado ...");  
            System.exit(1);  
        } catch (IOException e) {  
            System.out.println("Erro durante a leitura do arquivo ...");  
            System.exit(1);  
        }  
		
		return false;
	}
	
	public boolean RemoveDado(ContatoModel model){
		return false;
	}
	
	private int ObterQuantidadeDeLinhas() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(this.caminhoArquivoDb));
		int qtdLinhas = 0;
		try {
			    while (br.readLine() != null) {
			    	qtdLinhas++;
		        }
			    
			    br.close();
			    
			 }catch (FileNotFoundException e) {  
	            System.out.println("Erro ao tentar encontrar a quantidade de linhas do arquivo ...");  
	            System.exit(1);  
	         } 
		
		return qtdLinhas;
	}
	
	private int ObterNovoId() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(this.caminhoArquivoDb));
		int novoID = 0;
		String linha = "";
		
		try {
			    while ( (linha = br.readLine()) != null) {
			    	if(Integer.parseInt(linha.split(";")[0].toString()) > novoID);
			    		novoID = Integer.parseInt(linha.split(";")[0].toString());
		        }
			    
			    br.close();
			    
			 }catch (FileNotFoundException e) {  
	            System.out.println("Erro ao tentar gerar novo Id ...");  
	            System.exit(1);  
	         } 
		
		return novoID +1 ;
	}
	
	public Boolean AtualizaArquivo(String[] contatos)
	{
		try{ 
			 String novaLinha = System.getProperty("line.separator");
			 BufferedWriter bw = new BufferedWriter(new FileWriter(this.caminhoArquivoDb,false));
	         
			 for (int i = 0; i < contatos.length; i++) {
				 if(contatos[i] != null)
					 bw.write(contatos[i] + novaLinha);
			}
			 
	         bw.close();
	         return true;
	         
		} catch (FileNotFoundException e) {  
         System.out.println("Arquivo não encontrado ...");  
         System.exit(1);  
     } catch (IOException e) {  
         System.out.println("Erro durante a leitura do arquivo ...");  
         System.exit(1);  
     } 
		return false;
	}
}
