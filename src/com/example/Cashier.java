package com.example;

import java.awt.*;   
import java.awt.event.*;   
import javax.swing.*;   
import java.text.*;   
import java.util.*;   
   
/**  
 * This is the Cashier class  
 */   
public class Cashier extends JFrame {   
           
    /**  
     * This method consist of application launch events   
     */   
    public void launchApp() {      
        Login login = new Login();   
        login.launchFrame();   
    }   
   
    /**  
     * This the driver program  
     */   
    public static void main(String args[]) {   
        Cashier cashier = new Cashier();   
        cashier.launchApp();   
    }      
}// End of Cashier class   