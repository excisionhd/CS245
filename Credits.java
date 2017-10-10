import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Credits extends JPanel implements ActionListener
{

    private Game game;
    private JButton backButton;

    public Credits(Game game)
    {
        backButton = new JButton("Back");
        backButton.addActionListener(this);
        this.game = game;
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