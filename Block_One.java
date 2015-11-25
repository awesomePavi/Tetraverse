/**
 * 1x1 block
 * 
 * @author (Pavithran Pathmarajah) 
 * @version (2014 May 6)
 */
public class Block_One extends Shape
{
   // Creating block info
    public Block_One()
    {
        //current orientation
        rotation=1;
        //create block
        // minimal block size
        shape=new int[1][1];

        shape[0][0]=13;
            
        //Number Associated With Block
        blockNum=8;

        //postiton top center
        x=5;
        y=1;
    }
    
     public void clock()
    {
    }
    public void counter()
    {
    }
}
