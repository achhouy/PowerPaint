package view;

import actions.ButtonAction;

import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * 
 * @author Arrunn Chhouy
 * @version 1.0
 */
public class PowerPaintToolBar extends JToolBar {
    /**
     * 
     */
    private static final long serialVersionUID = 6710703346752937259L;

    /**
     * The list of the button actions.
     */
    private final List<ButtonAction> myButtonActions;
    
    /**
     * 
     * @param theButtonAction is the button action.
     */
    public PowerPaintToolBar(final List<ButtonAction> theButtonAction) {
        super();
        myButtonActions = theButtonAction;
        createToolBar();
    }
    
    /**
     * Creates a tool bar.
     * 
     */
    private void createToolBar() {
        final ButtonGroup group = new ButtonGroup();
        for (final ButtonAction ba : myButtonActions) {  
            final JToggleButton toolToggle = new JToggleButton(ba);
            group.add(toolToggle);
            add(toolToggle);
        }
    }
}
