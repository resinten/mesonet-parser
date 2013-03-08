import com.googlecode.lanterna.gui.*;
import com.googlecode.lanterna.gui.component.*;
import com.googlecode.lanterna.gui.dialog.*;

/**
 * The menu for the user to choose to load a year
 * @author Brian West
 */
public class YearMenu extends SoloWindow{
	/** the size of the input box */
	private static final int SIZE = 5;
	/** the text input box */
	private TextBox text;
	/** the back button */
	public Button back;

	/**
	 * The creation of the window is done here
	 */
	public YearMenu(){
		super("Load Year");
		text = new TextBox("", SIZE);

		addComponent(new Label("Type year in <yyyy> format:"));

		OptionPanel options = new OptionPanel(true);
		options.addComponent(text);
		options.addComponent(new Button("Enter", new Action(){
			@Override
			public void doAction(){
				try{
					Driver.parseYear(text.getText());
					Interface.prompt(text.getText()+" is ready to parse!");
					text.setText("");
					Interface.yearMenu.setFocus(Interface.yearMenu.back);
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
