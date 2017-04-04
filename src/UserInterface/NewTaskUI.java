/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Controllers.TaskCntl;

/**
 *
 * @author cmg5831
 */
public class NewTaskUI extends ParentFrame{
    private TaskCntl parentCntl;
    
    public NewTaskUI(TaskCntl theCntl){
        parentCntl = theCntl;
    }
}
