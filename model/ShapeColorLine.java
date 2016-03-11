
package model;

import java.awt.Color;
import java.awt.Shape;

/**
 * 
 * @author Arrunn Chhouy
 * @version 1.0
 */
public class ShapeColorLine {
    
    /**
     * A Shape.
     */
    private final Shape myShape;
    
    /**
     * A color.
     */
    private final Color myColor;
    
    /**
     * A line.
     */
    private final int myLine;
    
    /**
     * Constructs and sets all fields.
     * 
     * @param theShape a shape
     * @param theColor a color
     * @param theLine a line thickness
     */
    public ShapeColorLine(final Shape theShape, final Color theColor, final int theLine) {
        myShape = theShape;
        myColor = theColor;
        myLine = theLine;
    }
    
    /**
     * Gets the shape.
     * @return a shape
     */
    public Shape getShape() {
        return myShape;
    }
    
    /**
     * Gets the color.
     * @return a color
     */
    public Color getColor() {
        return myColor;
    }
    
    /**
     * Gets the line.
     * @return an int of the line.
     */
    public int getLine() {
        return myLine;
    }
}
