package HistoriaJogo;

/**
 *
 * @author MATHEUSBRAGAMATTOS
 */
import java.util.Scanner;

public class Jogo {
    private Personagem personagem;
    private Monstro monstro;
    private Scanner scanner;

    public Jogo() {
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("Bem-vindo ao Mundo de Eldoria, um reino de magia e monstros.");

        // Introdução e Escolha do Nome
        System.out.print("Qual é o seu nome, aventureiro? ");
        String nome = scanner.nextLine();

        // Escolher classe
        System.out.println("Escolha a sua classe de aventureiro:");
        System.out.println("1. Guerreiro");
        System.out.println("2. Mago");
        System.out.println("3. Arqueiro");
        int escolhaClasse = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha

        switch (escolhaClasse) {
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
                System.out.println("Escolha inválida! Você será um Guerreiro por padrão.");
                personagem = new Guerreiro(nome);
        }

        personagem.rolarAtributos(); // Rola os atributos do personagem

        // Começar a história
        comecarAventura();
    }

    public void comecarAventura() {
        System.out.println("\nVocê acorda em um lindo jardim, onde o cheiro das flores enche o ar.");
        System.out.println("O dia está claro e você tem várias opções para começar sua jornada.");
        System.out.println("1. Ir para a aldeia.");
        System.out.println("2. Ir ao mercado.");
        System.out.println("3. Visitar o curandeiro.");
        System.out.println("4. Seguir para a floresta misteriosa.");

        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        switch (escolha) {
            case 1:
                aldeia();
                break;
            case 2:
                mercado();
                break;
            case 3:
                encontrarCurandeiro();
                break;
            case 4:
                floresta();
                break;
            default:
                System.out.println("Escolha inválida! Você decide descansar um pouco no jardim.");
                comecarAventura();
                break;
        }
    }

    public void aldeia() {
        System.out.println("\nVocê chega à aldeia, onde os aldeões trabalham em seus afazeres diários.");
        System.out.println("Você pode visitar várias lojas ou conversar com os moradores.");
        System.out.println("1. Falar com o mercador.");
        System.out.println("2. Visitar o ferreiro.");
        System.out.println("3. Voltar ao jardim.");
        System.out.println("4. Seguir para a floresta.");

        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        switch (escolha) {
            case 1:
                mercado();
                break;
            case 2:
                System.out.println("O ferreiro oferece uma espada de ferro. Talvez você precise dela mais tarde.");
                aldeia();
                break;
            case 3:
                comecarAventura();
                break;
            case 4:
                floresta();
                break;
            default:
                System.out.println("Escolha inválida. Você decide retornar ao jardim.");
                comecarAventura();
                break;
        }
    }

    public void mercado() {
        System.out.println("\nVocê entra no mercado. Várias barracas estão cheias de mercadorias.");
        System.out.println("O mercador lhe oferece alguns itens e poções.");
        System.out.println("1. Comprar poções de cura.");
        System.out.println("2. Comprar uma espada mágica (Apenas para Guerreiro).");
        System.out.println("3. Comprar um feitiço de fogo (Apenas para Mago).");
        System.out.println("4. Comprar um arco (Apenas para Arqueiro).");
        System.out.println("5. Voltar ao jardim.");
        System.out.println("6. Ir para a floresta.");

        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        switch (escolha) {
            case 1:
                System.out.println("Você compra algumas poções de cura. Elas poderão ser úteis em batalha.");
                personagem.adicionarItem(new Item("Poção de Cura", 0)); // Poção de Cura, sem aumento de dano
                mercado();
                break;
            case 2:
                if (personagem instanceof Guerreiro) {
                    System.out.println("Você compra uma espada mágica. Agora está mais preparado para lutar.");
                    personagem.adicionarItem(new Item("Espada Mágica", 10)); // Espada Mágica aumenta o dano
                } else {
                    System.out.println("Apenas guerreiros podem comprar esta espada.");
                }
                mercado();
                break;
            case 3:
                if (personagem instanceof Mago) {
                    System.out.println("Você compra um feitiço de fogo. Agora pode causar mais dano com magia.");
                    personagem.adicionarItem(new Item("Feitiço de Fogo", 10)); // Feitiço de Fogo aumenta o dano
                } else {
                    System.out.println("Apenas magos podem comprar este feitiço.");
                }
                mercado();
                break;
            case 4:
                if (personagem instanceof Arqueiro) {
                    System.out.println("Você compra um arco. Agora pode atacar à distância com mais dano.");
                    personagem.adicionarItem(new Item("Arco", 8)); // Arco aumenta o dano
                } else {
                    System.out.println("Apenas arqueiros podem comprar este arco.");
                }
                mercado();
                break;
            case 5:
                comecarAventura();
                break;
            case 6:
                floresta();
                break;
            default:
                System.out.println("Escolha inválida. Você decide retornar ao jardim.");
                comecarAventura();
                break;
        }
    }

    // Método para encontrar o curandeiro e recuperar vida
    public void encontrarCurandeiro() {
        System.out.println("\nVocê encontrou o Curandeiro, um velho sábio da aldeia.");
        System.out.println("Ele oferece a você um poder de cura mágica em troca de uma pequena quantia de ouro.");
        System.out.println("1. Aceitar a cura.");
        System.out.println("2. Recusar a cura.");

        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (escolha == 1) {
            System.out.println("Você foi curado pelo Curandeiro!");
            personagem.sofrerDano(-50); // Cura 50 pontos de vida
            System.out.println("Você agora tem " + personagem.getVida() + " de vida.");
        } else {
            System.out.println("Você recusa a cura e segue sua jornada.");
        }

        // Depois de curado, o jogador tem controle sobre onde ir
        comecarAventura();
    }

    public void floresta() {
        System.out.println("\nVocê segue para a floresta. A luz do sol mal chega ao chão, e você sente a presença de algo estranho.");
        System.out.println("De repente, um monstro aparece diante de você!");
        monstro = new Monstro("Lobisomem", 50, 10); // Criação do monstro

        batalha();
    }

    public void batalha() {
        System.out.println("\nA batalha começa!");

        while (personagem.getVida() > 0 && monstro.getVida() > 0) {
            System.out.println("\nEscolha uma ação:");
            System.out.println("1. Atacar");
            System.out.println("2. Fugir");
            System.out.println("3. Usar Item");

            int escolha = scanner.nextInt();
            scanner.nextLine();  // Consumir a nova linha

            switch (escolha) {
                case 1:
                    personagem.atacar(monstro);
                    break;
                case 2:
                    fugir();
                    return;
                case 3:
                    usarItem();
                    break;
                default:
                    System.out.println("Escolha inválida.");
            }

            if (monstro.getVida() > 0) {
                monstro.atacar(personagem);
            }

            System.out.println("\nVocê tem " + personagem.getVida() + " de vida.");
            System.out.println(monstro.getNome() + " tem " + monstro.getVida() + " de vida.");
        }

        if (personagem.getVida() <= 0) {
            System.out.println(personagem.getNome() + " foi derrotado!");
            System.exit(0); 
        } else {
            System.out.println(monstro.getNome() + " foi derrotado!");
            System.exit(0); 
        }

        // Após a batalha, o jogador pode escolher o que fazer
        comecarAventura();
    }

    public void fugir() {
        System.out.println("\nVocê decide fugir da batalha!");
        System.exit(0); 
        comecarAventura(); // O jogador volta ao jardim ou a um ponto de escolha
    }

    public void usarItem() {
        System.out.println("\nVocê decide usar um item.");
        personagem.usarItem();
        batalha(); // Após usar o item, continua a batalha
    }
}
