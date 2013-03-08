/**
 * Generic header object for files
 * @author Brian West
 */
public class Header{
	/** the index where this header appears */
	private int index;
	/** the string identifying this header */
	private String name;

	/**
	 * construct a header with the given name and index
	 * @param name the name of the header
	 * @param index the index of the header
	 */
	public Header(String name, int index){
		this.name = name;
		this.index = index;
	}

	/**
	 * @return the index
	 */
	public int getIndex(){
		return index;
	}

	/**
	 * @return the name
	 */
	public String getName(){
		return name;
	}
}
