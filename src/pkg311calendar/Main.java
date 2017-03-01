/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg311calendar;

import Controllers.LoginCntl;
import javax.swing.UIManager;

/**
 *
 * @author Chandler
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
//          UIManager.setLookAndFeel(
//              UIManager.getSystemLookAndFeelClassName());
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }   
        catch(Exception e){
            
        }
        LoginCntl theLoginCntl = new LoginCntl();
    }
    
}
