
package model;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

/**
 * The RectangleTool class creates a rectangle.
 * 
 * @author Arrunn Chhouy
 * @version 1.0
 */
public class RectangleTool extends AbstractTool {
    /**
     * A rectangle shape.
     */
    protected RectangularShape myShape;
    
    /**
     * A starting point of the line.  
     */
    protected Point myStartLine;
    
    /**
     * Constructs a rectangle tool. 
     */
    public RectangleTool() {
        super("Rectangle");
    }
    
    /**
     * Constructs a rectangle tool.
     * 
     * @param theName is the shape.
     */
    public RectangleTool(final String theName) {
        super(theName);
    }
    

    /**
     * Creates a rectangle.
     * 
     * @return Shape that has been created
     */
    @Override
    public Shape draw() {
        return myShape;
    }

    /**
     * Sets the starting point for the rectangle
     * when the mouse is pressed.
     * 
     * @param theEvent is a mouse event.
     */
    @Override
    public void press(final MouseEvent theEvent) {
        myStartLine = theEvent.getPoint();
        
        myShape = new Rectangle2D.Double(myStartLine.x, myStartLine.y,
                                             myStartLine.x - myStartLine.x,
                                             myStartLine.y - myStartLine.y);
    }
    
    /**
     * Create rectangle when the mouse is dragged.
     * 
     * @param theEvent is a mouse event.
     * @param theSwitch is a boolean.
     */
    @Override
    public void drag(final MouseEvent theEvent, final boolean theSwitch) {
        final Point endLine = theEvent.getPoint(); 
        
        if (theSwitch) {
            double min = 0;
            // Quadrant 1
            if (myStartLine.x >= endLine.x && myStartLine.y >= endLine.y) {
                min = Math.min(myStartLine.x - endLine.x, myStartLine.y - endLine.y);
                myShape.setFrame(endLine.x, endLine.y, min, min);
                // Quadrant 4    
            } else if (myStartLine.x >= endLine.x && endLine.y >= myStartLine.y) {
                min = Math.min(myStartLine.x - endLine.x, endLine.y - myStartLine.y);
                myShape.setFrame(endLine.x, myStartLine.y, min, min);
            // Quadrant 2    
            } else if (endLine.x >= myStartLine.x && myStartLine.y >= endLine.y) {
                min = Math.min(endLine.x - myStartLine.x, myStartLine.y - endLine.y);
                myShape.setFrame(myStartLine.x, endLine.y, min, min);
            } else {
                min = Math.min(endLine.x - myStartLine.x, endLine.y - myStartLine.y);
                myShape.setFrame(myStartLine.x, myStartLine.y, min, min);
            }
        } else {
            // Checks to see if ending point is in quadrant 1
            if (myStartLine.x >= endLine.x && myStartLine.y >= endLine.y) {
                myShape.setFrame(endLine.x, endLine.y, 
                                    myStartLine.x - endLine.x, myStartLine.y - endLine.y);
            // Checks to see if ending point is in quadrant 4    
            } else if (myStartLine.x >= endLine.x && endLine.y >= myStartLine.y) {
                myShape.setFrame(endLine.x, myStartLine.y, 
                                    myStartLine.x - endLine.x, endLine.y - myStartLine.y);
            // Checks to see if ending point is in quadrant 2    
            } else if (endLine.x >= myStartLine.x && myStartLine.y >= endLine.y) {
                myShape.setFrame(myStartLine.x, endLine.y, 
                                    endLine.x - myStartLine.x, myStartLine.y - endLine.y);
            // Checks to see if ending point is in quadrant 3
            } else {
                myShape.setFrame(myStartLine.x, myStartLine.y,
                                    endLine.x - myStartLine.x, endLine.y - myStartLine.y);
            }
        }
    }
}
