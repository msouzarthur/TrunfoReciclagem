/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TrunfoGame;

import javax.swing.ImageIcon;

/**
 *
 * @author arthu
 */
public class fundoMenu {
    private void fundoMenu(){
        ImageIcon icon = new ImageIcon ("src/img/menu.png");
        icon.setImage(icon.getImage().getScaledInstance(1260,709, 1));
        FundoMenu.setIcon(icon);
    }
    
    private javax.swing.JLabel FundoMenu;
}
