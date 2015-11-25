
/**
 * link to classic version of tetris
 * 
 * @author (Shirley Xiao) 
 * @version (2014 June 8)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class MMenu_Cl implements ActionListener
{
    //run window
    JFrame runWindow;
    //current panel
    static GamePanel panel;
    static GameType type;
       
    
    //event of the classic button
    public void actionPerformed(ActionEvent e)
    {
        
        //set mode from arraylist 
      //  ArrayList<GameType> modes=new ArrayList<GameType>();
        //// GameType.ReadGameTypes(modes);
        
          //original gametype
       //  Main.type=modes.get(0);//game type 0 orig 1 arcade
         Main.InBetweenMenu(0);
    //  runWindow = new JFrame();
      //pass type to the inbetween menu
     // panel = new InBetweenMenu(runWindow, type);
   //   runWindow.add(panel);

      //resize
     // runWindow.pack();
    }
  
}
