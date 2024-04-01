package trabalho;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class OutroMétodo {

    public static void exibir(List<Integer> lista) {
        for (Integer item : lista) {
            System.out.println(item);
        }
    }

    public static Map<Integer, Numero> contarAparicoes(List<List<Integer>> listaGenerica) {
        Map<Integer, Numero> numeros = new HashMap<>();

        for (List<Integer> listaInterna : listaGenerica) {
            for (Integer valor : listaInterna) {
                if (!numeros.containsKey(valor)) {
                    numeros.put(valor, new Numero(valor));
                } else {
                    numeros.get(valor).incrementarAparicoes();
                }
            }
        }

        return numeros;
    }

    public static void exibirValoresEmTodasListas(List<List<Integer>> listaGenerica) {
        Map<Integer, Numero> numeros = contarAparicoes(listaGenerica);

        System.out.println("Valores presentes em todas as listas:");
        for (Numero numero : numeros.values()) {
            if (numero.getNumeroAparicoes() == listaGenerica.size()) {
                System.out.println(numero.getValor());
            }
        }
    }

    public static void exibirNumerosUnicos(List<List<Integer>> listaGenerica) {
        Map<Integer, Numero> numeros = contarAparicoes(listaGenerica);

        System.out.println("Valores que aparecem em somente uma lista:");
        for (Numero numero : numeros.values()) {
            if (numero.getNumeroAparicoes() == 1) {
                System.out.println(numero.getValor());
            }
        }
    }

    public static void main(String[] args) {
        Random gerador = new Random();

        List<List<Integer>> listaGenerica = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            List<Integer> listaInterna = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                int valor = gerador.nextInt(4);
                if (!listaInterna.contains(valor)) {
                    listaInterna.add(valor);
                }
            }
            listaGenerica.add(listaInterna);
        }

        
        for (List<Integer> listaInterna : listaGenerica) {
            System.out.println("Exibindo a lista " + listaGenerica.indexOf(listaInterna));
            exibir(listaInterna);
            
        }

        exibirValoresEmTodasListas(listaGenerica);
        exibirNumerosUnicos(listaGenerica);
    }
}
