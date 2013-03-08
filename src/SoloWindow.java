import com.googlecode.lanterna.gui.*;

/**
 * generic class that makes windows appear by themselves when they have focus (others disappear)
 * @author Brian West
 */
public abstract class SoloWindow extends Window{
	/**
	 * @param title the title of the window
	 */
	public SoloWindow(String title){
		super(title);
		setSoloWindow(true);
	}
}
