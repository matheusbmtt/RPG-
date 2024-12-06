/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package HistoriaJogo;

/**
 *
 * @author MATHEUSBRAGAMATTOS
 */
import java.util.Random;

public class Dados {
    private static Random random = new Random();

    public static int rolar(int faces) {
        return random.nextInt(faces) + 1;
    }
}
