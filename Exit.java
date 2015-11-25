
/**
 *Ending Screen
 * 
 * @author (Shirley Xiao) 
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.Color.*;

public class Exit extends GamePanel
{
    //static Exit runWindow;
   // static JPanel panel;
    public Exit(JFrame runWindow)
   { 
       //JPanel panel = (JPanel)this.getContentPane();  
  
        //JLabel label = new JLabel();  
        //label.setIcon(new ImageIcon("face.png"));// your image here  
        //label.setLocation(100, 100);
        //panel.setLayout(new FlowLayout(FlowLayout.LLEFT));
        //panel.add(label);  
   
       //this.setLocation(100, 100); 
      // this.pack(); 
      // create window
      this.setBackground(Color.BLACK);
       setPreferredSize(new Dimension(500,500)); 
       this.setVisible(true);
       
        
    }
    
    public void onDestroy(JFrame runWindow)
    {}
    
    public void paint(Graphics g)
    {
        super.paint(g);
        
       g.setColor(Color.WHITE);
       g.setFont(new Font("OCR A Std",Font.BOLD,30));
       g.drawString("HOPE YOU HAD FUN!", 110,180);
       g.setFont(new Font("OCR A Std",Font.BOLD,50));
       g.drawString("GOODBYE", 130, 300);
       
       //draw face
       g.setColor(Color.YELLOW);
       g.fillRect(235, 340, 40, 5);
       g.fillRect(230, 345, 50, 5);
       g.fillRect(225, 350, 60, 5);
       
       g.fillRect(220, 355, 15, 20);
       g.fillRect(245, 355, 20, 20);
       g.fillRect(275, 355, 15, 20);
       g.fillRect(235, 365, 10, 10);
       g.fillRect(265, 365, 10, 10);
       g.fillRect(220, 375, 10, 15);
       g.fillRect(280, 375, 10, 15);
       g.fillRect(230, 380, 5, 10);
       g.fillRect(235, 385, 5, 5);
       g.fillRect(270, 385, 5, 5);
       g.fillRect(275, 380, 5, 10);
       
       g.fillRect(235, 400, 40, 5);
       g.fillRect(230, 395, 50, 5);
       g.fillRect(225, 390, 60, 5);
       
       //border
       g.setColor(new Color(0xCC9966));
       //horizontal
       g.fillRect(80, 110, 30, 10);
       g.fillRect(130, 110, 30, 10);
       g.fillRect(180, 110, 30, 10);
       g.fillRect(230, 110, 30, 10);
       g.fillRect(280, 110, 30, 10);
       g.fillRect(330, 110, 30, 10);
       g.fillRect(380, 110, 30, 10);
       g.fillRect(430, 110, 30, 10);
       g.fillRect(480, 110, 30, 10);
       
       //vertical
       g.fillRect(80, 130, 10, 30);
       g.fillRect(80, 180, 10, 30);
       g.fillRect(80, 230, 10, 30);
       g.fillRect(80, 280, 10, 30);
       g.fillRect(80, 330, 10, 30);
       g.fillRect(80, 380, 10, 30);
       g.fillRect(80, 430, 10, 30);
       g.fillRect(80, 480, 10, 30);
       g.fillRect(80, 530, 10, 30);
       g.fillRect(80, 580, 10, 30);
       
       
       g.setColor(new Color(0x006666));
       g.fillRect(10, 30, 30, 10);
       g.fillRect(60, 30, 30, 10);
       g.fillRect(110, 30, 30, 10);
       g.fillRect(160, 30, 30, 10);
       g.fillRect(210, 30, 30, 10);
       g.fillRect(260, 30, 30, 10);
       g.fillRect(310, 30, 30, 10);
       g.fillRect(360, 30, 30, 10);
       g.fillRect(410, 30, 30, 10);
       g.fillRect(460, 30, 30, 10);
       g.fillRect(510, 30, 30, 10);
       
       g.fillRect(10, 30, 30, 10);
       g.fillRect(10, 80, 30, 10);
       g.fillRect(10, 130, 30, 10);
       g.fillRect(10, 180, 30, 10);
       g.fillRect(10, 230, 30, 10);
       g.fillRect(10, 280, 30, 10);
       g.fillRect(10, 330, 30, 10);
       g.fillRect(10, 380, 30, 10);
       g.fillRect(10, 430, 30, 10);
       g.fillRect(10, 480, 30, 10);
       g.fillRect(10, 530, 30, 10);
       g.fillRect(10, 580, 30, 10);
        
    }
   /** public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
               new Exit();
            }
        });
    }
   **/
}
    


