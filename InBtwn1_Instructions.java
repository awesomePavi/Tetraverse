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
public class InBtwn1_Instructions extends InBtwn_Buttons implements  MouseListener
{
    //button info
    int width;
    int height;
    //to call main panel
    InBetweenMenu window;
    //takes in window width, and height aswell as the menu info
    public InBtwn1_Instructions (int w, int h,InBetweenMenu ww)
    {
        //name of button
        super("DIRECTIONS");
        window=ww;
        width=w;
        height=h;
        setFocusPainted(false);//remove ugly highlight
        setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        setBackground(new Color(0x34536C)); //button colour
        setForeground(new Color(0x947D68));//text colour
        setOpaque(true);
        //postion
        setBounds(width-266,height-60, 145, 50);
        //get mouse info
        addMouseListener(this);
    }

    public void onDestroy()
    {
        this.removeMouseListener(this);
    }

    //on mouseover, show the instucrtions overlay and expand the button
    public void mouseEntered(MouseEvent e)
    {
        window.showIns();
        setBounds(width-273,height-65, 157, 60);
        setBackground(new Color(0x977E69));//background
        setForeground(new Color(0x34536C));//text
    }

    //set button back to nromal
    public void mouseExited(MouseEvent e)
    {
        window.standardWin();
        setBounds(width-266,height-60, 145, 50);
        setBackground(new Color(0x34536C)); //button
        setForeground(new Color(0x947D68));//text
    }

    //mouse listener interface

    public void     mousePressed(MouseEvent e)
    {
    }

    public void     mouseReleased(MouseEvent e)
    {
    }

    public void mouseClicked(MouseEvent e)
    {
    }
}
