/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import UserInterface.ContactsUI;
import UserInterface.TasksUI;

/**
 *
 * @author Chandler
 */
public class TaskCntl {
    private NavigationCntl parentCntl;
    private TasksUI theTasksUI;
    
    
    public TaskCntl(NavigationCntl theCntl){
        parentCntl = theCntl;
        theTasksUI = new TasksUI(this);
        theTasksUI.setVisible(true);
    }
    
    public void requestMainMenu(){
        theTasksUI.setVisible(false);
        parentCntl.requestThisCntl();
    }
}
