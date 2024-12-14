
package HistoriaJogo;


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

