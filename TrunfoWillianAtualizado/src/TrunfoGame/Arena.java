/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrunfoGame;


import static TrunfoGame.SuperTrunfoDaReciclagem.finaliza;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author willian
 */
public class Arena extends javax.swing.JFrame {
    private int numeroPlayers;
    private ArrayList<Jogador> jogadores;
    private boolean click=false;
    /**
     * Creates new form Arena
     * @param numeroPlayers
     * @param jogadores
     */
    public Arena(int numeroPlayers, ArrayList<Jogador> jogadores) {
        this.numeroPlayers = numeroPlayers;
        this.jogadores = jogadores;
        initComponents();
        fundoArena();
    }
    
    private void fundoArena(){
        //ADICIONA O FUNDO DA ARENA //
        ImageIcon icon = new ImageIcon ("src/img/arena.png");
        icon.setImage(icon.getImage().getScaledInstance(1260,709, 1));
        layoutArena.setIcon(icon);
        
        //ADICIONA O LAYOUT DA MESA //
        ImageIcon fundoMesa = new ImageIcon ("src/img/mesaFundo.png");
        fundoMesa.setImage(fundoMesa.getImage().getScaledInstance(850,400, 1));
        layoutMesa.setIcon(fundoMesa);
        
        mostraBaralho();
    }
    
    //MOSTRA BARALHO DE CADA JOGADOR //
    private void mostraBaralho(){                                               //Adicionando nomes e nº de cartas do baralho p/ parte grafica
        int numero=0;
        
        nomeJogador1.setText(jogadores.get(0).nome());                          //nome jogador no baralho
        numero = jogadores.get(0).numeroDeCartas(); 
        numeroJogador1.setText(Integer.toString(numero));                       //qtd de cartas do jogador no baralho
        nomeJ1.setText(jogadores.get(0).nome());                                // nome do jogador na mesa
        
        nomeJogador2.setText(jogadores.get(1).nome());
        numero = jogadores.get(1).numeroDeCartas();
        numeroJogador2.setText(Integer.toString(numero));
        nomeJ2.setText(jogadores.get(1).nome());
        
        //Importando img e setando na parte grafica//
        ImageIcon baralhoBaixo = new ImageIcon ("src/img/baralho.png");
        baralhoBaixo.setImage(baralhoBaixo.getImage().getScaledInstance(150,180, 1));
        baralho1.setIcon(baralhoBaixo);

        ImageIcon baralhoEsquerda = new ImageIcon ("src/img/baralhoEsquerda.png");
        baralhoEsquerda.setImage(baralhoEsquerda.getImage().getScaledInstance(180,150, 1));
        baralho2.setIcon(baralhoEsquerda);
        
        if(numeroPlayers>=3){
            //JOGADOR 3 -- Adicionando nomes e nº de cartas do baralho p/ parte grafica
            nomeJogador3.setText(jogadores.get(2).nome());
            numero = jogadores.get(2).numeroDeCartas();
            numeroJogador3.setText(Integer.toString(numero));
            nomeJ3.setText(jogadores.get(2).nome());
            //Importando img e setando na parte grafica//
            ImageIcon baralhoCima = new ImageIcon ("src/img/baralhoCima.png");
            baralhoCima.setImage(baralhoCima.getImage().getScaledInstance(150,180, 1));
            baralho3.setIcon(baralhoCima);
            
            if(numeroPlayers==4){
                //JOGADOR 4 -- Adicionando nomes e nº de cartas do baralho p/ parte grafica
                nomeJogador4.setText(jogadores.get(3).nome());
                numero = jogadores.get(3).numeroDeCartas();
                numeroJogador4.setText(Integer.toString(numero));
                nomeJ4.setText(jogadores.get(3).nome());
                //Importando img e setando na parte grafica//
                ImageIcon baralhoDireita = new ImageIcon ("src/img/baralhoDireita.png");
                baralhoDireita.setImage(baralhoDireita.getImage().getScaledInstance(180,150, 1));
                baralho4.setIcon(baralhoDireita);
            }
        }
        jogo(jogadores);
    }
    public ArrayList<Jogador> testaJogadores(ArrayList<Jogador> jogadores) {
        ArrayList<Jogador> novaLista = new ArrayList<Jogador>();
        for (int i = 0; i < jogadores.size(); i++) {
            if (jogadores.get(i).numeroDeCartas() > 0) {                        //Se o jogador nao tiver cartas
                novaLista.add(jogadores.get(i));                                //Se ele tem cartas, eh adicionado na nova lista
            }
        }
        if (novaLista.size() == 1) {
            finaliza(novaLista.get(0));                                         //Se houver somente 1 jogador, finaliza o jogo
        }
        return novaLista;                                                       //Retorna a lista de quem ainda esta no jogo
    }
    
    public void jogo(ArrayList<Jogador> jogadores){
        click = false;
        ArrayList<Carta> cartasDaRodada = new ArrayList<Carta>();
        Random r = new Random();
        int aleatorio = r.nextInt(jogadores.size());
        int i=0;
        for(i=0;i<jogadores.size();i++){
            cartasDaRodada.add(jogadores.get(i).excluir());
            
          ////////////////////////// ATUALIZA O NUMERO DE JOGADOR //////////////////////////
            numeroJogador1.setText(Integer.toString(jogadores.get(i).numeroDeCartas()));
            numeroJogador2.setText(Integer.toString(jogadores.get(i).numeroDeCartas()));
            
            if(jogadores.size() >= 3){
                numeroJogador3.setText(Integer.toString(jogadores.get(i).numeroDeCartas()));
                if(jogadores.size()==4){
                    numeroJogador4.setText(Integer.toString(jogadores.get(i).numeroDeCartas()));
                }
            }
        }
        exibirCartas(cartasDaRodada);
        jogadores = testaJogadores(jogadores);
    }
    
    //  MOSTRA A CARTA DO TOPO DE CADA JOGADOR NA MESA //
    public void exibirCartas(ArrayList<Carta> cartasDaRodada){
        ImageIcon iconeCartaJogador1 = new ImageIcon ("src/img/"+cartasDaRodada.get(0).getCodigo()+".png");
        iconeCartaJogador1.setImage(iconeCartaJogador1.getImage().getScaledInstance(160,255,1));
        cartaJogador1.setIcon(iconeCartaJogador1);
        
        ImageIcon iconeCartaJogador2 = new ImageIcon ("src/img/"+cartasDaRodada.get(1).getCodigo()+".png");
        iconeCartaJogador2.setImage(iconeCartaJogador2.getImage().getScaledInstance(160,255,1));
        cartaJogador2.setIcon(iconeCartaJogador2);
        
        if(jogadores.size()>=3){
            ImageIcon iconeCartaJogador3 = new ImageIcon ("src/img/"+cartasDaRodada.get(2).getCodigo()+".png");
            iconeCartaJogador3.setImage(iconeCartaJogador3.getImage().getScaledInstance(160,255,1));
            cartaJogador3.setIcon(iconeCartaJogador3);
            
            if(jogadores.size()==4){
                ImageIcon iconeCartaJogador4 = new ImageIcon ("src/img/"+cartasDaRodada.get(3).getCodigo()+".png");
                iconeCartaJogador4.setImage(iconeCartaJogador4.getImage().getScaledInstance(160,255,1));
                cartaJogador4.setIcon(iconeCartaJogador4);
            }
        }
        
        if(click){
            jogo(jogadores);
        }
    }
    
    private void mesa(){
       
  
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomeJ4 = new javax.swing.JLabel();
        nomeJ3 = new javax.swing.JLabel();
        nomeJ2 = new javax.swing.JLabel();
        nomeJ1 = new javax.swing.JLabel();
        btnPlay = new javax.swing.JButton();
        numeroJogador4 = new javax.swing.JLabel();
        nomeJogador4 = new javax.swing.JLabel();
        nomeJogador3 = new javax.swing.JLabel();
        numeroJogador3 = new javax.swing.JLabel();
        nomeJogador1 = new javax.swing.JLabel();
        numeroJogador1 = new javax.swing.JLabel();
        nomeJogador2 = new javax.swing.JLabel();
        numeroJogador2 = new javax.swing.JLabel();
        baralho4 = new javax.swing.JLabel();
        baralho2 = new javax.swing.JLabel();
        baralho3 = new javax.swing.JLabel();
        baralho1 = new javax.swing.JLabel();
        cartaJogador4 = new javax.swing.JLabel();
        cartaJogador3 = new javax.swing.JLabel();
        cartaJogador2 = new javax.swing.JLabel();
        cartaJogador1 = new javax.swing.JLabel();
        layoutMesa = new javax.swing.JLabel();
        layoutArena = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Super Trunfo Game");
        setMinimumSize(new java.awt.Dimension(1270, 750));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nomeJ4.setBackground(new java.awt.Color(0, 0, 0));
        nomeJ4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        nomeJ4.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(nomeJ4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 500, -1, -1));

        nomeJ3.setBackground(new java.awt.Color(0, 0, 0));
        nomeJ3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        nomeJ3.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(nomeJ3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 500, -1, -1));

        nomeJ2.setBackground(new java.awt.Color(0, 0, 0));
        nomeJ2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        nomeJ2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(nomeJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 500, -1, -1));

        nomeJ1.setBackground(new java.awt.Color(0, 0, 0));
        nomeJ1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        nomeJ1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(nomeJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, -1, -1));

        btnPlay.setBackground(new java.awt.Color(102, 0, 0));
        btnPlay.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnPlay.setForeground(new java.awt.Color(255, 255, 255));
        btnPlay.setText("Proxima rodada");
        btnPlay.setToolTipText("");
        btnPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlayMouseClicked(evt);
            }
        });
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        getContentPane().add(btnPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 540, 210, 40));

        numeroJogador4.setBackground(new java.awt.Color(0, 0, 0));
        numeroJogador4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        numeroJogador4.setForeground(new java.awt.Color(255, 255, 255));
        numeroJogador4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(numeroJogador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 420, 30, 40));

        nomeJogador4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        nomeJogador4.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(nomeJogador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 430, 80, 20));

        nomeJogador3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        nomeJogador3.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(nomeJogador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 90, 20));

        numeroJogador3.setBackground(new java.awt.Color(0, 0, 0));
        numeroJogador3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        numeroJogador3.setForeground(new java.awt.Color(255, 255, 255));
        numeroJogador3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(numeroJogador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 30, 40));

        nomeJogador1.setBackground(new java.awt.Color(51, 51, 51));
        nomeJogador1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        nomeJogador1.setForeground(new java.awt.Color(255, 255, 255));
        nomeJogador1.setText("NOME");
        getContentPane().add(nomeJogador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 650, 100, -1));

        numeroJogador1.setBackground(new java.awt.Color(0, 0, 0));
        numeroJogador1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        numeroJogador1.setForeground(new java.awt.Color(255, 255, 255));
        numeroJogador1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(numeroJogador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 640, 30, 40));

        nomeJogador2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        nomeJogador2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(nomeJogador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, 90, 20));

        numeroJogador2.setBackground(new java.awt.Color(0, 0, 0));
        numeroJogador2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        numeroJogador2.setForeground(new java.awt.Color(255, 255, 255));
        numeroJogador2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(numeroJogador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 30, 40));
        getContentPane().add(baralho4, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 320, 190, 150));
        getContentPane().add(baralho2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 250, 160));
        getContentPane().add(baralho3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 180, 180));

        baralho1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(baralho1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 520, 180, 180));
        getContentPane().add(cartaJogador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 190, 232, 345));
        getContentPane().add(cartaJogador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, 232, 345));
        getContentPane().add(cartaJogador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 232, 350));
        getContentPane().add(cartaJogador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 232, 345));
        getContentPane().add(layoutMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 900, 420));
        getContentPane().add(layoutArena, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        click = true;
      //mostraBaralho();
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlayMouseClicked
        System.out.println("sAFAfs");
        click = true;
    }//GEN-LAST:event_btnPlayMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Arena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Arena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Arena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Arena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel baralho1;
    private javax.swing.JLabel baralho2;
    private javax.swing.JLabel baralho3;
    private javax.swing.JLabel baralho4;
    private javax.swing.JButton btnPlay;
    private javax.swing.JLabel cartaJogador1;
    private javax.swing.JLabel cartaJogador2;
    private javax.swing.JLabel cartaJogador3;
    private javax.swing.JLabel cartaJogador4;
    private javax.swing.JLabel layoutArena;
    private javax.swing.JLabel layoutMesa;
    private javax.swing.JLabel nomeJ1;
    private javax.swing.JLabel nomeJ2;
    private javax.swing.JLabel nomeJ3;
    private javax.swing.JLabel nomeJ4;
    private javax.swing.JLabel nomeJogador1;
    private javax.swing.JLabel nomeJogador2;
    private javax.swing.JLabel nomeJogador3;
    private javax.swing.JLabel nomeJogador4;
    private javax.swing.JLabel numeroJogador1;
    private javax.swing.JLabel numeroJogador2;
    private javax.swing.JLabel numeroJogador3;
    private javax.swing.JLabel numeroJogador4;
    // End of variables declaration//GEN-END:variables
}
