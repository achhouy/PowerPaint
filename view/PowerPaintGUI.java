

package view;

import actions.ButtonAction;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;

import model.EllipseTool;
import model.LineTool;
import model.PencilTool;
import model.RectangleTool;


/**
 * This is the PowerPaint GUI and it creates the entire GUI.
 * 
 * @author Arrunn Chhouy
 * @version 1.0
 */
public class PowerPaintGUI {    
    /**
     * The window for PowerPaint.
     */
    private JFrame myFrame;
    
    /**
     * The drawing panel. 
     */
    private DrawingPanel myDrawingPanel;
    
    /**
     * The list of the button actions.
     */
    private List<ButtonAction> myButtonActions;
    
    /**
     * The Images Icon of a paint brush.
     */
    private final ImageIcon myIcon = new ImageIcon("./images/paintbrush.png");
          
    /**
     * Starts up the GUI for PowerPaint.
     */
    public void start() {
        setUpFrame();
    }

    /**
     * Sets up the entire window.
     */
    private void setUpFrame() {
        // Creates a window
        myFrame = new JFrame("PowerPaint"); 
        
        // Sets the frame to a border layout
        myFrame.setLayout(new BorderLayout());
        
        // Sets the title bar icon to the image
        myFrame.setIconImage(myIcon.getImage());
        
        // Creates a drawing panel
        myDrawingPanel = new DrawingPanel();
        
        // Sync the buttons together along with its specific tool.
        setUpAction();
        
        // Creates a menu bar.
        final JMenuBar menuBar = new PowerPaintMenuBar(myFrame, myDrawingPanel,
                                                       myButtonActions);
        
        // Adds the menu bar to the window
        myFrame.setJMenuBar(menuBar);
        
        final JToolBar toolBar = new PowerPaintToolBar(myButtonActions);
        // Creates a tool bar and places it in the east
        myFrame.add(toolBar, BorderLayout.SOUTH);
        
        // Adds the drawing panel in the center of the frame
        myFrame.add(myDrawingPanel, BorderLayout.CENTER);
        
        // Exits the application
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Packs and allows visibility
        adjustFrame();
    }
    
    /**
     * Sets up the action for each buttons.
     */
    private void setUpAction() {
        myButtonActions = new ArrayList<ButtonAction>();
        myButtonActions.add(new ButtonAction(new PencilTool(), 
                                             new ImageIcon("./images/pencil_bw.gif"),
                                             myDrawingPanel));
        myButtonActions.add(new ButtonAction(new LineTool(), 
                                             new ImageIcon("./images/line_bw.gif"), 
                                             myDrawingPanel));
        myButtonActions.add(new ButtonAction(new RectangleTool(), 
                                             new ImageIcon("./images/rectangle_bw.gif"),
                                             myDrawingPanel));
        myButtonActions.add(new ButtonAction(new EllipseTool(),
                                             new ImageIcon("./images/ellipse_bw.gif"),
                                             myDrawingPanel));
    }
    
    /**
     * Compacts and centers the frames and allows visibility.
     */
    private void adjustFrame() {
        // Compacts the window to the size of the content
        myFrame.pack();
        
        // Centers the window to the screen
        myFrame.setLocationRelativeTo(null);
        
        // Allows visibility of the window
        myFrame.setVisible(true);
    }
}
