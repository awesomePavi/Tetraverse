/**
 *
 * 
 * @author (Pavithran Pathmarajah) 
 * @version (2014 May 23)
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class gameover_Menu implements ActionListener
{ 
    public void actionPerformed(ActionEvent e) 
          {     
               Main.endGame();
              Main.mainMenu();
            }
}