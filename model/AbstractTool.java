
package model;


/**
 * The parent tool class that has some of the methods similar
 * across all tools.
 * 
 * @author Arrunn Chhouy
 * @version 1.0
 */
public abstract class AbstractTool implements Tool {
    /**
     * The "Tool" suffix.
     */
    private static final String TOOL_SUFFIX = "Tool";
    
    /**
     * The description of this tool (will be used on buttons).
     */
    private String myDescription;
    
    /**
     * Constructs a tool and uses a modified version of the class's name as
     * its description. Any package hierarchy in the name is removed, and the
     * word "Tool" is removed from the end (if present). 
     */
    protected AbstractTool() {
        final String name = getClass().getName();
        final int dot = name.lastIndexOf('.');
        if (dot >= 0 && name.endsWith(TOOL_SUFFIX)) {
            // truncate the word "Filter"
            myDescription = name.substring(dot + 1, name.length() - TOOL_SUFFIX.length());
        } else {
            myDescription = name.substring(dot + 1, name.length());
        }
    }
    
    /**
     * Constructs a filter with the specified description.
     * 
     * @param theDescription The description.
     */
    public AbstractTool(final String theDescription) {
        myDescription = theDescription;
    }

    /**
     * Gets the description of the tool.
     * 
     * @return a String 
     */
    @Override
    public String getDescription() {
        return myDescription;
    }
}
