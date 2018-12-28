package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class IntroStartGameButton extends JPanel
{
    protected static JButton button = new JButton("Start Game");
    
    public IntroStartGameButton()
    {
        super(new GridLayout());
        add(button);
    }
}
