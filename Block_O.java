/**
 * O Block
 * Rotation HardCoded
 * 
 * @author (Pavithran Pathmarajah) 
 * @version (2014 May 2)
 */
public class Block_O extends Shape
{   
    // Creating block info
    public Block_O()
    {
        //current orientation
        rotation=1;
        //create block
        rotate();
        //Number Associated With Block
        blockNum=4;

        //postiton top center
        x=5;
        y=1;
    }

    //creates block at set orientation
    public void rotate()
    {
        // minimal block size
        shape=new int[2][2];

        shape[0][0]=4;
        shape[1][0]=4;
        shape[0][1]=4;
        shape[1][1]=4;
    }
    
    public void clock()
    {
    }
    public void counter()
    {
    }
}