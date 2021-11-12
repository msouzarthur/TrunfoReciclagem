package TrunfoGame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author arthur souza - 19102583
 * @author william rodrigues - 19100835
 */
public class Baralho {

    private ArrayList<Carta> cartas;

    public Baralho(String endereco) {
        this.cartas = new ArrayList<Carta>();
        lerDoArquivo(endereco);
    }

    public Carta selecionaCarta() {
        Random valor = new Random();
        int i = valor.nextInt(cartas.size());
        return cartas.remove(i);
    }

    public int isEmpty() {
        return cartas.size();
    }

    private void lerDoArquivo(String info) {
        int i = 0;
        BufferedReader leitorArquivo = null;
        Carta ehReciclavel, naoReciclavel;
        System.out.println("- Lendo baralho, aguarde");
        try {
            leitorArquivo = new BufferedReader(new FileReader(info));
            String linhas = "";
            while ((linhas = leitorArquivo.readLine()) != null) {
                String[] dados = linhas.split(";");
                if (dados[7].equals("sim")) {
                    ehReciclavel = new Reciclavel(dados[0], dados[1], dados[2], dados[3], Cor.stringToCor(dados[4]), Double.parseDouble(dados[5]), Integer.parseInt(dados[6]));
                    cartas.add(ehReciclavel);
                } //if (dados[7].equals("não")) {
                else {
                    naoReciclavel = new NaoReciclavel(dados[0], dados[1], dados[2], dados[3], Cor.stringToCor(dados[4]), Double.parseDouble(dados[5]), Integer.parseInt(dados[6]));
                    cartas.add(naoReciclavel);
                }
                //Parada de seguranca
                if (i > 31) {
                    break;
                }
                i = i + 1;
            }
            System.out.println("- Baralho lido: " + cartas.size() + " cartas salvas");
        } catch (FileNotFoundException e) {
            System.out.println("*Arquivo nao encontrado");
        } catch (Exception e) {
            System.out.println("*Erro ao ler arquivo");
            e.printStackTrace();
        }
    }
}
