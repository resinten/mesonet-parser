/**
 * An exception thrown if the user provides invalid input
 * @author Brian West
 */
public class UserInputException extends Exception{
	/** create a default message that informs the user that their input was bad */
	public UserInputException(){
		super("What you just did was input an invalid option");
	}

	/**
	 * create an exception for the given user input
	 * @param input the input that the user provided
	 */
	public UserInputException(String input){
		super("You see that \""+ input+ "\" you just typed in?  We don't know what that is...");
	}
}
