import com.googlecode.lanterna.gui.*;
import com.googlecode.lanterna.gui.component.*;

/**
 * This displays the about page for the lanterna-based GUI
 * There's not much to it.
 * @author Brian West
 */
public class AboutDisplay extends Window{
	/**
	 * Uh, this is just a constructor that is basically the entirety of the class, so...yeah
	 */
	public AboutDisplay(){
		super("About");
		
		OptionPanel text = new OptionPanel();
		text.addComponent(new Label("This interface uses the Lanterna library, which is designed to provide text-based GUIs, a la Curses."));
		text.addComponent(new Label("The GUI is the only thing that uses an external library, and all code contained in the src/ folder"));
		text.addComponent(new Label("is written by me.  If this is an issue, a more traditional text-based menu can be used by specifying"));
		text.addComponent(new Label("\"-headless\" in the command-line arguments."));

		addComponent(text);
		addComponent(new Button("Back", new Action(){
			@Override
			public void doAction(){
				Interface.show(Interface.mainMenu);
			}
		}));
	}
}
