/**
 *  file: ScoreScreen.java
 *  author: Team FTP
 *  class: CS 245 - Programming Graphical User Interfaces

 *
 *  assignment: Swing Project v1.0
 *  date last modified: 10/9/17
 *
 *  purpose: This class displays the score screen after the game of Hangman
 */

 * 
 *  assignment: Swing Project v1.0
 *  date last modified: 10/9/17
 * 
 *  purpose: This class displays the score screen after the game of Hangman
 */
//package swingv1.pkg0;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//Public class for displaying the score screen
public class ScoreScreen extends JPanel implements ActionListener
{
    //Create instance variables
    private Game game;
    private JButton backButton;
    private int score;

    //Initialize instance variables
    public ScoreScreen(Game game, int score)
    {
        backButton = new JButton("End");
        backButton.addActionListener(this);
        this.game = game;
        this.score = score;
        //Create a new container
        Container container = new Container();

        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
        container.add(Box.createRigidArea(new Dimension(0, 50)));
        //Create the title and add it to the box container
        container.add(new JLabel("Game Over"));

        //Moves the next label a little bit down below the "Credits" label
        container.add(Box.createRigidArea(new Dimension(0, 40)));

        //List of programmers responsible for this application
        container.add(new JLabel("Your score is "+score+"."));
        container.add(Box.createRigidArea(new Dimension(0, 40)));
        container.add(backButton);

        //Adds the container to the panel
        this.add(container);
    }

    //Listens for any events
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        JButton b = null;

        if(o instanceof JButton) {
            b = (JButton) o;
        }

        //If "end" is pressed, return to the main menu
        if(b!=null){
            if(b.getText().equalsIgnoreCase("end")){
                game.frame.getContentPane().setVisible(false);
                game.frame.getContentPane().remove(this);
                game.frame.add(new Menu(game));
                game.frame.getContentPane().setVisible(true);
            }
        }
    }

}