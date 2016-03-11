package view;

import actions.ButtonAction;
import actions.ColorAction;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * PowerPaint Menu Bar class creates menu bar.
 * 
 * @author Arrunn Chhouy
 * @version 1.0
 */
public class PowerPaintMenuBar extends JMenuBar {
    /**
     * Serial ID.
     */
    private static final long serialVersionUID = -4910858749929381996L;

    /**
     * The max tick size for the FPS slider.
     */
    private static final int MAX_SLIDER_SIZE = 20;
    
    /**
     * The minor tick spacing for the FPS slider.
     */
    private static final int MINOR_TICK_SPACING = 1;

    /**
     * The major tick spacing for the FPS slider.
     */
    private static final int MAJOR_TICK_SPACING = 5;
    
    /**
     * The frame.
     */
    private final JFrame myFrame;
    
    /**
     * The drawing panel. 
     */
    private final DrawingPanel myDrawingPanel;
    
    /**
     * The file menu. 
     */
    private JMenu myFileMenu;
    
    /**
     * The Option menu. 
     */
    private JMenu myOptionMenu;
    
    /**
     * The Tool menu. 
     */
    private JMenu myToolMenu;
    
    /**
     * The list of the button actions.
     */
    private final List<ButtonAction> myButtonActions;
    
    /**
     * The Images Icon of a paint brush.
     */
    private final ImageIcon myIcon = new ImageIcon("./images/paintbrush.png");
    
    /**
     * Constructs a menu bar object.
     * 
     * @param theFrame is the window.
     * @param theDrawingPanel is the drawing panel.
     * @param theButtonAction is the button action.
     */
    public PowerPaintMenuBar(final JFrame theFrame, final DrawingPanel theDrawingPanel,
                             final List<ButtonAction> theButtonAction) {
        super(); 
        myFrame = theFrame;
        myDrawingPanel = theDrawingPanel;
        myButtonActions = theButtonAction;
        menuButton();
    }

    /**
     * Creates and add all the filters into an ArrayList.
     */
    private void menuButton() {
     // Builds the menu option and their mnemonic keys
        myFileMenu = new JMenu("File");
        myFileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenuItem();
        myOptionMenu = new JMenu("Options");
        myOptionMenu.setMnemonic(KeyEvent.VK_O);
        optionMenuItem();
        
        myToolMenu = new JMenu("Tools");
        myToolMenu.setMnemonic(KeyEvent.VK_T);
        toolMenuItem();
        final JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        helpMenu.add(aboutMenuItem());
        
        // Adds the menu to the menu bar.
        add(myFileMenu);
        add(myOptionMenu);
        add(myToolMenu);
        add(helpMenu);    
    }
    
    /**
     * Creates all the file menu item like undo and exit.
     */
    private void fileMenuItem() {
     // The items in the menu.
        final JMenuItem undoMenuItem = new JMenuItem("Undo all changes");
        undoMenuItem.setMnemonic(KeyEvent.VK_U);
        myDrawingPanel.setButtonEnabled(undoMenuItem);
        undoMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myDrawingPanel.clear();
            }
        });
         
        final JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setMnemonic(KeyEvent.VK_X);
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myFrame.dispose();
            }
        });
        // Add the menu items to the File menu
        myFileMenu.add(undoMenuItem);
        myFileMenu.addSeparator();
        myFileMenu.add(exitMenuItem);
    }
    
    /**
     * Creates the option menu item.
     */
    private void optionMenuItem() {
        final JCheckBoxMenuItem shapeOption = new JCheckBoxMenuItem("Square/Circle only");
        shapeOption.setMnemonic(KeyEvent.VK_S);
        shapeOption.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(final ItemEvent theEvent) {
//                System.out.println("Checked? " + shapeOption.isSelected());
                myDrawingPanel.setSquareCircle(shapeOption.isSelected());
            }
        });
        final JMenu thickMenuItem = new JMenu("Thickness");
        thickMenuItem.setMnemonic(KeyEvent.VK_T);
        thickMenuItem.add(createSlider());
        // Add the menu items to the Option Menu
        myOptionMenu.add(shapeOption);
        myOptionMenu.addSeparator();
        myOptionMenu.add(thickMenuItem);
        myOptionMenu.addSeparator();
        myOptionMenu.add(colorChooserItem());
    }
    
    /**
     * Creates a slider for the thickness.
     * 
     * @return a JSlider of a slider
     */
    private JSlider createSlider() {
        final JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 0 , MAX_SLIDER_SIZE,
                                           MAJOR_TICK_SPACING);
        slider.setMajorTickSpacing(MAJOR_TICK_SPACING);
        slider.setMinorTickSpacing(MINOR_TICK_SPACING);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.addChangeListener(new ChangeListener() {
            /** Called in response to slider events in this window. */
            @Override
            public void stateChanged(final ChangeEvent theEvent) {
                final int value = slider.getValue();
                if (value > 0) {
                    myDrawingPanel.setLine(value);
                } 
            }
        });
        return slider;
    }
    
    /**
     * Creates the Color button with the color chooser action.
     * 
     * @return a JMenuItem.
     */
    private JMenuItem colorChooserItem() {
        final Color initialColor = Color.decode("#4b2e83");
        final ColorIcon colorIcon = new ColorIcon(initialColor);
        final ColorAction colorAction = new ColorAction("Color...", colorIcon,
                                                        myDrawingPanel);
        final JMenuItem colorChooser = new JMenuItem(colorAction);
        colorChooser.setIcon(colorAction.getIcon());
        return colorChooser;
    }
    
    /**
     * Creates the tool menu item.
     */
    private void toolMenuItem() {
        final ButtonGroup group = new ButtonGroup();
        for (final ButtonAction ba : myButtonActions) {  
            final JRadioButtonMenuItem toolRadio = new JRadioButtonMenuItem(ba);
            group.add(toolRadio);
            myToolMenu.add(toolRadio);
        }
    }
    
    /**
     * Creates an About Menu Item along with actionListener.
     * 
     * @return a JMenuItem
     */
    private JMenuItem aboutMenuItem() {
        final String about = "About";
        final JMenuItem aboutItem = new JMenuItem(about);
        
        aboutItem.addActionListener(new ActionListener() {           
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                JOptionPane.showMessageDialog(null,
                                              "TCSS 305 PowerPaint\n" 
                                                              + "Winter 2016\n" 
                                                              + "Arrunn Chhouy", about,
                                                              JOptionPane.INFORMATION_MESSAGE,
                                                              myIcon);
            }
        });
        
        return aboutItem;
    }
}
