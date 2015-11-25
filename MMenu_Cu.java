
/**
 * links main menu to the custom mode
 * 
 * @author (Shirley Xiao) 
 * @version (2014 June 4)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class MMenu_Cu extends JFrame implements ActionListener
{  
    JFrame runWindow;
    static GamePanel panel;
    static GameType type;
   
    public void actionPerformed(ActionEvent e)
    {
               
       //System.out.println("Custom");
 
   /**
   *NOTE***get custom menu that stephan will create there will
   *be options to choose what type of block that will be included in the custom
   *mode and will play it like that
   */
  /*
      // setDefaultCloseOperation(EXIT_ON_CLOSE);
      // create window
      this.getContentPane().setBackground(Color.BLACK);
       this.setSize(new Dimension(500,500)); 
       this.setVisible(true);
       /  ArrayList<GameType> modes=new ArrayList<GameType>();
       */
         Main.customMode();
        
    }
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.RED);
        g.drawRect(100, 100, 100, 100);
    }
    
    
}

