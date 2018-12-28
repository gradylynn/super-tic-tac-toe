package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class IntroFrame extends JFrame implements ActionListener
{
    
    private final static int rows = 4;
    
    private static IntroPlayerChoiceButtons introPlayerChoiceButtons = new IntroPlayerChoiceButtons();
    
    private static IntroXOrOChoiceButtons introXOrOChoiceButtons = new IntroXOrOChoiceButtons();
    
    private static IntroPlayerEntry introPlayerEntry = new IntroPlayerEntry();
    
    private static IntroStartGameButton introStartGameButton = new IntroStartGameButton();
    
    public IntroFrame()
    {
        super("Super Tic-Tac-Toe");
        setSize(800,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        setLayout(new GridLayout(rows, 1));
        
        introPlayerChoiceButtons.playerVsPlayerButton.addActionListener(this);
        introPlayerChoiceButtons.playerVsRandomCompButton.addActionListener(this);
        introPlayerChoiceButtons.playerVsSmartCompButton.addActionListener(this);
        
        add(introPlayerChoiceButtons,0);
        
        setVisible(true);
    }
    
    protected void showPvPstuff()
    {
        introXOrOChoiceButtons.showPvPstuff();
        add(introXOrOChoiceButtons,1);
        introPlayerEntry.showPvPstuff();
        add(introPlayerEntry,2);
        add(introStartGameButton,rows-1);
        setVisible(true);
    }
    
    protected void showPvCstuff()
    {
        introXOrOChoiceButtons.showPvCstuff();
        add(introXOrOChoiceButtons,1);
        introPlayerEntry.showPvCstuff();
        add(introPlayerEntry,2);
        add(introStartGameButton,rows-1);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == introPlayerChoiceButtons.playerVsPlayerButton)
        {
            this.showPvPstuff();
        }
        else if(e.getSource() == introPlayerChoiceButtons.playerVsRandomCompButton || e.getSource() == introPlayerChoiceButtons.playerVsSmartCompButton)
        {
            this.showPvCstuff();
        }
        
    }
}
