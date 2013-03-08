import com.googlecode.lanterna.gui.*;
import com.googlecode.lanterna.gui.component.*;
import com.googlecode.lanterna.gui.dialog.*;

/**
 * Choose what you want displayed on the summary window
 * @author Brian West
 */
public class SummarySelection extends Window{
	/** the list of check boxes */
	CheckBoxList box;
	
	/**
	 * create the window
	 */
	public SummarySelection(){
		super("Summary Options");
		addComponent(new Label("What do you want displayed on the summary?"));
		OptionPanel options = new OptionPanel();
		options.addComponent(Interface.minButton);
		options.addComponent(Interface.maxButton);
		options.addComponent(Interface.meanButton);
		options.addComponent(Interface.medianButton);
		options.addComponent(Interface.stddevButton);
		addComponent(options);
		addComponent(new Button ("Done", new Action(){
			@Override
			public void doAction(){
				Interface.mainMenu.setFocus(Interface.mainMenu.summary);
				Interface.show(Interface.mainMenu);
			}
		}));
	}
}
