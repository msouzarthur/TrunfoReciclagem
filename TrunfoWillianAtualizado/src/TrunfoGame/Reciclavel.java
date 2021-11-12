package TrunfoGame;

/**
 * @author arthur souza - 19102583
 * @author william rodrigues - 19100835
 */
public class Reciclavel extends Carta {

    private boolean status = true;  //info de reciclavel

    public Reciclavel(String cod, String n, String d, String t, Cor c, double dec, int a) {
        super(cod, n, d, t, c, dec, a);
    }

    @Override
    public boolean ehReciclavel() {
        return this.status;
    }

    @Override
    public String toString() {
        return super.toString() + "\n-> Reciclavel: " + status;
    }
}
