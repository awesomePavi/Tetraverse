 /**
 * Blank Block used for intial Held Block
 * 
 * @author (Pavithran Pathmarajah) 
 * @version (2014 Apr 26)
 */
public class Block_Blank extends Shape
{
   // Creating block info
    public Block_Blank()
    {
        rotation=1;
		// minimal block size
        shape=new int[1][1];
		
        shape[0][0]=0;
        shape[0][0]=0;
		//postiton to identify its a blank block
        x=-1;
        y=-1;
    }
}
