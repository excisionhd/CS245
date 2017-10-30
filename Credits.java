/***************************************************************
 * file: Credits.java
 * author: Team FTP
 * class: CS 245 - Programming Graphical User Interfaces
 *
 * assignment: Swing Project v1.2
 * date last modified: 10/19/17
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
    private JLabel creditsLabel;
    private JLabel credits1, credits2, credits3;

    //constructor, accepts game for reference
    public Credits(Game game)
    {
        this.game = game;

        setLayout(null);

        backButton = new JButton("Back");
        creditsLabel = new JLabel("Credits");
        credits1 = new JLabel("Jason Kaufman: 012134941");
        credits2 = new JLabel("Amir Sotoodeh: 012165218");
        credits3 = new JLabel("Jacob Young: 010224552");

        creditsLabel.setBounds(195,70,200,60);
        credits1.setBounds(190,135,240,40);
        credits2.setBounds(192,165,240,40);
        credits3.setBounds(195,195,240,40);

        creditsLabel.setFont(new Font("Verdana", Font.BOLD, 50));
        credits1.setFont(new Font("Verdana", Font.BOLD, 14));
        credits2.setFont(new Font("Verdana", Font.BOLD, 14));
        credits3.setFont(new Font("Verdana", Font.BOLD, 14));
        //generates back button and adds action listener.
        backButton.addActionListener(this);
        backButton.setToolTipText("Main Menu");
        backButton.setBounds(240,260,100,24);

        add(creditsLabel);
        add(credits1);
        add(credits2);
        add(credits3);
        add(backButton);
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