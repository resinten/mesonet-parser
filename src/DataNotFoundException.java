/**
 * This exception is thrown when an Observation is constructed but the data is not valid, so the constructor will throw this exception here
 * @author Brian West
 */
public class DataNotFoundException extends Exception{
	/**
	 * if a tag was not specified, just notify the user that some Observation did not have valid data
	 */
	public DataNotFoundException(){
		super("A tag did not have valid data!");
	}

	/**
	 * notify the user that the given tag did not have valid data
	 * @param tag the id of the data that was invalid
	 */
	public DataNotFoundException(String tag){
		super(tag + " did not have valid data for a Station");
	}
}
