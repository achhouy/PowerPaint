
package model;

import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;

/**
 * A pencil tool objects that creates a freehand tool.
 * 
 * @author Arrunn Chhouy
 * @version 1.0
 */
public class PencilTool extends AbstractTool {
    /**
     * A path.
     */
    private Path2D myPath;
    
    /**
     * Constructs a pencil tool object.
     */
    public PencilTool() {
        super("Pencil");
    }
    
    /**
     * Draws the shape.
     */
    @Override
    public Shape draw() {
        return myPath;
    }
    
    /**
     * Controls the drag mouse event.
     * 
     * @param theEvent is a mouse event.
     * @param theSwitch is a boolean.
     */
    @Override
    public void drag(final MouseEvent theEvent, final boolean theSwitch) {
        myPath.lineTo(theEvent.getX(), theEvent.getY());        
    }

    /**
     * Controls the press mouse event.
     * 
     * @param theEvent is a mouse event.
     */
    @Override
    public void press(final MouseEvent theEvent) {
        myPath = new GeneralPath();
        myPath.moveTo(theEvent.getX(), theEvent.getY());
    }
}
