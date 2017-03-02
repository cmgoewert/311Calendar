/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Controllers.NavigationCntl;

/**
 *
 * @author Chandler
 */
public class MainMenuUI extends ParentFrame{
    private NavigationCntl parentNavigationCntl;
    
    public MainMenuUI(NavigationCntl newNavCntl){
        parentNavigationCntl = newNavCntl;
        this.setVisible(true);
        this.setTitle("Task Manager");
    }
}
