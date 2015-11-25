/**
 * The main menu of the game with options to different versions of tetris
 * 
 * @author (Shirley Xiao) 
 * @version (2014 Apr. 28)
 * 
 */
//importing
import java.io.*;
import javax.swing.*;
import java.awt.*;

import java.awt.Color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.*;
import javax.imageio.*;
import java.io.IOException;
import java.awt.Toolkit;
import javax.swing.JFrame;

                               //call gamepanel to allow the onDestroy method
public class MainMenu extends GamePanel
{
    //create buttons for the main menu
    JButton classicButton;
    JButton arcadeButton;
    JButton customButton;
    JButton exitButton;
    //binding button
    JButton cKeyButton;
    
    BufferedImage image; 
    
    //create variable from classes to connect the main menu
    //       to the desired operation
    MainMenu_Exit finish;
    MMenu_Cl classic;
    MMenu_Ar arcade;
    MMenu_Cu custom;
    
    //constructor
    public MainMenu(JFrame runWindow)
    {       
        //propreties of the classicButton
        classicButton = new JButton("CLASSIC");
        this.setLayout(null);
        //set colour of the words in the letter
        classicButton.setForeground(Color.WHITE);
        //set front of the button
        classicButton.setFont(new Font("Castellar", Font.PLAIN, 14));
        //setting desired colour of button
        classicButton.setBackground(new Color(0x062A3D));
        //set the permeter of the button
        classicButton.setBounds(454, 152, 280, 50);
        //add button to the main menu panel
        this.add(classicButton);
        
        //propreties of the arcadeButton
        arcadeButton = new JButton("ARCADE");
        this.setLayout(null);
        arcadeButton.setForeground(Color.WHITE);
        arcadeButton.setFont(new Font("Castellar", Font.PLAIN, 14));
        arcadeButton.setBackground(new Color(0x062A3D));
        arcadeButton.setBounds(504, 252, 230, 50);
        this.add(arcadeButton);
        
        //phase 3 
        //propreties if the customButton
        customButton = new JButton("CUSTOM MODE");
        this.setLayout(null);
        customButton.setForeground(Color.WHITE);
        customButton.setFont(new Font("Castellar", Font.PLAIN, 14));
        customButton.setBackground(new Color(0x062A3D));
        customButton.setBounds(554, 352, 180, 50);
        this.add(customButton);
        
       /* //propreties of the ckeyButton
        cKeyButton = new JButton("Bindings");
        this.setLayout(null);
        cKeyButton.setForeground(Color.WHITE);
        cKeyButton.setFont(new Font("Castellar", Font.PLAIN, 10));
        cKeyButton.setBackground(new Color(0x062A3D));
        cKeyButton.setBounds(605, 454, 130, 50);
        this.add(cKeyButton);*/

        //propreties of the exit button
        exitButton = new JButton("");
        this.setLayout(null);
        exitButton.setBackground(new Color(0x062A3D));
        exitButton.setBounds(675, 35, 50, 50);
        this.add(exitButton);
        
        //event 
        //classic button
        classic = new MMenu_Cl();
        //create action listener for classic button
        classicButton.addActionListener(classic);
        
        //arcade button
        arcade = new MMenu_Ar();
        //create action listener for arcade button
        arcadeButton.addActionListener(arcade);
        
        //custom button 
        custom = new MMenu_Cu();
         //create action listener for custom button
        customButton.addActionListener(custom);
       
        //Exit game button      
        finish = new MainMenu_Exit();
         //create action listener for exit button
        exitButton.addActionListener(finish);
      
      
      
      //create window  
     this.setBackground(Color.BLACK);
     //set size of the main menu
     setPreferredSize(new Dimension(750,690));
     //make frame visible
     runWindow.setVisible(true);
    }
    
    //removes the acitonlisteners
    public void onDestroy(JFrame runWindow)
    {
        exitButton.removeActionListener(finish);
        classicButton.removeActionListener(classic);
        arcadeButton.removeActionListener(arcade);
        customButton.removeActionListener(custom);
    }
    
    //graphics for the menu 
    //override the default java codes for graphics
    public void paint(Graphics g)
    {
        super.paint(g);
     //game banner------------------------------------------------------------------
        //navy blue tiles
        g.setColor(new Color(0x062F45));
        g.fillRect(100, 80, 100, 60);
        g.fillRect(100, 240, 100, 100);
        g.fillRect(100, 440, 100, 100);
        g.fillRect(100, 640, 100, 30);
        
        //beige tiles
        g.setColor(new Color(0x9C9C58));
        g.fillRect(100, 140, 100, 100);
        g.fillRect(100, 340, 100, 100);
        g.fillRect(100, 540, 100, 100);
       
       
//1st beige tile on the right---------------------------------------------------
        //pixel layer 1       
       g.setColor(new Color(0x96965D));
       g.fillRect(205, 70, 10,10);
       g.fillRect(225, 70, 10,10);
       g.fillRect(245, 70, 10,10);      
       g.fillRect(245, 90, 10,10);
       g.fillRect(245, 110, 10,10);
       g.fillRect(245, 130, 10,10);
       
       //pixel layer 2
       g.setColor(new Color(0x858554));
       g.fillRect(200, 60, 5,10);
       g.fillRect(215, 60, 10,10);
       g.fillRect(235, 60, 10,10);
       g.fillRect(255, 60, 10,10);
       g.fillRect(255, 80, 10,10);
       g.fillRect(255, 100, 10,10);
       g.fillRect(255, 120, 10,10);
          
       //pixel layer 3
       g.setColor(new Color(0x5C5C3B));
       g.fillRect(205, 50, 10,10);
       g.fillRect(225, 50, 10,10);
       g.fillRect(245, 50, 10,10);
       g.fillRect(265, 50, 10,10);
       g.fillRect(265, 70, 10,10);
       g.fillRect(265, 90, 10,10);
       g.fillRect(265, 110, 10,10);
       g.fillRect(265, 130, 10,10);
       
       //pixel layer 4
       g.setColor(new Color(0x4A4A32));
       g.fillRect(200, 40, 5,10);
       g.fillRect(215, 40, 10,10);
       g.fillRect(235, 40, 10,10);
       g.fillRect(255, 40, 10,10);
       g.fillRect(275, 40, 10,10);
       g.fillRect(275, 60, 10,10);
       g.fillRect(275, 80, 10,10);
       g.fillRect(275, 100, 10,10);
       g.fillRect(275, 120, 10,10);
       
       //pixel layer 5
       g.setColor(new Color(0x3B3B28));
       g.fillRect(205, 30, 10,10);
       g.fillRect(225, 30, 10,10);
       g.fillRect(245, 30, 10,10);
       g.fillRect(265, 30, 10,10);
       g.fillRect(265, 30, 10,10);
       g.fillRect(285, 30, 10,10);
       g.fillRect(285, 50, 10,10);
       g.fillRect(285, 70, 10,10);
       g.fillRect(285, 90, 10,10);
       g.fillRect(285, 110, 10,10);
       g.fillRect(285, 130, 10,10);
       
       //pixel layer 6
       g.setColor(new Color(0x171710));
       g.fillRect(200, 20, 5,10);
       g.fillRect(215, 20, 10,10);
       g.fillRect(235, 20, 10,10);
       g.fillRect(255, 20, 10,10);
       g.fillRect(275, 20, 10,10);
       g.setColor(Color.BLACK);
       g.fillRect(295, 20, 10,10);
       g.fillRect(295, 40, 10,10);
       g.fillRect(295, 60, 10,10);
       g.fillRect(295, 80, 10,10);
       g.fillRect(295, 100, 10,10);
       g.fillRect(295, 120, 10,10);

//2nd beige tile on the right--------------------------------------------------
       //pixel layer 1       
       g.setColor(new Color(0x96965D));
       g.fillRect(245, 250, 10,10);
       g.fillRect(245, 270, 10,10);      
       g.fillRect(245, 290, 10,10);
       g.fillRect(245, 310, 10,10);
       g.fillRect(245, 330, 10,10);
       
       
       //pixel layer 2
       g.setColor(new Color(0x858554));
       g.fillRect(255, 240, 10,10);
       g.fillRect(255, 260, 10,10);
       g.fillRect(255, 280, 10,10);
       g.fillRect(255, 300, 10,10);
       g.fillRect(255, 320, 10,10);
       
          
       //pixel layer 3
       g.setColor(new Color(0x5C5C3B));
       g.fillRect(265, 250, 10,10);
       g.fillRect(265, 270, 10,10);
       g.fillRect(265, 290, 10,10);
       g.fillRect(265, 310, 10,10);
       g.fillRect(265, 330, 10,10);
       
       //pixel layer 4
       g.setColor(new Color(0x4A4A32));
       g.fillRect(275, 240, 10,10);
       g.fillRect(275, 260, 10,10);
       g.fillRect(275, 280, 10,10);
       g.fillRect(275, 300, 10,10);
       g.fillRect(275, 320, 10,10);     
       
       //pixel layer 5
       g.setColor(new Color(0x3B3B28));
       g.fillRect(285, 250, 10,10);
       g.fillRect(285, 270, 10,10);
       g.fillRect(285, 290, 10,10);
       g.fillRect(285, 310, 10,10);
       g.fillRect(285, 330, 10,10);      
       
       //pixel layer 6
       g.setColor(Color.BLACK);
       g.fillRect(295, 240, 10,10);
       g.fillRect(295, 260, 10,10);
       g.fillRect(295, 280, 10,10);
       g.fillRect(295, 300, 10,10);
       g.fillRect(295, 320, 10,10);

//3rd beige tile on the right--------------------------------------------------
       //pixel layer 1       
       g.setColor(new Color(0x96965D));
       g.fillRect(245, 450, 10,10);
       g.fillRect(245, 470, 10,10);      
       g.fillRect(245, 490, 10,10);
       g.fillRect(245, 510, 10,10);
       g.fillRect(245, 530, 10,10);
       
       
       //pixel layer 2
       g.setColor(new Color(0x858554));
       g.fillRect(255, 440, 10,10);
       g.fillRect(255, 460, 10,10);
       g.fillRect(255, 480, 10,10);
       g.fillRect(255, 500, 10,10);
       g.fillRect(255, 520, 10,10);
       
          
       //pixel layer 3
       g.setColor(new Color(0x5C5C3B));
       g.fillRect(265, 450, 10,10);
       g.fillRect(265, 470, 10,10);
       g.fillRect(265, 490, 10,10);
       g.fillRect(265, 510, 10,10);
       g.fillRect(265, 530, 10,10);
       
       //pixel layer 4
       g.setColor(new Color(0x4A4A32));
       g.fillRect(275, 440, 10,10);
       g.fillRect(275, 460, 10,10);
       g.fillRect(275, 480, 10,10);
       g.fillRect(275, 500, 10,10);
       g.fillRect(275, 520, 10,10);     
       
       //pixel layer 5
       g.setColor(new Color(0x3B3B28));
       g.fillRect(285, 450, 10,10);
       g.fillRect(285, 470, 10,10);
       g.fillRect(285, 490, 10,10);
       g.fillRect(285, 510, 10,10);
       g.fillRect(285, 530, 10,10);      
       
       //pixel layer 6
       g.setColor(Color.BLACK);
       g.fillRect(295, 440, 10,10);
       g.fillRect(295, 460, 10,10);
       g.fillRect(295, 480, 10,10);
       g.fillRect(295, 500, 10,10);
       g.fillRect(295, 520, 10,10);
       
//4rd beige tile on the right--------------------------------------------------
      //pixel layer 1       
       g.setColor(new Color(0x96965D));
       g.fillRect(245, 650, 10,10);
       g.fillRect(245, 670, 10,10);     
           
       //pixel layer 2
       g.setColor(new Color(0x858554));
       g.fillRect(255, 640, 10,10);
       g.fillRect(255, 660, 10,10);
             
       //pixel layer 3
       g.setColor(new Color(0x5C5C3B));
       g.fillRect(265, 650, 10,10);
       g.fillRect(265, 670, 10,10);
       
       //pixel layer 4
       g.setColor(new Color(0x4A4A32));
       g.fillRect(275, 640, 10,10);
       g.fillRect(275, 660, 10,10);   
       
       //pixel layer 5
       g.setColor(new Color(0x3B3B28));
       g.fillRect(285, 650, 10,10);
       g.fillRect(285, 670, 10,10);

       //pixel layer 6
       g.setColor(Color.BLACK);
       g.fillRect(295, 640, 10,10);
       g.fillRect(295, 660, 10,10);  
       
//5th beige tile on the left--------------------------------------------------
        //pixel layer 1       
       g.setColor(new Color(0x96965D));
       g.fillRect(205, 670, 10,10);
       g.fillRect(225, 670, 10,10);
       g.fillRect(245, 670, 10,10);      
       
       //pixel layer 2
       g.setColor(new Color(0x858554));
       g.fillRect(200, 680, 5,10);
       g.fillRect(215, 680, 10,10);
       g.fillRect(235, 680, 10,10);
       g.fillRect(255, 680, 10,10);
       g.setColor(new Color(0x4A4A32));
       g.fillRect(275, 680 , 10, 10);
       g.setColor(Color.BLACK);
       g.fillRect(295, 680, 10, 10);
          
       //pixel layer 3
       g.setColor(new Color(0x5C5C3B));
       g.fillRect(205, 690, 10,10);
       g.fillRect(225, 690, 10,10);
       g.fillRect(245, 690, 10,10);
       g.fillRect(265, 690, 10, 10);
       g.setColor(new Color(0x3B3B28));
       g.fillRect(285, 690, 10, 10);
       g.setColor(Color.BLACK);
       g.fillRect(300, 690, 10, 10);
       
//1st beige tile on the left--------------------------------------------------
        //pixel layer 1       
       g.setColor(new Color(0x96965D));
       g.fillRect(85, 70, 10,10);
       g.fillRect(65, 70, 10,10);
       g.fillRect(45, 70, 10,10);      
       g.fillRect(45, 90, 10,10);
       g.fillRect(45, 110, 10,10);
       g.fillRect(45, 130, 10,10);
       
       //pixel layer 2
       g.setColor(new Color(0x858554));
       g.fillRect(95, 60, 5,10);
       g.fillRect(75, 60, 10,10);
       g.fillRect(55, 60, 10,10);
       g.fillRect(35, 60, 10,10);
       g.fillRect(35, 80, 10,10);
       g.fillRect(35, 100, 10,10);
       g.fillRect(35, 120, 10,10);
          
       //pixel layer 3
       g.setColor(new Color(0x5C5C3B));
       g.fillRect(85, 50, 10,10);
       g.fillRect(65, 50, 10,10);
       g.fillRect(45, 50, 10,10);
       g.fillRect(25, 50, 10,10);
       g.fillRect(25, 70, 10,10);
       g.fillRect(25, 90, 10,10);
       g.fillRect(25, 110, 10,10);
       g.fillRect(25, 130, 10,10);
       
       //pixel layer 4
       g.setColor(new Color(0x4A4A32));
       g.fillRect(95, 40, 5,10);
       g.fillRect(75, 40, 10,10);
       g.fillRect(55, 40, 10,10);
       g.fillRect(35, 40, 10,10);
       g.fillRect(15, 40, 10,10);
       g.fillRect(15, 60, 10,10);
       g.fillRect(15, 80, 10,10);
       g.fillRect(15, 100, 10,10);
       g.fillRect(15, 120, 10,10);
       
       //pixel layer 5
       g.setColor(new Color(0x3B3B28));
       g.fillRect(85, 30, 10,10);
       g.fillRect(65, 30, 10,10);
       g.fillRect(45, 30, 10,10);
       g.fillRect(25, 30, 10,10);
       g.fillRect(5, 30, 10,10);
       g.fillRect(5, 30, 10,10);
       g.fillRect(5, 50, 10,10);
       g.fillRect(5, 70, 10,10);
       g.fillRect(5, 90, 10,10);
       g.fillRect(5, 110, 10,10);
       g.fillRect(5, 130, 10,10);
//2nd beige tile on the left----------------------------------------------------
        //pixel layer 1       
       g.setColor(new Color(0x96965D));
       g.fillRect(45, 250, 10,10);
       g.fillRect(45, 270, 10,10);      
       g.fillRect(45, 290, 10,10);
       g.fillRect(45, 310, 10,10);
       g.fillRect(45, 330, 10,10);
       
       //pixel layer 2
       g.setColor(new Color(0x858554));
       g.fillRect(35, 240, 10,10);
       g.fillRect(35, 260, 10,10);
       g.fillRect(35, 280, 10,10);
       g.fillRect(35, 300, 10,10);
       g.fillRect(35, 320, 10,10);
       
          
       //pixel layer 3
       g.setColor(new Color(0x5C5C3B));
       g.fillRect(25, 250, 10,10);
       g.fillRect(25, 270, 10,10);
       g.fillRect(25, 290, 10,10);
       g.fillRect(25, 310, 10,10);
       g.fillRect(25, 330, 10,10);
       
       //pixel layer 4
       g.setColor(new Color(0x4A4A32));
       g.fillRect(15, 240, 10,10);
       g.fillRect(15, 260, 10,10);
       g.fillRect(15, 280, 10,10);
       g.fillRect(15, 300, 10,10);
       g.fillRect(15, 320, 10,10);     
       
       //pixel layer 5
       g.setColor(new Color(0x3B3B28));
       g.fillRect(5, 250, 10,10);
       g.fillRect(5, 270, 10,10);
       g.fillRect(5, 290, 10,10);
       g.fillRect(5, 310, 10,10);
       g.fillRect(5, 330, 10,10);  
       
//3rd beige tile on the left----------------------------------------------------
       //pixel layer 1       
       g.setColor(new Color(0x96965D));
       g.fillRect(45, 450, 10,10);
       g.fillRect(45, 470, 10,10);      
       g.fillRect(45, 490, 10,10);
       g.fillRect(45, 510, 10,10);
       g.fillRect(45, 530, 10,10);      
       
       //pixel layer 2
       g.setColor(new Color(0x858554));
       g.fillRect(35, 440, 10,10);
       g.fillRect(35, 460, 10,10);
       g.fillRect(35, 480, 10,10);
       g.fillRect(35, 500, 10,10);
       g.fillRect(35, 520, 10,10);       
          
       //pixel layer 3
       g.setColor(new Color(0x5C5C3B));
       g.fillRect(25, 450, 10,10);
       g.fillRect(25, 470, 10,10);
       g.fillRect(25, 490, 10,10);
       g.fillRect(25, 510, 10,10);
       g.fillRect(25, 530, 10,10);
       
       //pixel layer 4
       g.setColor(new Color(0x4A4A32));
       g.fillRect(15, 440, 10,10);
       g.fillRect(15, 460, 10,10);
       g.fillRect(15, 480, 10,10);
       g.fillRect(15, 500, 10,10);
       g.fillRect(15, 520, 10,10);     
       
       //pixel layer 5
       g.setColor(new Color(0x3B3B28));
       g.fillRect(5, 450, 10,10);
       g.fillRect(5, 470, 10,10);
       g.fillRect(5, 490, 10,10);
       g.fillRect(5, 510, 10,10);
       g.fillRect(5, 530, 10,10);      
       
//4th beige tile on the left--------------------------------------------------
        //pixel layer 1       
       g.setColor(new Color(0x96965D));
       g.fillRect(5, 670, 10,10);
       g.fillRect(25, 670, 10,10);
       g.fillRect(45, 670, 10,10);      
       g.fillRect(65, 670, 10,10);
       g.fillRect(85, 670, 10,10);
       
       //pixel layer 2
       g.setColor(new Color(0x858554));
       g.fillRect(0, 680, 5,10);
       g.fillRect(15, 680, 10,10);
       g.fillRect(35, 680, 10,10);
       g.fillRect(55, 680, 10,10);
       g.fillRect(75, 680, 10,10);
       g.fillRect(95, 680, 5,10);
          
       //pixel layer 3
       g.setColor(new Color(0x5C5C3B));
       g.fillRect(5, 690, 10,10);
       g.fillRect(25, 690, 10,10);
       g.fillRect(45, 690, 10,10);
       g.fillRect(65, 690, 10,10);
       g.fillRect(85, 690, 10,10);
       
//1st navyblue tile on the center------------------------------------------------
       //pixel layer 1 
       g.setColor(new Color(0x062A3D));
       g.fillRect(105, 70, 10,10);
       g.fillRect(125, 70, 10,10);
       g.fillRect(145, 70, 10,10);      
       g.fillRect(165, 70, 10,10);
       g.fillRect(185, 70, 10,10);
       
       //pixel layer 2
       g.setColor(new Color(0x052536));
       g.fillRect(100, 60, 5,10);
       g.fillRect(115, 60, 10,10);
       g.fillRect(135, 60, 10,10);
       g.fillRect(155, 60, 10,10);
       g.fillRect(175, 60, 10,10);
       g.fillRect(195, 60, 5,10);
          
       //pixel layer 3
       g.setColor(new Color(0x042130));
       g.fillRect(105, 50, 10,10);
       g.fillRect(125, 50, 10,10);
       g.fillRect(145, 50, 10,10);
       g.fillRect(165, 50, 10,10);
       g.fillRect(185, 50, 10,10);
       
       //pixel layer 4
       g.setColor(new Color(0x041A26));
       g.fillRect(100, 40, 5,10);
       g.fillRect(115, 40, 10,10);
       g.fillRect(135, 40, 10,10);
       g.fillRect(155, 40, 10,10);
       g.fillRect(175, 40, 10,10);
       g.fillRect(195, 40, 5,10);
       
       //pixel layer 5
       g.setColor(new Color(0x03151F));
       g.fillRect(105, 30, 10,10);
       g.fillRect(125, 30, 10,10);
       g.fillRect(145, 30, 10,10);
       g.fillRect(165, 30, 10,10);
       g.fillRect(185, 30, 10,10);
       
       //pixel layer 6
        g.setColor(Color.BLACK);
       g.fillRect(115, 20, 10,10);
       g.fillRect(135, 20, 10,10);
       g.fillRect(155, 20, 10,10);
       g.fillRect(175, 20, 10,10);     
       g.fillRect(195, 20, 5,10);  
       
//2nd navyblue tile on the center-----------------------------------------------
        //pixel layer 1       
       g.setColor(new Color(0x062A3D));
       g.fillRect(105, 670, 10,10);
       g.fillRect(125, 670, 10,10);
       g.fillRect(145, 670, 10,10);      
       g.fillRect(165, 670, 10,10);
       g.fillRect(185, 670, 10,10);
       
       //pixel layer 2
       g.setColor(new Color(0x052536));
       g.fillRect(100, 680, 5,10);
       g.fillRect(115, 680, 10,10);
       g.fillRect(135, 680, 10,10);
       g.fillRect(155, 680, 10,10);
       g.fillRect(175, 680, 10,10);
       g.fillRect(195, 680, 5,10);
          
       //pixel layer 3
       g.setColor(new Color(0x042130));
       g.fillRect(105, 690, 10,10);
       g.fillRect(125, 690, 10,10);
       g.fillRect(145, 690, 10,10);
       g.fillRect(165, 690, 10,10);
       g.fillRect(185, 690, 10,10);
       
       
//1st navyblue tile on the right------------------------------------------------
       //pixel layer 1       
       g.setColor(new Color(0x062A3D));
       g.fillRect(245, 150, 10,10);
       g.fillRect(245, 170, 10,10);      
       g.fillRect(245, 190, 10,10);
       g.fillRect(245, 210, 10,10);
       g.fillRect(245, 230, 10,10);
       
       
       //pixel layer 2
       g.setColor(new Color(0x052536));
       g.fillRect(255, 140, 10,10);
       g.fillRect(255, 160, 10,10);
       g.fillRect(255, 180, 10,10);
       g.fillRect(255, 200, 10,10);
       g.fillRect(255, 220, 10,10);
       
          
       //pixel layer 3
       g.setColor(new Color(0x042130));
       g.fillRect(265, 150, 10,10);
       g.fillRect(265, 170, 10,10);
       g.fillRect(265, 190, 10,10);
       g.fillRect(265, 210, 10,10);
       g.fillRect(265, 230, 10,10);
       
       //pixel layer 4
       g.setColor(new Color(0x041A26));
       g.fillRect(275, 140, 10,10);
       g.fillRect(275, 160, 10,10);
       g.fillRect(275, 180, 10,10);
       g.fillRect(275, 200, 10,10);
       g.fillRect(275, 220, 10,10);     
       
       //pixel layer 5
       g.setColor(new Color(0x03151F));
       g.fillRect(285, 150, 10,10);
       g.fillRect(285, 170, 10,10);
       g.fillRect(285, 190, 10,10);
       g.fillRect(285, 210, 10,10);
       g.fillRect(285, 230, 10,10);      
       
       //pixel layer 6
       g.setColor(Color.BLACK);
       g.fillRect(295, 140, 10,10);
       g.fillRect(295, 160, 10,10);
       g.fillRect(295, 180, 10,10);
       g.fillRect(295, 200, 10,10);
       g.fillRect(295, 220, 10,10);
       
//2nd navyblue tile on the right------------------------------------------------
          //pixel layer 1       
       g.setColor(new Color(0x062A3D));
       g.fillRect(245, 350, 10,10);
       g.fillRect(245, 370, 10,10);      
       g.fillRect(245, 390, 10,10);
       g.fillRect(245, 410, 10,10);
       g.fillRect(245, 430, 10,10);
       
       
       //pixel layer 2
       g.setColor(new Color(0x052536));
       g.fillRect(255, 340, 10,10);
       g.fillRect(255, 360, 10,10);
       g.fillRect(255, 380, 10,10);
       g.fillRect(255, 400, 10,10);
       g.fillRect(255, 420, 10,10);
       
          
       //pixel layer 3
       g.setColor(new Color(0x042130));
       g.fillRect(265, 350, 10,10);
       g.fillRect(265, 370, 10,10);
       g.fillRect(265, 390, 10,10);
       g.fillRect(265, 410, 10,10);
       g.fillRect(265, 430, 10,10);
       
       //pixel layer 4
       g.setColor(new Color(0x041A26));
       g.fillRect(275, 340, 10,10);
       g.fillRect(275, 360, 10,10);
       g.fillRect(275, 380, 10,10);
       g.fillRect(275, 400, 10,10);
       g.fillRect(275, 420, 10,10);     
       
       //pixel layer 5
       g.setColor(new Color(0x03151F));
       g.fillRect(285, 350, 10,10);
       g.fillRect(285, 370, 10,10);
       g.fillRect(285, 390, 10,10);
       g.fillRect(285, 410, 10,10);
       g.fillRect(285, 430, 10,10);      
       
       //pixel layer 6
       g.setColor(Color.BLACK);
       g.fillRect(295, 340, 10,10);
       g.fillRect(295, 360, 10,10);
       g.fillRect(295, 380, 10,10);
       g.fillRect(295, 400, 10,10);
       g.fillRect(295, 420, 10,10);
       
//3rd navyblue tile on the right------------------------------------------------
          //pixel layer 1       
       g.setColor(new Color(0x062A3D));
       g.fillRect(245, 550, 10,10);
       g.fillRect(245, 570, 10,10);      
       g.fillRect(245, 590, 10,10);
       g.fillRect(245, 610, 10,10);
       g.fillRect(245, 630, 10,10);
       
       
       //pixel layer 2
       g.setColor(new Color(0x052536));
       g.fillRect(255, 540, 10,10);
       g.fillRect(255, 560, 10,10);
       g.fillRect(255, 580, 10,10);
       g.fillRect(255, 600, 10,10);
       g.fillRect(255, 620, 10,10);
       
          
       //pixel layer 3
       g.setColor(new Color(0x042130));
       g.fillRect(265, 550, 10,10);
       g.fillRect(265, 570, 10,10);
       g.fillRect(265, 590, 10,10);
       g.fillRect(265, 610, 10,10);
       g.fillRect(265, 630, 10,10);
       
       //pixel layer 4
       g.setColor(new Color(0x041A26));
       g.fillRect(275, 540, 10,10);
       g.fillRect(275, 560, 10,10);
       g.fillRect(275, 580, 10,10);
       g.fillRect(275, 600, 10,10);
       g.fillRect(275, 620, 10,10);     
       
       //pixel layer 5
       g.setColor(new Color(0x03151F));
       g.fillRect(285, 550, 10,10);
       g.fillRect(285, 570, 10,10);
       g.fillRect(285, 590, 10,10);
       g.fillRect(285, 610, 10,10);
       g.fillRect(285, 630, 10,10);      
       
       //pixel layer 6
       g.setColor(Color.BLACK);
       g.fillRect(295, 540, 10,10);
       g.fillRect(295, 560, 10,10);
       g.fillRect(295, 580, 10,10);
       g.fillRect(295, 600, 10,10);
       g.fillRect(295, 620, 10,10);

//1st navyblue tile on the left-------------------------------------------------
       //pixel layer 1       
       g.setColor(new Color(0x062A3D));
       g.fillRect(45, 150, 10,10);
       g.fillRect(45, 170, 10,10);      
       g.fillRect(45, 190, 10,10);
       g.fillRect(45, 210, 10,10);
       g.fillRect(45, 230, 10,10);
       
       
       //pixel layer 2
       g.setColor(new Color(0x052536));
       g.fillRect(35, 140, 10,10);
       g.fillRect(35, 160, 10,10);
       g.fillRect(35, 180, 10,10);
       g.fillRect(35, 200, 10,10);
       g.fillRect(35, 220, 10,10);
       
        //pixel layer 3
       g.setColor(new Color(0x042130));
       g.fillRect(25, 150, 10,10);
       g.fillRect(25, 170, 10,10);
       g.fillRect(25, 190, 10,10);
       g.fillRect(25, 210, 10,10);
       g.fillRect(25, 230, 10,10);
       
       //pixel layer 4
       g.setColor(new Color(0x041A26));
       g.fillRect(15, 140, 10,10);
       g.fillRect(15, 160, 10,10);
       g.fillRect(15, 180, 10,10);
       g.fillRect(15, 200, 10,10);
       g.fillRect(15, 220, 10,10);  
       
        //pixel layer 5
       g.setColor(new Color(0x03151F));
       g.fillRect(5, 150, 10,10);
       g.fillRect(5, 170, 10,10);
       g.fillRect(5, 190, 10,10);
       g.fillRect(5, 210, 10,10);
       g.fillRect(5, 230, 10,10);  
       
//2nd navyblue tile-------------------------------------------------------------
 //pixel layer 1       
       g.setColor(new Color(0x062A3D));
       g.fillRect(45, 350, 10,10);
       g.fillRect(45, 370, 10,10);      
       g.fillRect(45, 390, 10,10);
       g.fillRect(45, 410, 10,10);
       g.fillRect(45, 430, 10,10);
       
       
       //pixel layer 2
       g.setColor(new Color(0x052536));
       g.fillRect(35, 340, 10,10);
       g.fillRect(35, 360, 10,10);
       g.fillRect(35, 380, 10,10);
       g.fillRect(35, 400, 10,10);
       g.fillRect(35, 420, 10,10);
       
          
       //pixel layer 3
       g.setColor(new Color(0x042130));
       g.fillRect(25, 350, 10,10);
       g.fillRect(25, 370, 10,10);
       g.fillRect(25, 390, 10,10);
       g.fillRect(25, 410, 10,10);
       g.fillRect(25, 430, 10,10);
       
       //pixel layer 4
       g.setColor(new Color(0x041A26));
       g.fillRect(15, 340, 10,10);
       g.fillRect(15, 360, 10,10);
       g.fillRect(15, 380, 10,10);
       g.fillRect(15, 400, 10,10);
       g.fillRect(15, 420, 10,10);     
       
       //pixel layer 5
       g.setColor(new Color(0x03151F));
       g.fillRect(5, 350, 10,10);
       g.fillRect(5, 370, 10,10);
       g.fillRect(5, 390, 10,10);
       g.fillRect(5, 410, 10,10);
       g.fillRect(5, 430, 10,10); 
   
//3rd navy blue tile------------------------------------------------------------
        //pixel layer 1       
       g.setColor(new Color(0x062A3D));
       g.fillRect(45, 550, 10,10);
       g.fillRect(45, 570, 10,10);      
       g.fillRect(45, 590, 10,10);
       g.fillRect(45, 610, 10,10);
       g.fillRect(45, 630, 10,10);
       
       
       //pixel layer 2
       g.setColor(new Color(0x052536));
       g.fillRect(35, 540, 10,10);
       g.fillRect(35, 560, 10,10);
       g.fillRect(35, 580, 10,10);
       g.fillRect(35, 600, 10,10);
       g.fillRect(35, 620, 10,10);
       
          
       //pixel layer 3
       g.setColor(new Color(0x042130));
       g.fillRect(25, 550, 10,10);
       g.fillRect(25, 570, 10,10);
       g.fillRect(25, 590, 10,10);
       g.fillRect(25, 610, 10,10);
       g.fillRect(25, 630, 10,10);
       
       //pixel layer 4
       g.setColor(new Color(0x041A26));
       g.fillRect(15, 540, 10,10);
       g.fillRect(15, 560, 10,10);
       g.fillRect(15, 580, 10,10);
       g.fillRect(15, 600, 10,10);
       g.fillRect(15, 620, 10,10);     
       
       //pixel layer 5
       g.setColor(new Color(0x03151F));
       g.fillRect(5, 550, 10,10);
       g.fillRect(5, 570, 10,10);
       g.fillRect(5, 590, 10,10);
       g.fillRect(5, 610, 10,10);
       g.fillRect(5, 630, 10,10);   
       
//border
         //top
       g.setColor(new Color(0x3B090F));
       g.fillRect(0, 0, 750, 25);
       g.setColor(new Color(0x30080D));
       g.fillRect(0, 10, 750, 15);
       g.setColor(new Color(0x240509));
       g.fillRect(0, 15, 750, 10);
       g.setColor(new Color(0x170306));
       g.fillRect(0, 20, 750, 5);
       
        //left side
        g.setColor(new Color(0x942532));
        g.fillRect(330, 25, 16, 700);
        g.setColor(new Color(0x660E19));
        g.fillRect(330, 25, 16, 125);
        g.setColor(new Color(0x4A0B13));
        g.fillRect(330, 25, 16, 115);
        g.setColor(new Color(0x3B090F));
        g.fillRect(330, 25, 16, 110);
        g.setColor(new Color(0x29070B));
        g.fillRect(330, 25, 16, 90);
        g.setColor(new Color(0x240509));
        g.fillRect(330, 25, 16, 100);
        g.setColor(new Color(0x170306));
        g.fillRect(330, 25, 16, 70);
        
      
        g.setColor(new Color(0x660E19));
        g.fillRect(330, 203, 16, 50);
        g.setColor(new Color(0x660E19));
        g.fillRect(330, 303, 16, 50);
        g.setColor(new Color(0x660E19));
        g.fillRect(330, 403, 16, 50);
        g.setColor(new Color(0x660E19));
        g.fillRect(330, 503, 16, 50);
        g.setColor(new Color(0x660E19));
        g.fillRect(330, 603, 16, 50);
        
         g.setColor(new Color(0x170306));
        g.fillRect(332, 25, 5, 700);
        
        //right side
        g.setColor(new Color(0x942532));
        g.fillRect(735, 25, 6, 700);
        g.setColor(new Color(0x660E19));
        g.fillRect(735, 25, 6, 125);
        g.setColor(new Color(0x4A0B13));
        g.fillRect(735, 25, 6, 115);
        g.setColor(new Color(0x3B090F));
        g.fillRect(735, 25, 6, 110);
        g.setColor(new Color(0x29070B));
        g.fillRect(735, 25, 6, 90);
        g.setColor(new Color(0x240509));
        g.fillRect(735, 25, 6, 100);
        g.setColor(new Color(0x170306));
        g.fillRect(735, 25, 6, 70);
        
      
        g.setColor(new Color(0x660E19));
        g.fillRect(735, 203, 6, 50);
        g.setColor(new Color(0x660E19));
        g.fillRect(735, 303, 6, 50);
        g.setColor(new Color(0x660E19));
        g.fillRect(735, 403, 6, 50);
        g.setColor(new Color(0x660E19));
        g.fillRect(735, 503, 6, 50);
        g.setColor(new Color(0x660E19));
        g.fillRect(735, 603, 6, 50);
              
//------------------------------------------------------------------------------
       //game name 
        g.setColor(Color.WHITE);
        g.setFont(new Font("Castellar", Font.PLAIN, 70));
      
        g.drawString("T", 125, 140);
        g.drawString("E", 125, 200);
        g.drawString("T", 125, 260);
        g.drawString("R", 125, 320);
        g.drawString("A", 125, 380);
        g.drawString("V", 125, 440);
        g.drawString("E", 125, 500);
        g.drawString("R", 125, 560);
        g.drawString("S", 125, 615);
        g.drawString("E", 125, 670);         
        
        //exit button
        g.setColor(new Color(0xBFBDBE));
        g.setFont(new Font("Castellar", Font.BOLD, 13));
        g.drawString("E", 655, 45);
        g.drawString("X", 655, 60);
        g.drawString("I", 655, 75);
        g.drawString("T", 655, 90);

        //horizontal line of rectangle
        g.setColor(new Color(0xBFBDBE));
        //classic button
        //vertical line of rectangle
        g.drawLine(450, 149, 450, 198);
        //horizontal line of rectangle
        g.drawLine(450, 149, 732, 149);
        
        //arcade button
        g.drawLine(500, 249, 500, 298);
        g.drawLine(500, 249, 732, 249);
        
        //custom button
        g.drawLine(550, 349, 550, 398);
        g.drawLine(550, 349, 732, 349);
        
        //binding button
       // g.drawLine(600, 449, 600, 498);
       // g.drawLine(600, 449, 732, 449);
        
        //exit button
        g.setColor(new Color(0x1F1E1E));
        g.drawLine(665, 25, 665, 93);
        g.setColor(new Color(0x5C5A5A));
        g.drawLine(665, 94, 732, 94);
        
        //width of rectangle
        g.setColor(Color.WHITE);
        //classic button
        g.drawLine(450, 149, 453, 152);
        g.drawLine(450, 198, 453, 201);
        
        //arcade button
        g.drawLine(500, 249, 503, 252);
        g.drawLine(500, 298, 503, 301);
        
        //custom button
        g.drawLine(550, 349, 553, 352);
        g.drawLine(550, 398, 553, 401);

        //bindings button
        g.drawLine(600, 449, 603, 452);
        g.drawLine(600, 498, 603, 501);       
        
    }
}