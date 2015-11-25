
/**
 * links to arcade mode of tetris
 * 
 * @author (Shirley Xiao) 
 * @version (2014 June 4)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class MMenu_Ar implements ActionListener 
{
    JFrame runWindow;
    //current panel
    static GamePanel panel;
    static GameType type;
    
    //event of the arcade button
    public void actionPerformed(ActionEvent e)
    {
        //set mode from arraylist 
        //ArrayList<GameType> modes=new ArrayList<GameType>();
     //    GameType.ReadGameTypes(modes);
        
          //game type 0 orig 1 arcade
     //   Main.type=modes.get(1);
        Main.InBetweenMenu(1);
         
      /* Main.removeAndPrep();
       runWindow = new JFrame();
      panel = new InBetweenMenu(runWindow, type);
      runWindow.add(panel);
      //resize
      runWindow.pack(); 
      Main.newWindowStart();*/
    }
}

