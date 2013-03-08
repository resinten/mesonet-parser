import com.googlecode.lanterna.gui.*;
import com.googlecode.lanterna.gui.component.*;
import com.googlecode.lanterna.gui.dialog.*;

/**
 * This menu displays the options of loading a year or a single day
 * @author Brian West
 */
public class LoadMenu extends SoloWindow{
	public Button back;

	/**
	 * create the menu
	 */
	public LoadMenu(){
		super("Load Data");
		addComponent(new Label("What would you like to load?"));
		
		OptionPanel options = new OptionPanel();
		options.addComponent(new Button("Load year", new Action(){
			@Override
			public void doAction(){
				Interface.show(Interface.yearMenu);
			}
		}));
		options.addComponent(new Button("Load day", new Action(){
			@Override
			public void doAction(){
				Interface.show(Interface.dayMenu);
			}
		}));
		
		addComponent(options);
		back = new Button("Back", new Action(){
			@Override
			public void doAction(){
				Interface.mainMenu.setFocus(Interface.mainMenu.summary);
				Interface.show(Interface.mainMenu);
			}
		});
		addComponent(back);
	}

	protected void setFocus(Interactable but){
		super.setFocus(but);
	}
}
