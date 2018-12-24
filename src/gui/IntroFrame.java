package gui;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class IntroFrame extends JFrame
{
    
    private final static int rows = 5;
    
    public IntroFrame()
    {
        super("Super Tic-Tac-Toe");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new GridLayout(rows, 1));
        
        add(new IntroPlayerChoiceButtons());
        
        setVisible(true);
    }
}
