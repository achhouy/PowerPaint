

package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.Icon;

/**
 * ColorIcon store a color and turns it into
 * an Icon.
 * 
 * @author Arrunn Chhouy
 * @version 1.0
 */
public class ColorIcon implements Icon {
    /**
     * The starting x position.
     */
    private static final int START_X = 15;
    
    /**
     * The starting y position.
     */
    private static final int START_Y = 5;
    
    /**
     * The size of the rectangle.
     */
    /**
     * The starting y position.
     */
    private static final int SIZE = 10;
    
    /**
     * A color.
     */
    private Color myColor;
    
    /**
     * A width.
     */
    private int myWidth;
    
    /**
     * A height.
     */
    private int myHeight;
      
    /**
     * Constructs a color icon.
     * 
     * @param theColor is a color
     */
    public ColorIcon(final Color theColor) {
        myColor = theColor;
    }
    
    /**
     * Sets the color.
     * 
     * @param theColor is a color
     */
    public void setColor(final Color theColor) {
        myColor = theColor;
    }
    
    /**
     * Gets the height.
     * 
     * @return an int
     */
    @Override
    public int getIconHeight() {
        return myHeight;
    }

    /**
     * Gets the width.
     * 
     * @return an int
     */
    @Override
    public int getIconWidth() {
        return myWidth;
    }

    /**
     * Paints a shape for an icon.
     * 
     * @param theComponent is a component.
     * @param theGraphics is a graphics.
     * @param theX is an int x value.
     * @param theY is an int y value.
     */
    @Override
    public void paintIcon(final Component theComponent, final Graphics theGraphics,
                          final int theX, final int theY) {
        final Graphics2D g2d = (Graphics2D) theGraphics.create();
        g2d.setColor(myColor);
        g2d.fillRect(theX - START_X, theY - START_Y, myWidth + SIZE, myHeight + SIZE);
        g2d.drawRect(theX - START_X, theY - START_Y, myWidth + SIZE, myHeight + SIZE);
    }

}
