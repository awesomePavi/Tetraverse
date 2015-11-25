/**
 * Gameover screen
 * 
 * @author (Shirley Xiao) 
 * @version (2014 Apr 29)
 */
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class GameOver extends GamePanel
{
    JButton againButton;
    JButton menuButton;
    JButton exitButton;

    gameoverAgain endScreen;
    gameover_Menu menu;
    gameover_Exit exitB;

    int score;
    int level;

    public GameOver(JFrame runWindow)
    { 

        //dispaly last score and level
        score =Game.score;
        level=Game.level;

        //create button to play again
        againButton = new JButton("Play again?");
        this.setLayout(null);
        againButton.setFont(new Font("Goudy Stout", Font.BOLD, 14));
        againButton.setBackground(new Color(0xFFD700));
        againButton.setBounds(90, 430, 300, 30);
        this.add(againButton);

        //create button menu
        menuButton = new JButton("Main Menu");
        this.setLayout(null);
        menuButton.setFont(new Font("Goudy Stout", Font.BOLD, 14));
        menuButton.setBackground(new Color(0x55FF00));
        menuButton.setBounds(90, 490, 300, 30);
        this.add(menuButton);

        //create button exit
        exitButton = new JButton("Quit Game");
        this.setLayout(null);
        exitButton.setFont(new Font("Goudy Stout", Font.BOLD, 14));
        exitButton.setBackground(new Color(0xee1100));
        exitButton.setBounds(90, 550, 300, 30);
        this.add(exitButton);

        //create Window
        this.setBackground(Color.BLACK);
        setPreferredSize(new Dimension(500,610));
        runWindow.setVisible(true);

        //restart game when button clicked
        endScreen = new gameoverAgain();
        againButton.addActionListener(endScreen);

        //go to main menu when button clicked
        menu = new gameover_Menu();
        menuButton.addActionListener(menu);

        //exit game when button clicked
        exitB = new gameover_Exit();
        exitButton.addActionListener(exitB);

    }

    public void onDestroy(JFrame runWindow)
    {
        againButton.removeActionListener(endScreen);

        for(ActionListener al : againButton.getActionListeners() ) {
            againButton.removeActionListener( al );
        }
    }

    public void paint(Graphics g)
    {
        super.paint(g);

        //draw line
        g.setColor(Color.RED);
        g.drawLine(0,100, 500, 100);
        g.drawLine(0, 80, 500, 80);

        //draw game over
        g.setColor(new Color(0x999999));
        g.setFont(new Font("Goudy Stout",Font.BOLD,55));
        g.drawString("G A M E ", 50 ,200);
        g.drawString("O V E R", 70, 300);

        g.setColor(Color.RED);
        g.setFont(new Font("Goudy Stout", Font.BOLD, 44));

        g.drawString("G", 50, 200);
        g.drawString("A", 150, 200);
        g.drawString("M", 260, 200);
        g.drawString("E", 380, 200);

        g.drawString("O", 70,300);
        g.drawString("V",170 , 300);
        g.drawString("E", 270, 300);
        g.drawString("R", 370, 300);

        //skull graphic DUPLICATE
        g.setColor(new Color(0x333333));
        //bone(topleft)
        g.fillRect(230, 350, 5, 10);
        g.fillRect(225, 355, 5, 5);
        g.fillRect(235, 360, 5, 5);

        //bone(bottomleft)
        g.fillRect(235, 385, 5, 5);
        g.fillRect(225, 390, 10, 5);
        g.fillRect(230, 395, 5, 5);

        //bone(topright)
        g.fillRect(275, 360, 5, 5);
        g.fillRect(280, 355, 10, 5);
        g.fillRect(280, 350, 5, 5);

        //bone(bottomleft)
        g.fillRect(275, 385, 5, 5);
        g.fillRect(280, 390, 5, 10);
        g.fillRect(285, 390, 5, 5);

        //face
        g.fillRect(240, 365, 5, 20);
        g.fillRect(245, 360, 25, 10);
        g.fillRect(240, 380, 10, 5);
        g.fillRect(250, 375, 5, 10);
        g.fillRect(255, 370, 5, 10);
        g.fillRect(260, 375, 5, 5);
        g.fillRect(260, 380, 15, 5);
        g.fillRect(270, 365, 5, 20);
        g.fillRect(245, 385, 25, 5);
        g.fillRect(245, 390, 5, 5);
        g.fillRect(255, 390, 5, 5);
        g.fillRect(265, 390, 5, 5);

        //skull graphic
        g.setColor(Color.WHITE);
        //bone(topleft)
        g.fillRect(220, 350, 5, 10);
        g.fillRect(215, 355, 5, 5);
        g.fillRect(225, 360, 5, 5);

        //bone(bottomleft)
        g.fillRect(225, 385, 5, 5);
        g.fillRect(215, 390, 10, 5);
        g.fillRect(220, 395, 5, 5);

        //bone(topright)
        g.fillRect(265, 360, 5, 5);
        g.fillRect(270, 355, 10, 5);
        g.fillRect(270, 350, 5, 5);

        //bone(bottomleft)
        g.fillRect(265, 385, 5, 5);
        g.fillRect(270, 390, 5, 10);
        g.fillRect(275, 390, 5, 5);

        //face
        g.fillRect(230, 365, 5, 20);
        g.fillRect(235, 360, 25, 10);
        g.fillRect(230, 380, 10, 5);
        g.fillRect(240, 375, 5, 10);
        g.fillRect(245, 370, 5, 10);
        g.fillRect(250, 375, 5, 5);
        g.fillRect(250, 380, 15, 5);
        g.fillRect(260, 365, 5, 20);
        g.fillRect(235, 385, 25, 5);
        g.fillRect(235, 390, 5, 5);
        g.fillRect(245, 390, 5, 5);
        g.fillRect(255, 390, 5, 5);

        //show final score and level
        g.setFont(new Font("Comic Sans MS",Font.BOLD,30));
        g.drawString("Score",100,370);
        g.drawString("level",320,370);

        g.drawString(Integer.toString(score),(280-getFontMetrics(new Font("Comic Sans MS",Font.BOLD,30)).stringWidth(Integer.toString(score)))/2,400);
        g.drawString(Integer.toString(level),(710-getFontMetrics(new Font("Comic Sans MS",Font.BOLD,30)).stringWidth(Integer.toString(level)))/2,400);

        
        //draw line
        g.setColor(Color.WHITE);
        //g.drawLine(0, 570, 500, 570);
        g.setColor(Color.RED);
        g.drawLine(0, 600, 500, 600);

        //outline for play again button
        g.setColor(Color.WHITE);
        g.drawRect(70, 420, 355, 50);
        //outline for play again button
        g.drawRect(70, 480, 355, 50);
        //outline for play again button
        g.drawRect(70, 540, 355, 50);

        
    }
}
