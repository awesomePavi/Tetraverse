/**
 * This class holds info on each game type
 * 
 * @author (Pavithran Pathmarajah) 
 * @version (May 7 2014)
 */
import java.io.*;
import java.util.*;
public class GameType
{    
    String gameName;
    int gameNum;
    String highScoreName[]={"*","*","*","*","*","*","*","*","*","*"};
    int highScore[]={0,0,0,0,0,0,0,0,0,0};
    boolean includeBlocks[] =new boolean[12];
    int orientationMode=0;
    boolean orientations[]=new boolean [4];
    int blockRotated=0;   
    int rotateDelay=0;
    int depth3D=0;  

    //default
    public GameType()
    {  
        gameName="Original";

        gameNum=0;

        includeBlocks[0]=true; //Block_I
        includeBlocks[1]=true; //Block_Z
        includeBlocks[2]=true; //Block_S
        includeBlocks[3]=true; //Block_O
        includeBlocks[4]=true; //Block_T       
        includeBlocks[5]=true; //Block_L
        includeBlocks[6]=true; //Block_J

        includeBlocks[7]=false; //Block_One
        includeBlocks[8]=true;//Block_Two
        includeBlocks[9]=true;  //Block_Three
        includeBlocks[10]=true; //Block_MiniL 
        includeBlocks[11]=true; //Block_Bomb

        orientationMode=0;    //0 is one 
        //1 is randomly
        //2 is clcok every x seconds
        //3 is counter clockwise

        rotateDelay=0;
        orientations[0]=true;//0 degress
        orientations[1]=false;//90 degress
        orientations[2]=false;//180 degress 
        orientations[3]=false;//270 degress

        blockRotated=0;   // not

        depth3D=10;
    } 

    public void newHighScore()
    {
        try
        {
            //creates temp file to transfer datta over tmeporarly
            File fileModes=new File("RunFiles/GameModes.txt");
            File fileTmp=File.createTempFile("TTEV",".tmp",new File("RunFiles"));

            Scanner in=new Scanner(fileModes);
            PrintWriter out=new PrintWriter(new FileWriter(fileTmp));

            //transfers everything from one file and repalces the highscore
            String tmp;
            while(in.hasNext())
            {
                tmp=in.nextLine();
                out.println(tmp);
                if(tmp.equals("GameNum: "+ gameNum))
                {
                    for(int i=0;i<10;i++)  
                    {
                        out.println("Name_"+i+": "+  highScoreName[i]);
                        out.println("Score_"+i+": "+ highScore[i]);
                        in.nextLine();
                        in.nextLine();
                    }

                }
            }

            in.close();
            out.close();

            //copies tmp file abck ot oiginal file
            in=new Scanner(fileTmp);
            out=new PrintWriter(new FileWriter(fileModes));
            while(in.hasNext())
            {
                out.println(in.nextLine());
            }
            in.close();
            out.close();

            fileTmp.delete(); //delete tmp files

            fileModes=null;
            fileTmp=null;

        }
        catch(FileNotFoundException e)
        { 
        }
        catch(IOException e)
        {  
        }
    }

    public void saveGameType()
    {
        try
        {
            File fileOut=new File("RunFiles/GameModes.txt");
            PrintWriter toFile=new PrintWriter(new FileWriter(fileOut,true));

            toFile.println("------------------");
            toFile.println("GameName: "+gameName);
            toFile.println("GameNum: "+ gameNum);
            for(int i=0;i<10;i++)  
            {
                toFile.println("Name_"+i+": "+  highScoreName[i]);
                toFile.println("Score_"+i+": "+ highScore[i]);
            }

            toFile.println("Block_I: "+ includeBlocks[0]);
            toFile.println("Block_Z: "+ includeBlocks[1]);
            toFile.println("Block_S: "+ includeBlocks[2]);
            toFile.println("Block_O: "+ includeBlocks[3]);
            toFile.println("Block_T: "+ includeBlocks[4]);
            toFile.println("Block_L: "+ includeBlocks[5]);
            toFile.println("Block_J: "+ includeBlocks[6]);
            toFile.println("Block_One: "+ includeBlocks[7]);
            toFile.println("Block_Two: "+ includeBlocks[8]);
            toFile.println("Block_Three: "+ includeBlocks[9]);
            toFile.println("Block_MiniL: "+ includeBlocks[10]);
            toFile.println("Block_Bomb: "+ includeBlocks[11]);
            toFile.println("OrientationMode: "+ orientationMode);
            toFile.println("RotationDelay: "+ rotateDelay);
            toFile.println("Orientaion0: "+ orientations[0]);
            toFile.println("Orientaion90: "+ orientations[1]);
            toFile.println("Orientaion180: "+ orientations[2]);
            toFile.println("Orientaion270: "+ orientations[3]);
            toFile.println("BlockRotated: "+ blockRotated);
            toFile.println("3DDepth: "+  depth3D);
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

    public static void ReadGameTypes(ArrayList<GameType> modes)
    {
        try
        {
            //tmp gametype for the file input
            GameType fileRead;
            File fileModes=new File("RunFiles/GameModes.txt");
            Scanner in=new Scanner(fileModes);
            while(in.hasNext())
            {
                //intialize tmp game type
                fileRead=new GameType();
                in.next();

                in.next();
                fileRead.gameName=in.next();

                in.next();
                fileRead.gameNum=Integer.parseInt(in.next());

                for(int i=0;i<10;i++)  
                {
                    in.next();
                    fileRead.highScoreName[i]=in.next();
                    in.next();
                    fileRead.highScore[i]=Integer.parseInt(in.next());
                }
                for(int i=0;i<12;i++) 
                {
                    in.next();
                    if(in.next().equals("true"))
                        fileRead.includeBlocks[i]=true;
                    else
                        fileRead.includeBlocks[i]=false;
                }

                in.next();
                fileRead.orientationMode=Integer.parseInt(in.next());
                in.next();
                fileRead.rotateDelay=Integer.parseInt(in.next());
                in.next();
                for(int i=0;i<4;i++) 
                {
                    if(in.next().equals("true"))
                        fileRead.orientations[i]=true;
                    else
                        fileRead.orientations[i]=false;

                    in.next();
                }
                fileRead.blockRotated=Integer.parseInt(in.next());
                in.next();
                fileRead.depth3D=Integer.parseInt(in.next());
                in.next(); 
                //ads tmp game type to list of types
                modes.add(fileRead);
            }

        }
        catch(IOException e)
        {  
        }

    }
}
