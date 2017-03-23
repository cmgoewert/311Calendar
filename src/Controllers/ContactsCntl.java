/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import UserInterface.ContactsUI;


/**
 *
 * @author Chandler
 */
public class ContactsCntl {
    private NavigationCntl parentCntl;
    private ContactsUI theContactsUI;
    
    
    public ContactsCntl(NavigationCntl theCntl){
        parentCntl = theCntl;
        theContactsUI = new ContactsUI(this);
        theContactsUI.setVisible(true);
    }
    
    public void requestMainMenu(){
        theContactsUI.setVisible(false);
        parentCntl.requestThisCntl();
    }
}
