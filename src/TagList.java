import java.util.ArrayList;

/**
 * Aggregation of observations with a common name
 * @author Brian West
 */
public class TagList{
	/** the common name */
	private String name;
	/** the observations */
	private ArrayList<Observation> observations;

	/**
	 * create a new tag list with the given name
	 * @param name the given name
	 */
	public TagList(String name){
		this.name = name;
		observations = new ArrayList<Observation>();
	}

	/** @return the name common to these observations */
	public String getName(){
		return name;
	}
	/** @return the observations contained by this list */
	public ArrayList<Observation> get(){
		return observations;
	}

	/**
	 * returns true if this tag list is equivalent to the given Object
	 * @param other the object to compare to
	 */
	@Override
	public boolean equals(Object other){
		if( this == other ) return true;
		if(!(other instanceof String)) return false;
		return this.name.equals(other);
	}
}
