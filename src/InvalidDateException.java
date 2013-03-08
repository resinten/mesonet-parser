/**
 * An exception thrown if the user inputs an invalid date to parse
 * @author Brian West
 */
public class InvalidDateException extends Exception{
	/**
	 * default constructor sets a generic message
	 */
	public InvalidDateException(){
		super("A valid date was not entered");
	}

	/**
	 * builds an exception with the given date
	 * @param date the date that caused the exception to be thrown
	 */
	public InvalidDateException(String date){
		super(date+" is not a valid date");
	}
}
