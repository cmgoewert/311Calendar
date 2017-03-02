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
    
    public NavigationCntl(){
        theMainMenuUI = new MainMenuUI(this);
    }
}
