import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A parser that is given a Mesonet file and builds Observations from it for storage
 * @author Brian West
 */
public class FileParser{
	/** the file to parse */
	private File file;
	/** the date that is associated with the Mesonet file */
	private String date;
	/** the headers in the Mesonet file */
	private ArrayList<Header> headers;

	/**
	 * create a new FileParser with the given file
	 * @param file the file to parse
	 */
	public FileParser(File file){
		this.file = file;
		this.date = file.getName().substring(0, file.getName().length()-4);
		this.headers = new ArrayList<Header>();
	}

	/**
	 * return the index at which the header appears
	 * @param tag the tag to find
	 * @return the index of the header
	 */
	private int indexOfHeader(String tag){
		for(int i = 0; i < headers.size(); i++)
			if( headers.get(i).getName().equals(tag) )
				return i;
		return 0;
	}

	/**
	 * start the file parser and build Observations from it
	 * @throws FileNotFoundException if the file somehow does not exist (Driver should have caught this, so the data was removed between adding the file to the queue and parsing it
	 */
	public void parse() throws FileNotFoundException{
		Scanner in = new Scanner(file);
		in.nextLine(); in.nextLine();
		headers = parseHeaders(in.nextLine());

		String[] line;
		int stidLoc = indexOfHeader("STID");
		while( in.hasNextLine() ){
			line = stripWhitespace(in.nextLine());
			String station = line[stidLoc];
			for(int i = 0; i < line.length; i++){
				if(i == stidLoc) continue;
				try{
					String tag = headers.get(i).getName();
					double value = Double.parseDouble(line[i]);
					Observation toAdd = new Observation(tag, value);
					StationDriver.addObservation(toAdd, station);
				}catch(DataNotFoundException e){
					Driver.error(e.getMessage());
				}
			}
		}
	}

	/**
	 * take in a line of input and build the headers from it
	 * @param input the Headers
	 * @return an arraylist containing the headers and their order
	 */
	private ArrayList<Header> parseHeaders(String input){
		ArrayList<Header> heads = new ArrayList<Header>();
		String[] line = stripWhitespace(input);
		for(int i = 0; i < line.length; i++)
			heads.add( new Header(line[i], i) );
		return heads;
	}

	/**
	 * take in a line of input and strip the whitespace from it
	 * @param input the line to parse
	 * @return an array of strings, whitespace delimited from the input
	 */
	private static String[] stripWhitespace(String input){
		if(input.startsWith(" "))
			return stripWhitespace( input.substring(1) );
		return input.split(" +");
	}

	/**
	 * @return the date string this file parser is parsing
	 */
	public String getDate(){
		return date;
	}
	/**
	 * @return the file this object is parsing
	 */
	public File getFile(){
		return file;
	}
}
