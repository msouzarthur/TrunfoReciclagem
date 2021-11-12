package TrunfoGame;

/**
 * @author arthur souza - 19102583
 * @author william rodrigues - 19100835
 */
abstract class Carta {

    private String codigo;
    private String nome;
    private String descricao;
    private String tipo;
    private Cor cor;
    private double decomposicao;
    private int ataque;

    Carta(String cod, String n, String d, String t, Cor c, double dec, int a) {
        this.codigo = cod;
        this.nome = n;
        this.descricao = d;
        this.tipo = t;
        this.cor = c;
        this.decomposicao = dec;
        this.ataque = a;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getTipo() {
        return this.tipo;
    }

    public Cor getCor() {
        return this.cor;
    }

    public double getDecomposicao() {
        return this.decomposicao;
    }

    public int getAtaque() {
        return this.ataque;
    }

    public boolean ehReciclavel() {
        return false;
    }

    @Override
    public String toString() {
        return "-> Codigo: " + codigo + "\n-> Nome: " + nome + "\n-> Descricao: " + descricao + "\n-> Tipo: " + tipo + "\n-> Cor: " + cor + "\n-> Decomposicao: " + decomposicao + "\n-> Ataque: " + ataque;
    }

    public int comparaCor(Carta adversario) {
        if (this.cor.equals(adversario.cor)) {
            return 0;
        }
        if (this.cor == Cor.VERMELHO && adversario.cor == Cor.PRETO) {
            return 0;
        }
        if (this.cor == Cor.PRETO && adversario.cor == Cor.VERMELHO) {
            return 0;
        }
        if (this.cor == Cor.VERDE && (adversario.cor == Cor.MARROM
                || adversario.cor == Cor.CINZA
                || adversario.cor == Cor.PRETO
                || adversario.cor == Cor.BRANCO
                || adversario.cor == Cor.LARANJA)) {
            return 1;
        }
        if (this.cor == Cor.VERMELHO && (adversario.cor == Cor.MARROM
                || adversario.cor == Cor.VERDE
                || adversario.cor == Cor.AMARELO
                || adversario.cor == Cor.CINZA)) {
            return 1;
        }
        if (this.cor == Cor.AZUL && (adversario.cor == Cor.MARROM
                || adversario.cor == Cor.CINZA
                || adversario.cor == Cor.VERMELHO
                || adversario.cor == Cor.AMARELO
                || adversario.cor == Cor.VERDE)) {
            return 1;
        }
        if (this.cor == Cor.BRANCO && (adversario.cor == Cor.LARANJA
                || adversario.cor == Cor.ROXO
                || adversario.cor == Cor.AZUL
                || adversario.cor == Cor.VERMELHO
                || adversario.cor == Cor.AMARELO)) {
            return 1;
        }
        if (this.cor == Cor.ROXO && (adversario.cor == Cor.AZUL
                || adversario.cor == Cor.VERMELHO
                || adversario.cor == Cor.AMARELO
                || adversario.cor == Cor.VERDE
                || adversario.cor == Cor.MARROM)) {
            return 1;
        }
        if (this.cor == Cor.MARROM && (adversario.cor == Cor.CINZA
                || adversario.cor == Cor.PRETO
                || adversario.cor == Cor.BRANCO
                || adversario.cor == Cor.LARANJA
                || adversario.cor == Cor.ROXO)) {
            return 1;
        }
        if (this.cor == Cor.LARANJA && (adversario.cor == Cor.ROXO
                || adversario.cor == Cor.AZUL
                || adversario.cor == Cor.VERMELHO
                || adversario.cor == Cor.AMARELO
                || adversario.cor == Cor.VERDE)) {
            return 1;
        }
        if (this.cor == Cor.CINZA && (adversario.cor == Cor.PRETO
                || adversario.cor == Cor.BRANCO
                || adversario.cor == Cor.LARANJA
                || adversario.cor == Cor.ROXO
                || adversario.cor == Cor.AZUL)) {
            return 1;
        }
        if (this.cor == Cor.AMARELO && (adversario.cor == Cor.VERDE
                || adversario.cor == Cor.MARROM
                || adversario.cor == Cor.CINZA
                || adversario.cor == Cor.PRETO
                || adversario.cor == Cor.BRANCO)) {
            return 1;
        }
        if (this.cor == Cor.PRETO && (adversario.cor == Cor.BRANCO
                || adversario.cor == Cor.LARANJA
                || adversario.cor == Cor.ROXO
                || adversario.cor == Cor.AZUL)) {
            return 1;
        }
        return -1;
    }

    public int comparaReciclavel(Carta adversario) {
        if (this.ehReciclavel() == adversario.ehReciclavel()) {
            return 0;
        } else if (this.ehReciclavel() && !adversario.ehReciclavel()) {
            return 1;
        }
        return -1;
    }

    public int comparaDecomposicao(Carta adversario) {
        if (this.decomposicao == adversario.getDecomposicao()) {
            return 0;
        } else if (this.decomposicao < adversario.getDecomposicao()) {
            return 1;
        }
        return -1;
    }

    public int comparaAtaque(Carta adversario) {
        if (this.ataque == adversario.getAtaque()) {
            return 0;
        } else if (this.ataque > adversario.getAtaque()) {
            return 1;
        }
        return -1;
    }
}
