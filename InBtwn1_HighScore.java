/**
 * All Attributes of the Instructions button
 * 
 * @author (Pavithran Pathmarajah) 
 * @version (2014 June 9)
 */
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.*;
import javax.swing.*;
public class InBtwn1_HighScore extends InBtwn_Buttons implements  MouseListener
{
   
    int width;
    int height;
    InBetweenMenu window;
    public InBtwn1_HighScore (int w, int h,InBetweenMenu ww)
    {
        super("HIGHSCORES");
        window=ww;
        width=w;
        height=h;
        setFocusPainted(false);//remove ugly highlight
        setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        setBackground(new Color(0x34536C)); //button
        setForeground(new Color(0x947D68));//text
        setOpaque(true);
        setBounds(121,height-60, 145, 50);
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
       window.showScore();
        setBounds(115,height-65, 157, 60);
        setBackground(new Color(0x977E69));//background
        setForeground(new Color(0x34536C));//text
    }
    
  

    public void mouseExited(MouseEvent e)
    {
        window.standardWin();
        setBounds(121,height-60, 145, 50);
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
