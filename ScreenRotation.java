/**
 * Updates the board screen and handels the random screen rotation
 * 
 * @author (Pavithran Pathmarajah) 
 * @version (2014 Jun 06)
 */
import java.util.*;
public class ScreenRotation extends Thread
{

    static boolean runLoop=false; 
    static boolean runUpdate=false;
    int mode;//current oreintation mode
    long timerDelay;//chagne every x seconds
    boolean orientations[];//avialbe orientions
    long timeForNextLoop=0;//timerforrotation
    long timeForScreenDraw=0;//screenupdate timer
    double curRotation;//rotation amount radians
    Random rand;//random orientiaon
    int curR;//used for random
    double tmp;//used for random
    
    //requirments to make thread
    public ScreenRotation(int mode,long rDelay, boolean oriendtaions[])
    {
        super("GRAPHICS");
        this.mode=mode;
        timerDelay=rDelay;
        orientations=oriendtaions;
        rand=new Random();
        curR=0;
    }

    //returns orietnaion radian value for given orientaion number 1 2 3 or 4
    public double Orientation(int i)
    {
        if (orientations[i]) //if aid orientaion is enabled
        {
            //return that radian value
            switch (i)
            {
                case 0:
                return 0;
                case 1:
                return Math.PI/2;
                case 2:
                return Math.PI;
                case 3:
                return Math.PI+Math.PI/2;
            }
        }
        //if not then check the next orientaion
        if((i+1)<4)
        {
            return Orientation (i+1); //recursion
        }

        //if no more go back to the first oriantion
        if(i==3)
        {
            return Orientation (0); //recurision
        }
        return 0; //dfault #worstcase scenario
    }

    
    public void run ()
    {
        //while game is running
        while(runLoop)
        {
            //while update is requested
            while(runUpdate)
            {
            //if it's time to rotate screen
            if (timeForNextLoop < System.currentTimeMillis ())
            { 
                Board.bufferG.rotate(Math.PI*2-curRotation, 300,300); //set screen back to normal
                if(mode==0) //one orientaion mode
                {
                    curRotation=Orientation(0); //set orinetiaon
                }
                if(mode==1) //random orientiaon mode
                {
                    curRotation=Orientation(rand.nextInt(4));
                }
                if(mode==2)//clockwise mode
                {
                    //continue form last mode and keep going until you get to the next mode ensuring not to repeat the same one
                    do
                    {
                        curR++;
                        if(curR>3)
                            curR=0;
                        tmp=Orientation(curR);  
                    }while(curRotation==tmp);
                    curRotation=tmp;

                }
                if(mode==3) //same as above expecpt counter cllockwise
                {
                    do
                    {
                        curR--;
                        if(curR<0)
                            curR=3;
                        tmp=Orientation(curR);
                    }while(curRotation==tmp);
                    curRotation=tmp;
                }

                Board.bufferG.rotate(curRotation, 300,300);//draw board now rotated
                timeForNextLoop=System.currentTimeMillis ()+timerDelay; //time until next orinetiaon change
            }
            
            //if it's time to update the screen
            if(timeForScreenDraw< System.currentTimeMillis ())
            {
                //update block bomb colour
                gameColour.updateColor();
                //set next update time 
                timeForScreenDraw= System.currentTimeMillis() +15;
                Board.drawAll();
                Main.runWindow.getGraphics ().drawImage (Board.buffered, 0, 0, Main.panel);
            }
        }
    }
    Main.runWindow.repaint();//repaint the new panel,just incase this class overrides the panels first paint
    }
}
