/**
 * This is the main Game, that handles the games info 
 *  -This includes block buffer, current block, and hold block
 *  - line completion checking
 *  -Game begin countdown
 *  -flash completed lines
 *  -holds score
 * 
 * @author (Pavithran Pathmarajah) 
 * @version (2014 May 2)
 */
import java.util.*;
public class Game extends Thread
{

    static Thread screen;   //game
    static Random  rand;    //to randomly choose blocks
    static Shape block;     // current play block
    static Shape buffer[];  //buffer of upcoming blocks
    static Shape hold;      //block on hold
    static int score;       // player score
    static int scoreOld;
    static boolean runLoop; //runGame Loop
    static long timeForNextLoop; //keeps track of elapsedtime
    static long delay;      //time delay per loop
    static boolean runGame; //called to end the game
    static boolean swapHoldBlock; //so that people cannot constantly swap hold blocks
    static int blocksUsed[]={0,0,0,0,0,0,0,0,0,0,0,0};
    static int lines;           //the total number of lines cleared
    static int linesCleared; //the number of lines cleared in one move
    static double combo;       //the number of successive moves that clears at least one line
    static int level;       //the level that the player is on
static int place = 10; //the high score place that the user is in, 9 is the last place on the list
    
    public Game()
    {  
        super("GAME");
        /***Blocks****/
        rand=new Random(System.currentTimeMillis());   //unique seed each time
        //fill buffer with blocks
        buffer=new Shape[4];
        buffer[0]=newBlock();
        buffer[1]=newBlock();
        buffer[2]=newBlock();
        buffer[3]=newBlock();    

        //fresh Board
        Board.board = new int [24][10];

        //sets the intial hold block to a blank box
        hold = new Block_Blank ();
        //Set up intital play block
        nextBlock ();
        linesCleared = 0;
        lines = 0;
        score = 0;
        combo = 1;
        level = 1;
        //time per game loop
        delay = 1000;
        //hold block can only be swapped once per round
        swapHoldBlock=false;
        place=10;
    }

    public static void begin ()
    {
        //disable keyboard
        GameKeyboard.enable=false; 
        int clr;       //colour of numbers
        long flashClock ; //tiemer
        /************3*****************/
        for (int i=0;i<66;i++) //66*15 millisecnds is one second
        {    
            flashClock = System.currentTimeMillis () + 15; //set clcok buffer
            Board.drawAll (); //currentboard update the randomborder
            //draw each block in letter 3. must go from bottom to top left to right for best effect
            clr = 18; //red

            Board.drawBlock (clr, 2, 18, true);
            Board.drawBlock (clr, 3, 18, true);
            Board.drawBlock (clr, 4, 18, true);
            Board.drawBlock (clr, 5, 18, true);
            Board.drawBlock (clr, 6, 18, true);

            Board.drawBlock (clr, 7, 17, true);
            Board.drawBlock (clr, 7, 16, true);
            Board.drawBlock (clr, 7, 15, true);

            Board.drawBlock (clr, 2, 14, true);
            Board.drawBlock (clr, 3, 14, true);
            Board.drawBlock (clr, 4, 14, true);
            Board.drawBlock (clr, 5, 14, true);
            Board.drawBlock (clr, 6, 14, true);

            Board.drawBlock (clr, 7, 13, true);
            Board.drawBlock (clr, 7, 12, true);
            Board.drawBlock (clr, 7, 11, true);

            Board.drawBlock (clr, 2, 10, true);
            Board.drawBlock (clr, 3, 10, true);
            Board.drawBlock (clr, 4, 10, true);
            Board.drawBlock (clr, 5, 10, true);
            Board.drawBlock (clr, 6, 10, true);
            //draw the number
            Main.runWindow.getGraphics ().drawImage (Board.buffered, 0, 0, Main.panel);

            //wait remaming time fo 15 milliseconds

            while (flashClock > System.currentTimeMillis ())
            {
            }}

        for (int i=0;i<67;i++)
        {    
            flashClock = System.currentTimeMillis () + 15;
            Board.drawAll (); //currentboard
            /************2*****************/
            //draw each block to show the number 2
            clr = 19; //yellow

            Board.drawBlock (clr, 3, 18, true);
            Board.drawBlock (clr, 4, 18, true);
            Board.drawBlock (clr, 5, 18, true);
            Board.drawBlock (clr, 6, 18, true);

            Board.drawBlock (clr, 2, 17, true);
            Board.drawBlock (clr, 2, 16, true);
            Board.drawBlock (clr, 2, 15, true);

            Board.drawBlock (clr, 3, 14, true);
            Board.drawBlock (clr, 4, 14, true);
            Board.drawBlock (clr, 5, 14, true);
            Board.drawBlock (clr, 6, 14, true);

            Board.drawBlock (clr, 7, 13, true);
            Board.drawBlock (clr, 7, 12, true);
            Board.drawBlock (clr, 7, 11, true);

            Board.drawBlock (clr, 3, 10, true);
            Board.drawBlock (clr, 4, 10, true);
            Board.drawBlock (clr, 5, 10, true);
            Board.drawBlock (clr, 6, 10, true);
            //draw the number
            Main.runWindow.getGraphics ().drawImage (Board.buffered, 0, 0, Main.panel);

            //delay for one second
            while (flashClock > System.currentTimeMillis ())
            {
            }}
        for (int i=0;i<66;i++)
        {    
            flashClock = System.currentTimeMillis () + 15;

            /************1*****************/
            Board.drawAll ();
            //draw number 1 on board
            clr = 20; //green

            Board.drawBlock (clr, 2, 18, true);
            Board.drawBlock (clr, 3, 18, true);
            Board.drawBlock (clr, 4, 18, true);
            Board.drawBlock (clr, 5, 18, true);
            Board.drawBlock (clr, 6, 18, true);
            Board.drawBlock (clr, 7, 18, true);

            Board.drawBlock (clr, 4, 17, true);
            Board.drawBlock (clr, 5, 17, true);

            Board.drawBlock (clr, 4, 16, true);
            Board.drawBlock (clr, 5, 16, true);

            Board.drawBlock (clr, 4, 15, true);
            Board.drawBlock (clr, 5, 15, true);

            Board.drawBlock (clr, 4, 14, true);
            Board.drawBlock (clr, 5, 14, true);

            Board.drawBlock (clr, 4, 13, true);
            Board.drawBlock (clr, 5, 13, true);

            Board.drawBlock (clr, 4, 12, true);
            Board.drawBlock (clr, 5, 12, true);

            Board.drawBlock (clr, 4, 11, true);
            Board.drawBlock (clr, 5, 11, true);

            Board.drawBlock (clr, 2, 10, true);
            Board.drawBlock (clr, 3, 10, true);
            Board.drawBlock (clr, 4, 10, true);
            Board.drawBlock (clr, 5, 10, true);

            Board.drawBlock (clr, 4, 9, true);
            Board.drawBlock (clr, 5, 9, true);

            //draw on screen
            Main.runWindow.getGraphics ().drawImage (Board.buffered, 0, 0, Main.panel);
            //delay one second
            while (flashClock > System.currentTimeMillis ())
            {
            }
        }

        //reanable keyboard
        GameKeyboard.enable=true; 
    }

    public static void pauseGame() 
    {        
        GameKeyboard.enable=false; 
        //stop running game loop
        runLoop=false;
        //stop the game update thread. and get rid of it for now
        ScreenRotation.runUpdate=false;
        //pull up pause game menu
        Main.pauseGame();
        Main.runWindow.repaint();
    }

    public static void resumeGame()
    {
        //show countdown timer
        begin();  

        //bring back screenupdate and rotation 
        ScreenRotation.runUpdate=true;
        //being running game loop again
        runLoop=true;

    } 
    //called on thread.start(), beign the thread
    public void run ()
    {
        runLoop = true; //run game loop
        runGame = true; //keep current game running
        timeForNextLoop = 0; //timer delay between block shifts down
        begin (); //countdown to start game
        //Basic GameRunLoop

        //create the grpahics updater system and screen rotation
        screen = new ScreenRotation(Main.type.orientationMode,Main.type.rotateDelay, Main.type.orientations);      
        ScreenRotation.runLoop=true;
        ScreenRotation.runUpdate=true;
        screen.start();

        while (runGame)
        {
            while (runLoop)
            {
                ScreenRotation.runUpdate=true;
                while (runLoop)
                { 
                    //if enough time has passed
                    if (timeForNextLoop < System.currentTimeMillis ())
                    // the actual code to be looped
                        loop ();
                }  
                ScreenRotation.runUpdate=false;
            }
        }
    }

    public static void endUpdateLoop()
    {
        //if the screen loop is still going then. Destory it.
        ScreenRotation.runUpdate=false;
        ScreenRotation.runLoop=false;
        screen.yield();
        screen=null;
    }

    public static void loop()
    {
        // block has hit the bottom
        if(block.checkBlock(0,1))
        {

            //to pause gameloop until everything is done
            timeForNextLoop = System.currentTimeMillis()+100000;
            //if bomb
            if (block.blockNum==12)
            {
                int blocksDestroyed = 0;
                //code to ditribute 9x9 bloxks in all directions
                //destroy bomb, and radius of 2 round
                // ScreenRotation.runUpdate=false;
                long flashClock;
                
                
                for (int i=0;i<7;i++)
                {

                    if(((block.y-2+i)>-1)&&((block.y-2+i)<24))
                    {
                        if (Board.board[block.y-2+i][block.x]!=0) 
                            blocksDestroyed++;
                        if (Board.board[block.y-2+i][block.x+1]!=0) 
                            blocksDestroyed++;
                        if (Board.board[block.y-2+i][block.x+2]!=0) 
                            blocksDestroyed++;
                    }
                }
                for (int i=0;i<7;i++)
                {
                    if(((block.x-2+i)>-1)&&((block.x-2+i)<10))
                    {
                        if (Board.board[block.y][block.x-2+i]!=0) 
                            blocksDestroyed++;
                        if (Board.board[block.y+1][block.x-2+i]!=0) 
                            blocksDestroyed++;
                        if (Board.board[block.y+2][block.x-2+i]!=0) 
                            blocksDestroyed++;
                    }
                }
                if(((block.x-1)>-1)&&((block.y+3)<24))
                {
                    if (Board.board[block.y+3][block.x-1]!=0) 
                            blocksDestroyed++;
                }
                if(((block.x+3)<10)&&((block.y+3)<24))
                {
                    if (Board.board[block.y+3][block.x+3]!=0) 
                            blocksDestroyed++;
                }
                if(((block.x-1)>-1)&&((block.y-1)>-1))
                {
                    if (Board.board[block.y-1][block.x-1]!=0) 
                            blocksDestroyed++;
                }
                if(((block.x+3)<10)&&((block.y-1)>-1))
                {
                    if (Board.board[block.y-1][block.x+3]!=0) 
                            blocksDestroyed++;
                }
                
                
                
                
                
                for (int j=8;j<13;j++)
                {
                    for (int b=0;b<10;b++)
                    {
                        flashClock = System.currentTimeMillis () + 15; //set clcok buffer
                        for (int i=0;i<7;i++)
                        {

                            if(((block.y-2+i)>-1)&&((block.y-2+i)<24))
                            {
                                Board.board[block.y-2+i][block.x]=j;
                                Board.board[block.y-2+i][block.x+1]=j;
                                Board.board[block.y-2+i][block.x+2]=j;
                            }
                        }
                        for (int i=0;i<7;i++)
                        {
                            if(((block.x-2+i)>-1)&&((block.x-2+i)<10))
                            {
                                Board.board[block.y][block.x-2+i]=j;
                                Board.board[block.y+1][block.x-2+i]=j;
                                Board.board[block.y+2][block.x-2+i]=j;
                            }
                        }
                        if(((block.x-1)>-1)&&((block.y+3)<24))
                        {
                            Board.board[block.y+3][block.x-1]=j;
                        }
                        if(((block.x+3)<10)&&((block.y+3)<24))
                        {
                            Board.board[block.y+3][block.x+3]=j;
                        }
                        if(((block.x-1)>-1)&&((block.y-1)>-1))
                        {
                            Board.board[block.y-1][block.x-1]=j;
                        }
                        if(((block.x+3)<10)&&((block.y-1)>-1))
                        {
                            Board.board[block.y-1][block.x+3]=j;
                        }
                        // Board.drawAll ();
                        //draw on screen
                        // Main.runWindow.getGraphics ().drawImage (Board.buffered, 0, 0, Main.panel);
                        while (flashClock > System.currentTimeMillis ())
                        {
                        }
                    }
                }

                for (int i=0;i<7;i++)
                {

                    if(((block.y-2+i)>-1)&&((block.y-2+i)<24))
                    {
                        Board.board[block.y-2+i][block.x]=0;
                        Board.board[block.y-2+i][block.x+1]=0;
                        Board.board[block.y-2+i][block.x+2]=0;
                    }
                }
                for (int i=0;i<7;i++)
                {
                    if(((block.x-2+i)>-1)&&((block.x-2+i)<10))
                    {
                        Board.board[block.y][block.x-2+i]=0;
                        Board.board[block.y+1][block.x-2+i]=0;
                        Board.board[block.y+2][block.x-2+i]=0;
                    }
                }
                if(((block.x-1)>-1)&&((block.y+3)<24))
                {
                    Board.board[block.y+3][block.x-1]=0;
                }
                if(((block.x+3)<10)&&((block.y+3)<24))
                {
                    Board.board[block.y+3][block.x+3]=0;
                }
                if(((block.x-1)>-1)&&((block.y-1)>-1))
                {
                    Board.board[block.y-1][block.x-1]=0;
                }
                if(((block.x+3)<10)&&((block.y-1)>-1))
                {
                    Board.board[block.y-1][block.x+3]=0;
                }

                //ScreenRotation.runUpdate=true;
                // worth 2 lines
                //linesCleared = 2;
                //add the number of lines cleared to the total number of lines
                //lines += linesCleared;
                //add to the score based on the level, lines cleared with one block, and the combo
                score += 5 * blocksDestroyed * level * combo;
                if (blocksDestroyed > 0)
                    combo += 0.5;
                else
                    combo = 1;
            }
            else
            {
                //add block to the board
                if(block.saveToBoard())
                {
                    linesCleared = rowsCompleted (block.y, block.y + block.shape.length - 1);
                    //add the number of lines cleared to the total number of lines
                    lines += linesCleared;
                    //add to the score based on the level, lines cleared with one block, and the combo
                    score += (5 + 5 * linesCleared) * linesCleared * level * combo;
                    //increases the combo if any lines are cleared
                    if (linesCleared > 0)
                    {
                        combo += 0.5;

                    }
                    else
                    {
                        combo = 1;
                    }

                }
            }
            level = (int) (lines / 10) + 1;

            //if the block is below the 4 mark, and the board array has a vlaue in the unseen region
            if ((block.y < 4) && isGameOver ())
            {
                // stop running current game
                runLoop = false;
                ScreenRotation.runLoop=false;
                screen.yield();
                screen=null;
                //load gameover menu
                Main.gameOverMenu ();
            }
            //hold block can be swaped again
            swapHoldBlock = false;
            nextBlock (); //newblock
        }     
        //block falls by one each round
        block.fall(); 
        //draw updated board to buffer
        //  Board.drawAll();
        //update game window
        // Main.runWindow.repaint();

        //change the speed at which the block falls
        delay = (long) (1000 * Math.pow (0.75, (double) (level - 1)));
        //timer
        timeForNextLoop = System.currentTimeMillis () + delay;
    }   

    //check rows to be solid, requires top and botto serach area
    public static int rowsCompleted(int rowTop,int rowBottom)
    {
        //number of cleared rows        
        int rowsCleared=0;
        int tmp[][]=new int[24][10]; //so that values do not change during check
        int flash[][]=new int[24][10]; //so that values do not change during check
        for(int y=0;y<24;y++)
        {
            System.arraycopy(Board.board[y], 0, tmp[y], 0, 10);
            System.arraycopy(Board.board[y], 0, flash[y], 0, 10);
        }
        //what rows to flash
        int clearRow[]=new int[rowBottom-rowTop+1];
        for(int i=0;i<clearRow.length;i++)
            clearRow[i]=500;//dont draw anything
        //current row relative to array
        int rowNum=-1;
        //check area, the actual game dispalys from 0 on top to 23 on bottom 
        for (int y=rowTop;y<rowBottom+1;y++)
        {         
            rowNum++;
            //row is assumed to be solid until proven otherwise  
            boolean solid=true;    
            //check row to be not solid
            for (int x=0;x<10;x++)  
            {
                //if blank
                if(tmp[y][x]==0)
                {      
                    //not solid
                    solid=false;
                    break;
                }
            }
            if (solid)
            {     
                //clear this row
                clearRow[rowNum]=y;
                // System.out.println(y);
                //total number of cleared rows increases
                rowsCleared++;

                //shift down rows
                for (int y1=y-1;y1>0;y1--)
                    for (int x1=0;x1<10;x1++)  
                        tmp[y1+1][x1]=tmp[y1][x1];
                //set very top row to blank 
                for (int x1=0;x1<10;x1++) 
                    tmp[0][x1]=0;

                for (int x=0;x<10;x++) 
                    Board.board[y][x]=8;     

            }
            else
            {
                //done clear the row
                clearRow[rowNum]=500;
                rowNum--;
            }
        }
        //if rows have been cleared flash hte following rows
        //  Board.board=flash;
        if(rowsCleared>0)
        {
            flashRow(clearRow,12,25); 
        }
        Board.board=tmp;
        return rowsCleared;
    }    

    //flash certain rows stated colour, and for x time
    public static void flashRow (int rows[], int colour, long delay)
    {

        long flashClock = System.currentTimeMillis () + 100;
        while (flashClock > System.currentTimeMillis ())
        {
        }

    }
    //check if game is over
    public static boolean isGameOver()
    {
        //check entire row
        for(int x=0;x<10;x++)
        //if board ahs a vlaue in the unseen area game is over
            if(Board.board[3][x]!=0)
            {
                return true;
        }
        //if not game is not over
        return false;
    }

    public static void holdBlock()
    {
        ScreenRotation.runUpdate=false;
        if(!swapHoldBlock)
        {
            // if there is a block being held
            if(hold.x>-1)
            {
                Shape tmpBlk=Shape.shapeNum(block.blockNum); //tmp value to move blocks around           
                block=Shape.shapeNum(hold.blockNum); //block becomes hold block
                hold=tmpBlk;//hold block become block           
            }
            else
            {
                hold=block; //hold block is current play block
                nextBlock(); // get next block from que
            }
            swapHoldBlock=true;
        }
        ScreenRotation.runUpdate=true;
    }

    public static void nextBlock()
    {
        // moves blocks up buffer
        block=Shape.shapeNum(buffer[0].blockNum);
        buffer[0]=Shape.shapeNum(buffer[1].blockNum);
        buffer[1]=Shape.shapeNum(buffer[2].blockNum);
        buffer[2]=Shape.shapeNum(buffer[3].blockNum);
        //new random block
        buffer[3]=newBlock();

    }

    //returns a new random shape from those that are enabled in each mode
    public static Shape newBlock()
    {
        //holds block number
        int block;
        //generate random block from 1 to 12. That is an included block and has been used less then 5 times recently
        do
        {
            block=rand.nextInt(12);
        }while(!Main.type.includeBlocks[block]&&blocksUsed[block]<5);
        
        // if the bomb block is chosen then there is a 1 in 4 chance of getting it. if not then return another block
            if (block ==11)
            {
                if(rand.nextInt(4)!=1)
                return newBlock();
            }
       
        //increse the total number of times this block has been used by 1
        blocksUsed[block]++;
        //check how many blocks have been used 5 times already
        int chkBlcks=0;
        for(int i=0;i<12;i++)
        {
            if(blocksUsed[block]<5)
                chkBlcks++;
        }
        //if more then 4 blocks ahve been used more then 5 times so far, its been disabled from the random
        if(chkBlcks>4)
        {
            //reenable the 5 blocks
            for(int i=0;i<12;i++)
            {
                blocksUsed[block]=0;
            }
        }
        //get shape related to the nubmer from shapes class
        return Shape.shapeNum(block+1); //blokcs go from 1 to 12
    }
}
