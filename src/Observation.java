/**
 * An observation of data reported by a station
 * @author Brian West
 */
public class Observation{
	/** the string id of this observation */
	private String tag;
	/** the value reported by this observation */
	private double value;
	
	/**
	 * create an observation with the given tag and value
	 * @param tag the tag for this observation
	 * @param value the value for this observation
	 * @throws DataNotFoundException if the data is not valid (-999.00)
	 */
	public Observation(String tag, double value) throws DataNotFoundException{
		this.tag = tag;
		this.value = value;
		if(value == -999.00)
			throw new DataNotFoundException(tag);
	}

	/**
	 * @return the name of the observation id
	 */
	public String getTag(){
		return tag;
	}
	/**
	 * @return the value of this observation
	 */
	public double getValue(){
		return value;
	}
}
