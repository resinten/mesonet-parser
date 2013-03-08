import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

/**
 * This class organizes files to be parsed and hands them off to parsers
 * @author Brian West
 */
public class ParserDriver{
	/** the list of files that need to be parsed */
	private static ArrayList<File> filesToDo;
	/** the list of dates that have already been parsed */
	private static HashMap<String,File> datesDone;
	/** the parsers that will be run on files */
	private static ArrayList<FileParser> parsers;

	/**
	 * initialize the various elements of the driver
	 */
	public static void init(){
		filesToDo = new ArrayList<File>();
		datesDone = new HashMap<String,File>(500);
		parsers = new ArrayList<FileParser>();
	}


	/**
	 * put a date in the list of dates that have been parsed
	 */
	public static void addDate(String date, File file){
//		for(int i = 0; i < datesDone.size(); i++){
//			if(datesDone.get(i).compareTo(date) > 0){
//				datesDone.add(i, date);
//				return;
//			}
//		}
//		datesDone.add(date);
		datesDone.put(date, file);
	}
	
	/**
	 * add a file to the list of files to be parsed
	 * @param file the file to add
	 */
	public static void addFile(File file){
		filesToDo.add( file );
	}
	/**
	 * add a file to the list of files to be parsed
	 * @param file the file to add
	 */
	public static void addFile(String file){
		filesToDo.add( new File(file) );
	}

	/**
	 * build a summary for the given tag<br>
	 * also runs parsers on any files remaining in the list of files that have not already been done according to the datesDone list
	 * @param tag the tag to build a summary for
	 */
	public static StateSummary buildSummary(String tag){
		while(filesToDo.size() > 0){ // create parsers for each file
			parsers.add(new FileParser(filesToDo.get(0)));
			filesToDo.remove(0);
		}
		int number = parsers.size();
		while(parsers.size() > 0){ // parse the file, then remove it from the list
			if(!isDateDone(parsers.get(0).getDate())){
				try{
					parsers.get(0).parse();
					addDate(parsers.get(0).getDate(), parsers.get(0).getFile()); // mark the date as done
				}catch(FileNotFoundException e){
					Driver.error(e.getMessage());
				}
				double step = number - parsers.size();
				double steps = number;
				//Interface.prompt("per: "+(step/steps));
				Driver.progress( step / steps );
			}
			parsers.remove(0);
		}
		return StationDriver.printSummary(tag);
	}

	/**
	 * @param date the date to check
	 * @return true if the date has already been parsed
	 */
	public static boolean isDateDone(String date){
//		for(int i = 0; i < datesDone.size(); i++){
//			if(datesDone.get(i).equals(date)) return true;
//		}
//		return false;
		return datesDone.containsKey(date);
		//return (Collections.binarySearch(datesDone, date) > -1)? true : false;
	}
}
