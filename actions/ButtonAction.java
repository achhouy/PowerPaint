package actions;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import model.Tool;
import view.DrawingPanel;

/**
 * 
 * 
 * @author Arrunn Chhouy
 * @version 1.0
 */
public class ButtonAction extends AbstractAction {
    /**
     * 
     */
    private static final long serialVersionUID = -2454054116560871100L;
    
    /**
     * The drawing panel.
     */
    private final DrawingPanel myDrawingPanel;

    /**
     * A tool.
     */
    private final Tool myTool;
    
    /**
     * Constructs and initializes the field.
     * 
     * @param theObject is the name of the button
     * @param theIcon is the Icon used for the button
     * @param thePanel is the panel
     */
    public ButtonAction(final Tool theObject, final Icon theIcon, 
                        final DrawingPanel thePanel) {
        super(theObject.getDescription());
        myDrawingPanel = thePanel;
        myTool = theObject;
//        putValue(Action.SMALL_ICON, theIcon);
        // Large icon to the tool bar
        final ImageIcon icon = (ImageIcon) theIcon;
        final Image largeImage = 
                        icon.getImage().getScaledInstance(15, -1, java.awt.Image.SCALE_SMOOTH);
        final ImageIcon largeIcon = new ImageIcon(largeImage);
        putValue(Action.LARGE_ICON_KEY, largeIcon);
        
        // Set a mnemonic on the first character of the name
        putValue(Action.MNEMONIC_KEY, KeyEvent.getExtendedKeyCodeForChar(
                                      theObject.getDescription().charAt(0)));

        // Coordinate button selection
        putValue(Action.SELECTED_KEY, true);
    }

    // Selects the tool to perform a certain behavior.
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myDrawingPanel.setTool(myTool); 
    }


}
