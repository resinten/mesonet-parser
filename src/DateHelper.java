/**
 * An abstract class useful for getting information about a date-string
 * @author Brian West
 */
public abstract class DateHelper{
	/**
	 * check whether a date-string is a valid yyyymmdd date
	 * @param date the date string, preferably in yyyymmdd format
	 * @return true if the date is a valid date (not completely determinant if returns true, so further checks should be run
	 */
	public static boolean isADate(String date){
		if(date.length() != 8) return false;
		if(!isAYear(date.substring(0, 4))) return false;
		if(!isAMonth(date.substring(4, 6))) return false;
		if(!isADay(date.substring(6))) return false;
		return true;
	}

	/**
	 * check whether a dd string is a valid day of a month
	 * @param day the day to check
	 * @return true if day MIGHT be valid (if it is between 1 and 31)
	 */
	public static boolean isADay(String day){
		try{
			int dayNum = Integer.parseInt(day);
			if( dayNum > 0 && dayNum < 32 )
				return true;
			return false;
		}catch(NumberFormatException e){
			return false;
		}
	}

	/**
	 * check whether the mm string is a valid month of the year
	 * @param month the month in mm format
	 * @return true if the month is between 1 and 12
	 */
	public static boolean isAMonth(String month){
		try{
			int monthNum = Integer.parseInt(month);
			if( monthNum > 0 && monthNum < 13 )
				return true;
			return false;
		}catch(NumberFormatException e){
			return false;
		}
	}

	/**
	 * checks whether the year is a valid year
	 * @param the year, in yyyy format
	 * @return true if the year string adheres to the ISO 8601 standard year format
	 */
	public static boolean isAYear(String year){
		try{
			int yearNum = Integer.parseInt(year);
			if( yearNum > -1 && yearNum <= 9999 )
				return true;
			return false;
		}catch(NumberFormatException e){
			return false;
		}
	}
}
