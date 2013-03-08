import java.io.File;
import java.io.FileNotFoundException;

/**
 * This is the main class that you should run
 * @author Brian West
 */
public class Driver{
	/** true if we are in "headless" mode */
	private static boolean headless = false;
	/** true if we want to print errors and debug info */
	private static boolean verbose = false;

	/** do we summarize min? */
	public static boolean minOn = true;
	/** do we summarize max? */
	public static boolean maxOn = true;
	/** do we summarize mean? */
	public static boolean meanOn = true;
	/** do we summarize median? */
	public static boolean medianOn = true;
	/** do we summarize stddev? */
	public static boolean stddevOn = true;

	/**
	 * the main method that checks options and initializes the proper menu
	 * @param args the command-line arguments used to call the program
	 */
	public static void main(String[] args){
		ParserDriver.init();
		StationDriver.init();
		if( searchArgs(args, "-headless") > -1 )
			headless = true;
		if( searchArgs(args, "-v") > -1)
			verbose = true;

		if(headless) TextMenu.start();
		else Interface.start();
	}

	/**
	 * generic error prompt method to alert the user of an error
	 * @param report the error message to report to the user
	 */
	public static void error(String report){
		if(!verbose) return;
		if(headless) TextMenu.prompt(report);
		else Interface.prompt(report);
	}

	/**
	 * we have a year to parse, which we try to parse, or throw an exception if it's not a year
	 * @param year the year to parse
	 * @throws InvalidDateException if the year given is not actually a year according to ISO 8601
	 */
	public static void parseYear(String year) throws InvalidDateException{
		if(!DateHelper.isAYear(year))
			throw new InvalidDateException(year);
		File yearData = new File("data/"+year);
		if(!yearData.isDirectory())
			throw new InvalidDateException(year);
		for(File f : yearData.listFiles())
			if(f.getName().endsWith("mdf"))
				ParserDriver.addFile(f);
	}

	/**
	 * we have a day to parse, which we try, or throw an exception if it's not a day
	 * @param date the day to parse
	 * @throws InvalidDateException if the date is not actually a date, shocker! O.O
	 */
	public static void parseDate(String date) throws InvalidDateException{
		if(!DateHelper.isADate(date))
			throw new InvalidDateException(date);
		File dateData = new File("data/"+date.substring(0, 4) + "/" + date + ".mdf");
		if(!dateData.isFile())
			throw new InvalidDateException(date);
		ParserDriver.addFile(dateData);
	}

	/**
	 * update any progress bars to the proper percent
	 * @param percent the percent full of the progress bar
	 */
	public static void progress(double percent){
		if(!headless) Interface.updateProg( percent );
	}

	/**
	 * search the given args for the given key and return the index of the arg
	 * @param args the arguments to search through
	 * @param key the key to search for
	 * @return the index in args that they key appears at, or -1 if it doesn't exist
	 */
	public static int searchArgs(String[] args, String key){
		for(int i = 0; i < args.length; i++)
			if(args[i].equals(key)) return i;
		return -1;
	}
}
