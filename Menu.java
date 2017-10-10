import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel implements ActionListener{

    private JButton playButton = new JButton("Play");
    private JButton highScoreButton = new JButton("Highscores");
    private JButton creditsButton = new JButton("Credits");
    private JLabel hangmanLabel = new JLabel("Hangman");
    private Game game;
    private HighScore hs;

    String choice = "";

    public Menu(Game game){
        this.game = game;
        playButton.addActionListener(this);
        highScoreButton.addActionListener(this);
        creditsButton.addActionListener(this);

        Container c = new Container();
        hangmanLabel.setFont(new Font("Impact", Font.BOLD, 64));
        c.add(hangmanLabel);

        c.setLayout(new BoxLayout(c, BoxLayout.PAGE_AXIS));
        c.add(Box.createRigidArea(new Dimension(0, 150)));
        c.add(playButton);
        c.add(highScoreButton);
        c.add(creditsButton);

        add(c);
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
                game.frame.add(new Hangman(game));
                game.frame.getContentPane().setVisible(true);
            }
            if(b.getText().equalsIgnoreCase("highscores")){
                game.frame.getContentPane().setVisible(false);
                game.frame.getContentPane().remove(this);
                game.frame.add(game.hs);
                game.frame.getContentPane().setVisible(true);
            }
            if(b.getText().equalsIgnoreCase("credits")){
                game.frame.getContentPane().setVisible(false);
                game.frame.getContentPane().remove(this);
                game.frame.add(new Credits(game));
                game.frame.getContentPane().setVisible(true);
            }
        }
    }
}