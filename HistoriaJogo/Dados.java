package HistoriaJogo;

import java.util.Random;

public class Dados {
    private static Random random = new Random();

    public static int rolar(int faces) {
        return random.nextInt(faces) + 1;
    }
}
