/**
 * Super calss of all tetris shapes includes:
 * 
 * -Check if the shape has landed
 * -Save shape to board
 * -Associate numbers to all shapes * 
 * 
 * @author (Christopher Wilson)
 * @author (Pavithran Pathmarajah)
 * @version (2014 May 12)
 */
public class Shape
{

    // instance variables - replace the example below with your own
    public int x,y;    
    public int shape[][];
    public int blockNum;    
    public int rotation;
    public boolean move = true; //returns true if shape can move at all
    public int board[][];
    //For rotationCheck method
    public int xmove, ymove, fakex = 0, fakey = 0;
    public int height, length;
    public int countx = 0;
    public int tmpx, tmpb, tmpy, xSlide = 0;
    public int middlex, middley;
    public int originalx = 0, originaly = 4, fakeXmove, fakeYmove;
    public boolean zBlock = false, rotate = false;
    public int lengthContent[];
    public int heightContent[];

    //Variables for the clock method

    public int xxx, xx, yy, yyy;

    //y value for the ghost being drawn
    int ghosty;// = 24 - Game.block.shape.length;
    
    public void clock()    
    {
        Game.runLoop=false;
        height = shape.length;
        length = shape[0].length;
        lengthContent = new int[shape[0].length];
        heightContent = new int[shape.length];
        int bb = 1, ca = 0;               
        int county = height-1;
        int indexF = -1000, indexR = -1000, index = 0;
        if (length > height)
        { 
            for (int a=0; a < height; a++)
            {
                for (int b=0; b < length; b++)
                {
                    if (shape[a][b] > 0)
                        heightContent[a]++;
                }
            }
            for (int a=0; a < height-1; a++)
                if (heightContent[a] == heightContent[a+1])
                {
                    index = 1;
                    zBlock = true;
            }
            if (height != 1)
                if (zBlock ==false)
                {
                    //Determines which y is the middle
                    for (int c=0; c < height-1; c++)
                    {
                        if (heightContent[c] > heightContent[c+1])
                            indexF = c;
                    }
                    for (int c = height-1; c > 0; c--)
                    {
                        if (heightContent[c] > heightContent[c-1])
                            indexR = c;
                    }
                    if (indexR == indexF)
                        index = indexF;
                    else if (indexR == -1000)
                        index = indexF;
                    else
                        index = indexR;                
            }
            middlex = x + (int) length/2;
            middley = y + index;
        }

        else if (height >= length) 
        {
            //Determining the middle y coridinate
            for (int b=0; b < length; b++)
                for (int a=0; a < height; a++)
                {
                    if (shape[a][b] > 0)
                        lengthContent[b]++;
            }

            for (int a=0; a < length-1; a++)
                if (lengthContent[a] == lengthContent[a+1])
                {
                    index = 0;
                    zBlock = true;
            }    
            if (length != 1)
                if (zBlock == false)
                {
                    for (int c=0; c < length-1; c++)
                    { 
                        if (lengthContent[c] > lengthContent[c+1])
                            indexF = c;
                    }
                    for (int c = length -1; c > 0; c--)
                    {
                        if (lengthContent[c] > lengthContent[c-1])
                            indexR = c;
                    }
                    if (indexR == indexF)
                        index = indexF;
                    else if (indexR == -1000)
                        index = indexF;
                    else
                        index = indexR;
            }
            middley = y + (int) height/2;
            middlex = x + index;
        }
        rotationCheck();
        for (int a=y; a<= (y + (height-1)); a++)
        {
            for (int b=x; b<= (x + (length-1)); b++)
            {
                xmove = (middlex - b) + (middley - a);
                ymove = (middley - a) - (middlex - b);
                if ((b == x) && (bb == height) && move == true && ca < 1)
                {
                    if (rotate == true)
                        x = x + xSlide;
                    x = b + xmove;
                    y = a + ymove;
                    ca++;
                }
            }
            bb++;
        }
        if (zBlock == true && shape[0].length > shape.length)
            y--;
        //If move is possible returning some value. Don't know what value??? to return
        if (move == true)
        {
            int tmp[][] = shape;         
            shape = new int[tmp[0].length][tmp.length];          
            yy = tmp.length-1;
            for (int b = 0; b < tmp.length; b++)
            {
                xx = 0;
                for (int a = 0; a < tmp[0].length; a++)
                {
                    shape[a][b] = tmp[yy][xx];
                    xx++;
                }
                yy--;
            }
        }
        Game.runLoop=true;
    }

    public void counter()
    {
        Game.runLoop=false;
        height = shape.length;
        length = shape[0].length;
        lengthContent = new int[shape[0].length];
        heightContent = new int[shape.length];
        int bb = 1;               
        int county = height-1;
        int indexF = -1000, indexR = -1000, index = 0;
        if (length > height)
        { 
            for (int a=0; a < height; a++)
            {
                for (int b=0; b < length; b++)
                {
                    if (shape[a][b] > 0)
                        heightContent[a]++;
                }
            }
            for (int a=0; a < height-1; a++)
                if (heightContent[a] == heightContent[a+1])
                {
                    index = 1;
                    zBlock = true;
            }
            if (height != 1)
                if (zBlock ==false)
                {
                    //Determines which y is the middle
                    for (int c=0; c < height-1; c++)
                    {
                        if (heightContent[c] > heightContent[c+1])
                            indexF = c;
                    }
                    for (int c = height-1; c > 0; c--)
                    {
                        if (heightContent[c] > heightContent[c-1])
                            indexR = c;
                    }
                    if (indexR == indexF)
                        index = indexF;
                    else if (indexR == -1000)
                        index = indexF;
                    else
                        index = indexR;                
            }
            middlex = x + (int) length/2;
            middley = y + index;
        }

        else if (height >= length) 
        {
            //Determining the middle y coridinate
            for (int b=0; b < length; b++)
                for (int a=0; a < height; a++)
                {
                    if (shape[a][b] > 0)
                        lengthContent[b]++;
            }

            for (int a=0; a < length-1; a++)
                if (lengthContent[a] == lengthContent[a+1])
                {
                    index = 1;
                    zBlock = true;
            }    
            if (length != 1)
                if (zBlock == false)
                {
                    for (int c=0; c < length-1; c++)
                    { 
                        if (lengthContent[c] > lengthContent[c+1])
                            indexF = c;
                    }
                    for (int c = length -1; c > 0; c--)
                    {
                        if (lengthContent[c] > lengthContent[c-1])
                            indexR = c;
                    }
                    if (indexR == indexF)
                        index = indexF;
                    else if (indexR == -1000)
                        index = indexF;
                    else
                        index = indexR;
            }
            middley = y + (int) height/2;
            middlex = x + index;
        }
        rotationCheckCounter();
        for (int a=y; a<= (y + (height-1)); a++)
        {
            for (int b=x; b<= (x + (length-1)); b++)
            {
                xmove = (middlex - b) - (middley - a);
                ymove = (middley - a) + (middlex - b);
                if ((a == y) && (bb == shape[0].length) && move == true)
                {
                    if (rotate == true)
                        x = x + xSlide;
                    x = b + xmove;
                    y = a + ymove;

                }
                bb++;
            }
        }
        //If move is possible returning some value. Don't know what value??? to return
        if (move == true)
        {
            int tmp[][] = shape;         
            shape = new int[tmp[0].length][tmp.length];            
            xx = tmp[0].length-1;
            yy = 0;
            for (int b = 0; b < tmp.length; b++)
            {
                xx = tmp[0].length-1;
                for (int a = 0; a < tmp[0].length; a++)
                {
                    shape[a][b] = tmp[yy][xx];
                    xx--;
                }
                yy++;
            }
        }
        Game.runLoop=true;
    }
    
    public boolean rotationCheck()
    {
        int rotateShape[][] = new int[shape[0].length][shape.length];
        int collisionShape[][] = new int[shape[0].length][shape.length];
        int shapex = 0, shapey = 0, count = 0, ca = 0;
        fakex = shape.length;
        height = shape.length;
        length = shape[0].length;
        yy = shape.length-1;
        for (int d = 0; d < shape.length; d++)
        {
            xx = 0;
            for (int c = 0; c < shape[0].length; c++)
            {
                collisionShape[c][d] = shape[yy][xx];
                xx++;
            }
            yy--;
        }
        for (int a=y; a<= (y + (height-1)); a++)
        {
            fakex--;
            fakey = 0;
            for (int b=x; b<= (x + (length-1)); b++)
            {
                xmove = (middlex - b) + (middley - a);
                ymove = (middley - a) - (middlex - b);
                if (b + xmove > 9)
                {
                    tmpx = x;
                    tmpy = y;
                    tmpb = b;
                    rotate = true;
                    if (length == 1)
                        xSlide = (9 - middlex) + (y - middley) + 1;
                    else
                        xSlide = (9 - middlex) - ((int)shape.length/2);                      
                    middlex = middlex + xSlide;
                    tmpx = tmpx + xSlide;                    
                    yy = shape.length-1;
                    for (int d = 0; d < shape.length; d++)
                    {
                        xx = 0;
                        for (int c = 0; c < shape[0].length; c++)
                        {
                            rotateShape[c][d] = shape[yy][xx];
                            xx++;
                        }
                        yy--;
                    }
                    for (int c = tmpy; c <= (tmpy + (length-1)); c++)
                        for (int d = tmpx; d <= (tmpx + (height-1)); d++)
                            if ((d == tmpx) && (c == (tmpy + (length-1))))
                            {
                                fakeXmove = (middlex - d) + (middley - c);
                                fakeYmove = (middley - c) - (middlex - d);
                                tmpx = d + fakeXmove;
                                tmpy = c + fakeYmove;
                    }
                    for (int c = tmpy; c <= (tmpy + (length-1)); c++)
                    {
                        shapex = 0;
                        for (int d = tmpx; d <= (tmpx + (height-1)); d++)
                        {
                            if (Board.board[c][d] > 0 && rotateShape[shapey][shapex] > 0)
                            {
                                move = false;
                                break;
                            }
                            shapex++;
                        }
                        shapey++;
                    }
                    if (move == false)
                        break;
                }
                else if (b + xmove < 0)
                {
                    tmpx = x;
                    tmpy = y;
                    tmpb = b;
                    move = true;
                    rotate = true;
                    xSlide = -(middlex - ((int)shape.length/2));               
                    middlex = middlex + xSlide;
                    tmpx = tmpx + xSlide;
                    yy = shape.length-1;
                    for (int d = 0; d < shape.length; d++)
                    {
                        xx = 0;
                        for (int c = 0; c < shape[0].length; c++)
                        {
                            rotateShape[c][d] = shape[yy][xx];
                            xx++;
                        }
                        yy--;
                    }
                    for (int c = tmpy; c <= (tmpy + (length-1)); c++)
                        for (int d = tmpx; d <= (tmpx + (height-1)); d++)
                            if ((d == tmpx) && (c == (tmpy + (length-1))))
                            {
                                fakeXmove = (middlex - d) + (middley - c);
                                fakeYmove = (middley - c) - (middlex - d);
                                tmpx = d + fakeXmove;
                                tmpy = c + fakeYmove;
                    }
                    for (int c = tmpy; c <= (tmpy + (length-1)); c++)
                    {
                        shapex = 0;
                        for (int d = tmpx; d <= (tmpx + (height-1)); d++)
                        {
                            if (Board.board[c][d] > 0 && rotateShape[shapey][shapex] > 0)
                            {
                                move = false;
                                break;
                            }
                            shapex++;
                        }
                        shapey++;
                    }
                    if (move == false)
                        break;
                }

                else if (Board.board[a + ymove][b + xmove] > 0 && collisionShape[fakey][fakex] > 0)
                {
                    tmpx = x;
                    tmpy = y;
                    if ((b + xmove) > middlex)
                    {
                        if (length == 1)
                        
                            xSlide = (tmpy - middley) + ((xmove + b) - middlex - 1);
                        else
                            xSlide = (((b + xmove) - middlex) - ((int)shape.length/2)) - ((int)shape.length/2);
                        rotate = true;
                        middlex = middlex + xSlide;
                        tmpx = tmpx + xSlide;
                        for (int c = tmpy; c <= (tmpy + (height-1)); c++)
                            for (int d = tmpx; d <= (tmpx + (length-1)); d++)
                                if ((d == tmpx) && (c == (tmpy + (height-1))) && ca < 1)
                                {
                                    fakeXmove = (middlex - d) + (middley - c);
                                    fakeYmove = (middley - c) - (middlex - d);
                                    tmpx = d + fakeXmove;
                                    tmpy = c + fakeYmove;
                                    ca++;
                        }
                        try 
                        {
                            for (int c = tmpy; c <= (tmpy + (length-1)); c++)
                            {
                                shapex = 0;
                                for (int d = tmpx; d <= (tmpx + (height-1)); d++)
                                {
                                    if (Board.board[c][d] > 0 && collisionShape[shapey][shapex] > 0)
                                    {
                                        move = false;
                                        break;
                                    }
                                    shapex++;
                                }
                                shapey++;
                            }
                        }
                        catch (ArrayIndexOutOfBoundsException e)
                        {
                            move = false;
                        }
                        if (move == false)
                            break;
                    }
                    else if ((b + xmove) < middlex )
                    {
                        if (length == 1)
                            xSlide = (a - middley) + ((b + xmove) - middlex + 1);
                        else
                            xSlide = -((middlex - (b + xmove)) - ((int)shape.length/2)) + ((int)shape.length/2);
                        rotate = true;
                        middlex = middlex + xSlide;
                        tmpx = tmpx + xSlide;
                        for (int c = tmpy; c <= (tmpy + (height-1)); c++)
                            for (int d = tmpx; d <= (tmpx + (length-1)); d++)
                                if ((d == tmpx) && (c == (tmpy + (height-1))) && ca < 1)
                                {
                                    fakeXmove = (middlex - d) + (middley - c);
                                    fakeYmove = (middley - c) - (middlex - d);
                                    tmpx = d + fakeXmove;
                                    tmpy = c + fakeYmove;
                                    ca++;
                        }
                        try
                        {
                            for (int c = tmpy; c <= (tmpy + (length-1)); c++)
                            {
                                shapex = 0;
                                for (int d = tmpx; d <= (tmpx + (height-1)); d++)
                                {
                                    if (Board.board[c][d] > 0 && collisionShape[shapey][shapex] > 0)
                                    {
                                        move = false;
                                        break;
                                    }
                                    shapex++;
                                }
                                shapey++;
                            }
                        }
                        catch (ArrayIndexOutOfBoundsException e)
                        {
                            move = false;
                        }
                        if (move == false)
                            break;
                    } 
                }
                else
                {
                    move = true;
                    count++;
                }
                fakey++;
            }
            if (move == false)
                break;
        }
        if (count == shape.length)
            rotate = false;
        if (shape[0].length == 1 && rotate == true && move == true)
        {
            x = tmpx;
            y = tmpy;
        }
        return move;
    }
    
    public boolean rotationCheckCounter()
    {
        int rotateShape[][] = new int[shape[0].length][shape.length];
        int collisionShape[][] = new int[shape[0].length][shape.length];
        int shapex = 0, shapey = 0, count = 0, ca = 0;
        fakex = shape.length;
        height = shape.length;
        length = shape[0].length;
        yy = shape.length-1;
        for (int d = 0; d < shape.length; d++)
        {
            xx = 0;
            for (int c = 0; c < shape[0].length; c++)
            {
                collisionShape[c][d] = shape[yy][xx];
                xx++;
            }
            yy--;
        }
        for (int a=y; a<= (y + (height-1)); a++)
        {
            fakex--;
            fakey = 0;
            for (int b=x; b<= (x + (length-1)); b++)
            {
                xmove = (middlex - b) - (middley - a);
                ymove = (middley - a) + (middlex - b);
                if (b + xmove > 9)
                {
                    tmpx = x;
                    tmpy = y;
                    tmpb = b;
                    rotate = true;
                    if (length == 1)
                        xSlide = (9 - middlex) + (y - middley) + 1;
                    else
                        xSlide = (9 - middlex) - ((int)shape.length/2);  
                    middlex = middlex + xSlide;
                    tmpx = tmpx + xSlide;                    
                    yy = shape.length-1;
                    for (int d = 0; d < shape.length; d++)
                    {
                        xx = 0;
                        for (int c = 0; c < shape[0].length; c++)
                        {
                            rotateShape[c][d] = shape[yy][xx];
                            xx++;
                        }
                        yy--;
                    }
                    for (int c = tmpy; c <= (tmpy + (height-1)); c++)
                        for (int d = tmpx; d <= (tmpx + (length-1)); d++)
                            if ((c == tmpy) && (d == (tmpx + (length-1))) && ca < 1)
                            {
                                fakeXmove = (middlex - d) - (middley - c);
                                fakeYmove = (middley - c) + (middlex - d);
                                tmpx = d + fakeXmove;
                                tmpy = c + fakeYmove;
                                ca++;
                    }
                    for (int c = tmpy; c <= (tmpy + (length-1)); c++)
                    {
                        shapex = 0;
                        for (int d = tmpx; d <= (tmpx + (height-1)); d++)
                        {
                            if (Board.board[c][d] > 0 && rotateShape[shapey][shapex] > 0)
                            {
                                move = false;
                                break;
                            }
                            shapex++;
                        }
                        shapey++;
                    }
                    if (move == false)
                        break;
                }
                else if (b + xmove < 0)
                {
                    tmpx = x;
                    tmpy = y;
                    tmpb = b;
                    move = true;
                    rotate = true;
                    xSlide = -(middlex - ((int)shape.length/2));               
                    middlex = middlex + xSlide;
                    tmpx = tmpx + xSlide;
                    yy = shape.length-1;
                    for (int d = 0; d < shape.length; d++)
                    {
                        xx = 0;
                        for (int c = 0; c < shape[0].length; c++)
                        {
                            rotateShape[c][d] = shape[yy][xx];
                            xx++;
                        }
                        yy--;
                    }
                    for (int c = tmpy; c <= (tmpy + (length-1)); c++)
                        for (int d = tmpx; d <= (tmpx + (height-1)); d++)
                            if ((c == tmpy) && (d == (tmpx + (shape[0].length-1))) && ca < 1)
                            {
                                fakeXmove = (middlex - d) - (middley - c);
                                fakeYmove = (middley - c) + (middlex - d);
                                tmpx = d + fakeXmove;
                                tmpy = c + fakeYmove;
                                ca++;
                    }
                    for (int c = tmpy; c <= (tmpy + (length-1)); c++)
                    {
                        shapex = 0;
                        for (int d = tmpx; d <= (tmpx + (height-1)); d++)
                        {
                            if (Board.board[c][d] > 0 && rotateShape[shapey][shapex] > 0)
                            {
                                move = false;
                                break;
                            }
                            shapex++;
                        }
                        shapey++;
                    }
                    if (move == false)
                        break;
                }

                else if (Board.board[a + ymove][b + xmove] > 0 && collisionShape[fakey][fakex] > 0)
                {
                    tmpx = x;
                    tmpy = y;
                    if ((b + xmove) > middlex)
                    {
                        if (length == 1)
                            xSlide = ((b + xmove) - middlex) + (middley - a) - 1;
                        else
                            xSlide = (((b + xmove) - middlex) - ((int)shape.length/2)) - ((int)shape.length/2);
                        rotate = true;
                        middlex = middlex + xSlide;
                        tmpx = tmpx + xSlide;
                        for (int c = tmpy; c <= (tmpy + (length-1)); c++)
                            for (int d = tmpx; d <= (tmpx + (height-1)); d++)
                                if ((c == tmpy) && (d == (tmpx + (shape[0].length-1))) && ca < 1)
                                {
                                    fakeXmove = (middlex - d) - (middley - c);
                                    fakeYmove = (middley - c) + (middlex - d);
                                    tmpx = d + fakeXmove;
                                    tmpy = c + fakeYmove;
                                    ca++;
                                }
                        try 
                        {
                            for (int c = tmpy; c <= (tmpy + (length-1)); c++)
                            {
                                shapex = 0;
                                for (int d = tmpx; d <= (tmpx + (height-1)); d++)
                                {
                                    if (Board.board[c][d] > 0 && collisionShape[shapey][shapex] > 0)
                                    {
                                        move = false;
                                        break;
                                    }
                                    shapex++;
                                }
                                shapey++;
                            }
                        }
                        catch (ArrayIndexOutOfBoundsException e)
                        {
                            move = false;
                        }
                        if (move == false)
                            break;
                    }
                    else if ((b + xmove) < middlex )
                    {
                        if (length == 1)
                            xSlide = ((b + xmove) - middlex) + (middley - a) + 2;
                        else
                            xSlide = -((middlex - (b + xmove)) - ((int)shape.length/2)) + ((int)shape.length/2);
                        rotate = true;
                        middlex = middlex + xSlide;
                        tmpx = tmpx + xSlide;
                        for (int c = tmpy; c <= (tmpy + (height-1)); c++)
                            for (int d = tmpx; d <= (tmpx + (length-1)); d++)
                                if ((c == tmpy) && (d == (tmpx + (length-1))) && ca < 1)
                                {
                                    fakeXmove = (middlex - d) - (middley - c);
                                    fakeYmove = (middley - c) + (middlex - d);
                                    tmpx = d + fakeXmove;
                                    tmpy = c + fakeYmove;
                                    ca++;
                        }
                        try
                        {
                            for (int c = tmpy; c <= (tmpy + (length-1)); c++)
                            {
                                shapex = 0;
                                for (int d = tmpx; d <= (tmpx + (height-1)); d++)
                                {
                                    if (Board.board[c][d] > 0 && collisionShape[shapey][shapex] > 0)
                                    {
                                        move = false;
                                        break;
                                    }
                                    shapex++;
                                }
                                shapey++;
                            }
                        }
                        catch (ArrayIndexOutOfBoundsException e)
                        {
                            move = false;
                        }
                        if (move == false)
                            break;
                    } 
                }
                else
                {
                    move = true;
                    count++;
                }
                fakey++;
            }
            if (move == false)
                break;
        }
        if (count == shape.length)
            rotate = false;          
        if (shape[0].length == 1 && rotate == true && move == true)
        {
            x = tmpx;
            y = tmpy;
        }
        return move;
    }

    //to access rotation hardcoded to each object
    public void rotate()
    {
        //to be filled in each block seperately
    }

    public void rShift()
    {
        //if the shape plus its total width does not go off the board and it will not hit a block
        if(((x+shape[0].length)<10)&&!checkBlock(1,0))
            x++; //move right
    }

    public void lShift()
    {
        //if it is moved over one will it stay on the baord. and if it will not hit a block
        if(((x-1)>-1)&&!checkBlock(-1,0))
            x--;
    }

    public void hardDrop()
    {
        while(!checkBlock(0,1))
        {
            y++;
        }
    }

    public void fall()
    {
        y++;        
    }

    public boolean checkBlock(int xShift, int yShift)
    {
        
        //check the blocks entire width and height
        for (int x1=0;x1<shape[0].length;x1++)
            for (int y1=0;y1<shape.length;y1++)
            {
                //if its not at the bottom and there is a block there and the board has a block there
                if((y+y1+yShift)<=23&&shape[y1][x1]!=0&&Board.board[y+y1+yShift][x+x1+xShift]!=0)
                {
                    // the block has hit                    
                    return true;
                }
                // if the block has gotten to the bottom of the board
                else if((y+y1+yShift)>23)
                {
                    // the block has hit
                    return true;
                }
        }
        return false;
    }

    //calculates where to draw the ghost piece
    public void ghost ()
    {
        ghosty = y;
        while (!checkBlock(0, ghosty - y))
        {
            ghosty++;
        }
        ghosty--;

    }

    //saves shape to the board
    public boolean saveToBoard()
    {
        //for the entire bojects length and width
        for (int x1=0;x1<shape[0].length;x1++)
            for (int y1=0;y1<shape.length;y1++)
            {
                //add the blocks value to the board, if the block isnt blank
                if(shape[y1][x1]!=0)
                    Board.board[y+y1][x+x1]=shape[y1][x1];
        }
        return true;
    }

    //Relates a vlaue back to its designated shape
    public static Shape shapeNum(int choice)
    {
        switch (choice)
        {
            case 1:
            return new Block_I();             
            case 2:
            return new Block_Z();
            case 3:
            return new Block_S();            
            case 4:
            return new Block_O();
            case 5:            
            return new Block_T();
            case 6:
            return new Block_L();
            case 7:
            return new Block_J();
            case 8:
            return new Block_One();
            case 9:
            return new Block_Two();
            case 10:
            return new Block_Three();
            case 11:
            return new Block_MiniL();
            case 12:
            return new Block_Bomb();
        }
        return new Block_Blank(); // default block
    }
}

