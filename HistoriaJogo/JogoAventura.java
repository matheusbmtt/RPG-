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
import java.util.Scanner;

public class JogoAventura {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Personagem personagem = criarPersonagem(scanner);
        jogo(personagem, scanner);
    }

    private static Personagem criarPersonagem(Scanner scanner) {
        System.out.println("Digite o nome do seu personagem:");
        String nome = scanner.nextLine();

        System.out.println("Escolha sua classe:");
        System.out.println("1 - Guerreiro");
        System.out.println("2 - Mago");
        System.out.println("3 - Arqueiro");

        int classeEscolhida = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer de entrada

        Personagem personagem = null;

        switch (classeEscolhida) {
            case 1:
                personagem = new Guerreiro(nome);
                break;
            case 2:
                personagem = new Mago(nome);
                break;
            case 3:
                personagem = new Arqueiro(nome);
                break;
            default:
                System.out.println("Classe inválida. Você será um Guerreiro por padrão.");
                personagem = new Guerreiro(nome);
                break;
        }

        personagem.sortearForca();
        personagem.sortearVida();
        personagem.sortearMana();

        return personagem;
    }

    private static void jogo(Personagem personagem, Scanner scanner) {
        while (personagem.getVida() > 0) {
            System.out.println("\nEscolha uma ação:");
            System.out.println("1 - Ir para a vila");
            System.out.println("2 - Enfrentar um monstro");
            System.out.println("3 - Ver atributos");
            System.out.println("4 - Sair do jogo");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada

            switch (escolha) {
                case 1:
                    irParaVila(personagem, scanner);
                    break;
                case 2:
                    enfrentarMonstro(personagem, scanner);
                    break;
                case 3:
                    personagem.mostrarAtributos();
                    break;
                case 4:
                    System.out.println("Saindo do jogo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }

        System.out.println("Você morreu! Fim de jogo.");
    }

    private static void irParaVila(Personagem personagem, Scanner scanner) {
        System.out.println("Você chegou na vila.");

        System.out.println("1 - Comprar uma arma");
        System.out.println("2 - Falar com o mestre da vila");
        System.out.println("3 - Voltar");

        int escolhaVila = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer de entrada

        switch (escolhaVila) {
            case 1:
                comprarArma(personagem, scanner);
                break;
            case 2:
                falarComOMestre(personagem);
                break;
            case 3:
                System.out.println("Voltando ao jogo...");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void comprarArma(Personagem personagem, Scanner scanner) {
        System.out.println("O que você deseja comprar?");
        System.out.println("1 - Espada (para Guerreiro)");
        System.out.println("2 - Arco (para Arqueiro)");
        System.out.println("3 - Cajado (para Mago)");

        int escolhaArma = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer de entrada

        if (escolhaArma == 1 && !(personagem instanceof Guerreiro)) {
            System.out.println("Você não pode comprar a Espada. Apenas Guerreiros podem equipá-la.");
        } else if (escolhaArma == 2 && !(personagem instanceof Arqueiro)) {
            System.out.println("Você não pode comprar o Arco. Apenas Arqueiros podem equipá-lo.");
        } else if (escolhaArma == 3 && !(personagem instanceof Mago)) {
            System.out.println("Você não pode comprar o Cajado. Apenas Magos podem equipá-lo.");
        } else {
            switch (escolhaArma) {
                case 1:
                    personagem.usarArma("Espada");
                    break;
                case 2:
                    personagem.usarArma("Arco");
                    break;
                case 3:
                    personagem.usarArma("Cajado");
                    break;
            }
        }
    }

    private static void falarComOMestre(Personagem personagem) {
        System.out.println("O mestre da vila lhe oferece poções.");
        System.out.println("1 - Poção de Vida");
        System.out.println("2 - Poção de Força");

        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        switch (escolha) {
            case 1:
                personagem.usarPoção("Poção de Vida");
                break;
            case 2:
                personagem.usarPoção("Poção de Força");
                break;
            default:
                System.out.println("Escolha inválida!");
        }
    }

    private static void enfrentarMonstro(Personagem personagem, Scanner scanner) {
        System.out.println("Você se deparou com um monstro feroz! Deseja lutar?");
        System.out.println("1 - Sim");
        System.out.println("2 - Não");

        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        if (escolha == 1) {
            Random rand = new Random();
            int vidaMonstro = 55;  // Vida do monstro fixada em 55
            System.out.println("O monstro tem " + vidaMonstro + " de vida.");

            while (vidaMonstro > 0 && personagem.getVida() > 0) {
                System.out.println("\nEscolha sua ação:");
                System.out.println("1 - Atacar");
                System.out.println("2 - Fugir");

                int acaoBatalha = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha

                switch (acaoBatalha) {
                    case 1:
                        int dano = atacar(personagem); // Dano sorteado
                        System.out.println("Você causou " + dano + " de dano!");
                        vidaMonstro -= dano;

                        // Exibir a vida do monstro e do personagem após o ataque
                        System.out.println("Vida do monstro: " + vidaMonstro);
                        System.out.println("Sua vida: " + personagem.getVida());

                        if (vidaMonstro <= 0) {
                            System.out.println("Você derrotou o monstro!");
                            return;
                        }

                        // Monstro ataca
                        int danoMonstro = rand.nextInt(6) + 5; // Dano do monstro entre 5 e 10
                        System.out.println("O monstro causou " + danoMonstro + " de dano!");
                        personagem.receberDano(danoMonstro);

                        // Exibir a vida do monstro e do personagem após o ataque do monstro
                        System.out.println("Vida do monstro: " + vidaMonstro);
                        System.out.println("Sua vida: " + personagem.getVida());

                        if (personagem.getVida() <= 0) {
                            System.out.println("Você foi derrotado pelo monstro!");
                            return;
                        }
                        break;
                    case 2:
                        System.out.println("Você fugiu da batalha.");
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            }
        } else {
            System.out.println("Você fugiu da batalha.");
        }
    }

    private static int atacar(Personagem personagem) {
        // Sorteia o dano do ataque do jogador
        Scanner scanner = new Scanner(System.in);
        System.out.println("Aperte ENTER para atacar...");
        scanner.nextLine(); // Aguarda o ENTER

        Random rand = new Random();
        int dano = rand.nextInt(personagem.getForca()) + 1; // Sorteia o dano com base na força do personagem
        return dano;
    }
}
