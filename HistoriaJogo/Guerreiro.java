package HistoriaJogo;
import HistoriaJogo.Personagem;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// Guerreiro.java
// Guerreiro.java
public class Guerreiro implements Personagem {
    private String nome;
    private int forca;
    private int vida;
    private int mana;
    private String arma;

    public Guerreiro(String nome) {
        this.nome = nome;
        this.arma = "Nenhuma";
    }

    @Override
    public void sortearForca() {
        System.out.println("\nAperte ENTER para sortear a Força...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Aguarda o ENTER
        this.forca = (int) (Math.random() * 6) + 10; // Sorteia entre 10 e 15
        System.out.println("Força sorteada: " + this.forca);
    }

    @Override
    public void sortearVida() {
        System.out.println("\nAperte ENTER para sortear a Vida...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Aguarda o ENTER
        this.vida = (int) (Math.random() * 6) + 20; // Sorteia entre 20 e 25
        System.out.println("Vida sorteada: " + this.vida);
    }

    @Override
    public void sortearMana() {
        System.out.println("\nAperte ENTER para sortear a Mana...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Aguarda o ENTER
        this.mana = (int) (Math.random() * 3) + 5; // Sorteia entre 5 e 7
        System.out.println("Mana sorteada: " + this.mana);
    }

    @Override
    public void mostrarAtributos() {
        System.out.println("Força: " + this.forca);
        System.out.println("Vida: " + this.vida);
        System.out.println("Mana: " + this.mana);
        System.out.println("Arma equipada: " + this.arma);
    }

    @Override
    public int getForca() {
        return this.forca;
    }

    @Override
    public int getVida() {
        return this.vida;
    }

    @Override
    public int getMana() {
        return this.mana;
    }

    @Override
    public void receberDano(int dano) {
        this.vida -= dano;
    }

    @Override
    public void usarArma(String tipoArma) {
        if (tipoArma.equals("Espada")) {
            this.forca += 5;
            this.arma = "Espada";
            System.out.println("Você equipou a Espada! Força aumentada em 5.");
        }
    }

    @Override
    public void usarPoção(String tipoPoção) {
        if (tipoPoção.equals("Poção de Vida")) {
            this.vida += 10;
            System.out.println("Você usou uma Poção de Vida! Vida aumentada em 10.");
        } else if (tipoPoção.equals("Poção de Força")) {
            this.forca += 3;
            System.out.println("Você usou uma Poção de Força! Força aumentada em 3.");
        }
    }
}

