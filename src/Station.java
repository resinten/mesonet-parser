import java.util.ArrayList;

/**
 * A station, which contains observations
 * @author Brian West
 */
public class Station{
	/** the name of the station */
	private String name;
	/** the tags of the station */
	private ArrayList<TagList> tags;

	/**
	 * create a station with the given name
	 * @param name the name of the station
	 */
	public Station(String name){
		this.name = name;
		tags = new ArrayList<TagList>();
	}

	/**
	 * add an observation to the station
	 * @param observation the observation to add
	 */
	public void addObservation(Observation observation){
		getTag(observation.getTag()).add(observation);
	}
	/**
	 * find the tag in the station, which could be sped up with a hash map, I'm sure
	 * @param tag the tag to find
	 * @return the index of the tag in the array of tags
	 */
	public int findTag(String tag){ // means we need to override .equals(TagList)
		for(int i = 0; i < tags.size(); i++){
			if(tags.get(i).getName().equals(tag))
				return i;
		}
		tags.add(new TagList(tag));
		return tags.size()-1;
		//int index = tags.indexOf(tag);
		//if( index == -1 ){
		//	tags.add(new TagList(tag));
		//	index = tags.size()-1;
		//}
		//return index;
	}

	/** @return the station's name */
	public String getName(){
		return name;
	}
	/** @return the list of observations of the given tag */
	public ArrayList<Observation> getTag(String tag){
		return tags.get( findTag(tag) ).get();
	}
}
