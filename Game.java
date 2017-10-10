import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Game {

    final int FINAL_WIDTH = 600;
    final int FINAL_HEIGHT = 400;

    JFrame frame;
    MyPanel intro;
    Credits credits;
    Menu menu;
    HighScore hs;
    ScoreScreen ss;
    Hangman hg;

    public enum STATE{
        Intro,
        Menu,
        HighScore,
        Credits,
        Game,
    }

    public static STATE gameState = STATE.Intro;

    public Game(){
        frame = new JFrame("CS245 Project");
        intro = new MyPanel();
        hs = new HighScore(this);
        hg = new Hangman(this);
        menu = new Menu(this);
        credits = new Credits(this);

        frame.setPreferredSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.add(intro);
        frame.setVisible(true);

        if(gameState == STATE.Intro) {

            try {
                TimeUnit.SECONDS.sleep(1);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("DONE");
            frame.getContentPane().setVisible(false);
            frame.getContentPane().remove(intro);
            frame.add(menu);
            frame.getContentPane().setVisible(true);

        }





    }



    public static void main(String[] args) {
        new Game();
    }
}
