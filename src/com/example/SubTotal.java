package com.example;

import java.awt.*;   
import java.awt.event.*;   
import javax.swing.*;   
import java.text.*;   
import java.util.*;   

class SubTotal extends JFrame implements KeyListener {   
    
    // Variable to cumulate total payments   
    int perItemTotal, grandTotal;   
   
    // GUI components   
    private JFrame subTotalFrame;   
    private JPanel subTotalNorthPanel,   
                   subTotalSouthPanel,   
                   subTotalCenterPanel,   
                   subTotalTitlePanel,   
                   subTotalDetailPanel,   
                   subTotalOrderedPanel,   
                   subTotalHeaderPanel;   
       
    private JLabel subTotalStoreLabel,   
                   subTotalTitleLabel,   
                   subTotalCashierLabel,   
                   subTotalHeaderLabel,   
                   subTotalDateLabel,   
                   subTotalOrderedLabel[],   
                   subTotalGrandTotalLabel,   
                   subTotalGuideLabel;   
                                                   
    /**  
     * This constructor initialize GUI components  
     */   
    public SubTotal() {   
        subTotalFrame = new JFrame("Sub Total");   
        subTotalFrame.getContentPane().setLayout(new BorderLayout(0,0));   
           
        subTotalNorthPanel = new JPanel();   
        subTotalNorthPanel.setLayout(new FlowLayout());   
        subTotalNorthPanel.setBackground(Color.black);   
           
        subTotalSouthPanel = new JPanel();   
        subTotalSouthPanel.setBackground(new Color(0,155,0));   
                   
        subTotalTitlePanel = new JPanel();   
        subTotalTitlePanel.setLayout(new BorderLayout(10,10));   
        subTotalTitlePanel.setBackground(new Color(137,195,232));   
           
        subTotalDetailPanel = new JPanel();   
        subTotalDetailPanel.setLayout(new GridLayout(2,1));   
        subTotalDetailPanel.setBackground(new Color(157,217,252));   
               
        subTotalCenterPanel = new JPanel();   
        subTotalCenterPanel.setLayout(new BorderLayout(0,0));   
        subTotalCenterPanel.setBackground(new Color(160,255,150));   
           
        subTotalStoreLabel = new JLabel(" Binus Restaurant ");   
        subTotalStoreLabel.setForeground(Color.yellow);   
        subTotalStoreLabel.setFont(new Font("Arial Black",Font.BOLD+Font.ITALIC,36));   
   
        subTotalTitleLabel = new JLabel(" SUB TOTAL ", JLabel.CENTER);   
        subTotalTitleLabel.setForeground(Color.blue);   
        subTotalTitleLabel.setFont(new Font("Courier New",Font.BOLD,24));   
           
        // Acquire current date information   
        GregorianCalendar calendar = new GregorianCalendar();   
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,   
                                DateFormat.SHORT,   
                                Locale.US);   
           
        // Acquire current cashier logged in   
        subTotalCashierLabel = new JLabel("   Cashier on Duty : " + Login.cashierName);   
        subTotalCashierLabel.setForeground(Color.red);   
        subTotalCashierLabel.setFont(new Font("Verdana",Font.BOLD,14));   
           
        subTotalDateLabel = new JLabel("   Date/Time : "    
                                     + dateFormat.format(calendar.getTime())     
                                     + "  ");   
        subTotalDateLabel.setForeground(Color.red);   
        subTotalDateLabel.setFont(new Font("Verdana",Font.BOLD,14));   
           
        // Header   
        subTotalHeaderLabel = new JLabel("    Food Item"   
                                        +"           Price/Unit"   
                                        +"    Ordered"   
                                        +"    Total(Rupiah)   ");   
        subTotalHeaderLabel.setForeground(Color.white);   
        subTotalHeaderLabel.setFont(new Font("Verdana",Font.BOLD,18));   
           
        // Display the food items ordered on the menu   
        subTotalOrderedPanel = new JPanel();   
        subTotalOrderedPanel.setBackground(new Color(0,0,0));   
        subTotalOrderedPanel.add(subTotalHeaderLabel);   
           
        // Extra 2 element for Quit and SubTotal options   
        subTotalOrderedLabel = new JLabel[Menu.choice.length];   
        perItemTotal = 0;   
        grandTotal = 0;   
        int count = 0;   
                       
        for (int i = 0; i < Menu.choice.length; i++) {   
               
            if (Menu.ordered[i] > 0) {   
               
            perItemTotal = Menu.ordered[i] * Menu.price[i];   
            grandTotal+= perItemTotal;   
            count++;   
               
            // Populating the menu table   
            subTotalOrderedLabel[i] = new JLabel("  " + Menu.choice[i]   
                                               +"    " + Menu.price[i] + "0"   
                                               +"        " + Menu.ordered[i]   
                                               +"       " + perItemTotal + "0");   
            subTotalOrderedLabel[i].setForeground(Color.green);   
            subTotalOrderedLabel[i].setFont(new Font("Courier New",Font.BOLD,18));   
               
            subTotalOrderedPanel.add(subTotalOrderedLabel[i]);   
               
            // Reset the ordered amount of all food type ordered to 0      
            Menu.ordered[i] = 0;   
            }   
        }   
           
        // Show grand total figure   
        subTotalGrandTotalLabel = new JLabel(" Sub Total : Rp " + grandTotal + "0");   
        subTotalGrandTotalLabel.setForeground(Color.yellow);   
        subTotalGrandTotalLabel.setFont(new Font("Courier New",Font.BOLD,30));             
           
        subTotalOrderedPanel.add(subTotalGrandTotalLabel);   
                   
        // Simple instructions added for user cashier   
        subTotalGuideLabel = new JLabel("   Press [ Esc ] to return to menu");   
        subTotalGuideLabel.setForeground(Color.white);   
        subTotalGuideLabel.setFont(new Font("Verdana",Font.BOLD,14));      
           
        subTotalOrderedPanel.setLayout(new GridLayout(count+2,1,0,0));   
    }   
   
    /**  
     * This method consist of frame launch events   
     */   
    public void launchFrame() {    
   
        subTotalFrame.setSize(200,350);   
           
        // Arranging GUI components in Panel onto Frame   
        subTotalDetailPanel.add(subTotalCashierLabel);   
        subTotalDetailPanel.add(subTotalDateLabel);   
        subTotalTitlePanel.add(subTotalTitleLabel, BorderLayout.WEST);   
        subTotalTitlePanel.add(subTotalDetailPanel, BorderLayout.EAST);   
        subTotalNorthPanel.add(subTotalStoreLabel, BorderLayout.NORTH);   
        subTotalSouthPanel.add(subTotalGuideLabel, BorderLayout.SOUTH);        
        subTotalCenterPanel.add(subTotalTitlePanel, BorderLayout.NORTH);   
        subTotalCenterPanel.add(subTotalOrderedPanel, BorderLayout.CENTER);   
        subTotalFrame.getContentPane().add(subTotalNorthPanel, BorderLayout.NORTH);   
        subTotalFrame.getContentPane().add(subTotalCenterPanel, BorderLayout.CENTER);   
        subTotalFrame.getContentPane().add(subTotalSouthPanel, BorderLayout.SOUTH);   
           
        subTotalFrame.pack();          
       
        // Centering the screen on the desktop   
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();   
        Dimension frameSize = subTotalFrame.getSize();   
        subTotalFrame.setLocation(((screenSize.width - frameSize.width) / 2),   
                            ((screenSize.height - frameSize.height) / 2));         
           
        subTotalFrame.addKeyListener(this);   
           
        subTotalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        subTotalFrame.setVisible(true);   
    }   
   
    // Unused interface methods   
    public void keyTyped(KeyEvent e) { }   
    public void keyReleased(KeyEvent e) { }   
       
    public void keyPressed(KeyEvent e) {    
           
        // [Escape] key is pressed   
        if (e.getKeyCode() == 27) {   
            subTotalFrame.setVisible(false);   
            Menu menu = new Menu();   
            menu.launchFrame();   
        }   
    }   
}// End of SubTotal class  