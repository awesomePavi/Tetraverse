/**
 * Z Block
 * Rotation HardCoded
 * 
 * @author (Pavithran Pathmarajah) 
 * @version (2014 May 2)
 */
public class Block_Z extends Shape
{   
    // Creating block info
    public Block_Z()
    {
        //current orientation
        rotation=1;
        //create block
        rotate();
        //Number Associated With Block
        blockNum=2;

        //postiton top center
        x=4;
        y=1;
    }

    //creates block at set orientation
    public void rotate()
    {
        if(rotation ==1 || rotation ==3)
        {
            // minimal block size
            shape=new int[2][3];

            shape[0][0]=2;
            shape[0][1]=2;
            shape[0][2]=0;
            shape[1][0]=0;
            shape[1][1]=2;
            shape[1][2]=2;
        }         
        else  if(rotation ==2||rotation ==4)
        {
            // minimal block size
            shape=new int[3][2];

            shape[0][0]=0;
            shape[0][1]=2;
            shape[1][0]=2;
            shape[1][1]=2;
            shape[2][0]=2;
            shape[2][1]=0;
        }
    }
}