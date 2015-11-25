/**
 * This class loads, saves, jhold keylayout info
 * 
 * @author (Pavithran Pathmarajah) 
 * @version (27 May 2014)
 */
import java.io.*;
import java.util.*;
public class KeyLayout
{
    // the keys in the program
    int leftKey;
    int rightKey;
    int downKey;
    int spaceKey;
    int xKey;
    int zKey;
    int escKey;
    int cKey;
    int aKey;
    int sKey; 
    String layoutName;

    public KeyLayout()
    {
        //standard keys
        leftKey=37;
        rightKey=39;
        downKey=40;
        spaceKey=32;
        xKey=88;
        zKey=90;
        escKey=27;
        cKey=67;
        aKey=65;
        sKey=83;   
        layoutName="Standard";
    }

    //Reference GameType
    public static void readLayouts(ArrayList<KeyLayout> layouts)
    {
        try
        {
            KeyLayout fileRead;
            File fileModes=new File("RunFiles/KeyLayouts.txt");
            Scanner in=new Scanner(fileModes);
            while(in.hasNext())
            {
                System.out.println("yo");
                fileRead=new KeyLayout();
                String tmp;
                tmp= in.next();
                tmp= in.next();
                fileRead.layoutName=in.next();
                tmp= in.next();
                tmp= in.next();
                System.out.println(tmp);
                fileRead.leftKey=Integer.parseInt(tmp);
                tmp= in.next();
                tmp= in.next();
                fileRead.rightKey=Integer.parseInt(tmp);
                tmp= in.next();
                tmp= in.next();
                fileRead.downKey=Integer.parseInt(tmp);
                tmp= in.next();
                tmp= in.next();
                fileRead.spaceKey=Integer.parseInt(tmp);
                tmp= in.next();
                tmp= in.next();
                fileRead.xKey=Integer.parseInt(tmp);
                tmp= in.next();
                tmp= in.next();
                fileRead.zKey=Integer.parseInt(tmp);
                tmp= in.next();
                tmp= in.next();
                fileRead.escKey=Integer.parseInt(tmp);
                tmp= in.next();
                tmp= in.next();
                fileRead.cKey=Integer.parseInt(tmp);
                tmp= in.next();
                tmp= in.next();
                fileRead.aKey=Integer.parseInt(tmp);
                tmp= in.next();
                tmp= in.next();
                fileRead.sKey=Integer.parseInt(tmp);
                tmp= in.next();
                layouts.add(fileRead);
            }

        }
        catch(IOException e)
        {  
        }

    }

    public static void saveLayouts(ArrayList<KeyLayout> layouts)
    {
        try
        {
            File fileOut=new File("RunFiles/KeyLayouts.txt");
            PrintWriter toFile=new PrintWriter(new FileWriter(fileOut,false));
            KeyLayout tmp;
            for (int i=0;i<layouts.size();i++)
            {
                tmp=layouts.get(i);
                toFile.println("------------------");
                toFile.println("KeyLayoutName: "+ tmp.layoutName);

                toFile.println("leftKey: "+ tmp.leftKey);
                toFile.println("rightKey: "+ tmp.rightKey);
                toFile.println("downKey: "+ tmp.downKey);
                toFile.println("spaceKey: "+  tmp.spaceKey);
                toFile.println("xKey: "+ tmp.xKey);
                toFile.println("zKey: "+  tmp.zKey);
                toFile.println("escKey: "+  tmp.escKey);
                toFile.println("cKey: "+ tmp.cKey);
                toFile.println("aKey: "+ tmp.aKey);
                toFile.println("sKey: "+  tmp.sKey);
                toFile.println("------------------");
            }
            toFile.close();

            fileOut=null;
        }
        catch(FileNotFoundException e)
        { 
        }
        catch(IOException e)
        {  
        }
    }

    public void save()
    {
        try
        {
            File fileOut=new File("RunFiles/KeyLayouts.txt");
            PrintWriter toFile=new PrintWriter(new FileWriter(fileOut,true));

            toFile.println("------------------");
            toFile.println("KeyLayoutName: "+ layoutName);

            toFile.println("leftKey: "+ leftKey);
            toFile.println("rightKey: "+ rightKey);
            toFile.println("downKey: "+ downKey);
            toFile.println("spaceKey: "+  spaceKey);
            toFile.println("xKey: "+ xKey);
            toFile.println("zKey: "+  zKey);
            toFile.println("escKey: "+  escKey);
            toFile.println("cKey: "+ cKey);
            toFile.println("aKey: "+ aKey);
            toFile.println("sKey: "+  sKey);
            toFile.println("------------------");
            toFile.close();

            fileOut=null;
        }
        catch(FileNotFoundException e)
        { 
        }
        catch(IOException e)
        {  
        }
    }
}
