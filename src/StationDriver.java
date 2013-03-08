import java.util.ArrayList;
import java.util.HashMap;

/**
 * The main driver to interact with stations
 * @author Brian West
 */
public class StationDriver{
	/** hash map of stations */
	private static HashMap<String,Station> stations;
	
	/**
	 * initialize the hash map
	 */
	public static void init(){
		stations = new HashMap<String,Station>(100);
	}

	/**
	 * add the given observation to the given station
	 * @param observation the observation to add
	 * @param station the station to add the observation to
	 */
	public static void addObservation(Observation observation, String station){
		if(!stations.containsKey(station)) stations.put(station, new Station(station));
		stations.get( station ).addObservation(observation);
	}

//	public static int findStation(String station){
//		for(int i = 0; i < stations.size(); i++)
//			if( stations.get(i).getName().equals(station) )
//				return i;
//		stations.add(new Station(station));
//		return stations.size()-1;
//	}

	/**
	 * print a summary of the given tag<br>
	 * does NOT run parsers on remaining files
	 * @param tag the tag to print a summary for
	 * @return a StateSummary for the given data

	 */
	public static StateSummary printSummary(String tag){
		return new StateSummary(stations, tag);
	}
}
