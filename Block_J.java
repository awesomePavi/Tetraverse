/**
 * J Block
 * Rotation HardCoded
 * 
 * @author (Pavithran Pathmarajah) 
 * @version (2014 May 2)
 */
public class Block_J extends Shape
{   
    // Creating block info
    public Block_J()
    {
        //current orientation
        rotation=1;
        //create block
        rotate();
        //Number Associated With Block
        blockNum=7;       
        //postiton top center
        x=4;
        y=0;
    }

    //creates block at set orientation
    public void rotate()
    {
        if(rotation ==1)
        {
            // minimal block size
            shape=new int[3][2];

            shape[0][0]=0;
            shape[0][1]=7;
            shape[1][0]=0;
            shape[1][1]=7;
            shape[2][0]=7;
            shape[2][1]=7;
        }         
        else  if(rotation ==2)
        {
            // minimal block size
            shape=new int[2][3];

            shape[0][0]=7;
            shape[0][1]=0;
            shape[0][2]=0;
            shape[1][0]=7;
            shape[1][1]=7;
            shape[1][2]=7;
        }
        else  if(rotation ==3)
        {
            // minimal block size
            shape=new int[3][2];

            shape[0][0]=7;
            shape[0][1]=7;
            shape[1][0]=7;
            shape[1][1]=0;
            shape[2][0]=7;
            shape[2][1]=0;
        }
        else  if(rotation ==4)
        {
            // minimal block size
            shape=new int[2][3];

            shape[0][0]=7;
            shape[0][1]=7;
            shape[0][2]=7;
            shape[1][0]=0;
            shape[1][1]=0;
            shape[1][2]=7;
        }
    }
}