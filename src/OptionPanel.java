import com.googlecode.lanterna.gui.*;
import com.googlecode.lanterna.gui.component.*;

/**
 * a panel that makes creating menus much easier
 * @author Brian West
 */
public class OptionPanel extends Panel{
	/** create a new panel with a vertical alignment of elements */
	public OptionPanel(){
		super(new Border.Bevel(false), Panel.Orientation.VERTICAL);
	}

	/**
	 * create a new panel with either a vertical or horizontal alignment of elements
	 * @param horizontal true if you want the alignment to be horizontal instead of vertical
	 */
	public OptionPanel(boolean horizontal){
		super(new Border.Bevel(false), (horizontal)? Panel.Orientation.HORISONTAL : Panel.Orientation.VERTICAL);
	}
}
