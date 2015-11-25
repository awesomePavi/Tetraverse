/**
 * Pause Menu with options
 * 
 * @author (Shirley Xiao) 
 * @version (2014 Apr. 27)
 * 
 * http://www.javamex.com/tutorials/swing/jbutton.shtml
 * http://docs.oracle.com/javase/tutorial/uiswing/components/button.html
 * http://examples.javacodegeeks.com/desktop-java/swing/jbutton/create-jbutton-example/
 * http://stackoverflow.com/questions/1839074/howto-make-jbutton-with-simple-flat-style
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Robot;
import java.awt.image.BufferedImage;
  import javax.swing.ImageIcon;

public class PauseMenu extends GamePanel
{
     JButton resuButton;
     JButton restButton;
     JButton exButton;
     JButton menuButton;
     Pause_Menu mainMenu;
     Pause_Resume Continue; 
     Pause_Exit finish;
     Pause_Restart again;
     private BufferedImage image;
    public PauseMenu(JFrame runWindow)     
   {
       //buttons
       //resume button graphics
      resuButton = new JButton("RESUME");
      this.setLayout(null);
      resuButton.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
      resuButton.setBackground(Color.GREEN);
      resuButton.setBounds(380, 80, 100, 80);
       this.add(resuButton);
       
       //restart button graphics
       restButton = new JButton("RESTART");
       this.setLayout(null);
       restButton.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
       restButton.setBackground(Color.WHITE);
       restButton.setBounds(380, 200, 100, 80);
       this.add(restButton);
       
       //exit button graphics
       exButton = new JButton("EXIT");
       this.setLayout(null);
       exButton.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
       exButton.setBackground(Color.RED);
       exButton.setBounds(380, 440, 100, 80);
       this.add(exButton);
       
       //menu button grpahics
       menuButton  = new JButton("MENU");
       this.setLayout(null);
       menuButton.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
       menuButton.setBackground(Color.magenta);
       menuButton.setBounds(380, 320, 100, 80);
       this.add(menuButton);
       
      //takes screenshot of game before the pause menu is accessed
    
      
     // JLabel image = new JLabel(new ImageIcon("screenShot.png"));
      //image.setBounds(100, 500, 100, 100);

     // this.add(image);

       //creates window
       this.setBackground(new Color(0x339999));
       setPreferredSize(new Dimension(500,600));
       runWindow.setVisible(true);
       
     
      //Exit game button      
      finish = new Pause_Exit();
      exButton.addActionListener(finish);
       
       //resume game after paused
        Continue=new Pause_Resume();
        resuButton.addActionListener(Continue);
      
      //click restart button
      again = new Pause_Restart();
      restButton.addActionListener(again);
      
      mainMenu = new Pause_Menu();
      menuButton.addActionListener(mainMenu );
    }
    
    //remove listeners
    public void onDestroy(JFrame runWindow)
    {
        restButton.removeActionListener(again);
        resuButton.removeActionListener(Continue);
        exButton.removeActionListener(finish);
         menuButton.removeActionListener(mainMenu);
    }
    
   public void paint(Graphics g)
    {
        super.paint(g);
       
       //Pause menu title banner
        g.setColor(new Color(0x33CCCC));
        g.fillRect(40, 100, 200, 100);
        
        g.setColor(Color.BLACK);
        g.drawRect(60, 120, 160, 60);
        g.drawRect(40, 100, 200, 100);
        
        g.setColor(Color.WHITE);
        g.drawRect(61, 121, 160, 60);
     
        //text in banner
        g.setColor(Color.BLACK);
        g.setFont(new Font("Comic Sans MS",Font.BOLD,40));
        g.drawString("Paused. . .", 90,165);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Comic Sans MS",Font.BOLD,41));
        g.drawString("Paused . . .", 85,167);
        
        //Resume 
        g.setColor(Color.GREEN);
        ///g.drawRect(380, 115, 100, 80);
        
        //Restart
        g.setColor(Color.WHITE);
        //g.drawRect(380, 240, 100, 80);
        
        //Exit
        g.setColor(Color.RED);
        //g.drawRect(380, 358, 100, 80);
        
        //border
        g.setColor(Color.BLACK);
        //top
        g.fillRect(0, 50, 500, 30);
        //left
        g.fillRect(10, 10, 10, 600);
        //right
        g.fillRect(480, 10, 10, 600);
        //bottom
        g.fillRect(0, 562, 500, 10);
        
        //highlight
        g.setColor(Color.WHITE);
        //vertical line(left)
        g.drawLine(10, 0, 10, 50);
        g.drawLine(10, 560, 10, 80);
        g.drawLine(10, 572, 10, 608);
        //vertical line(right)
        g.drawLine(480, 0, 480, 50);
        g.drawLine(480, 560, 480, 80);
        g.drawLine(480, 572, 480,608);
        //horizontal line(top)
        g.drawLine(0, 50, 10, 50);
        g.drawLine(21, 50, 480, 50);
        g.drawLine(490, 50, 500, 50);
        //horizontal line(bottom)
        g.drawLine(0, 562, 10, 562);
        g.drawLine(20, 562, 480, 562);
        g.drawLine(490, 562, 500, 562);
       
       //show last view from in game
       g.drawRect(40,210,310,310);
       g.drawImage(Board.buffered, 45, 215, 300,300,null);
      
        
    }   
}



