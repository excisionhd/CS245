/***************************************************************
 * file: MyPanel.java
 * author: Team FTP
 * class: CS 245
 *
 * assignment: Swing Project v1.1
 * date last modified: 10/19/17
 *
 * purpose: Intro screen that displays the project and
 * team name.
 ****************************************************************/

import javax.swing.*;
import java.awt.*;


class MyPanel extends JPanel {

    private Game game;

    //default constructor
    public MyPanel(Game game) {
        this.game = game;

        //create a border
        setBorder(BorderFactory.createLineBorder(Color.black));

    }

    public Dimension getPreferredSize() {
        return new Dimension(600, 400);
    }

    public void paintComponent(Graphics g) {

        ImageIcon dog = new ImageIcon("dog.jpg");
        super.paintComponent(g);
        dog.paintIcon(this,g,0,0);
        Font f = new Font("Impact", Font.BOLD, 46); //creates font for title
        Font f2 = new Font("Impact", Font.BOLD, 20);
        Graphics2D g2 = (Graphics2D)g;
        g2.setFont(f);
        g2.setColor(Color.BLACK);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawString("CS245 Project",this.getWidth()/4,130); //draws title on top with team on bottom
        g2.setFont(f2);
        g2.drawString("By Team FTP",this.getWidth()-350,this.getHeight()-64);



    }

}