import com.googlecode.lanterna.gui.*;
import com.googlecode.lanterna.gui.component.*;
import com.googlecode.lanterna.gui.dialog.*;

/**
 * Menu that lets the user choose a tag to summarize<br>
 * In the future, they might be given a list of tags that they can choose, but right now they have to type it in
 * @author Brian West
 */
public class SummaryMenu extends SoloWindow{
	/** the input box for typing */
	public TextBox text;
	/** the thread used to run stats on data */
	public ParserRunner run;

	/** create the menu */
	public SummaryMenu(){
		super("Build Summary");
		text = new TextBox("", 10);
		addComponent(new Label("Type the tag of the data you would like to summarize"));

		OptionPanel options = new OptionPanel(true);
		options.addComponent(text);
		options.addComponent(new Button("Enter", new Action(){
			@Override
			public void doAction(){
				run = new ParserRunner(text.getText());
				//Interface.gui.runInEventThread(new SummaryAction(text.getText()));
				text.setText("");
			}
		}));
		options.addComponent(new Button("Clear", new Action(){
			@Override
			public void doAction(){
				text.setText("");
			}
		}));

		addComponent(options);
		addComponent(new Button("Back", new Action(){
			@Override
			public void doAction(){
				Interface.show(Interface.mainMenu);
			}
		}));

		OptionPanel progress = new OptionPanel(true);
		progress.addComponent(Interface.prog);
		addComponent(progress);
	}

	/**
	 * change the window to focus on the given button
	 * @param but the button to focus on
	 */
	protected void setFocus(Interactable but){
		super.setFocus(but);
	}
}
