package HistoriaJogo;

/**
 *
 * @author MATHEUSBRAGAMATTOS
 */
import java.util.ArrayList;
import java.util.List;

public class Guerreiro implements Personagem {
    private String nome;
    private int forca;
    private int vida;
    private int mana;
    private int agilidade;
    private List<Item> inventario; // Inventário para armazenar os itens

    public Guerreiro(String nome) {
        this.nome = nome;
        this.inventario = new ArrayList<>();
    }

    @Override
    public void rolarAtributos() {
        // Rola os atributos
        // Exemplo: rolando dados para força, vida, mana, etc.
    }

    @Override
    public void atacar(Monstro monstro) {
        int dano = forca; // Dano base do guerreiro
        for (Item item : inventario) {
            dano += item.getDano(); // Adiciona dano dos itens no inventário
        }
        System.out.println(nome + " ataca com espada causando " + dano + " de dano!");
        monstro.sofrerDano(dano);
    }

    @Override
    public void usarMagia() {
        // Magias não implementadas para Guerreiro
    }

    @Override
    public void usarItem() {
        System.out.println(nome + " usa um item do inventário.");
    }

    @Override
    public void fugir() {
        System.out.println(nome + " foge da batalha.");
    }

    @Override
    public int getForca() {
        return forca;
    }

    @Override
    public int getVida() {
        return vida;
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public int getAgilidade() {
        return agilidade;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void sofrerDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) {
            this.vida = 0;
        }
    }

    @Override
    public void adicionarItem(Item item) {
        this.inventario.add(item); // Adiciona o item ao inventário
    }

    @Override
    public List<Item> getInventario() {
        return inventario; // Retorna o inventário do personagem
    }
}
