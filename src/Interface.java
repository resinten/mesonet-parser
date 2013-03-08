import java.io.File;

import java.util.ArrayList;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.gui.*;
import com.googlecode.lanterna.gui.component.*;
import com.googlecode.lanterna.gui.dialog.*;

/**
 * The main driver of this app, which takes input
 * from command line and a text-based menu to
 * load and parse files, build summaries, and
 * print data.
 * @author Brian West
 */
public class Interface{
	/** the GUI screen as implemented by the lanterna library */
	public static GUIScreen gui;

	/** the main menu */
	public static MainMenu mainMenu;
	/** the load menu */
	public static LoadMenu loadMenu;
	/** the summary menu */
	public static SummaryMenu summaryMenu;
	/** the year menu */
	public static YearMenu yearMenu;
	/** the day menu */
	public static DayMenu dayMenu;
	/** the about menu */
	public static AboutDisplay aboutMenu;
	/** the options for summaries */
	public static SummarySelection summaryOptions;

	/** the generic progress bar, only used by the summary builder, put here as a hack to get it to work */
	public static ProgressBar prog;

	/** button to toggle min summary */
	public static CheckBox minButton;
	/** button to toggle max summary */
	public static CheckBox maxButton;
	/** button to toggle mean summary */
	public static CheckBox meanButton;
	/** button to toggle median summary */
	public static CheckBox medianButton;
	/** button to toggle stddev summary */
	public static CheckBox stddevButton;

	/**
	 * start the GUI and display the main menu
	 */
	public static void start(){
		try{
			gui = TerminalFacade.createGUIScreen();
			if(gui == null){
				System.err.println("Couldn't start a terminal interface!");
				System.exit(1);
			}
			gui.getScreen().startScreen();
			//gui.setTitle("Mesonet Parser");

			prog = new ProgressBar(45);
			minButton = new CheckBox("Minimum", true){
				@Override
				protected void onActivated(){
					super.onActivated();
					Driver.minOn = !Driver.minOn;
				}
			};
			maxButton = new CheckBox("Maximum", true){
				@Override
				protected void onActivated(){
					super.onActivated();
					Driver.maxOn = !Driver.maxOn;
				}
			};
			meanButton = new CheckBox("Mean", true){
				@Override
				protected void onActivated(){
					super.onActivated();
					Driver.meanOn = !Driver.meanOn;
				}
			};
			medianButton = new CheckBox("Median", true){
				@Override
				protected void onActivated(){
					super.onActivated();
					Driver.medianOn = !Driver.medianOn;
				}
			};
			stddevButton = new CheckBox("Std. Dev.", true){
				@Override
				protected void onActivated(){
					super.onActivated();
					Driver.stddevOn = !Driver.stddevOn;
				}
			};

			mainMenu = new MainMenu();
			loadMenu = new LoadMenu();
			summaryMenu = new SummaryMenu();
			yearMenu = new YearMenu();
			dayMenu = new DayMenu();
			aboutMenu = new AboutDisplay();
			summaryOptions = new SummarySelection();

			gui.showWindow(mainMenu, GUIScreen.Position.CENTER);

			gui.getScreen().stopScreen();
		}catch(Exception e){
			gui.getScreen().stopScreen();
			e.printStackTrace();
			System.exit(0);
		}
	}

	public static void close(){
//		gui.runInEventThread(new Action(){
//			@Override
//			public void doAction(){
//				Interface.gui.getScreen().stopScreen();
//			}
//		});
		gui.getScreen().stopScreen();
		System.exit(0);
	}

	/**
	 * return the main GUI window, useful for other windows changing the focus
	 * @return the GUIScreen
	 */
	public static GUIScreen getMain(){
		return gui;
	}

	/**
	 * prompt the user with the given message
	 * @param message the message to prompt the user with
	 */
	public static void prompt(String message){
		MessageBox.showMessageBox(gui, "Attention!", message);
	}

	/**
	 * update the progress bar to the given percent
	 * @param percent the percent of the progress bar
	 */
	public static void updateProg(double percent){
		if(prog == null){
			prompt("We can't find a progress bar!");
			return;
		}
		prog.setProgress(percent);
	}

	/**
	 * change the focus to the given window
	 * @param win the new window to give focus to
	 */
	public static void show(Window win){
		gui.showWindow(win, GUIScreen.Position.CENTER);
	}

	/**
	 * prompt the user that the menu they attempted to access has not been implemented yet
	 */
	public static void unimplemented(){
		prompt("Oops! This feature has not been implemented yet.");
	}
}
