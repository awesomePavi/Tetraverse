/**
 * Bomb Block
 * 
 * @author (Pavithran Pathmarajah) 
 * @version (2014 May 7)
 */
public class  Block_Bomb extends Shape
{
   // Creating block info
    public Block_Bomb()
    {
        //current orientation
        rotation=1;
        //create block
        // minimal block size
        shape=new int[3][3];

        shape[0][0]=17;
        shape[0][1]=17;
        shape[0][2]=17;        
        shape[1][0]=17;
        shape[1][1]=17;
        shape[1][2]=17;
        shape[2][0]=17;
        shape[2][1]=17;
        shape[2][2]=17;
            
        //Number Associated With Block
        blockNum=12;

        //postiton top center
        x=4;
        y=1;
    }
    
    public void clock()
    {
    }
    public void counter()
    {
    }
}