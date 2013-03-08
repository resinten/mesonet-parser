import java.util.Scanner;

/**
 * The text based menu that was called for by the project description<br>
 * actually implemented after the fact
 * @author Brian West
 */
public class TextMenu{
	/** standard input */
	private static Scanner in;
	/** constant identifier for the main menu */
	private static final int MAINMENU = 0;
	/** the load menu id */
	private static final int LOADMENU = 1;
	/** the summary menu id */
	private static final int SUMMARYMENU = 2;
	/** the year load menu id */
	private static final int YEARMENU = 3;
	/** the day load menu id */
	private static final int DAYMENU = 4;
	
	/** the current window, defaulted to the main menu */
	private static int window = MAINMENU;

	/**
	 * start the menu
	 */
	public static void start(){
		in = new Scanner(System.in);
		while(true){
			System.out.println("");
			try{
				switch(window){
					case MAINMENU:
						showMain();
						break;
					case LOADMENU:
						showLoad();
						break;
					case SUMMARYMENU:
						showSummary();
						break;
					case YEARMENU:
						showYear();
						break;
					case DAYMENU:
						showDay();
						break;
					default:
						prompt("Something terrible happened!");
						System.exit(1);
				}
			}catch(UserInputException e){
				prompt(e.getMessage());
			}catch(StringIndexOutOfBoundsException e){
				prompt("No option was selected!");
			}
		}
	}

	/**
	 * alert the user with the given message
	 * @param message the message to give the user
	 */
	public static void prompt(String message){
		System.err.println("\nAttention! "+message);
	}

	/**
	 * alert the user the feature they request has not been made yet
	 */
	public static void unimplemented(){
		prompt("Sorry, this has not been implemented yet!");
	}

	/**
	 * show the menu to load a particular date
	 * @throws UserInputException if the user does not provide valid input
	 */
	private static void showDay() throws UserInputException{
		System.out.println("Load Day");
		System.out.println("Type date in <yyyymmdd> format:");
		String line = in.nextLine();
		window = LOADMENU;
		try{
			Driver.parseDate(line);
			prompt(line + " is ready to parse!");
		}catch(InvalidDateException e){
			throw new UserInputException(line);
		}
	}

	/**
	 * show the general load menu to choose between loading a year and a day
	 */
	private static void showLoad() throws UserInputException{
		System.out.println("Load Data");
		System.out.println("What would you like to load?");
		System.out.println("1. Load year");
		System.out.println("2. Load day");
		System.out.println("3. Back");
		String line = in.nextLine();
		switch(line.charAt(0)){
			case '1':
				window = YEARMENU;
				break;
			case '2':
				window = DAYMENU;
				break;
			case '3':
				window = MAINMENU;
				break;
			default:
				throw new UserInputException(line);
		}
	}

	/**
	 * show the main menu
	 * @throws UserInputException if the user does not provide valid input
	 */
	private static void showMain() throws UserInputException{
		System.out.println("Mesonet Menu");
		System.out.println("Select an option");
		System.out.println("1. Load data");
		System.out.println("2. Build summary");
		System.out.println("3. Exit");
		String line = in.nextLine();
		switch(line.charAt(0)){
			case '1':
				window = LOADMENU;
				break;
			case '2':
				window = SUMMARYMENU;
				break;
			case '3':
				System.out.println("Goodbye!");
				System.exit(0);
				break;
			default:
				throw new UserInputException(line);
		}
	}

	/**
	 * show a given summary to the user
	 * @param summary the summary to be displayed
	 */
	private static void showStats(StateSummary summary) throws UserInputException{
		System.out.println("\n"+summary);
		System.out.println("Press <Enter> to continue");
		in.nextLine();
	}

	/**
	 * show the menu where the user can choose a tag to be summarized
	 */
	private static void showSummary() throws UserInputException{
		System.out.println("Build Summary");
		System.out.println("Type the tag of the data you would like to summarize");
		System.out.println("Or a blank line to return");
		String line = in.nextLine();
		if(line.equals("")){
			window = MAINMENU;
			return;
		}
		showStats( ParserDriver.buildSummary(line) );
	}

	/**
	 * show the menu to load a user-provided year
	 * @throws UserInputException if the user does not provide a valid year
	 */
	private static void showYear() throws UserInputException{
		System.out.println("Load Year");
		System.out.println("Type year in <yyyy> format:");
		String line = in.nextLine();
		window = LOADMENU;
		try{
			Driver.parseYear(line);
			prompt(line + " is ready to parse!");
		}catch(InvalidDateException e){
			throw new UserInputException(line);
		}
	}
}
