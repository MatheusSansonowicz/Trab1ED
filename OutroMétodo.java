package trabalho;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class OutroMétodo {
	
	public static void exibir(List<Integer> lista) {
        for (Integer item : lista) {
            System.out.println(item);
        }
    }
	
	public static void exibirValoresEmTodasListas(List<List<Integer>> listaGenerica) {
	    List<Numero> numeros = GerenciadorNumeros.contarAparicoes(listaGenerica);

	    // Exibir os números presentes em todas as listas
	    System.out.println("Valores presentes em todas as listas:");
	    for (Numero numero : numeros) {
	        if (numero.getNumeroAparicoes() == listaGenerica.size()) {
	            System.out.println(numero.getValor());
	        }
	    }
	}

	public static void exibirNumerosUnicos(List<List<Integer>> listaGenerica) {
	    List<Numero> numeros = GerenciadorNumeros.contarAparicoes(listaGenerica);

	    // Exibir os números que aparecem em apenas uma lista
	    System.out.println("Valores que aparecem em somente uma lista:");
	    for (Numero numero : numeros) {
	        if (numero.getNumeroAparicoes() == 1) {
	            System.out.println(numero.getValor());
	        }
	    }
	}


	public static void main(String[] args) {
		
		List<Integer> lista = new ArrayList<Integer>();
        Random gerador = new Random();
        
        
        List<List<Integer>> listaGenerica = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            List<Integer> listaInterna = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                int valor = gerador.nextInt(400);
                if (!listaInterna.contains(valor)) { // Verifique se o valor já está na lista interna
                    listaInterna.add(valor); // Adicione à lista interna
                }
            }
            listaInterna.sort(null); // Classifique a lista interna
            listaGenerica.add(listaInterna); // Adicione a lista interna à lista genérica
        }
        // Exiba todas as listas internas da lista genérica
        for (List<Integer> listaInterna : listaGenerica) {
            exibir(listaInterna);
        }
        
     // Exibir valores presentes em todas as listas
        exibirValoresEmTodasListas(listaGenerica);

        // Exibir valores que aparecem em somente uma lista
        exibirNumerosUnicos(listaGenerica);

	}

}
