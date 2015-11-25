/**
 * 1x2 by 1 L block
 * 
 * @author (Pavithran Pathmarajah) 
 * @version (2014 May 6)
 */
public class Block_MiniL extends Shape
{
    // Creating block info
    public Block_MiniL()
    {
        //current orientation
        rotation=1;
        //create block
        // minimal block size
        shape=new int[2][2];

        shape[0][0]=6;
        shape[0][1]=6;
        shape[1][0]=6;
        shape[1][1]=0;

        //Number Associated With Block
        blockNum=6;

        //postiton top center
        x=4;
        y=0;
    }  

    public void clock()
    {
        Game.runLoop=false;
        int xx, yy, yyy, xxx, indexF = -1000, indexR = -1000;
        int Ltmp[][] = new int[2][2];
        int times = 0;
        Ltmp = shape;
        lengthContent = new int[shape[0].length];
        heightContent = new int[shape.length];
        //Height Content
        for (int a=0; a < shape.length; a++)
            for (int b=0; b < shape[0].length; b++)
                if (shape[a][b] > 0)
                    heightContent[a]++;
        for (int c=0; c < shape.length-1; c++)
        {
            if (heightContent[c] > heightContent[c+1])
                indexF = c;
        }
        for (int c = shape.length-1; c > 0; c--)
        {
            if (heightContent[c] > heightContent[c-1])
                indexR = c;
        }
        if (indexR == indexF)
            yy = indexF;
        else if (indexR == -1000)
            yy = indexF;
        else
            yy = indexR;
        //Length Content
        indexF = 0;
        indexR = 0;
        for (int b=0; b < shape[0].length; b++)
            for (int a=0; a < shape.length; a++)
            {
                if (shape[a][b] > 0)
                    lengthContent[b]++;
        }
        for (int c=0; c < shape[0].length-1; c++)
        { 
            if (lengthContent[c] > lengthContent[c+1])
                indexF = c;
        }
        for (int c = shape[0].length -1; c > 0; c--)
        {
            if (lengthContent[c] > lengthContent[c-1])
                indexR = c;
        }
        if (indexR == indexF)
            xx = indexF;
        else if (indexR == -1000)
            xx = indexF;
        else
            xx = indexR;
        middlex = x + xx;
        middley = y + yy;
        if (rotationCheck())
        {          
            yyy = Ltmp.length-1;
            for (int a=y; a<= (y + (shape.length-1)); a++)
            {
                fakex--;
                fakey = 0;
                for (int b=x; b<= (x + (shape[0].length-1)); b++)
                {
                    xmove = (middlex - b) + (middley - a);
                    ymove = (middley - a) - (middlex - b);
                    if (b == x && a == y + shape.length-1 && times < 1)
                    {
                        x = b + xmove;
                        y = a + ymove;
                        times++;
                    }
                }
            }
            shape = new int[Ltmp[0].length][Ltmp.length];
            for (int b = 0; b < Ltmp.length; b++)
            {
                xxx = 0;
                for (int a = 0; a < Ltmp[0].length; a++)
                {
                    shape[a][b] = Ltmp[yyy][xxx];
                    xxx++;
                }
                yyy--;
            }
        }
        Game.runLoop=true;
    }
    
    public void counter()
    {
        Game.runLoop=false;
        int xx, yy, yyy, xxx, indexF = -1000, indexR = -1000;
        int Ltmp[][] = new int[2][2];
        int times = 0;
        Ltmp = shape;
        lengthContent = new int[shape[0].length];
        heightContent = new int[shape.length];
        //Height Content
        for (int a=0; a < shape.length; a++)
            for (int b=0; b < shape[0].length; b++)
                if (shape[a][b] > 0)
                    heightContent[a]++;
        for (int c=0; c < shape.length-1; c++)
        {
            if (heightContent[c] > heightContent[c+1])
                indexF = c;
        }
        for (int c = shape.length-1; c > 0; c--)
        {
            if (heightContent[c] > heightContent[c-1])
                indexR = c;
        }
        if (indexR == indexF)
            yy = indexF;
        else if (indexR == -1000)
            yy = indexF;
        else
            yy = indexR;
        //Length Content
        indexF = 0;
        indexR = 0;
        for (int b=0; b < shape[0].length; b++)
            for (int a=0; a < shape.length; a++)
            {
                if (shape[a][b] > 0)
                    lengthContent[b]++;
        }
        for (int c=0; c < shape[0].length-1; c++)
        { 
            if (lengthContent[c] > lengthContent[c+1])
                indexF = c;
        }
        for (int c = shape[0].length -1; c > 0; c--)
        {
            if (lengthContent[c] > lengthContent[c-1])
                indexR = c;
        }
        if (indexR == indexF)
            xx = indexF;
        else if (indexR == -1000)
            xx = indexF;
        else
            xx = indexR;
        middlex = x + xx;
        middley = y + yy;
        if (rotationCheckCounter())
        {          
            yyy = Ltmp.length-1;
            for (int a=y; a<= (y + (shape.length-1)); a++)
            {
                fakex--;
                fakey = 0;
                for (int b=x; b<= (x + (shape[0].length-1)); b++)
                {
                    xmove = (middlex - b) - (middley - a);
                    ymove = (middley - a) + (middlex - b);
                    if (a == y && b == x + shape[0].length-1 && times < 1)
                    {
                        x = b + xmove;
                        y = a + ymove;
                        times++;
                    }
                }
            }
            shape = new int[Ltmp[0].length][Ltmp.length];
            yyy = 0;
            for (int b = 0; b < Ltmp.length; b++)
            {
                xxx = Ltmp[0].length-1;
                for (int a = 0; a < Ltmp[0].length; a++)
                {
                    shape[a][b] = Ltmp[yyy][xxx];
                    xxx--;
                }
                yyy++;
            }
        }
        Game.runLoop=true;
    }
}
