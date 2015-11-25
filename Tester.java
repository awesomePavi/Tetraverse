
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.util.*;
public class Tester
{
      static int choice=1;
           static JFrame t=new JFrame();
 public static void main()
 {
     gameColour.setColour();
      ArrayList<KeyLayout> modes=new ArrayList<KeyLayout>();
        KeyLayout.readLayouts(modes);
      
     //t.add(new BindingsMenu(t,modes));
     //t.add(new HighScoreScreen(t));
     t.add(new CustomModeScreen(t));
     t.pack();
     t.setVisible (true);
    }
}
