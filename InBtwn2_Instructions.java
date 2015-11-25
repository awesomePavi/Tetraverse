/**
 * All Attributes of the Instructions button
 * 
 * @author (Pavithran Pathmarajah) 
 * @version (2014 May 22)
 */
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.*;
import javax.swing.*;
public class InBtwn2_Instructions extends InBtwn_Buttons implements  MouseListener
{
   
    int width;
    int height;
    InBetweenMenu window;
    public InBtwn2_Instructions (int w, int h,InBetweenMenu ww)
    {
        super("DIRECTIONS");
        window=ww;
        width=w;
        height=h;
        setFocusPainted(false);//remove ugly highlight
        setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        setBackground(new Color(0x34536C)); //button
        setForeground(new Color(0x947D68));//text
        setOpaque(true);
        setBounds((width-170)/2,height-60, 170, 60);
        addMouseListener(this);
    }

    public void onDestroy()
    {
        this.removeMouseListener(this);
    }

    public void mouseClicked(MouseEvent e)
    {
    }

    public void mouseEntered(MouseEvent e)
    {
       window.showIns();
        setBounds((width-212)/2,height-65, 212, 60);
        setBackground(new Color(0x977E69));//background
        setForeground(new Color(0x34536C));//text
    }
    
  

    public void mouseExited(MouseEvent e)
    {
        window.standardWin();
        setBounds((width-170)/2,height-60, 170, 50);
        setBackground(new Color(0x34536C)); //button
        setForeground(new Color(0x947D68));//text
    }
    
    

    public void     mousePressed(MouseEvent e)
    {
    }

    public void     mouseReleased(MouseEvent e)
    {
    }
}
