package trabalho;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Principal {
	
	private static List<Integer> listaLixeira = new ArrayList<>();
    
	//método exibição
    public static void exibir(List<Integer> lista) {
        for (Integer item : lista) {
            System.out.println(item);
        }
    }
    
    //método exibição repetidos
    
   public static void exibirValoresRepetidos(List<List<Integer>> listaGenerica) {
    List<Integer> primeiraLista = listaGenerica.get(0);
    List<Integer> segundaLista = listaGenerica.get(1);

    for (Integer valor : primeiraLista) {
        if (segundaLista.contains(valor) && !listaRepeteTodos.contains(valor)) {
            listaRepeteTodos.add(valor);
        }
    }

    for (int i = 2; i < listaGenerica.size(); i++) {
        List<Integer> listaInterna = listaGenerica.get(i);
        List<Integer> novaListaRepeteTodos = new ArrayList<>();
        for (Integer valor : listaRepeteTodos) {
            if (listaInterna.contains(valor)) {
                novaListaRepeteTodos.add(valor);
            }
        }
        listaRepeteTodos = novaListaRepeteTodos;
    }

    // Se listaRepeteTodos estiver vazia, mostrar mensagem e sair do método
    if (listaRepeteTodos.isEmpty()) {
        System.out.println("Não há números que se repetem em todas as listas.");
    } else {
        // Exibir os valores que aparecem em todas as listas internas
        System.out.println("Valores que aparecem em todas as listas:");
        exibir(listaRepeteTodos);
    }
}

    
   public static void mostrarNumerosUnicos(List<List<Integer>> listaGenerica) {
    for (List<Integer> listaInterna : listaGenerica) {
        for (int i = 0; i < listaInterna.size(); i++) {
            Integer valor = listaInterna.get(i);
            if (!listaRepeteTodos.contains(valor) && !listaLixeira.contains(valor) && !listaUnica.contains(valor)) {
                listaUnica.add(valor);
            } else if (listaUnica.contains(valor)) {
                listaLixeira.add(valor);
                listaUnica.remove(valor); // Remover o número de listaUnica se já estiver presente
                i--; // Reduzir o índice para reprocessar o item removido
            }
        }
    }

    // Exibir os valores que aparecem somente em uma das listas internas
    System.out.println("Valores que aparecem somente em uma lista:");
    exibir(listaUnica);
}

    
    //Principal
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
        
     // Exibir valores que aparecem em todas as listas internas
        exibirValoresRepetidos(listaGenerica);

/// Exibir valores que aparecem apenas uma vez
        mostrarNumerosUnico(listaGenerica)
    }
    
}
