
package model;

import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

/**
 * 
 * @author Arrunn Chhouy
 * @version 1.0
 */
public class LineTool extends AbstractTool {
    /**
     * A starting point of the line.  
     */
    private Point myStartLine;
    
    /**
     * The Line.
     */
    private Line2D myLine;

    /**
     * Constructs a line tool object.
     */
    public LineTool() {
        super("Line");
    }

    /**
     * Draws the shape.
     * 
     * @return a Shape of the object.
     */
    @Override
    public Shape draw() {
        return myLine;
    }

    /**
     * Handles the press events.
     * 
     * @param theEvent is a mouse event.
     */
    @Override
    public void press(final MouseEvent theEvent) {
        myStartLine = theEvent.getPoint();
        myLine = new Line2D.Double(myStartLine.x, myStartLine.y,
                                   myStartLine.x, myStartLine.y);
        
    }
    
    /**
     * Handles drag events.
     * 
     * @param theEvent is a mouse event.
     * @param theSwitch is a boolean.
     */
    @Override
    public void drag(final MouseEvent theEvent, final boolean theSwitch) {
        final Point endLine = theEvent.getPoint(); 
        myLine.setLine(myStartLine.x, myStartLine.y, endLine.x, endLine.y);
    }
    
}
