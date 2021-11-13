package TrunfoGame;

import java.util.ArrayList;

/**
 * @author arthur souza - 19102583
 * @author william rodrigues - 19100835
 */
public class Jogador {

    private String nome;
    private ArrayList<Carta> cartas;
    
    Jogador(String n) {
        this.nome = n;
        this.cartas = new ArrayList<Carta>();
    }

    public String nome() {
        return nome;
    }

    public int numeroDeCartas() {
        return cartas.size();
    }

    public void incluir(Carta nova) {
        cartas.add(cartas.size(), nova);
    }

    public Carta listar() {
        return cartas.get(0);
    }

    public Carta excluir() {
        return cartas.remove(0);
    }

    public boolean temCartas() {
        return !(cartas.isEmpty());
    }
}
