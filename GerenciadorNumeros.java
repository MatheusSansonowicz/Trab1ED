package trabalho;

public class GerenciadorNumeros {

    public static List<Numero> contarAparicoes(List<List<Integer>> listaGenerica) {
        List<Numero> numeros = new ArrayList<>();

        for (List<Integer> listaInterna : listaGenerica) {
            for (Integer valor : listaInterna) {
                Numero numero = encontrarNumero(numeros, valor);
                if (numero == null) {
                    numeros.add(new Numero(valor));
                } else {
                    numero.incrementarAparicoes();
                }
            }
        }

        return numeros;
    }

    private static Numero encontrarNumero(List<Numero> numeros, int valor) {
        for (Numero numero : numeros) {
            if (numero.getValor() == valor) {
                return numero;
            }
        }
        return null;
    }
}