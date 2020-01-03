package com.example;

import java.awt.*;   
import java.awt.event.*;   
import javax.swing.*;   
import java.text.*;   
import java.util.*;   
class Menu extends JFrame implements KeyListener {   
	   
    // GUI components   
    private JFrame menuFrame;   
    private JPanel menuNorthPanel,   
                   menuSouthPanel,   
                   menuCenterPanel,   
                   menuTitlePanel,   
                   menuDetailPanel,   
                   menuChoicePanel,   
                   menuHeaderPanel;   
       
    private JLabel menuStoreLabel,   
                   menuTitleLabel,   
                   menuCashierLabel,   
                   menuHeaderLabel,   
                   menuDateLabel,   
                   menuChoiceLabel[],   
                   menuGuideLabel;
       
    /**  
     * Element listing of all the food NAMES  
     */   
    public static String choice[] = {"Kwetiau Goreng",   
                                    "Mie Goreng    ",   
                                    "Nasi Campur   ",   
                                    "Nasi Kuning   ",   
                                    "Roti Bakar    ",   
                                    "Soft Drink    ",   
                                    "Jus Buah      ",   
                                    "Air Mineral   "};    
       
    /**  
     * Element listing of all the food PRICE  
     */   
    public static int price[] = {45000,   
                                    35000,   
                                    35000,   
                                    40000,   
                                    15000,   
                                    10000,   
                                    10000,   
                                    10000};   
       
    /**  
     * To keep track of the amount of food ordered  
     */   
    public static int ordered[];   
                      
    String option[] = {"Sub Total",   
                       "Log Off"};   
                       
    /**  
     * This constructor initialize GUI components  
     */   
    public Menu() {   
        menuFrame = new JFrame("Cashier Menu");   
        menuFrame.getContentPane().setLayout(new BorderLayout(0,0));   
           
        menuNorthPanel = new JPanel();   
        menuNorthPanel.setLayout(new FlowLayout());   
        menuNorthPanel.setBackground(Color.black);   
           
        menuSouthPanel = new JPanel();   
        menuSouthPanel.setBackground(new Color(0,155,0));   
                   
        menuTitlePanel = new JPanel();   
        menuTitlePanel.setLayout(new BorderLayout(10,10));   
        menuTitlePanel.setBackground(new Color(137,195,232));   
           
        menuDetailPanel = new JPanel();   
        menuDetailPanel.setLayout(new GridLayout(2,1));   
        menuDetailPanel.setBackground(new Color(157,217,252));   
               
        menuCenterPanel = new JPanel();   
        menuCenterPanel.setLayout(new BorderLayout(0,0));   
        menuCenterPanel.setBackground(new Color(160,255,150));   
           
        menuStoreLabel = new JLabel(" Binus Restaurant ");   
        menuStoreLabel.setForeground(Color.yellow);   
        menuStoreLabel.setFont(new Font("Arial Black",Font.BOLD+Font.ITALIC,36));   
   
        menuTitleLabel = new JLabel(" Cashier Menu ", JLabel.CENTER);   
        menuTitleLabel.setForeground(Color.blue);   
        menuTitleLabel.setFont(new Font("Courier New",Font.BOLD,24));   
           
        // Acquire current date information   
        GregorianCalendar calendar = new GregorianCalendar();   
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,   
                                DateFormat.SHORT,   
                                Locale.US);   
           
        // Acquire current cashier logged in   
        menuCashierLabel = new JLabel("   Cashier on Duty : " + Login.cashierName);   
        menuCashierLabel.setForeground(Color.red);   
        menuCashierLabel.setFont(new Font("Verdana",Font.BOLD,14));   
           
        menuDateLabel = new JLabel("   Date/Time : "    
                                   + dateFormat.format(calendar.getTime())     
                                   + "  ");   
        menuDateLabel.setForeground(Color.red);   
        menuDateLabel.setFont(new Font("Verdana",Font.BOLD,14));   
           
        // Header   
        menuHeaderLabel = new JLabel("             Food Item"   
                                    +"              Price(Ribu)"   
                                    +"    Ordered");   
        menuHeaderLabel.setForeground(Color.white);   
        menuHeaderLabel.setFont(new Font("Verdana",Font.BOLD,18));   
           
        // Set the food items and menu choices   
        menuChoicePanel = new JPanel();   
        menuChoicePanel.setLayout(new GridLayout(choice.length+4,1,0,0));   
        menuChoicePanel.setBackground(new Color(0,0,0));   
        menuChoicePanel.add(menuHeaderLabel);   
           
        // Extra 2 element for Quit and SubTotal options   
        menuChoiceLabel = new JLabel[choice.length + 2];   
        ordered = new int[choice.length];   
                       
        for (int i = 0; i < choice.length; i++)  {   
               
            // Set default ordered amount of all food to 0     
            ordered[i] = 0;   
               
            // Populating the menu table   
            menuChoiceLabel[i] = new JLabel("  [" + (i+1) + "]  " + choice[i]   
                                           +"      "+ price[i]
                                           +"       "+ ordered[i]);   
            menuChoiceLabel[i].setForeground(Color.green);   
            menuChoiceLabel[i].setFont(new Font("Courier New",Font.BOLD,18));   
               
            menuChoicePanel.add(menuChoiceLabel[i]);   
        }   
           
        // Add options to menu   
        menuChoiceLabel[choice.length] = new JLabel("  [0]  " + option[0]);   
        menuChoiceLabel[choice.length+1] = new JLabel("  [Q]  "    
                                                      + option[1] + " "    
                                                      + Login.cashierName);   
        menuChoiceLabel[choice.length].setForeground(Color.yellow);   
        menuChoiceLabel[choice.length+1].setForeground(Color.yellow);   
        menuChoiceLabel[choice.length].setFont(new Font("Courier New",Font.BOLD,18));   
        menuChoiceLabel[choice.length+1].setFont(new Font("Courier New",Font.BOLD,18));   
        menuChoicePanel.add(menuChoiceLabel[choice.length]);   
        menuChoicePanel.add(menuChoiceLabel[choice.length+1]);   
           
        // Simple instructions added for user cashier   
        menuGuideLabel = new JLabel("   Use the keyboard and press the appropriate keys in [ ]");   
        menuGuideLabel.setForeground(Color.white);   
        menuGuideLabel.setFont(new Font("Verdana",Font.BOLD,14));      
    }   
   
    /**  
     * This method consist of frame launch events   
     */   
    public void launchFrame() {    
   
        menuFrame.setSize(200,350);   
           
        // Arranging GUI components in Panel onto Frame   
        menuDetailPanel.add(menuCashierLabel);   
        menuDetailPanel.add(menuDateLabel);   
        menuTitlePanel.add(menuTitleLabel, BorderLayout.WEST);   
        menuTitlePanel.add(menuDetailPanel, BorderLayout.EAST);   
        menuNorthPanel.add(menuStoreLabel, BorderLayout.NORTH);   
        menuSouthPanel.add(menuGuideLabel, BorderLayout.SOUTH);        
        menuCenterPanel.add(menuTitlePanel, BorderLayout.NORTH);   
        menuCenterPanel.add(menuChoicePanel, BorderLayout.CENTER);   
        menuFrame.getContentPane().add(menuNorthPanel, BorderLayout.NORTH);   
        menuFrame.getContentPane().add(menuCenterPanel, BorderLayout.CENTER);   
        menuFrame.getContentPane().add(menuSouthPanel, BorderLayout.SOUTH);   
           
        menuFrame.pack();          
       
        // Centering the screen on the desktop   
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();   
        Dimension frameSize = menuFrame.getSize();   
        menuFrame.setLocation(((screenSize.width - frameSize.width) / 2),   
                            ((screenSize.height - frameSize.height) / 2));         
           
        menuFrame.addKeyListener(this);   
           
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        menuFrame.setVisible(true);   
   
    }   
       
    private void refresh() {   
        for (int i = 0; i < choice.length; i++)  {   
                           
            // Populating the menu table   
            menuChoiceLabel[i].setText("  [" + (i+1) + "]  " + choice[i]   
                                           +"      "+ price[i]
           
                                           +"       "+ ordered[i]);   
        }          
    }   
       
    // Unused interface methods   
    public void keyTyped(KeyEvent e) { }   
    public void keyReleased(KeyEvent e) { }   
       
    public void keyPressed(KeyEvent e) {           
        switch(e.getKeyCode()) {   
        case 49:   
        case 50:   
        case 51:   
        case 52:   
        case 53:   
        case 54:   
        case 55:   
        case 56:   
            // Accumulate food items   
            ordered[e.getKeyCode() - 49]++;   
            break;   
           
        case 48:   
            // Calculate total   
            menuFrame.setVisible(false);   
            SubTotal subTotal = new SubTotal();   
            subTotal.launchFrame();   
            break;   
               
        case 81:   
            // Quit program   
            menuFrame.setVisible(false);   
            JOptionPane.showMessageDialog(this, "User Log Off",   
                "Goodbye and have a nice day!", JOptionPane.INFORMATION_MESSAGE);   
            System.exit(0);   
            break;   
        }   
       
        // Refreshes the menu;   
        this.refresh();   
    }   
}// End of Menu class   
   