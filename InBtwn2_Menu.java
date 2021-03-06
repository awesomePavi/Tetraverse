/**
 * All Attributes of the menu button
 * 
 * @author (Pavithran Pathmarajah) 
 * @version (2014 May 22)
 */
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class InBtwn2_Menu extends InBtwn_Buttons implements  MouseListener,  ActionListener
{

    int width;
    int height;
     InBetweenMenu window;
    public InBtwn2_Menu (int w, int h,InBetweenMenu ww)
    {
        super("EDIT");
        window=ww;
        width=w;
        height=h;
        setFocusPainted(false);//remove ugly highlight
        setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        setBackground(new Color(0x34536C)); //button
        setForeground(new Color(0x947D68));//text
        setOpaque(true);
        setBounds(-20,height-60, 170, 50);
        addMouseListener(this);
        addActionListener(this);
    }

    public void onDestroy()
    {
        this.removeMouseListener(this);
        this.removeActionListener(this);
    }

    public void mouseClicked(MouseEvent e)
    {
    }

    public void mouseEntered(MouseEvent e)
    {    
      // window.blur();
       window.repaint();
        setBounds(-20,height-65, 190, 60);
       setBackground(new Color(0x977E69));//background
        setForeground(new Color(0x34536C));//text
    }
    
  

    public void mouseExited(MouseEvent e)
    {
         // window.standardWin();
        setBounds(-20,height-60, 170, 50);
        setBackground(new Color(0x34536C)); //button
        setForeground(new Color(0x947D68));//text
    }
    
    

    public void     mousePressed(MouseEvent e)
    {
    }

    public void     mouseReleased(MouseEvent e)
    {
    }
     public void actionPerformed(ActionEvent e) 
          {  
               Main.endGame();
                Main.customMode();
            }  
}
