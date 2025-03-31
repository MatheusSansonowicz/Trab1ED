package trabalho;

public class Numero {
    private int valor;
    private int numeroAparicoes;

    public Numero(int valor) {
        this.valor = valor;
        this.numeroAparicoes = 1; // Inicialmente, o número aparece uma vez
    }

    public int getValor() {
        return valor;
    }

    public int getNumeroAparicoes() {
        return numeroAparicoes;
    }

    public void incrementarAparicoes() {
        this.numeroAparicoes++;
    }
}
