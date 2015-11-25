/**
 * all panels must contain key-info to function with the main program
 * 
 * @author (Pavithran Pathmarajah)
 * @version (2014 Apr 30)
 */
import javax.swing.*;
public abstract class GamePanel extends JPanel
{
    /**
     * destory all event listners in your class
     * 
     * @param takes in window that, listneres must be removed from
     */
    public abstract void onDestroy(JFrame runWindow);
}
