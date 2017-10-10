import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel implements ActionListener{

    private JButton playButton = new JButton("Play");
    private JButton highScoreButton = new JButton("Highscores");
    private JButton creditsButton = new JButton("Credits");
    private Game game;
    private HighScore hs;

    String choice = "";

    public Menu(Game game){
        this.game = game;
        playButton.addActionListener(this);
        highScoreButton.addActionListener(this);
        creditsButton.addActionListener(this);
        add(playButton);
        add(highScoreButton);
        add(creditsButton);
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
            if(b.getText().equalsIgnoreCase("play")){
                game.frame.getContentPane().setVisible(false);
                game.frame.getContentPane().remove(this);
                game.frame.add(new Hangman());
                game.frame.getContentPane().setVisible(true);
            }
            if(b.getText().equalsIgnoreCase("highscores")){
                game.frame.getContentPane().setVisible(false);
                game.frame.getContentPane().remove(this);
                game.frame.add(new HighScore());
                game.frame.getContentPane().setVisible(true);
            }
            if(b.getText().equalsIgnoreCase("credits")){
                game.frame.getContentPane().setVisible(false);
                game.frame.getContentPane().remove(this);
                game.frame.add(new Credits());
                game.frame.getContentPane().setVisible(true);
            }
        }
    }
}
