/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Controllers.LoginCntl;

/**
 *
 * @author Chandler
 */
public class SignUpUI extends ParentFrame{
    private LoginCntl parentLoginCntl;
    
    public SignUpUI(LoginCntl theLoginCntl){
        parentLoginCntl = theLoginCntl;
        initComponents();
    }
    
    public void initComponents(){
        this.setSize(900,600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
