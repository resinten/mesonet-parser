import com.googlecode.lanterna.gui.*;
import com.googlecode.lanterna.gui.component.*;
import com.googlecode.lanterna.gui.dialog.*;

/**
 * this is a button class that just exits the program, which wasn't necessary, but I like to take up disk space
 * @author Brian West
 */
public class ExitButton extends Button{
	/**
	 * create the button
	 * @param prompt the prompt for the button
	 */
	public ExitButton(String prompt){
		super(prompt, new Action(){
			@Override
			public void doAction(){
				MessageBox.showMessageBox(Interface.getMain(), "Exiting", "Goodbye!");
				Interface.close();
			}
		});
	}
}
