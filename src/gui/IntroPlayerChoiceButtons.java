package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class IntroPlayerChoiceButtons extends JPanel
{
    
    private JLabel text = new JLabel("Choose a play mode:");
    
    protected ButtonGroup buttonGroup = new ButtonGroup();
    
    protected JRadioButton playerVsPlayerButton = new JRadioButton("Player vs. Player");
    
    protected JRadioButton playerVsRandomCompButton = new JRadioButton("Player vs. Random Computer");
    
    protected JRadioButton playerVsSmartCompButton = new JRadioButton("Player vs. Smart Computer");
    
    public IntroPlayerChoiceButtons()
    {
        super(new GridLayout());
        
        buttonGroup.add(playerVsPlayerButton);
        buttonGroup.add(playerVsRandomCompButton);
        buttonGroup.add(playerVsSmartCompButton);
        
        add(text);
        add(playerVsPlayerButton);
        add(playerVsRandomCompButton);
        add(playerVsSmartCompButton);
    }
}
