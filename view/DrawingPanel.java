
package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.swing.JMenuItem;
import javax.swing.JPanel;

import model.PencilTool;
import model.ShapeColorLine;
import model.Tool;


/**
 * The drawing panel for PowerPaint.
 * 
 * @author Arrunn Chhouy
 * @version 1.0
 */
public class DrawingPanel extends JPanel {

    /** 
     * The serial version ID.  
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * The background color of the panel.
     */
    private static final Color BACKGROUND_COLOR = Color.WHITE;
    
    /** 
     * The default pane width. 
     */
    private static final int WIDTH = 500;
    
    /** 
     * The default pane height. 
     */
    private static final int HEIGHT = 400;
    
    /**
     * The line width.
     */
    private static final int LINE_WIDTH = 5;
    
    /**
     * A string code for the color purple.
     */
    private static final String MY_COLOR_CODE = "#4b2e83";
    
    /**
     * A color.
     */
    private Color myColor;
    
    /**
     * A line width.
     */
    private int myLineWidth;
    
    /**
     * A boolean to for undo button. 
     */
    private boolean myUndo;
    
    /**
     * A boolean for square/circle button.
     */
    private boolean mySquareCircle;
    
    /**
     * A button for the option button.
     */
    private JMenuItem myButton;
    
    /**
     * The current tool object.
     */
    private Tool myCurrentTool = new PencilTool();
    
    /**
     * A collection for the ShapeColorLine object.
     */
    private final List<ShapeColorLine> mySCL;
    
    /**
     * Constructs and sets all the fields.
     */
    public DrawingPanel() {
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        mySCL = new ArrayList<ShapeColorLine>();
        myUndo = false;
        myLineWidth = LINE_WIDTH;
        setBackground(BACKGROUND_COLOR);
        myColor = Color.decode(MY_COLOR_CODE);
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseListener());
        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    }
    
    /**
     * Enables the button.
     * 
     * @param theButton is a JMenuItem.
     */
    public void setButtonEnabled(final JMenuItem theButton) {
        myButton = theButton;
        myButton.setEnabled(!mySCL.isEmpty());
    }
    
    /**
     * Clears the array.
     */
    public void clear() {
        mySCL.clear();
        myUndo = true;
        repaint();
    }
    
    /**
     * Changes the line width.
     * 
     * @param theLineWidth of the size.
     */
    public void setLine(final int theLineWidth) {
        myLineWidth = theLineWidth;
    }
    
    /**
     * Sets the tool.
     * 
     * @param theTool is the tool.
     */
    public void setTool(final Tool theTool) {
        myCurrentTool = theTool;   
    }
    
    /**
     * Sets the color.
     * 
     * @param theColor is the color.
     */
    public void setColor(final Color theColor) {
        myColor = theColor;
    }
    
    /**
     * Sets the switch boolean.
     * 
     * @param theSwitch a boolean
     */
    public void setSquareCircle(final boolean theSwitch) {
        mySquareCircle = theSwitch;
    }
    
    /**
     * Paints the the shapes.
     * 
     * @param theGraphics The graphics context to use for painting.
     */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g2d = (Graphics2D) theGraphics;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                             RenderingHints.VALUE_ANTIALIAS_ON);
        myButton.setEnabled(!mySCL.isEmpty());
        for (final ShapeColorLine scl : mySCL) {
            if (Objects.nonNull(scl.getShape())) {
                // Set the color
                g2d.setPaint(scl.getColor());
    
                // Set the thickness
                g2d.setStroke(new BasicStroke(scl.getLine()));
                
                if (scl.getLine() != 0) {
                    // Set the shape
                    g2d.draw(scl.getShape());
                }
            }
        }
        if (!myUndo) {
            mySCL.add(new ShapeColorLine(myCurrentTool.draw(), myColor, myLineWidth));
        }
        myUndo = false;
    }
    
    /**
     * Listens for mouse clicks, to draw on our panel.
     */
    private class MyMouseListener extends MouseAdapter {    
        /**
         * Handles a press event.
         * 
         * @param theEvent The event.
         */
        @Override
        public void mousePressed(final MouseEvent theEvent) {
            myCurrentTool.press(theEvent);
            repaint();
        }
        
        /**
         * Handles a drag event.
         * 
         * @param theEvent The event.
         */
        @Override
        public void mouseDragged(final MouseEvent theEvent) {
            myCurrentTool.drag(theEvent, mySquareCircle);
            repaint();
        }
    }
}
