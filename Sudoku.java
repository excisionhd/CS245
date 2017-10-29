/***************************************************************
 * file: Sudoku.java
 * author: Team FTP
 * class: CS 245 - Programming Graphical User Interfaces
 *
 * assignment: Swing Project v1.2
 * date last modified: 10/19/17
 *
 * purpose: This class is the Sudoku game panel
 *
 ****************************************************************/

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import javax.swing.*;
import javax.swing.text.NumberFormatter;

public class Sudoku extends JPanel implements ActionListener
{
    private Game game;
    private int score;
    private final int SUDOKU_WIDTH = 9;
    private final int SUDOKU_HEIGHT = 9;
    private JTextField[][] numbers;
    private JButton submit;
    private JButton quit;

    public Sudoku(Game game, int score)
    {
        this.game = game;
        this.score = score;
        numbers = new JTextField[SUDOKU_WIDTH][SUDOKU_HEIGHT];
        JButton submit = new JButton("Submit");
        JButton quit = new JButton("Quit");

        for (int i = 0; i < SUDOKU_HEIGHT; i++)
        {
            for (int j = 0; j < SUDOKU_WIDTH; j++)
            {
                numbers[i][j].addActionListener(this);
            }
        }
        submit.addActionListener(this);
        quit.addActionListener(this);
        submit.setToolTipText("Check if answers are correct");
        quit.setToolTipText("Exit to game over screen");
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object o = e.getSource();
        JButton b = null;
        JTextField t = null;

        if (o instanceof JButton)
        {
            b = (JButton) o;
        }
        else if (o instanceof JTextField)
        {
            t = (JTextField) o;
        }

        if (t!=null)
        {

        }

        if(b!=null)
        {

        }
    }
}
