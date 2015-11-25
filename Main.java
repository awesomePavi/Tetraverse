/**
 * MainWindow For Program
 *
 * @author (Pavithran Pathmarajah)
 * @author (Shirley Xiao)
 * 
 * @version (2014 May 7)
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class Main extends JFrame
{
    static  Main runWindow; // runWindow
    static GamePanel panel; //current panel (menu, game so on)
    static Thread game;//game
    static GameType type;
    static  KeyLayout keyLayout=new KeyLayout(); 
    static ArrayList<GameType> modes=new ArrayList<GameType>();
    
    //removes current panel and info, and unfocuses to add new panel and info
    public static void removeAndPrep()
    {
        //prep panel for removal
        panel.onDestroy(runWindow);
        //remove current panel
        runWindow.remove(panel);
        //unfocus current window
        runWindow.setFocusable(false);
    }

    //add panel and refocus window on listners, update
    public static void newWindowStart()
    {
        //add new panel
        runWindow.add(panel);
        //focus back on current window        
        runWindow.setFocusable(true);
        runWindow.requestFocus();
        //resize
        runWindow.pack();
        //center window
        runWindow.setLocationRelativeTo(null);
        //update screen
        runWindow.repaint();        
    }

    public static void pauseGame()
    {
        removeAndPrep();
        //load pause menu
        panel=new PauseMenu(runWindow) ;
        newWindowStart();
    }

    public static void resumeGame()
    {
        removeAndPrep();
        //bring back board
        panel=new Board(runWindow);
        newWindowStart();
        Game.resumeGame();
    }

    public static void restartGame()
    {
        removeAndPrep();
        //end current game
        Game.runGame=false;
        Game.endUpdateLoop();
        game.yield(); //stop thread
        //loads board
        panel=new Board(runWindow);
        //sets up a new Game
        game=new Game();
        //refocus window
        newWindowStart();
        game.start(); //start new game
    }

    public static void gameOverMenu()
    {
        removeAndPrep();
        
        //if the user beats a high score, take them to the high score screen
        boolean newHighScore = false;
        while (Game.place > 0 && Game.score >  Main.type.highScore[Game.place - 1])
        {
            newHighScore = true;
             Game.place--;
        }
        if (newHighScore) 
        {
            panel = new HighScoreScreen(runWindow);
            newWindowStart();
            
        }
        else
        {
            panel=new GameOver(runWindow) ;
            newWindowStart();
        }
        //load gameovermenu
    }
    
    public static void mainMenu()
    {
        removeAndPrep();
        
        //load mainMenu
         panel=new MainMenu(runWindow) ;
        newWindowStart();
    }

    public static void endGame()
    {
        //end current game         
        Game.runGame=false;
        //if new highscore
        for(int i=0;i<10;i++)
        {
           if(Game.score>type.highScore[i])
            {
                for(int g=9;g>(i+1);g--)
                {
                    type.highScoreName[g]=type.highScoreName[g-1];
                    type.highScore[g]=type.highScore[g-1];
                }
                type.highScoreName[i]="yoyo"+Game.score;
                type.highScore[i]=Game.score;//Game.score;
            
                type. newHighScore();
                break;
             }
        }
        Game.endUpdateLoop();
        game.yield(); //stop thread
    }

    public static void exit()
    {
        removeAndPrep();
        endGame();
        //exit screen
        panel=new Exit(runWindow) ;
        newWindowStart();

        panel.paint(runWindow.getGraphics());
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {}
        //get rid of run window
        runWindow.dispose();
    }
    
    public static void customMode()
    {
        type=modes.get(2);
        removeAndPrep();
        //load pause menu        
        panel=new CustomModeScreen(runWindow); 
        newWindowStart();
        panel.paint(runWindow.getGraphics());
    }
    
    public static void customGameInBetween()
    {
        removeAndPrep();
        //load pause menu        
        panel=new InBetweenMenu(runWindow,type); 
        newWindowStart();
        panel.paint(runWindow.getGraphics());
    }
    
    public static void mainMenuExit()
    {
        removeAndPrep();
        //exit screen
        panel=new Exit(runWindow) ;
        newWindowStart();

        panel.paint(runWindow.getGraphics());
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {}
        //get rid of run window
        runWindow.dispose();
    }

    //begin program, set up intial jframe
    public Main(){
        
        Thread.currentThread().setName("yo");
        //End program when window closes
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        //no minimize full screen or exit button 
        setUndecorated(true); 
        //intialize colours for game
        gameColour.setColour();
        
       // ArrayList<GameType> modes=new ArrayList<GameType>();
        GameType.ReadGameTypes(modes);
      //  
        //original gametype
      //  type=modes.get(0);//game type 0 orig 1 arcade 2 test;
        //modes=null;
        
          panel=new MainMenu(this) ;
        
        /*//sets up a new Game
        game=new Game();
        //load board
        panel=new Board(this);
        panel=new InBetweenMenu(this,type);*/
        //add panel
        add(panel);
        //resize
        pack();    
        //center window
        setLocationRelativeTo(null);
    }
    
    public static void InBetweenMenu(int mode)
    {
        type=modes.get(mode);
        removeAndPrep();
        //load pause menu        
        panel=new InBetweenMenu(runWindow,type); 
        newWindowStart();
        panel.paint(runWindow.getGraphics());
    }


    public static void main(String args[])
    {
        //Create Window
        runWindow =  new Main();
        // begin Game loop
       // game.start();
    }

}
