/**
 * Sets the tetris colours.
 * 
 * @author (Christopher Wilson) 
 * @Additions(Stephen Webb)
 * @version (2014 Apr 27)
 */
import java.awt.*;
public class gameColour
{
    public static Color colour[] = new Color[21];
    //to step the bomb colour changer ticker up
    static int steper=0;
    static boolean bmbClr=false; //current colour
    
    //each shape's colour
    public static void setColour()
    {
        colour[0] = new Color(0,0,0);            // black 
        colour[1] = new Color(0, 240, 255);      // I (blue)
        colour[2] = new Color(255, 0, 0);        // Z (red)
        colour[3] = new Color(0, 255, 0);        // S (green)
        colour[4] = new Color(255, 128, 0);      // O (orange)
        colour[5] = new Color(255, 255, 0);      // T (yellow)
        colour[6] = new Color(255, 70, 200);     // L (pink)
        colour[7] = new Color(191, 0, 255);      // J (purple)
        
        colour[13] = Color.pink;//new Color(191, 0, 255);      // One (purple)
        colour[14] = Color.yellow;//new Color(191, 0, 255);      // Two (purple)
        colour[15] = Color.cyan;//new Color(191, 0, 255);      // Three (purple)
        colour[16] = Color.magenta;//new Color(191, 0, 255);      // MiniL (purple)
        colour[17] = Color.green;//new Color(191, 0, 255);      // Bomb (purple)

        colour[8] = new Color(255, 255, 255);    // white
        colour[9] = new Color(200, 200, 200);    // light gray
        colour[10] = new Color(128, 128, 128);   // gray
        colour[11] = new Color(64, 64, 64);      // dark gray
        colour[12] = new Color(32, 32, 32);      // very dark gray
        
        colour[18] = new Color(255, 000, 000);   // 3
        colour[19] = new Color(250,250,0);      // 2
        colour[20] = new Color(000, 255, 000);      // 1
        steper=0;
    }
    
    //called every grpahis update loop
    public static void updateColor()
    {
        steper++;
        //after hald a second using 15 milli update loop
        if(steper>34)
        {
            //setnewcolour
            if (bmbClr)
             colour[17]=Color.green;
            else
             colour[17]=Color.red;
             //necttime it will be other colour
            bmbClr=!bmbClr;
            //count again
            steper=0;
        }
    }
}
