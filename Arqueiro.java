package HistoriaJogo;

/**
 *
 * @author MATHEUSBRAGAMATTOS
 */
import java.util.ArrayList;
import java.util.List;

public class Arqueiro implements Personagem {
    private String nome;
    private int forca;
    private int vida;
    private int mana;
    private int agilidade;
    private List<Item> inventario; // Inventário de itens
    private Item arco; // Arco como item que pode aumentar o dano

    public Arqueiro(String nome) {
        this.nome = nome;
        this.inventario = new ArrayList<>();
    }

    @Override
    public void rolarAtributos() {
        // Rolagem dos atributos do Arqueiro
        this.forca = new Dados().rolarAtributo(2, 6);
        this.vida = new Dados().rolarAtributo(2, 8);
        this.mana = new Dados().rolarAtributo(1, 6);
        this.agilidade = new Dados().rolarAtributo(3, 6); // Arqueiro tem mais agilidade
    }

    @Override
    public void atacar(Monstro monstro) {
        int dano = forca + getDanoItens(); // Calcula o dano base + dano dos itens
        System.out.println(nome + " ataca com seu arco e causa " + dano + " de dano!");
        monstro.sofrerDano(dano);
    }

    @Override
    public void usarMagia() {
        System.out.println(nome + " não pode usar magia, classe Arqueiro.");
    }

    @Override
    public void usarItem() {
        System.out.println(nome + " usa um item de recuperação.");
        // Exemplo de uso de item para recuperação de vida
        this.vida += 20; // Recupera 20 pontos de vida
    }

    @Override
    public void fugir() {
        System.out.println(nome + " tenta fugir!");
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
        if (this.vida < 0) this.vida = 0;
    }

    @Override
    public void adicionarItem(Item item) {
        this.inventario.add(item);
        if (item.getNome().equals("Arco Mágico")) {
            this.arco = item; // Arco é um item específico para o Arqueiro
        }
    }

    @Override
    public List<Item> getInventario() {
        return inventario;
    }

    // Método para calcular o dano adicional com base nos itens no inventário
    private int getDanoItens() {
        int danoExtra = 0;
        for (Item item : inventario) {
            danoExtra += item.getDano(); // Adiciona o dano de cada item
        }
        return danoExtra;
    }
}
