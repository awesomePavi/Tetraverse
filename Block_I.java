/**
 * I Block
 * Rotation HardCoded
 * 
 * @author (Pavithran Pathmarajah) 
 * @version (2014 May 2)
 */
public class Block_I extends Shape
{   
    // Creating block info
    public Block_I()
    {
        //current orientation
        rotation=1;
        //create block
        rotate();
        //Number Associated With Block
        blockNum=1;

        //postiton top center
        x=5;
        y=0;
    }

    //creates block at set orientation
    public void rotate()
    {
        if(rotation ==1 || rotation ==3)
        {
            // minimal block size
            shape=new int[4][1];

            shape[0][0]=1;
            shape[1][0]=1;
            shape[2][0]=1;
            shape[3][0]=1;
        } 

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
            middley = y + 2;
        }
        if (rotationCheck())
        {
            if (shape.length > shape[0].length)//original height is greater than length
            {
                if (rotate == false)
                {
                    x = x - 1;
                    y = y + 2;
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
                y = y - 2;
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
            Game.runLoop=true;
        }
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
            middlex = x + 2;
        }
        else
        {
            middlex = x;
            middley = y + 2;
        }
        if (rotationCheckCounter())
        {
            if (shape.length > shape[0].length)//original height is greater than length
            {
                if (rotate == false)
                {
                    x = x - 2;
                    y = y + 2;
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
                x = x + 2;
                y = y - 2;
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
