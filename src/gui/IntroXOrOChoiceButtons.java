package gui;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class IntroXOrOChoiceButtons extends JPanel
{   
    private static JLabel PvCtext;
    
    private static JLabel PvPtext;
    
    private static JTextField PvPxName;
    
    protected static ButtonGroup buttonGroup = new ButtonGroup();
    
    protected static JRadioButton X = new JRadioButton("X's");
    
    protected static JRadioButton O = new JRadioButton("O's");
    
    public IntroXOrOChoiceButtons()
    {
        super(new GridLayout());
    }
    
    protected void showPvPstuff()
    {
        removeAll();
        PvPtext = new JLabel("Enter X's name (X goes first):");
        add(PvPtext);
        PvPxName = new JTextField();
        add(PvPxName);
    }
    
    protected void showPvCstuff()
    {
        removeAll();
        PvCtext = new JLabel("Choose X's or O's (X goes first):");
        add(PvCtext);
        buttonGroup = new ButtonGroup();
        X = new JRadioButton("X's");
        O = new JRadioButton("O's");
        buttonGroup.add(X);
        buttonGroup.add(O);
        add(X);
        add(O);
    }
}
