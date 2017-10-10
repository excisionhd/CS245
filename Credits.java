/***************************************************************
 * file: Credits.java
 * author: Team FTP
 * class: CS 245 - Programming Graphical User Interfaces
 *
 * assignment: Swing Project v1.0
 * date last modified: 10/9/17
 *
 * purpose: This class is the credits GUI that consist of labels
 * for every team member that contributed to the program.
 *
 ****************************************************************/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Credits extends JPanel implements ActionListener
{

    private Game game;
    private JButton backButton;

    //constructor, accepts game for reference
    public Credits(Game game)
    {
        this.game = game;

        //generates back button and adds action listener.
        backButton = new JButton("Back");
        backButton.addActionListener(this);

        //Create a new container
        Container container = new Container();

        //Makes the container a box so that the credits will appear starting from the top going down
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));

        //Moves the next label down so it is not close to te top of the window
        container.add(Box.createRigidArea(new Dimension(0, 50)));
        //Create the title and add it to the box container
        container.add(new JLabel("Credits"));

        //Moves the next label a little bit down below the "Credits" label
        container.add(Box.createRigidArea(new Dimension(0, 40)));

        //List of programmers responsible for this application
        container.add(new JLabel("Jason Kaufman: 012134941"));
        container.add(new JLabel("Amir Sotoodeh: 012165218"));
        container.add(new JLabel("Jacob Young: 010224552"));
        container.add(Box.createRigidArea(new Dimension(0, 50)));
        container.add(backButton);

        //Adds the container to the panel
        this.add(container);
    }

    //override method that allows the user to back into the menu.
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        JButton b = null;
        String buttonText = "";

        if(o instanceof JButton) {
            b = (JButton) o;
        }

        if(b!=null){
            if(b.getText().equalsIgnoreCase("back")){
                game.frame.getContentPane().setVisible(false);
                game.frame.getContentPane().remove(this);
                game.frame.add(new Menu(game));
                game.frame.getContentPane().setVisible(true);
            }
        }
    }
}