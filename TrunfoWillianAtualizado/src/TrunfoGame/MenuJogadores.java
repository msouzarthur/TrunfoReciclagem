package TrunfoGame;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;
/**
 * @author arthur souza - 19102583
 * @author william rodrigues - 19100835
 */
public class MenuJogadores extends javax.swing.JFrame {
    private int numeroPlayers = 0;
    private ArrayList<Jogador> jogadores;
    /**
     * Creates new form MenuJogadores
     */
    public MenuJogadores() {
        initComponents();
        fundoMenu();
    }
    public void iniciarJogo(){
        Arena arena = new Arena( jogadores);
        arena.setVisible(true);
        this.dispose();
    }
    public void cadastros(){
        jogadores = new ArrayList<Jogador>();
        Jogador auxiliar;
        String nomes;
        if(btnAddPlayer1.isSelected()){
            nomes = nomeJogador1.getText();
            auxiliar = new Jogador(nomes);
            jogadores.add(new Jogador(nomeJogador1.getText()));
            System.out.println("Jogador adicionado");
            numeroPlayers = numeroPlayers+1;
        }
        if(btnAddPlayer2.isSelected()){
            nomes = nomeJogador2.getText();
            auxiliar = new Jogador(nomes);
            jogadores.add(new Jogador(nomeJogador2.getText()));
            System.out.println("Jogador adicionado");
            numeroPlayers = numeroPlayers+1;
        }
        
        if(numeroPlayers==2){
            System.out.println(numeroPlayers);
            sortearCartas();
            iniciarJogo();
        }
        else
            cadastros();
    }
    public void sortearCartas(){
        Baralho baralho = new Baralho("File/dados.csv");
        for (int i = 0; i < numeroPlayers; i++) {                               //distribui as cartas do baralho
            for (int j = 1; j <= Math.floor(32 / numeroPlayers); j++) {         //32 cartas / numero de jogadores; o floor arredonda pra baixo quando for 3
                jogadores.get(i).incluir(baralho.selecionaCarta());             //2 j : 16 c/j ; 3 j : 10 c/j ; 4 j : 8 c/j
            }                                                                   //Tira do baralho de forma aleatoria e passa pra mao dos jogadores
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAddPlayer1 = new javax.swing.JToggleButton();
        btnAddPlayer2 = new javax.swing.JToggleButton();
        btnJogar = new javax.swing.JButton();
        nomeJogador1 = new javax.swing.JTextField();
        nomeJogador2 = new javax.swing.JTextField();
        fundoMenu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddPlayer1.setBackground(new java.awt.Color(0, 0, 0));
        btnAddPlayer1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnAddPlayer1.setForeground(new java.awt.Color(255, 255, 255));
        btnAddPlayer1.setText("ADICIONAR");
        btnAddPlayer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPlayer1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, -1, -1));

        btnAddPlayer2.setBackground(new java.awt.Color(0, 0, 0));
        btnAddPlayer2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnAddPlayer2.setForeground(new java.awt.Color(255, 255, 255));
        btnAddPlayer2.setText("ADICIONAR");
        btnAddPlayer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPlayer2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, -1, -1));

        btnJogar.setBackground(new java.awt.Color(0, 0, 0));
        btnJogar.setFont(new java.awt.Font("Arial Black", 1, 36)); // NOI18N
        btnJogar.setForeground(new java.awt.Color(255, 255, 255));
        btnJogar.setText("JOGAR");
        btnJogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJogarActionPerformed(evt);
            }
        });
        getContentPane().add(btnJogar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 580, -1, -1));

        nomeJogador1.setBackground(new java.awt.Color(0, 0, 0));
        nomeJogador1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        nomeJogador1.setForeground(new java.awt.Color(255, 255, 255));
        nomeJogador1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nomeJogador1.setText("Jogador 1");
        nomeJogador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeJogador1ActionPerformed(evt);
            }
        });
        getContentPane().add(nomeJogador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 280, 230, -1));

        nomeJogador2.setBackground(new java.awt.Color(0, 0, 0));
        nomeJogador2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        nomeJogador2.setForeground(new java.awt.Color(255, 255, 255));
        nomeJogador2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nomeJogador2.setText("Jogador 2");
        getContentPane().add(nomeJogador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 350, 230, -1));

        fundoMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        fundoMenu.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        fundoMenu.setPreferredSize(new java.awt.Dimension(1260, 790));
        getContentPane().add(fundoMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddPlayer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPlayer1ActionPerformed
        if(btnAddPlayer1.isSelected())
            btnAddPlayer1.setBackground(Color.green);
        else
            btnAddPlayer1.setBackground(Color.red);
    }//GEN-LAST:event_btnAddPlayer1ActionPerformed

    private void nomeJogador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeJogador1ActionPerformed
    }//GEN-LAST:event_nomeJogador1ActionPerformed

    private void btnAddPlayer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPlayer2ActionPerformed
        if(btnAddPlayer2.isSelected())
            btnAddPlayer2.setBackground(Color.green);
        else
            btnAddPlayer2.setBackground(Color.red);
    }//GEN-LAST:event_btnAddPlayer2ActionPerformed

    private void btnJogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJogarActionPerformed
        cadastros();
    }//GEN-LAST:event_btnJogarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuJogadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuJogadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuJogadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuJogadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuJogadores().setVisible(true);
            }
        });
    }
    

    private void fundoMenu() {
        ImageIcon icon = new ImageIcon ("src/img/menu.png");
        icon.setImage(icon.getImage().getScaledInstance(1260,709, 1));
        fundoMenu.setIcon(icon);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAddPlayer1;
    private javax.swing.JToggleButton btnAddPlayer2;
    private javax.swing.JButton btnJogar;
    private javax.swing.JLabel fundoMenu;
    private javax.swing.JTextField nomeJogador1;
    private javax.swing.JTextField nomeJogador2;
    // End of variables declaration//GEN-END:variables

}
