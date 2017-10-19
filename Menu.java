/**
 *  file: Menu.java
 *  author: Team FTP
 *  class: CS 245 - Programming Graphical User Interfaces

 *
 *  assignment: Swing Project v1.0
 *  date last modified: 10/9/17
 *
 *  purpose: This class displays the menu to the user after the
 *  introduction screen has displayed for 3 seconds.
 */

 * 
 *  assignment: Swing Project v1.0
 *  date last modified: 10/9/17
 * 
 *  purpose: This class displays the menu to the user after the
 *  introduction screen has displayed for 3 seconds
 */
//package swingv1.pkg0;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel implements ActionListener{

    //Private variables for the buttons
    private JButton playButton;
    private JButton highScoreButton;
    private JButton creditsButton;

    private JLabel hangmanLabel;

    private Game game;
    private HighScore hs;

    String choice = "";

    //Constructor that initializes buttons and creates listeners for the buttons
    public Menu(Game game){
        this.game = game;

        highScoreButton = new JButton("Highscores");
        playButton = new JButton("Play");
        creditsButton = new JButton("Credits");
        hangmanLabel = new JLabel("Hangman");

        playButton = new JButton("Play");
        highScoreButton = new JButton("Highscores");
        creditsButton = new JButton("Credits");

        playButton.addActionListener(this);
        highScoreButton.addActionListener(this);
        creditsButton.addActionListener(this);
        add(playButton);
        add(highScoreButton);
        add(creditsButton);
    }

    //Method to wait for actions
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        JButton b = null;
        String buttonText = "";

        if(o instanceof JButton) {
            b = (JButton) o;
        }

        if(b!=null){
            //If "play" is pressed, begin Hangman
            if(b.getText().equalsIgnoreCase("play")){

                game.frame.getContentPane().setVisible(false);
                game.frame.getContentPane().remove(this);
                game.frame.add(new Hangman(game));
                game.frame.getContentPane().setVisible(true);
            }
            //If "highscores" is pressed, display highscores
            if(b.getText().equalsIgnoreCase("highscores")){
                game.frame.getContentPane().setVisible(false);
                game.frame.getContentPane().remove(this);
                game.frame.add(game.hs);
                game.frame.getContentPane().setVisible(true);
            }
            //If "credits" is pressed, display credits
            if(b.getText().equalsIgnoreCase("credits")){
                game.frame.getContentPane().setVisible(false);
                game.frame.getContentPane().remove(this);
                game.frame.add(new Credits(game));
                game.frame.getContentPane().setVisible(true);
            }
        }
    }
}
