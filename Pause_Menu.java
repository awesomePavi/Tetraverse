/**
 * Write a description of class Pause_Restart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Pause_Menu implements ActionListener
{
   public void actionPerformed(ActionEvent e) 
          {     
              Main.endGame();
              Main.mainMenu();
            }   
}
