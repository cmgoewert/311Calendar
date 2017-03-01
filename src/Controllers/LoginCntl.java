/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Model.UserList;
import UserInterface.LoginUI;

/**
 *
 * @author cmg5831
 */
public class LoginCntl {
    LoginUI theLoginUI;
    UserList theUserList;
    
    public LoginCntl(){
        theLoginUI = new LoginUI(this);
        if(theUserList == null){
            theUserList = new UserList();
        } 
    }
    
    public boolean requestAuthenticate(String usernameToCheck, char[] passwordToCheck){
        boolean result = theUserList.authenticate(usernameToCheck, passwordToCheck);
        return result;
    }
}
