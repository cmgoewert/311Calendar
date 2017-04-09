/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Controllers.TaskCntl;
import Model.Contact;
import Model.Task;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.SpinnerDateModel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author cmg5831
 */
public class NewTaskUI extends ParentFrame{
    private TaskCntl parentCntl;
    private JLabel title, description, dueDate, collaborators, urgency, instructions;
    private JTextField titleField, descField;
    private SpinnerDateModel dateField;
    private JSpinner newSpin;
    private JComboBox collabBox,urgencyField;
    private JPanel mainPanel, navPanel, labelPanel;
    private JButton save, cancel;
    
    public NewTaskUI(TaskCntl theCntl){
        parentCntl = theCntl;
        initComponents();
    }
    
    private void initComponents(){
        this.setSize(900,600);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        Font lfont = new Font(Font.SANS_SERIF, Font.BOLD,18);
        Font ifont = new Font(Font.SERIF, Font.ITALIC,16);
        Font font = new Font(Font.SERIF,0,16);
        
        title = new JLabel("Task Title:");
        title.setFont(lfont);
        
        description = new JLabel("Description:");
        description.setFont(lfont);
        
        dueDate = new JLabel("Due Date:");
        dueDate.setFont(lfont);
        
        collaborators = new JLabel("Collaborators:");
        collaborators.setFont(lfont);
        
        urgency = new JLabel("Level of Urgency:");
        urgency.setFont(lfont);
        
        titleField = new JTextField();
        titleField.setFont(font);
        titleField.setEditable(true);
        
        descField = new JTextField();
        descField.setFont(font);
        descField.setEditable(true);
        
        dateField = new SpinnerDateModel();
        
        newSpin = new JSpinner(dateField);
        newSpin.setEditor(new JSpinner.DateEditor(newSpin,"MM/dd/yyyy hh:mm a"));
        newSpin.setFont(font);
        
        collabBox = new JComboBox();
        collabBox.setFont(font);
        collabBox.setEditable(true);
        ArrayList<Contact> contacts = parentCntl.requestContacts();
        for(int i = 0; i < contacts.size(); i++){
            collabBox.addItem(contacts.get(i).toString());
        }
        
        urgencyField = new JComboBox();
        urgencyField.setFont(font);
        urgencyField.setRenderer(new ComboBoxRenderer());
        urgencyField.addItem("Most Urgent");
        urgencyField.addItem("More Urgent");
        urgencyField.addItem("Less Urgent");
        
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5,1,0,0));
        mainPanel.add(titleField);
        mainPanel.add(descField);
        mainPanel.add(newSpin);
        mainPanel.add(collabBox);
        mainPanel.add(urgencyField);
        
        labelPanel = new JPanel();
        labelPanel.setLayout(new GridLayout(5,1,0,0));
        labelPanel.add(title);
        labelPanel.add(description);
        labelPanel.add(dueDate);
        labelPanel.add(collaborators);
        labelPanel.add(urgency);
        
        instructions = new JLabel("Enter the following information and press save to create a new task.");
        instructions.setFont(ifont);
        instructions.setHorizontalAlignment(JLabel.CENTER);
        
        save = new JButton("Save");
        save.setFont(lfont);
        save.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(25, 0, 25, 0), new EmptyBorder(0,0,0,0)));
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        
        cancel = new JButton("Cancel");
        cancel.setFont(lfont);
        cancel.addActionListener(new CancelListener());
        
        navPanel = new JPanel();
        navPanel.setLayout(new GridLayout(1,2,0,0));
        navPanel.add(cancel);
        navPanel.add(save);
        
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(instructions, BorderLayout.NORTH);
        this.getContentPane().add(navPanel, BorderLayout.SOUTH);
        this.getContentPane().add(labelPanel, BorderLayout.WEST);
        this.getContentPane().add(mainPanel, BorderLayout.CENTER);
        this.getRootPane().setDefaultButton(save);
    }
    
     private void saveButtonActionPerformed(java.awt.event.ActionEvent evt){
        ArrayList<Contact> contactList = parentCntl.requestContacts();
        Contact newContact = null;
        for(int i = 0; i < contactList.size();i++){
            if(contactList.get(i).toString() == collabBox.getSelectedItem().toString()){
                newContact = contactList.get(i);
            }
        }
        
        Task taskToAdd = new Task(titleField.getText(),descField.getText(),newSpin.getValue().toString(),newContact, urgencyField.getSelectedIndex());
        parentCntl.addNewTask(taskToAdd);
        this.parentCntl.getTableModel().fireTableDataChanged();
    }
    
    class CancelListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            setInvisible();
        }
    }
    
    private void setInvisible(){
        this.setVisible(false);
    }
    
    class ComboBoxRenderer extends JLabel implements ListCellRenderer {

        public ComboBoxRenderer() {
            setOpaque(true);
        }

        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
         
            setText(value.toString());

            switch(index){
                case '0':
                        setBackground(Color.RED);
                        break;
                case '1':
                        setBackground(Color.YELLOW);
                        break;
                case '2':
                        setBackground(Color.GREEN);
                        break;
              
            }

            return this;
        }
    }
           
}
