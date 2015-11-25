
/**
 * Write a description of class CustomModeScreen here.
 * 
 * @author (Stephen Webb) 
 * @version (10 June 2014)
 */

import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.event.*;


public class CustomModeScreen extends GamePanel implements ActionListener
{
    Graphics bufferG;
    BufferedImage buffer;
    JButton rotation[] = new JButton[4];
    JButton blocks[] = new JButton[12];
    JButton depth[] = new JButton[2];
    JButton orientation[] = new JButton[4];
    JButton proceed[] = new JButton[2];
    
        JTextField depthInput; 
        
    public CustomModeScreen(JFrame runWindow)
    {
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        buffer = new BufferedImage (400,200, BufferedImage.TYPE_3BYTE_BGR);
        bufferG = buffer.getGraphics ();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        proceed[0] = new JButton("Back");
        proceed[0].setActionCommand("back");
        proceed[1] = new JButton ("Proceed");
        proceed[1].setActionCommand("proceed");
        addButtons(proceed, c);
            
        c.gridx = 0;
        c.gridy = 1;
        rotation[0] = new JButton("None");
        rotation[0].setActionCommand("none");
        rotation[1] = new JButton("Random");
        rotation[1].setActionCommand("random");
        rotation[2] = new JButton("Clockwise");
        rotation[2].setActionCommand("clock");
        rotation[3] = new JButton("Counter-Clockwise");
        rotation[3].setActionCommand("counter");
        for (int i = 0; i < 4; i++)
        {
            rotation[i].addActionListener(this);
            add(rotation[i], c);
            c.gridx++;
            if (Main.type.orientationMode == i)
            rotation[i].setEnabled(false);
        }
        
            orientation[0] = new JButton("0");
            orientation[0].setActionCommand("0");
            orientation[1] = new JButton("90");
            orientation[1].setActionCommand("90");
            orientation[2] = new JButton("180");
            orientation[2].setActionCommand("180");
            orientation[3] = new JButton("270");
            orientation[3].setActionCommand("270");
            for (int i = 0; i < orientation.length; i++)
            {
                onOff(orientation, Main.type.orientations, i);
                onOff(orientation, Main.type.orientations, i);
            }
            
            c.gridx = 0;
            c.gridy = 2;
            addButtons(orientation,c);
        
            blocks[0] = new JButton( "I");
            blocks[0].setActionCommand("I");
            blocks[1] = new JButton( "Z");
            blocks[1].setActionCommand("Z");
            blocks[2] = new JButton( "S");
            blocks[2].setActionCommand("S");
            blocks[3] = new JButton( "O");
            blocks[3].setActionCommand("O");
            blocks[4] = new JButton( "T");
            blocks[4].setActionCommand("T");
            blocks[5] = new JButton( "L");
            blocks[5].setActionCommand("L");
            blocks[6] = new JButton( "J");
            blocks[6].setActionCommand("J");
            blocks[7] = new JButton( "One");
            blocks[7].setActionCommand("One");
            blocks[8] = new JButton( "Two");
            blocks[8].setActionCommand("Two");
            blocks[9] = new JButton( "Three");
            blocks[9].setActionCommand("Three");
            blocks[10] = new JButton( "MiniL");
            blocks[10].setActionCommand("MiniL");
            blocks[11] = new JButton( "Bomb");
            blocks[11].setActionCommand("Bomb");
            for (int i = 0; i < blocks.length; i++)
            {
                onOff(blocks, Main.type.includeBlocks, i);
                onOff(blocks, Main.type.includeBlocks, i);
            }
            c.gridx = 0;
            c.gridy = 3;
            addButtons(blocks,c);
            
            depth[0] = new JButton("Decrease Depth");
            depth[0].setActionCommand("depth-");
            depth[1] = new JButton("Increase Depth");
            depth[1].setActionCommand("depth+");
            c.gridx = 0;
            c.gridy = 4;
            addButtons(depth,c);
            
            depthInput= new JTextField (3);
            depthInput.setText(Integer.toString(Main.type.depth3D,10));
            depthInput.addActionListener (this);
            depthInput.setActionCommand ("depth");
            add (depthInput, c);
                        
        
    }

    public void actionPerformed (ActionEvent e)
    {
        
            if(e.getActionCommand().equals("I")&& minCheck(Main.type.includeBlocks, 0))
                onOff(blocks, Main.type.includeBlocks, 0);
            else if(e.getActionCommand().equals("Z")&& minCheck(Main.type.includeBlocks, 1))
                onOff(blocks, Main.type.includeBlocks, 1);
            else if(e.getActionCommand().equals("S")&& minCheck(Main.type.includeBlocks, 2))
                onOff(blocks, Main.type.includeBlocks, 2);
            else if(e.getActionCommand().equals("O")&& minCheck(Main.type.includeBlocks, 3))
                onOff(blocks, Main.type.includeBlocks, 3);
            else if(e.getActionCommand().equals("T")&& minCheck(Main.type.includeBlocks, 4))            
                onOff(blocks, Main.type.includeBlocks, 4);
            else if(e.getActionCommand().equals("L") && minCheck(Main.type.includeBlocks, 5))
                onOff(blocks, Main.type.includeBlocks, 5);
            else if(e.getActionCommand().equals("J") && minCheck(Main.type.includeBlocks, 6))
                onOff(blocks, Main.type.includeBlocks, 6);
            
            else if(e.getActionCommand().equals("One")&& minCheck(Main.type.includeBlocks, 7))
                onOff(blocks, Main.type.includeBlocks, 7);
            else if(e.getActionCommand().equals("Two")&& minCheck(Main.type.includeBlocks, 8))
                onOff(blocks, Main.type.includeBlocks, 8);
            else if(e.getActionCommand().equals("Three")&& minCheck(Main.type.includeBlocks, 9))
                onOff(blocks, Main.type.includeBlocks, 9);
            else if(e.getActionCommand().equals("MiniL")&& minCheck(Main.type.includeBlocks, 10))
                onOff(blocks, Main.type.includeBlocks, 10);
            else if(e.getActionCommand().equals("Bomb")&& minCheck(Main.type.includeBlocks, 11))
                onOff(blocks, Main.type.includeBlocks, 11);
            
            else if(e.getActionCommand().equals("none")){
                rotation[Main.type.orientationMode].setEnabled(true);
                Main.type.orientationMode = 0;
                rotation[Main.type.orientationMode].setEnabled(false);
            }
            else if(e.getActionCommand().equals("random")){
                rotation[Main.type.orientationMode].setEnabled(true);
                Main.type.orientationMode = 1;
                rotation[Main.type.orientationMode].setEnabled(false);
            }
            else if(e.getActionCommand().equals("clock")){
                rotation[Main.type.orientationMode].setEnabled(true);
                Main.type.orientationMode = 2;
                rotation[Main.type.orientationMode].setEnabled(false);
            }
            else if(e.getActionCommand().equals("counter")){
                rotation[Main.type.orientationMode].setEnabled(true);
                Main.type.orientationMode = 3;
                rotation[Main.type.orientationMode].setEnabled(false);
            }
            
            else if(e.getActionCommand().equals("0")&& minCheck(Main.type.orientations, 0))
                onOff(orientation, Main.type.orientations, 0);
            else if(e.getActionCommand().equals("90")&& minCheck(Main.type.orientations, 1))
                onOff(orientation, Main.type.orientations, 1);
            else if(e.getActionCommand().equals("180")&& minCheck(Main.type.orientations, 2))
                onOff(orientation, Main.type.orientations, 2);
            else if(e.getActionCommand().equals("270")&& minCheck(Main.type.orientations, 3))
                onOff(orientation, Main.type.orientations, 3);
            
            else if(e.getActionCommand().equals("depth+")){
                if (Main.type.depth3D < 15)
                {
                    Main.type.depth3D++;
                    depthInput.setText(Integer.toString(Main.type.depth3D,10));
                }
            }
            else if(e.getActionCommand().equals("depth-")){
                if (Main.type.depth3D > 0)
                {
                    Main.type.depth3D--;
                    depthInput.setText(Integer.toString(Main.type.depth3D,10));
                }
            }
            
            else if (e.getActionCommand().equals("back"))
                Main.mainMenu();
            
            else if(e.getActionCommand().equals("proceed"))
                Main.customGameInBetween();
                
            else if (e.getActionCommand().equals("depth"))
            {
                Main.type.depth3D = Integer.parseInt(depthInput.getText ());
                depthInput.setText(Integer.toString(Main.type.depth3D,10));
            }
        }
    
        public boolean minCheck (boolean[] check, int checking)
        {
            boolean atLeastOne = false;
            for (int i = 0; i < check.length; i++)
            {
                if (check[i] == true && checking != i)
                {
                    atLeastOne = true;
                }
            }
            return atLeastOne;
        }
        
        public void onOff (JButton[] j, boolean b[], int i)
        {
            b[i] = !b[i];
            if (b[i]) 
            {
                j[i].setBackground(gameColour.colour[3]);
                //j.setBackground(gameColour.colour[2]);
            }
            else
            {
                j[i].setBackground(gameColour.colour[2]);
            }
        }
        
        public void addButtons(JButton[] j, GridBagConstraints c)
        {
            for (int i = 0; i < j.length; i++)
            {
                j[i].addActionListener(this);
                add(j[i], c);
                c.gridx++;
            }
        }
        
    
    
    
    
    public void onDestroy(JFrame runWindow)
    {
    }
    
}
