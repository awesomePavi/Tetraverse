/**
 * Write a description of class  here.
 *
 * @author (Stephen Webb)
 * @version (9 Jun 2014)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.event.*;

public class HighScoreScreen extends GamePanel implements ActionListener
{
    Graphics highScoreG; //
    BufferedImage highScoreB;
    JTextField nameInput; 
    Font plain = new Font("Comic Sans MS", Font.BOLD, 14);
    public HighScoreScreen (JFrame runWindow)
    {
        //super(new GridBagLayout());
        nameInput = new JTextField (12);
        nameInput.addActionListener (this);
        
        GridBagConstraints c = new GridBagConstraints ();
                //c.fill = GridBagConstraints.HORIZONTAL;
              //c.weightx = 0.5;

        //c.gridwidth = GridBagConstraints.REMAINDER;
        
        //c.fill = GridBagConstraints.BOTH;
        //c.gridx = 0;
        //c.gridy = 0;
        //c.ipady = 40;
        //c.gridwidth = GridBagConstraints.REMAINDER;
        //c.gridheight = GridBagConstraints.REMAINDER;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.CENTER;
        add (nameInput, c);

        highScoreB= new BufferedImage (400,100, BufferedImage.TYPE_3BYTE_BGR);
        highScoreG = highScoreB.getGraphics ();
        
        setBackground(new Color(0x133753));
        //Set window size
        setPreferredSize(new Dimension(400,100));
        //make window visible
        runWindow.setVisible(true); 
        drawBuffer();
        repaint();
    }

    public void onDestroy (JFrame runWindow)
    {
        //remove listner
        nameInput.removeActionListener(this);
        setIgnoreRepaint (false);
    }


    public void paint (Graphics g)
    {
        super.paint (g);
        g.drawImage (highScoreB, 0, 0, this);
    }
    
     public void actionPerformed (ActionEvent evt)
    {
        for (int i = 9; i >= Game.place; i--)
        {
            if (i != 0)
            {
                Main.type.highScore[i] =  Main.type.highScore[i - 1];
                Main.type.highScoreName[i] =  Main.type.highScoreName[i - 1];
            }
            }
         Main.type.highScore[Game.place] = Game.score;
         Main.type.highScoreName[Game.place] = nameInput.getText ();
         Main.type.newHighScore();
        nameInput.setText("");
        Main.removeAndPrep();
        Main.panel = new GameOver(Main.runWindow);
        Main.newWindowStart();
        
    }
   
    public void drawBuffer()
    {
        highScoreG.setColor(new Color(0x133753));
        highScoreG.fillRect(0,0,400,100);
        highScoreG.setColor(Color.white);
        highScoreG.setFont(plain);
        highScoreG.drawString("Congratulations! You got a score of " + Integer.toString(Game.score, 10), 10, 50);
        highScoreG.drawString("and placed #" + Integer.toString(Game.place + 1, 10) + "!", 10, 64);
        highScoreG.drawString("Enter your name:", 10, 18);

    }

}
