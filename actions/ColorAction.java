
package actions;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JColorChooser;

import view.ColorIcon;
import view.DrawingPanel;

/**
 * The color actions controls the color button.
 * 
 * @author Arrunn Chhouy
 * @version 1.0
 */
public class ColorAction extends AbstractAction {
    /**
     * Serial ID. 
     */
    private static final long serialVersionUID = 1L;

    /**
     * The drawing panel.
     */
    private final DrawingPanel myDrawingPanel;
    
    /**
     *  An initial color.
     */
    private Color myInitialColor;
    
    /**
     * A color icon.
     */
    private final ColorIcon myColorIcon;
    
    /**
     * Constructs a color action object.
     * 
     * @param theName is the name
     * @param theIcon is a icon of the color
     * @param thePanel is the drawing panel
     */
    public ColorAction(final String theName, final Icon theIcon, final DrawingPanel thePanel) {
        super(theName);
        myDrawingPanel = thePanel;
        myInitialColor = Color.decode("#4b2e83");
        myColorIcon = new ColorIcon(myInitialColor);
        putValue(Action.SMALL_ICON, theIcon);
    }

    /**
     * Handles an action performed on a button.
     * 
     * @param theEvent is an event that occurred.
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        final Color newColor = JColorChooser.showDialog(null , 
                                                        "Change Button Background",
                                                        myInitialColor);
        myInitialColor = newColor;                
        myDrawingPanel.setColor(newColor); 
        myColorIcon.setColor(newColor);
    }

    /**
     * Gets an icon.
     * 
     * @return an Icon.
     */
    public Icon getIcon() {
        return myColorIcon;
    }

}
