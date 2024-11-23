package HistoriaJogo;

/**
 *
 * @author MATHEUSBRAGAMATTOS
 */
import java.util.List;

public interface Personagem {
    void rolarAtributos(); // Rolagem dos atributos do personagem
    void atacar(Monstro monstro); // Ataque no monstro
    void usarMagia(); // Para classes como Mago
    void usarItem(); // Usar um item como poção de cura
    void fugir(); // Fugir de uma batalha

    int getForca(); 
    int getVida(); 
    int getMana();
    int getAgilidade();
    String getNome();
    void sofrerDano(int dano); // Método para sofrer dano

    void adicionarItem(Item item); // Adicionar item ao inventário
    List<Item> getInventario(); // Recuperar o inventário
}
