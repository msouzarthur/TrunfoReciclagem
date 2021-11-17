package TrunfoGame;

import javax.swing.ImageIcon;
/**
 * @author arthur souza - 19102583
 * @author william rodrigues - 19100835
 */
public class Menu extends javax.swing.JFrame {

    public Menu() {
       
        initComponents();
        fundoMenu();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fechaRegra = new javax.swing.JButton();
        ins = new javax.swing.JLabel();
        jogar = new javax.swing.JButton();
        instrucao = new javax.swing.JButton();
        sair = new javax.swing.JButton();
        FundoMenu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Super Trunfo Game");
        setAutoRequestFocus(false);
        setMinimumSize(new java.awt.Dimension(1200, 750));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fechaRegra.setBackground(new java.awt.Color(255, 255, 255));
        fechaRegra.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        fechaRegra.setForeground(new java.awt.Color(255, 0, 0));
        fechaRegra.setText("X");
        fechaRegra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaRegraActionPerformed(evt);
            }
        });
        getContentPane().add(fechaRegra, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 10, 50, 30));

        ins.setBackground(new java.awt.Color(24, 240, 240));
        ins.setAutoscrolls(true);
        getContentPane().add(ins, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 1260, 710));

        jogar.setBackground(new java.awt.Color(0, 0, 0));
        jogar.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jogar.setForeground(new java.awt.Color(225, 225, 225));
        jogar.setText("JOGAR");
        jogar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jogarMouseClicked(evt);
            }
        });
        jogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jogarActionPerformed(evt);
            }
        });
        getContentPane().add(jogar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, 170, 70));

        instrucao.setBackground(new java.awt.Color(0, 0, 0));
        instrucao.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        instrucao.setForeground(new java.awt.Color(225, 225, 225));
        instrucao.setText("INSTRUÇÕES");
        instrucao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                instrucaoMouseClicked(evt);
            }
        });
        instrucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instrucaoActionPerformed(evt);
            }
        });
        getContentPane().add(instrucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 170, 70));

        sair.setBackground(new java.awt.Color(0, 0, 0));
        sair.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        sair.setForeground(new java.awt.Color(225, 225, 225));
        sair.setText("SAIR");
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sairMouseClicked(evt);
            }
        });
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });
        getContentPane().add(sair, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 500, 170, 70));

        FundoMenu.setBackground(new java.awt.Color(0, 0, 0));
        FundoMenu.setFont(new java.awt.Font("Bauhaus 93", 1, 36)); // NOI18N
        getContentPane().add(FundoMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1270, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void fundoMenu(){
        ImageIcon icon = new ImageIcon ("src/img/menu.png");
        icon.setImage(icon.getImage().getScaledInstance(1260,709, 1));
        FundoMenu.setIcon(icon);
        visivelInicio();
    }
    
    private void visivelInicio(){
        ins.setVisible(false);
        fechaRegra.setVisible(false);
    
    }

    private void jogarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jogarMouseClicked

    }//GEN-LAST:event_jogarMouseClicked

    private void jogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jogarActionPerformed
        MenuJogadores mjogadores = new MenuJogadores();
        mjogadores.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jogarActionPerformed

    private void fechaRegraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaRegraActionPerformed
        ins.setVisible(false);
        fechaRegra.setVisible(false);
    }//GEN-LAST:event_fechaRegraActionPerformed
    
    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_sairActionPerformed

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked

    }//GEN-LAST:event_sairMouseClicked

    private void instrucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instrucaoActionPerformed
        ins.setVisible(true);
        fechaRegra.setVisible(true);
        ImageIcon icon = new ImageIcon ("src/img/regrasCompleto.png");
        icon.setImage(icon.getImage().getScaledInstance(900,700, 1));
        ins.setIcon(icon);
    }//GEN-LAST:event_instrucaoActionPerformed

    private void instrucaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instrucaoMouseClicked

    }//GEN-LAST:event_instrucaoMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FundoMenu;
    private javax.swing.JButton fechaRegra;
    private javax.swing.JLabel ins;
    private javax.swing.JButton instrucao;
    private javax.swing.JButton jogar;
    private javax.swing.JButton sair;
    // End of variables declaration//GEN-END:variables
}
