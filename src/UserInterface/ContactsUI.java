/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Controllers.ContactsCntl;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Chandler
 */
public class ContactsUI extends ParentFrame{
    private ContactsCntl parentCntl;
    private JButton backButton,newContactButton;
    private JTable theContactsTable;
    private JPanel buttonPanel,tablePanel;
    private JScrollPane theScrollPane;
    
    public ContactsUI(ContactsCntl theCntl){
        parentCntl = theCntl;
        initComponents();
    }
    
    private void initComponents(){
        Font font = new Font(Font.SERIF,0,16);
        Font lfont = new Font(Font.SANS_SERIF, Font.BOLD,18);
        Font tableFont = new Font(Font.SANS_SERIF,0,18);
        
        backButton = new JButton("Back To Main Menu");
        backButton.setFont(lfont);
        backButton.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(25, 0, 25, 0), new EmptyBorder(0,0,0,0)));
        backButton.addActionListener(new BackListener());
        
        newContactButton = new JButton("New Contact");
        newContactButton.setFont(lfont);
        newContactButton.addActionListener(new NewListener());
        
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2,0,0));
        buttonPanel.add(backButton);
        buttonPanel.add(newContactButton);
        
        theContactsTable = new JTable(this.parentCntl.getTableModel());
        theContactsTable.setFont(tableFont);
        theContactsTable.setRowHeight(25);
        theContactsTable.getTableHeader().setFont(lfont);
        
//        theMediaTable.getColumnModel().getColumn(0).setPreferredWidth(3);
//        theMediaTable.getColumnModel().getColumn(1).setPreferredWidth(100);
//        theMediaTable.getColumnModel().getColumn(2).setPreferredWidth(80);
//        theMediaTable.getColumnModel().getColumn(3).setPreferredWidth(3);
        //then do col 1 and 2, 15 and 20 respectively

        theScrollPane = new JScrollPane(theContactsTable);
        theScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        theScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        theScrollPane.setPreferredSize(new Dimension(500, 320));
        theContactsTable.setFillsViewportHeight(true);

        tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(theScrollPane, BorderLayout.CENTER);
        
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        this.getContentPane().add(tablePanel, BorderLayout.CENTER);
    }
    
    class BackListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            parentCntl.requestMainMenu();
        }
    }
    
    class NewListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            parentCntl.requestNewContact();
        }
    }
}
