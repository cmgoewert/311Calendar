/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import UserInterface.LoginUI;

/**
 *
 * @author cmg5831
 */
public class LoginCntl {
    LoginUI theLoginUI;
    
    public LoginCntl(){
        theLoginUI = new LoginUI(this);
    }
}
