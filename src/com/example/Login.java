package com.example;

import java.awt.*;   
import java.awt.event.*;   
import javax.swing.*;   
import java.text.*;   
import java.util.*;   
/**  
 * This is the Login class  
 */   
class Login extends JFrame implements KeyListener {   
   
    // Store cashier's name   
    public static String cashierName;   
   
    // GUI components   
    private JFrame loginFrame;   
    private JLabel loginLabel;   
    private JTextField loginText;   
   
    /**  
     * This constructor initialize GUI components  
     */   
    public Login() {   
        loginFrame = new JFrame("Cashier Login");   
        loginLabel = new JLabel("Cashier Name :");   
        loginText = new JTextField("NewUser", 10);   
        loginText.setFont(new Font("",Font.BOLD,12));   
    }   
   
    /**  
     * This method consist of frame launch events   
     */   
    public void launchFrame() {    
        loginFrame.setSize(200,350);   
               
        loginFrame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER,20,20));   
        loginFrame.getContentPane().add(loginLabel);   
        loginFrame.getContentPane().add(loginText);   
        loginFrame.pack();   
       
        // Centering the screen on the desktop   
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();   
        Dimension frameSize = loginFrame.getSize();   
        loginFrame.setLocation(((screenSize.width - frameSize.width) / 2),   
                            ((screenSize.height - frameSize.height) / 2));         
   
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        loginFrame.setVisible(true);   
           
        loginText.selectAll();   
        loginText.addKeyListener(this);   
    }   
       
    // Unused interface methods   
    public void keyTyped(KeyEvent e) { }   
    public void keyReleased(KeyEvent e) { }   
       
    public void keyPressed(KeyEvent e) {    
           
        // Key Enter is pressed   
        if (e.getKeyCode() == 10) {   
               
            cashierName = loginText.getText();   
            loginFrame.setVisible(false);   
               
            Menu menu = new Menu();   
            menu.launchFrame();   
               
        }   
    }   
}// End of Login class   