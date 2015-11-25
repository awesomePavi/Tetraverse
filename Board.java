/**
 * Draws the blocks and board and everything and stuff
 *
 * @author (Stephen Webb)
 * @additions(Pavithran Pathmarajah)
 *
 * @version (2014 Jun 3)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.event.*;
public class Board extends GamePanel
{
    boolean run=false;
    //the game board staticly refrenced from all classes
    static int board[][] = new int [24][10];
    //keyboard input 
    KeyListener keyIn;    
    //set thickness of the blocks (how deep the 3D is)
    static int depth3D = 10;
    //how much the board is shifted from the top left corner of the screen
    static int shiftx = 200, shifty = 20;
    static BufferedImage buffered = new BufferedImage (600, 600, BufferedImage.TYPE_INT_RGB);
    static Graphics2D bufferG = buffered.createGraphics ();
    public Board(JFrame runWindow) 
    {
        runWindow.setIgnoreRepaint(true);
        //Set window size
        setPreferredSize(new Dimension(600,600));
        //make window visible
        runWindow.setVisible(true);
        //add Game Keyboard
        keyIn=new GameKeyboard();
        runWindow.addKeyListener(keyIn);
        
        depth3D=Main.type.depth3D;
    }

    //before removing panel
    public void onDestroy(JFrame runWindow)
    {
        //remove listner
        runWindow.removeKeyListener(keyIn);
        runWindow.setIgnoreRepaint(false);
    }

    public void paint(Graphics g)
    {
        g.drawImage (buffered, 0, 0, this);
    }


    //draw a block on the screen at the point specified
    public static void drawBlock (int c, int x, int y, boolean solid)
    {
        if (c != 0)
        {
            int[] x3D = new int [4], y3D = new int [4];
            
            //back face
            bufferG.setColor (gameColour.colour [c]);
            if (solid)
            {
                bufferG.fillRect (shiftx + x * 20 + depth3D, shifty + y * 20 - depth3D, 20, 20);
                bufferG.setColor (gameColour.colour [0]);
            }
            bufferG.drawRect (shiftx + x * 20, shifty + y * 20, 20, 20);
            
            //bottom side
            bufferG.setColor (gameColour.colour [c]);
            x3D [0] = shiftx + x * 20;
            x3D [1] = shiftx + x * 20 + depth3D;
            x3D [2] = shiftx + x * 20 + 20 + depth3D;
            x3D [3] = shiftx + x * 20 + 20;
            y3D [0] = shifty + y * 20 + 20;
            y3D [1] = shifty + y * 20 + 20 - depth3D;
            y3D [2] = shifty + y * 20 + 20 - depth3D;
            y3D [3] = shifty + y * 20 + 20;
            bufferG.drawPolygon (x3D, y3D, 4);
            if (solid)
            {
                bufferG.fillPolygon (x3D, y3D, 4);
                bufferG.setColor (gameColour.colour [0]);
            }
            //left side
            bufferG.setColor (gameColour.colour [c]);
            x3D [0] = shiftx + x * 20;
            x3D [1] = shiftx + x * 20 + depth3D;
            x3D [2] = shiftx + x * 20 + depth3D;
            x3D [3] = shiftx + x * 20;
            y3D [0] = shifty + y * 20;
            y3D [1] = shifty + y * 20 - depth3D;
            y3D [2] = shifty + y * 20 + 20 - depth3D;
            y3D [3] = shifty + y * 20 + 20;
            bufferG.drawPolygon (x3D, y3D, 4);
            if (solid)
            {
                bufferG.fillPolygon (x3D, y3D, 4);
                bufferG.setColor (gameColour.colour [0]);
            }
            //top side
            bufferG.setColor (gameColour.colour [c]);
            x3D [0] = shiftx + x * 20;
            x3D [1] = shiftx + x * 20 + depth3D;
            x3D [2] = shiftx + x * 20 + 20 + depth3D;
            x3D [3] = shiftx + x * 20 + 20;
            y3D [0] = shifty + y * 20;
            y3D [1] = shifty + y * 20 - depth3D;
            y3D [2] = shifty + y * 20 - depth3D;
            y3D [3] = shifty + y * 20;
            if (solid)
            {
                bufferG.fillPolygon (x3D, y3D, 4);
                bufferG.setColor (gameColour.colour [0]);
            }
            bufferG.drawPolygon (x3D, y3D, 4);
            //right side
            bufferG.setColor (gameColour.colour [c]);
            x3D [0] = shiftx + x * 20 + 20;
            x3D [1] = shiftx + x * 20 + 20 + depth3D;
            x3D [2] = shiftx + x * 20 + 20 + depth3D;
            x3D [3] = shiftx + x * 20 + 20;
            y3D [0] = shifty + y * 20;
            y3D [1] = shifty + y * 20 - depth3D;
            y3D [2] = shifty + y * 20 + 20 - depth3D;
            y3D [3] = shifty + y * 20 + 20;
            if (solid)
            {
                bufferG.fillPolygon (x3D, y3D, 4);
                bufferG.setColor (gameColour.colour [0]);
            }
            bufferG.drawPolygon (x3D, y3D, 4);
            //front face
            bufferG.setColor (gameColour.colour [c]);
            if (solid)
            {
                bufferG.fillRect (shiftx + x * 20, shifty + y * 20, 20, 20);
                bufferG.setColor (gameColour.colour [0]);
            }
            bufferG.drawRect (shiftx + x * 20, shifty + y * 20, 20, 20);
        }

    }

    public static void drawBorder (int col, int x, int y, int numx, int numy )
    {
            for (int j = y ; j > y - numy; j--)
                for (int i = x ; i < x + numx; i++)
                {
                    drawBlock (Game.rand.nextInt(7) + 1, i, j, true);
                    
                }
    }
    
    
        public static void drawAll ()
    {
        //background
        bufferG.setColor (gameColour.colour [0]);
        bufferG.fillRect (0, 0, 600, 600);
        
        //array for the polygon points
        int[] x3D = new int [4], y3D = new int [4];
        Game.block.ghost ();
        
        
        //bottom hold border
        drawBorder (Game.rand.nextInt (7) + 1, -9, 9, 7, 1);
        //left hold border
        drawBorder (Game.rand.nextInt (7) + 1, -9, 8, 1, 6);
        //draw the block on hold, if one exists
        if (Game.hold.x != -1)
        {
            for (int j = Game.hold.shape.length - 1 ; j >= 0 ; j--)
                for (int i = 0 ; i < Game.hold.shape [0].length ; i++)
                {
                    drawBlock (Game.hold.shape [j] [i], i - 7, j + 5, Game.hold.shape [j] [i] != 0);
                }
        }
        //right hold border
        drawBorder (Game.rand.nextInt (7) + 1, -3, 8, 1, 5);
        //top hold border
        drawBorder (Game.rand.nextInt (7) + 1, -9, 3, 7, 1);
        
        
        //bottom board border
        drawBorder (Game.rand.nextInt (7) + 1, -1, 24, 12, 1);
        //left board border
        drawBorder (Game.rand.nextInt (7) + 1, -1, 23, 1, 24);
        
        //draw the empty and filled squares on the board, draw the current shape integrated into the board
        for (int col = 0 ; col <= 2 ; col++)
            for (int j = Board.board.length - 1 ; j >= 0 ; j--)
                for (int i = 0 ; i < Board.board [j].length ; i++)
                {
                    
                        //if the square at that spot is occupied
                        if (col == 0)
                        {
                        //if the square at that spot is empty
                        if (Board.board [j] [i] == 0 && j >=4)
                        {
                            drawBlock (11, i, j, false);
                        }

                        }
                    
                    if (col == 1)
                    {
                        if ( Board.board [j] [i] > 0)
                        {
                        drawBlock (Board.board [j] [i], i, j, true);
                    }
                        if (((j - Game.block.y) >= 0) && ((j - Game.block.y) <= Game.block.shape.length - 1) && ((i - Game.block.x) >= 0) && ((i - Game.block.x) <= Game.block.shape [0].length - 1) && (Game.block.shape [j - Game.block.y] [i - Game.block.x] != 0))
                    {
                        drawBlock (Game.block.shape [j - Game.block.y] [i - Game.block.x], i, j, true);
                    }
                    }
                    //if the current block is in this spot, and is not empty
                    
                    //if the ghost is in this spot, and is not empty
                    if (((j - Game.block.ghosty) >= 0) && ((j - Game.block.ghosty) <= Game.block.shape.length - 1) && ((i - Game.block.x) >= 0) && ((i - Game.block.x) <= Game.block.shape [0].length - 1) && (Game.block.shape [j - Game.block.ghosty] [i - Game.block.x] != 0) && col == 2)
                    {
                        drawBlock (9, i, j, false);
                    }
                }

        //right board border
        drawBorder (Game.rand.nextInt (7) + 1, 10, 23, 1, 24);
        
        //bottom buffer border
        drawBorder (Game.rand.nextInt (7) + 1, 12, 19, 7, 1);
        //left buffer boarder
        drawBorder (Game.rand.nextInt (7) + 1, 12, 18, 1, 16);
        //draw the blocks in the buffer
        for (int buf = 0 ; buf < 3 ; buf++)
            for (int j = Game.buffer [buf].shape.length - 1 ; j >= 0 ; j--)
                for (int i = 0 ; i < Game.buffer [buf].shape [0].length ; i++)
                {
                    drawBlock (Game.buffer [buf].shape [j] [i], Game.buffer [buf].x + 10 + i, 5 * buf + 4 + j, Game.buffer [buf].shape [j] [i] != 0);
                }
                
        //right buffer boarder
        drawBorder (Game.rand.nextInt (7) + 1, 18, 18, 1, 16);
        //top buffer border
        drawBorder (Game.rand.nextInt (7) + 1, 12, 2, 7, 1);
        bufferG.setColor(gameColour.colour[9]);
        bufferG.setFont(new Font("Arial",Font.BOLD, 42));
        bufferG.drawString("Hold", shiftx - 180 + (int)depth3D/2, shifty + 60 - (int)depth3D/2);
        bufferG.drawString("Buffer", shiftx + 240 + (int)depth3D/2, shifty + 40 - (int)depth3D/2);
        bufferG.setFont(new Font("Arial",Font.BOLD, 34));
        bufferG.drawString("Score: " + Integer.toString(Game.score, 10), shiftx - 180, shifty + 550);
        bufferG.drawString("Level: " + Integer.toString(Game.level, 10), shiftx + 80, shifty + 550);
        bufferG.drawString("Combo: " + Integer.toString((int)((Game.combo - 1) * 2), 10), shiftx + 230, shifty + 550);
    }
}