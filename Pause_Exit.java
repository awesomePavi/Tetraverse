/**
 * Write a description of class Pause_Exit here.
 * 
 * @author (Shirley Xiao) 
 * @version (2014 May 1)
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Pause_Exit implements ActionListener
{
    public void actionPerformed(ActionEvent e) 
          {   
               Main.exit();
            }
}