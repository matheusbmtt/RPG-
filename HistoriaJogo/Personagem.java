/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package HistoriaJogo;

/**
 *
 * @author MATHEUSBRAGAMATTOS
 */
// Personagem.java (Interface)
// Personagem.java (Interface)
public interface Personagem {
    void sortearForca();
    void sortearVida();
    void sortearMana();
    void mostrarAtributos();
    int getForca();
    int getVida();
    int getMana();
    void receberDano(int dano);
    void usarArma(String tipoArma);
    void usarPoção(String tipoPoção);
}

