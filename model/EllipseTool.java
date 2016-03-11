
package model;

import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

/**
 * The EllipseTool class creates an Ellipse shape.
 * 
 * @author Arrunn Chhouy
 * @version 1.0
 */
public class EllipseTool extends RectangleTool {
   
    /**
     * Constructs an ellipse tool.
     */
    public EllipseTool() {
        super("Ellipse");
    }
    
    /**
     * Creates the ellipse shape.
     * 
     * @return a Shape
     */
    @Override
    public Shape draw() {
        return myShape;
    }

    /**
     * Sets the starting point for the ellipse
     * when the mouse is pressed.
     * 
     * @param theEvent is a mouse event
     */
    @Override
    public void press(final MouseEvent theEvent) {
        myStartLine = theEvent.getPoint();
        
        myShape = new Ellipse2D.Double(myStartLine.x, myStartLine.y,
                                             myStartLine.x - myStartLine.x,
                                             myStartLine.y - myStartLine.y);    
    }
}
