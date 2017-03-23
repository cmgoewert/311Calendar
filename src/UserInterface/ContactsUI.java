/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Controllers.ContactsCntl;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Chandler
 */
public class ContactsUI extends ParentFrame{
    private ContactsCntl parentCntl;
    private JButton backButton;
    private JPanel buttonPanel;
    
    public ContactsUI(ContactsCntl theCntl){
        parentCntl = theCntl;
        initComponents();
    }
    
    private void initComponents(){
        backButton = new JButton("Back To Main Menu");
        backButton.addActionListener(new BackListener());
        
        buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }
    
    class BackListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            parentCntl.requestMainMenu();
        }
    }
}
