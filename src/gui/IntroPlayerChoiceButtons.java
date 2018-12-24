package gui;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class IntroPlayerChoiceButtons extends JPanel
{
    private final static int numButtons = 3;
    
    private ButtonGroup buttonGroup = new ButtonGroup();
    
    private JRadioButton playerVsPlayerButton = new JRadioButton("Player vs. Player");
    
    private JRadioButton playerVsRandomCompButton = new JRadioButton("Player vs. Random Computer");
    
    private JRadioButton playerVsSmartCompButton = new JRadioButton("Player vs. Smart Computer");
    
    public IntroPlayerChoiceButtons()
    {
        super(new GridLayout(1,numButtons));
        
        buttonGroup.add(playerVsPlayerButton);
        buttonGroup.add(playerVsRandomCompButton);
        buttonGroup.add(playerVsSmartCompButton);
        
        add(playerVsPlayerButton);
        add(playerVsRandomCompButton);
        add(playerVsSmartCompButton);
    }
}
