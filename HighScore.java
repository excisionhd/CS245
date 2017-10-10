import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HighScore extends JPanel implements ActionListener{

    private JLabel[] highScoreArray = new JLabel[5]; //array of high scores where index 0 is highest.
    private JButton backButton = new JButton("Back");
    private Game game;


    public HighScore(Game game){
        this.game = game;
        //initialize new Labels into array.
        for(int i = 0;i<highScoreArray.length;i++){
            highScoreArray[i] = new JLabel("ABC.....000000");
        }

        //"Highscore" Label.
        JLabel hs = new JLabel("High Score");
        //container for white space and highscore label
        Container c1 = new Container();

        //setting the LayoutManager as box so that it appears as a list.
        c1.setLayout(new BoxLayout(c1,BoxLayout.PAGE_AXIS));

        //create whitespace between Panel and Label
        c1.add(Box.createRigidArea(new Dimension(0,50)));
        c1.add(hs);

        //create whitespace between Label and HighScore Labels
        c1.add(Box.createRigidArea(new Dimension(0,40)));


        //adds all highscores into the container.
        for(int i=0;i<highScoreArray.length;i++) {
            c1.add(highScoreArray[i]);
        }

        //set the font for all the labels
        hs.setFont(new Font("Arial", Font.BOLD, 32));
        for(int i=0;i<highScoreArray.length;i++) {
            highScoreArray[i].setFont(new Font("Arial", Font.BOLD, 16));
        }

        backButton.addActionListener(this);
        c1.add(backButton);

        //add the container into the panel.
        this.add(c1);
    }

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

    public void updateHighScore(int score){
        for (int i = 0;i<highScoreArray.length;i++){

        }
    }
}
