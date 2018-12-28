package gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IntroPlayerEntry extends JPanel
{   
    private static JLabel PvCtext;
    
    private static JLabel PvPtext;
    
    private static JTextField nameEntry;
    
    public IntroPlayerEntry()
    {
        super(new GridLayout());
    }
    
    protected void showPvPstuff()
    {
        removeAll();
        PvPtext = new JLabel("Enter O's name (X goes first):");
        add(PvPtext);
        nameEntry = new JTextField();
        add(nameEntry);
    }
    
    protected void showPvCstuff()
    {
        removeAll();
        PvCtext = new JLabel("Enter Player's name:");
        add(PvCtext);
        nameEntry = new JTextField();
        add(nameEntry);
    }
}