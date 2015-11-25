/**
 * Tells whast includerd in each GameType otion to go back and forward, and shows instructions
 * 
 * @author (Pavithran Pathmarajah) 
 * @version (2014 June 9)
 */

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

public class InBetweenMenu extends GamePanel
{
    BufferedImage buffered; //the main writing and stuff
    BufferedImage insBuffered; //instructions overlay
    BufferedImage window; //main window
    BufferedImage board;//little pieces that look liek boards
    BufferedImage scoreBuffered;//score overlay

    //graphics fr all the bojects above
    Graphics bufferIns;  
    Graphics bufferG;  
    Graphics windowG;
    Graphics2D boardG;
    Graphics bufferScore;

    //set the olour of the board
    Color boardClr=new Color(0xFF00FF);
    Color bgColor=new Color(0x133753);

    int depth3D; //for tetris blocks

    //buttons
    InBtwn_Buttons play;
    InBtwn_Buttons menu;
    InBtwn_Buttons instructions;
    InBtwn_Buttons highscores;

    //shift for blocks
    int shiftx=20;
    int shifty=10;
    //screen info
    int width;
    int height;
    //overlaysize
    int insHeight;
    int scoreWidth;

    //to size window accordingly
    int numBlocks;
    //differnt fonts
    Font title,buttons,headers,instructionText,degreeSymbol,scoresText;
    //game info
    GameType gameInfo;

    public InBetweenMenu(JFrame runWindow,GameType info)  
    {   
        gameInfo=info;

        //set fonts
        title=new Font("Comic Sans MS", Font.BOLD, 100);
        buttons=new Font("Comic Sans MS", Font.BOLD, 14);
        headers=new Font("Comic Sans MS", Font.BOLD, 14);
        instructionText=new Font("Comic Sans MS", Font.BOLD, 24);
        degreeSymbol=new Font("Comic Sans MS", Font.BOLD, 10);
        scoresText=new Font("Comic Sans MS", Font.PLAIN, 17);

        //calculate and set widnow dimesions
        width=540; // for 7 blocks wide plus 15/2 on each side
        height=450;//adjust per new heights

        //calculate total height change for blocks to dispaly:
        numBlocks=0;
        for(int i=0;i<12;i++)
        {
            if (info.includeBlocks[i])
                numBlocks++;
        }
        height=450+(((int)Math.ceil(numBlocks/7.0))*75); //10 buffer top and bottom and 60 for shapes

        //check number of avilable orientaions. Ressive windows accordinglt
        int numOrientations=0;
        for (int i =0;i<4;i++)
        {
            if (gameInfo.orientations[i])
                numOrientations++;
        }
        insHeight=290;
        if (numOrientations>1)
            insHeight+=20;
        if (numOrientations>3)
            height+=20;
            
        scoreWidth=295;

        //create buffers
        buffered = new BufferedImage (width,height-70, BufferedImage.TYPE_3BYTE_BGR);
        insBuffered= new BufferedImage (520,insHeight, BufferedImage.TYPE_3BYTE_BGR);
        window = new BufferedImage (width,height-70, BufferedImage.TYPE_3BYTE_BGR);
        board= new BufferedImage (61,61, BufferedImage.TYPE_3BYTE_BGR);
        scoreBuffered= new BufferedImage (scoreWidth,290, BufferedImage.TYPE_3BYTE_BGR);

        //create grpahcs
        bufferG = buffered.getGraphics ();  
        bufferIns=insBuffered.getGraphics ();  
        windowG= window.getGraphics();
        boardG = (Graphics2D)board.getGraphics();
        bufferScore = scoreBuffered.getGraphics ();  

        //get 3d block info
        depth3D=info.depth3D;   

        setLayout(null); //button organizer       
        drawImages();//draw all the graohics to the buffers

        //if custom mode do not include the highscore button
        if(gameInfo.gameNum==2)
        {
            play= new InBtwn2_Play(width,height,this);
            menu= new InBtwn2_Menu(width,height,this);
            instructions= new InBtwn2_Instructions(width,height,this);
        }
        //if has highscores
        else
        {
            play= new InBtwn1_Play(width,height,this);
            menu= new InBtwn1_Menu(width,height,this);
            instructions= new InBtwn1_Instructions(width,height,this);
            //add the highscore to the menu
            highscores= new InBtwn1_HighScore(width,height,this);
            highscores.setFont(buttons);
            highscores.setOpaque(true);
            add( highscores);
        }

        //add play button to menu
        play.setFont(buttons);
        play.setOpaque(true);
        add(play);

        //add menu button to the menu
        menu.setFont(buttons);
        menu.setOpaque(true);
        add(menu);

        //add the insturctions button ot the menu
        instructions.setFont(buttons);
        instructions.setOpaque(true);
        add( instructions);

        //set colour of background
        setBackground(bgColor);
        //Set window size
        setPreferredSize(new Dimension(width,height));
        //make window visible
        runWindow.setVisible(true);   

    }

    //when rmeoving the panel
    public void onDestroy(JFrame runWindow)
    {
        //remove buttons and listners
        play.onDestroy();
        menu.onDestroy();
        instructions.onDestroy();
        remove(play);  
        remove(menu);
        remove(instructions);
    }

    public void drawImages()
    {
        /*************************************************************************************/
        /*************************************************************************************/
        /*************************************************************************************/
        /***********************************Mini Board**************************************/
        /*************************************************************************************/
        /*************************************************************************************/
        /*************************************************************************************/
        boardG.setColor(bgColor);
        boardG.fillRect(0,0,61,61);
        boardG.setColor(Color.black);
        boardG.fillRect(0,10,13,13);
        boardG.fillRect(15,0,30,60);
        boardG.fillRect(47,10,13,35); 
        boardG.setColor(boardClr);
        boardG.drawRect(15,0,30,60);
        boardG.drawRect(0,10,13,13);
        boardG.drawRect(47,10,13,35);
        drawArrow(boardG,30,2,30, 20);

        /*************************************************************************************/
        /*************************************************************************************/
        /*************************************************************************************/
        /***********************************Main BG**************************************/
        /*************************************************************************************/
        /*************************************************************************************/
        /*************************************************************************************/

        bufferG.setColor(bgColor);
        bufferG.fillRect(0, 0,width,height-50);

        // 5*5 for each block 20 each so 500 pixels plus 40 20 on each side
        // make 25 gradient
        //dark to light
        int colours[]={0x1D3C55, 0x264256, 0x304758, 0x3A4C59, 0x44515B, 0x4D575C, 0x575C5E, 0x5A5E5F, 0x5D5F5F
            , 0x606160, 0x636360, 0x666461, 0x696661, 0x6C6762, 0x6F6962, 0x726B63, 0x756C63, 0x786E64, 0x7B7064
            , 0x7E7165, 0x817365, 0x847566, 0x877666, 0x8B7867, 0x8E7967, 0x917B68, 0x947D68, 0x977E69, 0x9A8069};

        //draw top area for title
        for(int x=0;x<colours.length;x++)
        {
            bufferG.setColor(new  Color(colours[x]));
            bufferG.fillRect((9*x)+22,8,9,135);
        }
        for(int x=colours.length-1;x>-1;x--)
        {
            bufferG.setColor(new  Color(colours[x]));
            bufferG.fillRect((9*(55-x))+23,8,9,135);
        }

        //make the chekered effect
        boolean draw=true;
        for(int x=0;x<60;x++)
        {
            for (int y=0;y<15;y++)
            {
                if (draw)
                {
                    bufferG.fillRect(9*x,8+9*y,9,9);
                }
                draw=!draw;
            }
        }

        //http://meyerweb.com/eric/tools/color-blend/ use for colour fade checkered flag background for name strong in center fade to sides
        //layer one

        //write title of mode
        bufferG.setColor(Color.black);
        bufferG.setFont(title);
        bufferG.drawString( gameInfo.gameName,(width-getFontMetrics(title).stringWidth(gameInfo.gameName))/2,100);

        //faded effect for heading
        for(int x=colours.length-1;x>-1;x--)
        {
            bufferG.setColor(new  Color(colours[x]));
            bufferG.fillRect((15*(27-x)),150,15,20);
        }

        //eading name
        bufferG.setColor(new Color(0x1D3C55));
        bufferG.setFont(headers);
        bufferG.drawString("Blocks Included:", 20, 165);

        //draw included game blocks
        int posx=0;
        int posy=0;
        for (int i=0; i<12;i++)
        {
            if(gameInfo.includeBlocks[i])
            {
                Shape tmp=Shape.shapeNum(i+1);
                for (int y=tmp.shape.length-1;y>-1;y--)
                    for (int x=0;x<tmp.shape[0].length;x++)    
                        drawBlock(bufferG,tmp.shape[y][x],(posx*5)+x,12+(posy*5)+y,true);
                posx++;
            }
            //go to next row if 7 blocks have been drawn
            if (posx>6)
            {
                posx=0;
                posy++;
            }
        }
        //if new row declared but not used
        if (posx==0)
        {
            posy--;
        }
        for(int x=colours.length-1;x>-1;x--)
        {
            bufferG.setColor(new  Color(colours[x]));
            bufferG.fillRect((15*(27-x)),(17+(posy*5))*15+5,15,20);
        }

        
        bufferG.setColor(new Color(0x1D3C55));
        bufferG.setFont(headers);
//if enabled, draw block rotaion and diagram
        if(gameInfo.blockRotated==1)
        {
            bufferG.drawString("Block Rotation Enabled", 20, (17+(posy*5))*15+20);
            posx=0;
            Shape tmp= new Block_T();
            for (int i=1;i<6;i++)
            {
                tmp.rotation=i;
                tmp.rotate();
                for (int y=tmp.shape.length-1;y>-1;y--)
                    for (int x=0;x<tmp.shape[0].length;x++)    
                        drawBlock(bufferG,tmp.shape[y][x],2+(posx*6)+x,(19+(posy*5))+y,true);
                posx++;
            }
            bufferG.setColor(Color.white);
            drawArrow(bufferG,105,((19+(posy*5))*15)+30,135,((19+(posy*5))*15)+30);
            drawArrow(bufferG,185,((19+(posy*5))*15)+30,225,((19+(posy*5))*15)+30);
            drawArrow(bufferG,290,((19+(posy*5))*15)+30,315,((19+(posy*5))*15)+30);
            drawArrow(bufferG,365,((19+(posy*5))*15)+30,405,((19+(posy*5))*15)+30);
        }
        //if disabled show unrotated block
        else
        {
            bufferG.drawString("Block Rotation Disabled", 20, (17+(posy*5))*15+20);
            Shape tmp= new Block_Z();
            for (int y=tmp.shape.length-1;y>-1;y--)
                for (int x=0;x<tmp.shape[0].length;x++)    
                    drawBlock(bufferG,tmp.shape[y][x],5+x,(20+(posy*5))+y,true);
            for (int y=tmp.shape.length-1;y>-1;y--)
                for (int x=0;x<tmp.shape[0].length;x++)    
                    drawBlock(bufferG,tmp.shape[y][x],23+x,(20+(posy*5))+y,true);
            bufferG.setColor(Color.white);
            drawArrow(bufferG,155,((19+(posy*5))*15)+30,360,((19+(posy*5))*15)+30);
        }

        //find the number of avilable screen orientions
        int numOrientations=0;
        for (int i =0;i<4;i++)
        {
            if (gameInfo.orientations[i])
                numOrientations++;
        }

        //if only one then write text on left and draw single ode on the left
        if(numOrientations==1)
        {
            for(int x=colours.length-1;x>-1;x--)
            {
                bufferG.setColor(new  Color(colours[x]));
                bufferG.fillRect((10*(27-x)),(24+(posy*5))*15+30,10,20);
            }

            bufferG.setColor(new Color(0x1D3C55));
            bufferG.setFont(headers);
            bufferG.drawString("Only Avaialbe Orientation", 20, (24+(posy*5))*15+45);

            int orientation=0;
            for (int i =0;i<4;i++)
            {
                if (gameInfo.orientations[i])
                    orientation=i;
            }

            //draw board aimge
            drawBoard(orientation,330,(24+(posy*5))*15+10);

        }
        //if more then one then
        else
        {
            //deaw writing area
            for(int x=colours.length-1;x>-1;x--)
            {
                bufferG.setColor(new  Color(colours[x]));
                bufferG.fillRect((10*(27-x)),(24+(posy*5))*15+5,10,20);
            }

            //display current oriention mode
            bufferG.setColor(new Color(0x1D3C55));
            bufferG.setFont(headers);
            if(gameInfo.orientationMode==0)
            {
                bufferG.drawString("Orientation Changed Manually", 20, (24+(posy*5))*15+20);

            }
            else if(gameInfo.orientationMode==1)
            {
                bufferG.drawString("Orientation Changed Randomly", 20, (24+(posy*5))*15+20);

            }
            else if(gameInfo.orientationMode==2)
            {
                bufferG.drawString("Orientation Changed Clockwise", 20, (24+(posy*5))*15+20);

            }
            else if(gameInfo.orientationMode==3)
            {
                bufferG.drawString("Orientation Changed Counter-Clockwise", 20, (24+(posy*5))*15+20);

            }

            //if two orientions total
            if(numOrientations==2)
            {
               // draw line below last to write on
                for(int x=colours.length-1;x>-1;x--)
                {
                    bufferG.setColor(new  Color(colours[x]));
                    bufferG.fillRect((10*(27-x)),(24+(posy*5))*15+55,10,20);
                }
                bufferG.setColor(new Color(0x1D3C55));
                bufferG.setFont(headers);
                bufferG.drawString("Two Avaialbe Orientations", 20, (24+(posy*5))*15+70);
                int orientation=0;
                //find and draw the two avilable oritnions
                for (int i =0;i<4;i++)
                {
                    if (gameInfo.orientations[i])
                    {
                        orientation=i;
                        break;
                    }
                }
                drawBoard(orientation,330,(24+(posy*5))*15+10);

                for (int i =orientation+1;i<4;i++)
                {
                    if (gameInfo.orientations[i])
                    {
                        orientation=i;
                        break;
                    }
                }
                drawBoard(orientation,430,(24+(posy*5))*15+10);

            }
            //if 3 orientions
            else if(numOrientations==3)
            {
                //same as aboce
                for(int x=colours.length-1;x>-1;x--)
                {
                    bufferG.setColor(new  Color(colours[x]));
                    bufferG.fillRect((10*(27-x)),(24+(posy*5))*15+55,10,20);
                }
                bufferG.setColor(new Color(0x1D3C55));
                bufferG.setFont(headers);
                bufferG.drawString("Three Avaialbe Orientations", 20, (24+(posy*5))*15+70);
                int orientation=0;
                //find and draw the three avilalbe oritions
                for (int i =0;i<4;i++)
                {
                    if (gameInfo.orientations[i])
                    {
                        orientation=i;
                        break;
                    }
                }
                drawBoard(orientation,310,(24+(posy*5))*15+10);

                for (int i =orientation+1;i<4;i++)
                {
                    if (gameInfo.orientations[i])
                    {
                        orientation=i;
                        break;
                    }
                }
                drawBoard(orientation,380,(24+(posy*5))*15+10);

                for (int i =orientation+1;i<4;i++)
                {
                    if (gameInfo.orientations[i])
                    {
                        orientation=i;
                        break;
                    }
                }
                drawBoard(orientation,450,(24+(posy*5))*15+10);

            }
            //if there are 4 enabled orietions
            else if(numOrientations==4)
            {
                //on the same line draw text
                for(int x=colours.length-1;x>-1;x--)
                {
                    bufferG.setColor(new  Color(colours[x]));
                    bufferG.fillRect(540-(10*(27-x)),(24+(posy*5))*15+5,10,20);
                }
                bufferG.setColor(new Color(0x1D3C55));
                bufferG.setFont(headers);
                bufferG.drawString("All Orientations Available", 350, (24+(posy*5))*15+20);

                //below draw the 4 oritentions
                drawBoard(0,90,(24+(posy*5))*15+40);
                drawBoard(1,180,(24+(posy*5))*15+40); 
                drawBoard(2,270,(24+(posy*5))*15+40);
                drawBoard(3,360,(24+(posy*5))*15+40);
            }
        }
        
        //draw onto main window for first screen update
        windowG.drawImage(buffered,0,0,this );

        /*************************************************************************************/
        /*************************************************************************************/
        /*************************************************************************************/
        /***********************************INSTURCTIONS**************************************/
        /*************************************************************************************/
        /*************************************************************************************/
        /*************************************************************************************/
        // draw borders
        bufferIns.setColor(new Color(0x28587d));
        bufferIns.fillRect(0, 0,520,insHeight);
        bufferIns.setColor(bgColor);
        bufferIns.fillRect(5, 5,510,insHeight-10);

        //fade effect
        for(int x=0;x<colours.length;x++)
        {
            bufferIns.setColor(new  Color(colours[x]));
            bufferIns.fillRect((8*x)+28,10,8,20);
        }
        for(int x=colours.length-1;x>-1;x--)
        {
            bufferIns.setColor(new  Color(colours[x]));
            bufferIns.fillRect((8*(55-x))+29,10,8,20);
        }

        //first area of text
        bufferIns.setColor(new Color(0x1D3C55));
        bufferIns.setFont(headers);
        bufferIns.drawString("Objective",260-(getFontMetrics(headers).stringWidth("Objective")/2),25);   //center   
        bufferIns.setColor(Color.white);
        bufferIns.drawString("- To place Blocks onto the Board to create solid rows",20,45);
        bufferIns.drawString("- Rows are cleared to earn points, there are combos as well",20,65); 

        //middle fade text
        for(int x=0;x<colours.length;x++)
        {
            bufferIns.setColor(new  Color(colours[x]));
            bufferIns.fillRect((8*x)+28,75,8,20);
        }
        for(int x=colours.length-1;x>-1;x--)
        {
            bufferIns.setColor(new  Color(colours[x]));
            bufferIns.fillRect((8*(55-x))+29,75,8,20);
        }
//objective of the game
        bufferIns.setColor(new Color(0x1D3C55));
        bufferIns.setFont(headers);
        bufferIns.drawString("Things To Know",260-(getFontMetrics(headers).stringWidth("Things To Know")/2),90);      
        bufferIns.setColor(Color.white);
        bufferIns.drawString("- As the game goes on it will get proressively more difficult",20,110);     
        bufferIns.drawString("- you can only swap a falling block once",20,130);  
        bufferIns.drawString("- More rows you clear at once, the bigger the combo",20,150); 
        bufferIns.drawString("- You can harddrop to place block at the bottom of the board",20,170); 
        bufferIns.drawString("- You can soft drop to speed up the down speed of a block temporarly",20,190); 

        int yShiftText=0;
        //things to be added if orientions modes are enabled
        if (numOrientations>1)
        {
            //shift everything down to make room for this text and explainthe oriention mode
            yShiftText=20;
            if(gameInfo.orientationMode==0)
                bufferIns.drawString("- You can manually change the screen orientation, with the keys",20,210);  
            if(gameInfo.orientationMode==1)
                bufferIns.drawString("- The screen will randomly change orienations",20,210);  
            if(gameInfo.orientationMode==2)
                bufferIns.drawString("- The screen will rotate clockwise",20,210);
                 if(gameInfo.orientationMode==3)
                bufferIns.drawString("- The screen will rotate counter-clockwise",20,210);
        } 

        //last fade effect for controls
        for(int x=0;x<colours.length;x++)
        {
            bufferIns.setColor(new  Color(colours[x]));
            bufferIns.fillRect((8*x)+28,200+yShiftText,8,20);
        }
        for(int x=colours.length-1;x>-1;x--)
        {
            bufferIns.setColor(new  Color(colours[x]));
            bufferIns.fillRect((8*(55-x))+29,200+yShiftText,8,20);
        }
//write controls info to buffer
        bufferIns.setColor(new Color(0x1D3C55));
        bufferIns.setFont(headers);
        bufferIns.drawString("Controls",260-(getFontMetrics(headers).stringWidth("Controls")/2),215+yShiftText);      
        bufferIns.setColor(Color.white);
        bufferIns.drawString("Left Arrow - Shift Block Left",20,235+yShiftText); 
        bufferIns.drawString("Right Arrow - Shift Block Left",270,235+yShiftText); 

        bufferIns.drawString("Down Arrow - Soft Drop",20,255+yShiftText); 
        bufferIns.drawString("Space Bar - Hard Drop",270,255+yShiftText);

        bufferIns.drawString("Esc Key - Pause Game",20,275+yShiftText);

        /*************************************************************************************/
        /*************************************************************************************/
        /*************************************************************************************/
        /************************************HIGH SCORE***************************************/
        /*************************************************************************************/
        /*************************************************************************************/
        /*************************************************************************************/
        // border and BG
        bufferScore.setColor(new Color(0x28587d));
        bufferScore.fillRect(0, 0, scoreWidth,290);
        bufferScore.setColor(bgColor);
        bufferScore.fillRect(5, 5, scoreWidth-10,280);

        //set the fade amount and draw the dividing lines between scores
        int amtFade=scoreWidth/58;
        for (int i=0;i<11;i++)
        {
            for(int x=0;x<colours.length;x++)
            {
                bufferScore.setColor(new  Color(colours[x]));
                bufferScore.fillRect((amtFade*x)+amtFade,(25*i)+32,amtFade,2);
            }
            for(int x=colours.length-1;x>-1;x--)
            {
                bufferScore.setColor(new  Color(colours[x]));
                bufferScore.fillRect((amtFade*(55-x))+amtFade,(25*i)+32,amtFade,2);
            }
        }
        //write the headers
        bufferScore.setColor(Color.white);
        bufferScore.setFont(scoresText);
        bufferScore.drawString("#",(50-getFontMetrics(scoresText).stringWidth("#"))/2,25);
        bufferScore.drawString("Name",(210-getFontMetrics(scoresText).stringWidth("Name"))/2,25);  
        bufferScore.drawString("Score",190+(((scoreWidth-150)/2)-getFontMetrics(scoresText).stringWidth("Score"))/2,25); 
//write the number, name and score
        for (int i=0;i<10;i++)
        {
            bufferScore.drawString(Integer.toString(i+1),(50-getFontMetrics(scoresText).stringWidth(Integer.toString(i+1)))/2,50+(i*25)); 
            bufferScore.drawString(gameInfo.highScoreName[i],(210-getFontMetrics(scoresText).stringWidth(gameInfo.highScoreName[i]))/2,50+(i*25));
            bufferScore.drawString(Integer.toString(gameInfo.highScore[i]),190+(((scoreWidth-150)/2)-getFontMetrics(scoresText).stringWidth(Integer.toString(gameInfo.highScore[i])))/2,50+(i*25)); //31 digit max
        }

    }
    
    //to rotate nd draw the baord to the main window without making annew oard for each orintion
    public void drawBoard(int orientation, int x,int y)
    {
        //to rotate the oject, works with @D graphics
        AffineTransform at = new AffineTransform();
        Graphics2D tmpG=(Graphics2D) bufferG;
        //0 is no rotate 1 is 90 degrees, 2 is 180 degrees, 3 is 270 degrees
        switch(orientation)
        {
            case 0:
            //move to position
            at.translate(x,y);
            //no effects draw straight to the board
            tmpG.drawImage(board,at,this);
            //draw the curret oriention amounr 0 degrees
            bufferG.setColor(Color.white);
            bufferG.setFont(degreeSymbol);
            bufferG.drawString("0", x+25, y+35);
            bufferG.drawString("o", x+32, y+30);
            break;
            case 1:
            //move to position and shift to stay on buffer after rotaion
            at.translate(x+60,y);
            //rotate
            at.rotate(Math.PI/2);
            //draw to buffer
            tmpG.drawImage(board,at,this);
            //draw degrees amount
            bufferG.setColor(Color.white);
            bufferG.setFont(degreeSymbol);
            bufferG.drawString("90", x+20, y+35);
            bufferG.drawString("o", x+34, y+30);
            break;
            case 2:
            at.translate(x+60,y+60);
            at.rotate(Math.PI);
            tmpG.drawImage(board,at,this);
            bufferG.setColor(Color.white);
            bufferG.setFont(degreeSymbol);
            bufferG.drawString("180", x+18, y+35);
            bufferG.drawString("o", x+38, y+30);
            break;
            case 3:
            at.translate(x,y+60);
            at.rotate(3*Math.PI/2);
            tmpG.drawImage(board,at,this);
            bufferG.setColor(Color.white);
            bufferG.setFont(degreeSymbol);
            bufferG.drawString("270", x+22, y+35);
            bufferG.drawString("o", x+42, y+30);
            break;
        }
    }

    //when instructions are moused over
    public void showIns()
    {
        //blur bacground, write header
        blur(); 
        windowG.setColor(Color.white);
        windowG.setFont(instructionText);
        //if there is a g in the name 'original" then
        if(gameInfo.gameNum==0)
            windowG.drawString("Instructions",(width-getFontMetrics(instructionText).stringWidth("Instructions"))/2,145); 
        else
            windowG.drawString("Instructions",(width-getFontMetrics(instructionText).stringWidth("Instructions"))/2,125); 
            //draw instruction overlay
        windowG.drawImage(insBuffered,10,145+((height-145-70-insHeight)/2),this);//draw oberlay
        //update
        repaint();
    }

    //when highscore is mosed over
    //reference aboce
    public void showScore()
    {
        blur(); //background
        windowG.setColor(Color.white);
        windowG.setFont(instructionText);
        if(gameInfo.gameNum==0)
            windowG.drawString("High Scores",(width-getFontMetrics(instructionText).stringWidth("High Scores"))/2,145);  
        else
            windowG.drawString("High Scores",(width-getFontMetrics(instructionText).stringWidth("High Scores"))/2,125);   
        windowG.drawImage(scoreBuffered,(540- scoreWidth)/2,145+((height-145-70-290)/2),this);//draw oberlay
        repaint();
    }

    //bluring info
    public void blur() {
        //conditions
        float data[] = { 0.1f, 0.125f, 0.0625f, 0.125f, 0.25f, 0.125f,
                0.0625f, 0.125f, 0.0625f };    
//create blur kernal, and blur image
        Kernel kernel = new Kernel(3, 3, data);
        ConvolveOp convolve = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP,
                null);
        BufferedImage tmp= new BufferedImage (width,height-70, BufferedImage.TYPE_3BYTE_BGR);
        convolve.filter(buffered, window);
        convolve.filter(window,tmp);
        convolve.filter(tmp,window);
        convolve.filter(window,tmp);
    }

    //nomral window no overlay
    public void standardWin()
    {
        windowG.drawImage(buffered,0, 0,this ); //draw standard info
        repaint();
    }

    public void paint(Graphics g)
    {
        super.paint(g); //draw buttons 
        g.drawImage(window,0,0,this ); //draw the other info
    }

    //find in board class
    public void drawBlock (Graphics g, int c, int x, int y, boolean solid)
    {
        if (c != 0)
        {
            int[] x3D = new int [4], y3D = new int [4];
            //draw polygons for 3D part
            //bottom side
            g.setColor (gameColour.colour [c]);
            x3D [0] = shiftx + x * 15;
            x3D [1] = shiftx + x * 15 + depth3D;
            x3D [2] = shiftx + x * 15 + 15 + depth3D;
            x3D [3] = shiftx + x * 15 + 15;
            y3D [0] = shifty + y * 15 + 15;
            y3D [1] = shifty + y * 15 + 15 - depth3D;
            y3D [2] = shifty + y * 15 + 15 - depth3D;
            y3D [3] = shifty + y * 15 + 15;
            g.drawPolygon (x3D, y3D, 4);
            if (solid)
            {
                g.fillPolygon (x3D, y3D, 4);
                g.setColor (gameColour.colour [0]);
            }
            //left side
            g.setColor (gameColour.colour [c]);
            x3D [0] = shiftx + x * 15;
            x3D [1] = shiftx + x * 15 + depth3D;
            x3D [2] = shiftx + x * 15 + depth3D;
            x3D [3] = shiftx + x * 15;
            y3D [0] = shifty + y * 15;
            y3D [1] = shifty + y * 15 - depth3D;
            y3D [2] = shifty + y * 15 + 15 - depth3D;
            y3D [3] = shifty + y * 15 + 15;
            g.drawPolygon (x3D, y3D, 4);
            if (solid)
            {
                g.fillPolygon (x3D, y3D, 4);
                g.setColor (gameColour.colour [0]);
            }
            //top side
            g.setColor (gameColour.colour [c]);
            x3D [0] = shiftx + x * 15;
            x3D [1] = shiftx + x * 15 + depth3D;
            x3D [2] = shiftx + x * 15 + 15 + depth3D;
            x3D [3] = shiftx + x * 15 + 15;
            y3D [0] = shifty + y * 15;
            y3D [1] = shifty + y * 15 - depth3D;
            y3D [2] = shifty + y * 15 - depth3D;
            y3D [3] = shifty + y * 15;
            if (solid)
            {
                g.fillPolygon (x3D, y3D, 4);
                g.setColor (gameColour.colour [0]);
            }
            g.drawPolygon (x3D, y3D, 4);
            //right side
            g.setColor (gameColour.colour [c]);
            x3D [0] = shiftx + x * 15 + 15;
            x3D [1] = shiftx + x * 15 + 15 + depth3D;
            x3D [2] = shiftx + x * 15 + 15 + depth3D;
            x3D [3] = shiftx + x * 15 + 15;
            y3D [0] = shifty + y * 15;
            y3D [1] = shifty + y * 15 - depth3D;
            y3D [2] = shifty + y * 15 + 15 - depth3D;
            y3D [3] = shifty + y * 15 + 15;
            if (solid)
            {
                g.fillPolygon (x3D, y3D, 4);
                g.setColor (gameColour.colour [0]);
            }
            g.drawPolygon (x3D, y3D, 4);
            //draw the squares for the main part of block
            g.setColor (gameColour.colour [c]);
            if (solid)
            {
                g.fillRect (shiftx + x * 15, shifty + y * 15, 15, 15);
                g.setColor (gameColour.colour [0]);
            }
            g.drawRect (shiftx + x * 15, shifty + y * 15, 15, 15);
        }
    }
    //draws arrows
    int ARR_SIZE = 10;
    public void drawArrow(Graphics g1,int x1,int y1,int x2, int y2)
    {
        Graphics2D g = (Graphics2D) g1.create();

        double dx = x2 - x1, dy = y2 - y1;
        double angle = Math.atan2(dy, dx);
        int len = (int) Math.sqrt(dx*dx + dy*dy);
        AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
        at.concatenate(AffineTransform.getRotateInstance(angle));
        g.transform(at);

        // Draw horizontal arrow starting in (0, 0)
        g.drawLine(0, 0, len, 0);
        g.fillPolygon(new int[] {len, len-ARR_SIZE, len-ARR_SIZE, len},
            new int[] {0, -ARR_SIZE, ARR_SIZE, 0}, 4);
    }

}
