import com.googlecode.lanterna.gui.*;
import com.googlecode.lanterna.gui.component.*;
import com.googlecode.lanterna.gui.dialog.*;

/**
 * This menu is used for loading a specific day into the list of files to be parsed
 * @author Brian West
 */
public class DayMenu extends SoloWindow{
	/** the input box */
	private TextBox text;
	/** the back button */
	public Button back;

	/**
	 * the entirety of creating the window
	 */
	public DayMenu(){
		super("Load Day");
		text = new TextBox("", 9);

		addComponent(new Label("Type date in <yyyymmdd> format:"));

		OptionPanel options = new OptionPanel(true);
		options.addComponent(text);
		options.addComponent(new Button("Enter", new Action(){
			@Override
			public void doAction(){
				try{
					Driver.parseDate(text.getText());
					Interface.prompt(text.getText()+" is ready to parse!");
					text.setText("");
					Interface.dayMenu.setFocus(Interface.dayMenu.back);
				}catch(InvalidDateException e){
					Interface.prompt(e.getMessage());
				}
			}
		}));
		options.addComponent(new Button("Clear", new Action(){
			@Override
			public void doAction(){
				text.setText("");
			}
		}));

		addComponent(options);
		back = new Button("Back", new Action(){
			@Override
			public void doAction(){
				Interface.loadMenu.setFocus(Interface.loadMenu.back);
				Interface.show(Interface.loadMenu);
			}
		});
		addComponent(back);
	}
}
