package HistoriaJogo;

/**
 *
 * @author MATHEUSBRAGAMATTOS
 */
public class Item {
    private String nome;
    private int dano; // Dano adicional fornecido pelo item

    public Item(String nome, int dano) {
        this.nome = nome;
        this.dano = dano;
    }

    public String getNome() {
        return nome;
    }

    public int getDano() {
        return dano;
    }
}
