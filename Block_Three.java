/**
 * 1x3 block
 * 
 * @author (Pavithran Pathmarajah) 
 * @version (2014 May 6)
 */
public class Block_Three extends Shape
{
      // Creating block info
    public Block_Three()
    {
        //current orientation
        rotation=1;
        //create block
        // minimal block size
        shape=new int[1][3];

        shape[0][0]=15;
        shape[0][1]=15;
        shape[0][2]=15;
            
        //Number Associated With Block
        blockNum=10;

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
        if (shape.length == 1)
        {
            middlex = x + 1;
            middley = y;
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
                    x = x - 1;
                    y = y + 1;
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
                x = x + 1;
                y = y - 1;
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
                    y = y + 1;
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
                x = x + 1;
                y = y - 1;
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
