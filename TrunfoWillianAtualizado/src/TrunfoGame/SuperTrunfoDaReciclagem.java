package TrunfoGame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author arthur souza - 19102583
 * @author william rodrigues - 19100835
 */
public class SuperTrunfoDaReciclagem {

    public static void main(String[] args) throws IOException {
        menu();                                                                 //chama o menu
    }

    public static void menu() {
        exibirQuebra();
        Scanner teclado = new Scanner(System.in);                               //Teclado para leitura 
        int j, i = 1, auxiliar = 0;                                             //Variaveis auxiliares
        Jogador jogadorAuxiliar;                                                //Variavel auxiliar para incluir
        ArrayList<Jogador> jogadores = new ArrayList<Jogador>();                //Lista de jogadores
        Baralho baralho = new Baralho("File/dados.csv");                        //Baralho com as cartas
        while (i != 0)                                                          //Exibe menu e pega opcao
        {
            System.out.println("- 1 - Instrucoes");
            System.out.println("- 2 - Inserir Jogadores");
            System.out.println("- 3 - Jogar");
            System.out.println("- 0 - Sair");
            do {
                System.out.println("- Insira a opcao: ");
                i = teclado.nextInt();
            } while (i < 0 || i > 3);
            switch (i) {
                case 1:
                    instrucoes();                                               //Chama as instrucoes
                    break;
                case 2:                                                         //Salva os jogadores com nomes
                    do {
                        System.out.println("- Quantos jogadores (2 a 4)?");
                        auxiliar = teclado.nextInt();
                    } while (auxiliar < 2 || auxiliar > 4);
                    String nomeAux;
                    for (j = 0; j < auxiliar; j++) {
                        System.out.println("- Digite o nome do jogador " + (j + 1) + ":");
                        nomeAux = teclado.next();
                        jogadorAuxiliar = new Jogador(nomeAux);                 //Salva os jogadores no array
                        jogadores.add(jogadorAuxiliar);
                        System.out.println("- Jogador adicionado!");
                    }
                    break;
                case 3:                                                         //Inicia o jogo se houver jogadores
                    if (!jogadores.isEmpty()) {
                        iniciarJogo(jogadores, baralho);
                    } else {
                        System.out.println("- Nao ha jogadores");
                    }
                    break;
                case 0:
                    teclado.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("- Opcao invalida");
                    System.out.println("- Fechando para evitar erros");
                    teclado.close();
                    System.exit(0);
            }
        }
    }

    public static void exibirQuebra() {                                         //printa a quebra entre informacoes
        System.out.println("---------------------------------------------------");
    }

    public static void iniciarJogo(ArrayList<Jogador> jogadores, Baralho baralho) {
        exibirQuebra();
        ArrayList<Carta> cartasDaRodada = new ArrayList<Carta>();               //array de cartas jogadas na mesa
        int i, j;                                                               //variaveis auxiliares
        Random r = new Random();                                                //numero aleatorio
        int aleatorio = r.nextInt(jogadores.size());                            //gera o primeiro jogador
        System.out.println("- Os jogadores receberao: " + Math.floor(32 / jogadores.size()) + " cartas");
        for (i = 0; i < jogadores.size(); i++) {                                //distribui as cartas do baralho
            for (j = 1; j <= Math.floor(32 / jogadores.size()); j++) {          //32 cartas / numero de jogadores; o floor arredonda pra baixo quando for 3
                jogadores.get(i).incluir(baralho.selecionaCarta());             //2 j : 16 c/j ; 3 j : 10 c/j ; 4 j : 8 c/j
            }                                                                   //Tira do baralho de forma aleatoria e passa pra mao dos jogadores
        }
        status(jogadores);                                                      //imprime o andamento do jogo
        for (i = 0; i < jogadores.size(); i++) {
            cartasDaRodada.add(jogadores.get(i).excluir());                     //Adiciona os topos dos jogadores no array de cartas da mesa
        }
        System.out.println("- O jogador " + jogadores.get(aleatorio).nome() + " vai começar");
        System.out.println("- Sua carta é: ");                                  //mostra o primeiro a jogar e sua carta do topo do baralho
        System.out.println(cartasDaRodada.get(aleatorio));
        i = menuModo();                                                         //Pega o modo de jogo que ele escolheu
        jogo(jogadores, i, 0, cartasDaRodada);                                  //Continua as demais rodadas
    }

    public static void jogo(ArrayList<Jogador> jogadores, int modoDeJogo, int numeroRodadas, ArrayList<Carta> cartasDaRodada) {
        exibirQuebra();
        Random r = new Random();                                                //Numero random
        int numeroRodada = numeroRodadas;                                       //contador de rodadas
        int i, vencedor, coringa = 0;                                           //variaveis auxiliares
        boolean empate = false;                                                 //flag pra empate
        do {
            if (empate) {                                                       //se esta empatado
                System.out.println("- Empate identificado");
                jogadores = testaJogadores(jogadores);                          //testa quem ainda tem carta pra rodada de desempate
                System.out.println("- Distribuindo cartas novas");              //joga as cartas novas na mesa
                for (i = 0; i < jogadores.size(); i++) //Pega as novas cartas
                {
                    cartasDaRodada.add(0, jogadores.get(i).excluir());
                }
                System.out.println("- Reiniciando rodada " + numeroRodada);
            } else {                                                            //se nao esta empatado
                numeroRodada = numeroRodadas + 1;
                System.out.println("- Iniciando rodada " + numeroRodada);
                System.out.println("- Jogando cartas na mesa...");
            }
            //adicionar pra poder escolher o modo de jogo
            //modoDeJogo = menuModo();
            empate = false;
            vencedor = 0;
            status(jogadores);                                                  //Imprime o andamento
            System.out.print("- Atributo da rodada: ");
            switch (modoDeJogo) {
                case 0:                                                         //rodada sobre decomposicao
                    System.out.println("Decomposição");
                    mostrarCartas(cartasDaRodada, jogadores, 0);
                    for (i = 1; i < jogadores.size(); i++) {                    //encontra a menor decomposicao das cartas
                        if (cartasDaRodada.get(vencedor).comparaDecomposicao(cartasDaRodada.get(i)) == -1) {
                            vencedor = i;
                            empate = false;
                        }
                    }
                    for (i = 0; i < jogadores.size(); i++) {                    //testa se nao ha empate na menor decomposicao com as cartas da mesa
                        if (vencedor != i) {                                    //se nao for a carta vencedora com ela mesma, existe um empate
                            if (cartasDaRodada.get(vencedor).comparaDecomposicao(cartasDaRodada.get(i)) == 0) {
                                empate = true;
                            }
                        }
                    }
                    break;
                case 1:                                                         //rodada sobre reciclabilidade
                    vencedor = 0;
                    System.out.println("Reciclabilidade");
                    mostrarCartas(cartasDaRodada, jogadores, 1);
                    for (i = 1; i < jogadores.size(); i++) {                    //encontra a carta reciclavel
                        if (cartasDaRodada.get(vencedor).comparaReciclavel(cartasDaRodada.get(i)) == -1) {
                            vencedor = i;
                            empate = false;
                        }
                    }
                    for (i = 0; i < jogadores.size(); i++) {                    //testa se nao tem mais de uma reciclavel na mesa
                        if (vencedor != i) {                                    //se nao for ela mesma, existe um empate
                            if (cartasDaRodada.get(vencedor).comparaReciclavel(cartasDaRodada.get(i)) == 0) {
                                empate = true;
                            }
                        }
                    }
                    break;
                case 2:                                                         //rodada de ataque
                    vencedor = 0;
                    System.out.println("Ataque");
                    mostrarCartas(cartasDaRodada, jogadores, 2);
                    for (i = 1; i < jogadores.size(); i++) {                    //encontra o maior ataque na mesa
                        if (cartasDaRodada.get(vencedor).comparaAtaque(cartasDaRodada.get(i)) == -1) {
                            vencedor = i;
                            empate = false;
                        }
                    }
                    for (i = 0; i < jogadores.size(); i++) {                    //testa se nao tem um ataque igual na mesa
                        if (vencedor != i) {                                    //se nao for ela mesma, existe um empate
                            if (cartasDaRodada.get(vencedor).comparaAtaque(cartasDaRodada.get(i)) == 0) {
                                empate = true;
                            }
                        }
                    }
                    break;
                case 3:                                                         //rodada de cores
                    vencedor = 0;
                    System.out.println("Cor");
                    mostrarCartas(cartasDaRodada, jogadores, 3);
                    for (i = 1; i < jogadores.size(); i++) {                    //pega a cor que ganha das outras
                        if (cartasDaRodada.get(vencedor).comparaCor(cartasDaRodada.get(i)) == -1) {
                            vencedor = i;
                            empate = false;
                        }
                    }
                    for (i = 0; i < jogadores.size(); i++) {                    //testa se nao tem um empate
                        if (vencedor != i) {                                    //se nao for ela mesma, existe um empate
                            if (cartasDaRodada.get(vencedor).comparaCor(cartasDaRodada.get(i)) == 0) {
                                empate = true;
                            }
                        }
                    }
                    break;
                default:
                    break;
            }
            modoDeJogo = r.nextInt(4);                                          //testa coringa retorna 5 se ele venceu, ou o indice do vencedor
            coringa = testaCoringas(cartasDaRodada, jogadores.size());          //testa o coringa
            if (coringa == 5) {                                                 //se o coringa venceu
                for (i = 0; i < jogadores.size(); i++) {                        //localiza ele na mesa
                    if (cartasDaRodada.get(i).getCodigo().equals("H3")) {
                        empate = false;
                        vencedor = i;
                    }
                }
            } else if (coringa >= 0 && coringa <= 3) {                          //se ha um coringa na mesa
                vencedor = coringa;                                             //mas ele perdeu, atualiza pro indice do vencedor
                empate = false;
            }
        } while (empate != false);

        System.out.print("* Vencedor da rodada: ");
        System.out.println(jogadores.get(vencedor).nome());                     //exibe o vencedor da rodada
        for (i = 0; i < cartasDaRodada.size(); i++) {
            jogadores.get(vencedor).incluir(cartasDaRodada.get(i));             //adiciona as cartas da rodada no vencedor
        }
        System.out.println("- Resumo da rodada");
        status(jogadores);                                                      //mostra o andamento do jogo
        System.out.println("- Pressione ENTER para continuar...");
        try {
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(SuperTrunfoDaReciclagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        jogadores = testaJogadores(jogadores);                                  //Testa quem ainda esta no jogo 
        cartasDaRodada.clear();                                                 //reseta as cartas da mesa
        for (i = 0; i < jogadores.size(); i++)                                  //Pega as novas cartas da mesa
        {
            cartasDaRodada.add(jogadores.get(i).excluir());
        }
        jogo(jogadores, r.nextInt(4), numeroRodada, cartasDaRodada);            //repete o jogo

    }

    public static int testaCoringas(ArrayList<Carta> cartasDaRodada, int tamanho) {
        //Retorna 5 se ha um coringa entre as cartas e ele venceu
        //Retorna 6 se nao ha um coringa entre as cartas
        //Retorna x/indice se ha um coringa as cartas e ele perdeu para a carta no x/indice
        //Se houver mais de um terminado em 1, o primeiro identificado ganha
        for (int i = 0; i < tamanho; i++) {                                     //Roda pra achar o coringa
            if (cartasDaRodada.get(i).getCodigo().equals("H3")) {               //Se acha o coringa
                System.out.println("- Ha um coringa na mesa");
                for (int j = 0; j < tamanho; j++) {                             //Roda pra comparar o coringa
                    if(cartasDaRodada.get(j).getCodigo().equals("A1")) {
                        return j;
                    } else if (cartasDaRodada.get(j).getCodigo().equals("B1")) {
                        return j;
                    } else if (cartasDaRodada.get(j).getCodigo().equals("C1")) {
                        return j;
                    } else if (cartasDaRodada.get(j).getCodigo().equals("D1")) {
                        return j;
                    } else if (cartasDaRodada.get(j).getCodigo().equals("E1")) {
                        return j;
                    } else if (cartasDaRodada.get(j).getCodigo().equals("F1")) {
                        return j;
                    } else if (cartasDaRodada.get(j).getCodigo().equals("H1")) {
                        return j;
                    } else if (cartasDaRodada.get(j).getCodigo().equals("G1")) {
                        return j;
                    }
                }
                return 5;
            }
        }
        return 6;
    }

    public static ArrayList<Jogador> testaJogadores(ArrayList<Jogador> jogadores) {
        ArrayList<Jogador> novaLista = new ArrayList<Jogador>();
        for (int i = 0; i < jogadores.size(); i++) {
            if (jogadores.get(i).numeroDeCartas() == 0) {                       //Se o jogador nao tiver cartas
                System.out.println("- Aparentemente o jogador " + jogadores.get(i).nome() + " ficou sem cartas");
                System.out.println("- O jogo continuará com os demais");        //Eh deixado de fora na nova lista
            } else {
                novaLista.add(jogadores.get(i));                                //Se ele tem cartas, eh adicionado na nova lista
            }
        }
        if (novaLista.size() == 1) {
            finaliza(novaLista.get(0));                                         //Se houver somente 1 jogador, finaliza o jogo
        }
        return novaLista;                                                       //Retorna a lista de quem ainda esta no jogo
    }

    public static void finaliza(Jogador vencedor) {                             //exibe o vencedor e volta pro menu
        System.out.println("- Pressione ENTER para finalizar");
        exibirQuebra();
        try {
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(SuperTrunfoDaReciclagem.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("- Parabéns " + vencedor.nome() + ", você ganhou o jogo");
        System.out.println("- Sua carta da sorte é: ");
        System.out.println(vencedor.listar().toString());
        System.out.println("- Fique a vontade para jogar de novo com seus amigos");
        System.out.println("- Pressione ENTER para continuar...");
        try {
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(SuperTrunfoDaReciclagem.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        menu();
    }

    public static void instrucoes() {                                           //exibe as instrucoes
        exibirQuebra();
        System.out.println("- Seja bem vindo ao Super Trunfo da Reciclagem - ");
        System.out.println("- Primeiro, insira o numero de jogadores para poder jogar");
        System.out.println("- Cada jogador recebera cartas de forma aleatória");
        System.out.println("- A cada rodada, o atributo a ser comparado é escolhido também de forma aleatória");
        System.out.println("- Os atributos sao: Decomposicao, Reciclabilidade, Ataque e Cor");
        System.out.println("- Caso o jogador ganhe a rodada, ele ganhará a carta do(s) adversário(s)");
        System.out.println("- O jogador com todas as cartas ganha o jogo");
        System.out.println("- Boa sorte!");
        System.out.println("- Pressione ENTER para voltar");                    //implementa a funcionalidade do enter pra continuar
        try {                                                                   
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(SuperTrunfoDaReciclagem.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void status(ArrayList<Jogador> jogadores) {
        System.out.print("- Jogadores ");                                       //Exibe o nome dos jogadores da partida
        for (int i = 0; i < jogadores.size(); i++) {                            //Exibe a quantidade de cartas deles
            System.out.print(" |" + jogadores.get(i).nome() + ":" + jogadores.get(i).numeroDeCartas() + " cartas|");
        }
        System.out.println();
    }

    public static int menuModo() {                                              //menu de opcoes pra primeira jogada
        int i = 0;
        Scanner entrada = new Scanner(System.in);
        do {
            System.out.println("- Escolha o atributo a ser comparado");
            System.out.println("- 0 - Decomposicao");
            System.out.println("- 1 - Reciclabilidade");
            System.out.println("- 2 - Ataque");
            System.out.println("- 3 - Cor");
            System.out.println("- Insira a opcao:");
            i = entrada.nextInt();
        } while (i < 0 || i > 3);
        return i;
    }

    public static void mostrarCartas(ArrayList<Carta> cartasDaRodada, ArrayList<Jogador> jogadores, int modoDeJogo) {
        System.out.println("- Cartas na mesa (" + cartasDaRodada.size() + ")");
        for (int i = 0; i < jogadores.size(); i++) {                            //exibe as cartas de acordo com o modo de jogo selecionado
            System.out.print("* Carta do " + jogadores.get(i).nome() + ": ");
            switch (modoDeJogo) {
                case 0:
                    System.out.println("Codigo - " + cartasDaRodada.get(i).getCodigo() + ", Decomposicao - " + cartasDaRodada.get(i).getDecomposicao());
                    break;
                case 1:
                    System.out.println("Codigo - " + cartasDaRodada.get(i).getCodigo() + ", Reciclabilidade - " + cartasDaRodada.get(i).ehReciclavel());
                    break;
                case 2:
                    System.out.println("Codigo - " + cartasDaRodada.get(i).getCodigo() + ", Ataque - " + cartasDaRodada.get(i).getAtaque());
                    break;
                case 3:
                    System.out.println("Codigo - " + cartasDaRodada.get(i).getCodigo() + ", Cor - " + cartasDaRodada.get(i).getCor());
                    break;
                default:
                    break;
            }
        }
    }
}
