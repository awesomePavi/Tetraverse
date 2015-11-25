/**
 * 1x2 block
 * 
 * @author (Pavithran Pathmarajah) 
 * @version (2014 May 6)
 */
public class Block_Two extends Shape
{
     // Creating block info
    public Block_Two()
    {
        //current orientation
        rotation=1;
        //create block
        // minimal block size
        shape=new int[1][2];

        shape[0][0]=14;
        shape[0][1]=14;
            
        //Number Associated With Block
        blockNum=9;

        //postiton top center
        x=4;
        y=1;
    }
    
    public void clock()
    {
        Game.runLoop=false;
        int itmp[][] = new int[shape.length][shape[0].length];
        int yy, xx, py = 0, px = 0;
        itmp = shape;
        if (shape.length < shape[0].length )
        {
            middley = y;
            middlex = x + 1;
        }
        else
        {
            middlex = x;
            middley = y + 1;
        }
        if (rotationCheck())
        {
            if (shape.length > shape[0].length)//original height is greater than length
            {
                if (rotate == false)
                {
                    x = middlex;
                    y = middley;
                }
                shape = new int[shape[0].length][shape.length];
                for (int a = 0; a < shape.length; a++)
                {
                    for (int b = 0; b < shape[0].length; b++)
                    {
                        shape[a][b] = itmp[py][px];
                        py++;
                    }
                }

            }
            else //original length is greater than height
            {
                x = middlex;
                y = middley - 1;
                shape = new int[shape[0].length][shape.length];
                for (int a = 0; a < shape.length; a++)
                {
                    for (int b = 0; b < shape[0].length; b++)
                    {
                        shape[a][b] = itmp[py][px];
                    }
                    px++;
                }
            }
        }
        Game.runLoop=true;
    }
    
    public void counter()
    {
        Game.runLoop=false;
        int itmp[][] = new int[shape.length][shape[0].length];
        int yy, xx, py = 0, px = 0;
        itmp = shape;
        if (shape.length < shape[0].length )
        {
            middley = y;
            middlex = x + 1;
        }
        else
        {
            middlex = x;
            middley = y + 1;
        }
        if (rotationCheckCounter())
        {
            if (shape.length > shape[0].length)//original height is greater than length
            {
                if (rotate == false)
                {
                    x = x - 1;
                    y = middley;
                }
                shape = new int[shape[0].length][shape.length];
                for (int a = 0; a < shape.length; a++)
                {
                    for (int b = 0; b < shape[0].length; b++)
                    {
                        shape[a][b] = itmp[py][px];
                        py++;
                    }
                }

            }
            else //original length is greater than height
            {
                x = middlex;
                y = middley - 1;
                shape = new int[shape[0].length][shape.length];
                for (int a = 0; a < shape.length; a++)
                {
                    for (int b = 0; b < shape[0].length; b++)
                    {
                        shape[a][b] = itmp[py][px];
                    }
                    px++;
                }
            }
        }
        Game.runLoop=true;
    }
}
