/**
 * Handels Keyboard for the game
 * 
 * @author (Pavithran Pathmarajah) 
 * @author (Stephen Webb) 
 * @version (2014 may 13)
 */
import java.awt.event.*;

public class GameKeyboard implements KeyListener
{

    //So that the down arrow does not go on forever
    long coolDown,coolDownr,coolDownl;
    long coolDownAmt;
    //keyInput settings    
    static boolean enable=false; //ebnable or diable keybaord
    public GameKeyboard()
    {
        coolDown=0;//so that there is a vlaue to comapare to
        coolDownr=0;
        coolDownl=0;
        coolDownAmt=100;//the delay inbetween active falls;
    }

    //command once key is typed down + up does not function with arrow keys
    public void keyTyped(KeyEvent e) {

    }

    //commands that run while key is pressed
    public void keyPressed(KeyEvent e) {
        if (enable)
        {
            if(e.getKeyCode()==Main.keyLayout.downKey) //soft Drop
            {           
                //check if cool down if not do the same drop hthe game does once a loop
                if(coolDown<System.currentTimeMillis()) 
                {
                    //if there is no block underneath
                    if (!Game.block.checkBlock(0,1))
                    {
                        Game.loop(); //fall one
                    }
                    //no block down two then
                    else if (!Game.block.checkBlock(0,2)) 
                    {
                        Game.block.fall(); //fall one
                    }
                    coolDown=System.currentTimeMillis()+coolDownAmt; //set cooldown
                }
            }

            if(e.getKeyCode()==Main.keyLayout.leftKey) //shiftLeft
            { 
                if(coolDownr<System.currentTimeMillis()) 
                {
                    Game.block.lShift();
                    coolDownr=System.currentTimeMillis()+coolDownAmt; //set cooldown
                }
            }

            if(e.getKeyCode()==Main.keyLayout.rightKey) //shiftright
            { 
                if(coolDownl<System.currentTimeMillis()) 
                {
                    Game.block.rShift();
                    coolDownl=System.currentTimeMillis()+coolDownAmt; //set cooldown
                }
            }
        }
    }

    //commands that run once finger comes off key
    public void keyReleased(KeyEvent e) {
        if (enable)
        {
            if(e.getKeyCode()==Main.keyLayout.spaceKey) //harddrop
            {    
                Game.block.hardDrop();
                Game.loop(); //loop and mvoe to next piece
            }
            if(e.getKeyCode()==Main.keyLayout.xKey) //Rotate Right
            {   
                Game.block.clock();
            }
            if(e.getKeyCode()==Main.keyLayout.zKey) //Rotate Left
            {  
                Game.block.counter();
            }
            if(e.getKeyCode()==Main.keyLayout.escKey) //Pause
            {
                Game.pauseGame();
            }
            if(e.getKeyCode()==Main.keyLayout.cKey) //Hold block
            {         
                Game.holdBlock(); //Run Hold command 
            }
            if(e.getKeyCode()==Main.keyLayout.aKey) //rotate screen left
            {         
                //ADD
            }
            if(e.getKeyCode()==Main.keyLayout.sKey) //rotate screen Right
            {         
                //ADD
            }
            Game.timeForNextLoop = System.currentTimeMillis()+Game.delay;
        }
    }
}