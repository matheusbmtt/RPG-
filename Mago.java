package HistoriaJogo;

/**
 *
 * @author MATHEUSBRAGAMATTOS
 */
import java.util.ArrayList;
import java.util.List;

public class Mago implements Personagem {
    private String nome;
    private int forca;
    private int vida;
    private int mana;
    private int agilidade;
    private List<Item> inventario; // Inventário de itens
    private Item feitiço; // Feitiço como item que pode aumentar o dano

    public Mago(String nome) {
        this.nome = nome;
        this.inventario = new ArrayList<>();
    }

    @Override
    public void rolarAtributos() {
        // Rolagem dos atributos do Mago
        this.forca = new Dados().rolarAtributo(2, 6);
        this.vida = new Dados().rolarAtributo(2, 8);
        this.mana = new Dados().rolarAtributo(3, 6);
        this.agilidade = new Dados().rolarAtributo(1, 6); // Mago tem menos agilidade
    }

    @Override
    public void atacar(Monstro monstro) {
        int dano = forca + getDanoItens(); // Calcula o dano base + dano dos itens
        System.out.println(nome + " ataca com seu feitiço e causa " + dano + " de dano!");
        monstro.sofrerDano(dano);
    }

    @Override
    public void usarMagia() {
        if (mana > 0) {
            int danoMagia = 15 + getDanoItens(); // Feitiço com dano base de 15 + bônus de itens
            System.out.println(nome + " lança um feitiço poderoso, causando " + danoMagia + " de dano!");
            mana--; // Consome 1 de mana para usar o feitiço
        } else {
            System.out.println(nome + " não tem mana suficiente para lançar um feitiço.");
        }
    }

    @Override
    public void usarItem() {
        System.out.println(nome + " usa um item de recuperação.");
        // Exemplo de uso de item para recuperação de vida
        this.vida += 30; // Recupera 30 pontos de vida
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
        if (item.getNome().equals("Feitiço de Fogo")) {
            this.feitiço = item; // Feitiço de Fogo como item específico para o Mago
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
