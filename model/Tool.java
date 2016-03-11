
package model;

import java.awt.Shape;
import java.awt.event.MouseEvent;

/**
 * An interface for tools that draw certain ways.
 * 
 * @author Arrunn Chhouy
 * @version 1.0
 */
public interface Tool {
    /**
     * Allows the ability to draw a shape.
     *
     * @return Shape a shape.
     */
    Shape draw();    
    
    /**
     * Returns a text description of this tool.
     * 
     * @return a text description of this tool.
     */
    String getDescription();
    
    /**
     * Handles a press event.
     * 
     * @param theEvent The event.
     */
    void press(MouseEvent theEvent);
    
    /**
     * Handles a drag event.
     * 
     * @param theEvent is the mouse event.
     * @param theSwitch is a boolean.
     */
    void drag(MouseEvent theEvent, boolean theSwitch);

}
