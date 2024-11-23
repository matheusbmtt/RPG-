package HistoriaJogo;

/**
 *
 * @author MATHEUSBRAGAMATTOS
 */
import java.util.Random;

public class Dados {
    private Random random;

    public Dados() {
        this.random = new Random();
    }

    // Método para rolar um dado de N faces
    public int rolarDado(int faces) {
        return random.nextInt(faces) + 1;
    }

    // Método para rolar um dado para atributos
    public int rolarAtributo(int quantidadeDeDados, int faces) {
        int resultado = 0;
        for (int i = 0; i < quantidadeDeDados; i++) {
            resultado += rolarDado(faces);
        }
        return resultado;
    }
}

