import java.util.ArrayList;
import java.util.HashMap;

/**
 * this is a summary of a list of data, which is not actually stored long term, but is somewhat convenient
 * @author Brian West
 */
public class StateSummary{
	/** the tag of the data summarized */
	private String tag;
	/** the observations to summarize over */
	private ArrayList<Observation> observations;

	/** the minimum value */
	private double min;
	/** the maximum value */
	private double max;
	/** the mean value */
	private double mean;
	/** the median value */
	private double median;
	/** the standard standard deviation */
	private double stddev;
	/** the number of items counted */
	private int count;

	/**
	 * Please don't use this; it's existence is solely to test the GUI
	 * @param name the name of the test Summary
	 */
	public StateSummary(String name){
		tag = name;
		min = Math.random()*100;
		max = Math.random()*100;
		mean = Math.random()*100;
		median = Math.random()*100;
		stddev = Math.random()*100;
	}

	/**
	 * construct a state summary of the given tag from the given stations
	 * @param stations a hash map of stations to parse
	 * @param tag the tag to summarize
	 */
	public StateSummary(HashMap<String,Station> stations, String tag){
		this.tag = tag;
		observations = new ArrayList<Observation>();
		for(String i : stations.keySet())
			observations.addAll( stations.get(i).getTag(tag) );
		calculateStats();
	}

	/**
	 * perform the calculations on the data
	 */
	private void calculateStats(){
		count = observations.size();
		if(observations.size() < 1){
			min = 0;
			max = 0;
			mean = 0;
			median = 0;
			stddev = 0;
			return;
		}
		double[] vals = new double[observations.size()];
		for(int i = 0; i < observations.size(); i++)
			vals[i] = observations.get(i).getValue();
		min = MegaMath.calcMin(vals);
		max = MegaMath.calcMax(vals);
		mean = MegaMath.calcMean(vals);
		median = MegaMath.calcMedian(vals);
		stddev = MegaMath.calcDeviation(vals, mean);
	}

	/** @return the tag of the data */
	public String getTag(){
		return tag;
	}
	/** @return the number of elements summarized */
	public double getCount(){
		return count;
	}
	/** @return the minimum value of the elements */
	public double getMin(){
		return min;
	}
	/** @return the maximum value of the elements */
	public double getMax(){
		return max;
	}
	/** @return the mean value of the elements */
	public double getMean(){
		return mean;
	}
	/** @return the median value of the elements */
	public double getMedian(){
		return median;
	}
	/** @return the standard deviation of the elements */
	public double getDev(){
		return stddev;
	}

	/**
	 * @return a string representation for the summary
	 */
	@Override
	public String toString(){
		String r;
		r =  tag+":\n";
		r += "------------------\n";
		r += "Count:\t\t"+count+"\n";
		r += "Min:\t\t"+min+"\n";
		r += "Max:\t\t"+max+"\n";
		r += "Mean:\t\t"+mean+"\n";
		r += "Median:\t\t"+median+"\n";
		r += "Standard Dev.:\t"+stddev+"\n";
		return r;
	}
}
