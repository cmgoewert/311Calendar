/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import UserInterface.MainMenuUI;

/**
 *
 * @author Chandler
 */
public class NavigationCntl {
    private MainMenuUI theMainMenuUI;
    private LoginCntl parentCntl;
    private ContactsCntl contactCntl;
    
    public NavigationCntl(LoginCntl newLoginCntl){
        theMainMenuUI = new MainMenuUI(this);
        parentCntl = newLoginCntl;
    }
    
    public void requestContactCntl(){
        contactCntl = new ContactsCntl(this);
        theMainMenuUI.setVisible(false);
    }
    
    public void requestThisCntl(){
        theMainMenuUI.setVisible(true);
    }
    
}
