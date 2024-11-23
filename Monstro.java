package HistoriaJogo;

/**
 *
 * @author MATHEUSBRAGAMATTOS
 */
public class Monstro {
    private String nome;
    private int vida;
    private int forca;

    public Monstro(String nome, int vida, int forca) {
        this.nome = nome;
        this.vida = vida;
        this.forca = forca;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getForca() {
        return forca;
    }

    public void sofrerDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) this.vida = 0;  // Garantir que a vida não fique negativa
    }

    public void atacar(Personagem personagem) {
        System.out.println(nome + " ataca " + personagem.getNome() + " causando " + forca + " de dano.");
        personagem.sofrerDano(forca);
    }
}
