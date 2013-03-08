import com.googlecode.lanterna.gui.*;
import com.googlecode.lanterna.gui.component.*;
import com.googlecode.lanterna.gui.dialog.*;

/**
 * The main menu of the program
 * @author Brian West
 */
public class MainMenu extends SoloWindow{
	/** the button to select a summary to build */
	public Button summary;

	/** create the menu */
	public MainMenu(){
		super("Mesonet Menu");
		addComponent(new Label("Select an option"));

		OptionPanel options = new OptionPanel();
		options.addComponent(new Button("Load data", new Action(){
			@Override
			public void doAction(){
				Interface.show(Interface.loadMenu);
			}
		}));
		summary = new Button("Build Summary", new Action(){
			@Override
			public void doAction(){
				Interface.show(Interface.summaryMenu);
			}
		});
		options.addComponent(summary);
//		options.addComponent(new Button("Options", new Action(){
//			@Override
//			public void doAction(){
//			}
//		}));
		options.addComponent(new Button("Options", new Action(){
			@Override
			public void doAction(){
				Interface.show(Interface.summaryOptions);
			}
		}));
		options.addComponent(new Button("About", new Action(){
			@Override
			public void doAction(){
				Interface.show(Interface.aboutMenu);
			}
		}));

		addComponent(options);
		addComponent(new ExitButton("Exit"));
	}

	/**
	 * set the focus of the menu to be on a specific button
	 * @param but the button to focus on
	 */
	protected void setFocus(Interactable but){
		super.setFocus(but);
	}
}
