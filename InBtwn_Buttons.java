/**
 * Abstract class InBtwn_Buttons - so you can use differnt classes for the smae button
 * 
 * @author (Pavithran Pathmarajah)
 * @version (2014 Jun 09)
 */
import javax.swing.*;

public  class InBtwn_Buttons extends JButton
{
    /**
     * To allow the subclasses to super the button name
     */
    public InBtwn_Buttons (String s)
    {
        super(s);
    }
    //universal to remove listeners
   public  void onDestroy()
   {
    }
}
