import java.util.Scanner;


public class Main {
	
	private static int[] numeros = new int[]{1,5,6,8,10,9,7,4,3,2};
	private static int totalTrocas = 0;
	private static int totalComparacoes = 0;
	private static Scanner entradaDados = new Scanner(System.in);
	
	public static void main(String arg[]){ 
		
		String opcaoSelecionada = "";
		System.out.println("========| Selecione o algoritmo de ordenação |===============);");
		System.out.println(" 1 - Heap Sort");
		System.out.println(" 2 - QuickSort");
		System.out.println("=============================================================");
		System.out.print("Opção: ");
		opcaoSelecionada = entradaDados.next();
		System.out.println();
				
		switch (opcaoSelecionada) {
		case "1":
			totalTrocas = 0;
			totalComparacoes = 0;
			heapSortExecucao(numeros);
			break;
		
		case "2":
			totalTrocas = 0;
			totalComparacoes = 0;
			quickSortExecucao(numeros,1,numeros.length);
			break;

		default:
			System.exit(1);
			break;
		}
		
		System.out.println("Total de comparações: " + totalComparacoes);
		System.out.println("Total de trocas: " + totalTrocas);
	}

	
	/// SELECTION SORT **********************************************************************************
	public static void quickSortExecucao(int []numeros,int inicio, int fim) {
		   int meio;
		   
		   
		   if (inicio < fim) {
		     meio = dividir(numeros, inicio, fim);
		     quickSortExecucao(numeros, inicio, meio);
		     quickSortExecucao(numeros, meio + 1, fim);
		   }
		 }
		 
		 public static int dividir(int []numeros,int inicio, int fim) {
		   
		   totalTrocas++;
		   int pivo, raiz, i;
		   pivo = numeros[inicio];
		   raiz = inicio;
		 
		   for (i = inicio + 1; i < fim; i++) {
		     if (numeros[i] < pivo) {
		       numeros[raiz] = numeros[i];
		       numeros[i] = numeros[raiz + 1];
		       raiz++;
		       totalComparacoes++;
		     }
		   }
		   
		   numeros[raiz] = pivo;
		   return raiz;
		 }
	
	
	/// HEAP SORT **********************************************************************************
	public static void heapSortExecucao(int[] numeros)
    {
		setaRaiz(numeros);
      
	    int n = numeros.length;
	
	    for (int i = numeros.length - 1; i > 0; i--)
	    {
		    trocaPosicao(numeros, i , 0);
		    maiorAtual(numeros, 0, --n);
	    }
    }
	
    private static void setaRaiz(int[] v)
    {
       for (int i = v.length/2 - 1; i >= 0; i--)
       {
    	   maiorAtual(v, i , v. length );
    	   
       }   
    }
    
    private static void maiorAtual(int[] v, int pos, int n)
    {  
       int max;
       int l = 2 * pos + 1;
       int direita = 2 * pos + 2;
       if ( (l < n) && (v[l] > v[pos]) )
       {
    	   max = l;
       }
       else
       {
    	   max = pos;
       }
       if (direita < n && v[direita] > v[max])
       {
    	   max = direita;
       }
       if (max != pos)
       {
    	   trocaPosicao(v, pos, max);
    	   maiorAtual(v, max, n);
       }
       
       totalComparacoes++;
    }

    public static void trocaPosicao ( int[ ] v, int j, int aposJ )
    {
       int aux = v [ j ];
       v [ j ] = v [ aposJ ];
       v [ aposJ ] = aux;
       
       totalTrocas++;
    }
}
