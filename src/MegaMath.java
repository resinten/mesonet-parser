import java.util.Arrays;

/**
 * Perform some basic calculations for the Lord and Master StateSummary class
 * @author Brian West
 */
public class MegaMath{
	/**
	 * calculate a min for values
	 * @param values the values to calculate for
	 */
	public static double calcMin(double[] values){
		double min = values[0];
		for(int i = 1; i < values.length; i++){
			if( values[i] < min ) min = values[i];
		}
		return min;
	}

	/**
	 * calculate a max for values
	 * @param values the values to calculate for
	 */
	public static double calcMax(double[] values){
		double max = values[0];
		for(int i = 1; i < values.length; i++)
			if( values[i] > max ) max = values[i];
		return max;
	}

	/**
	 * calculate a mean for values
	 * @param values the values to calculate for
	 */
	public static double calcMean(double[] values){
		double sum = 0;
		for(int i = 0; i < values.length; i++)
			sum += values[i];
		return sum / (double)values.length;
	}

	/**
	 * calculate a median for values
	 * @param values the values to calculate for
	 */
	public static double calcMedian(double[] values){
		Arrays.sort(values);
		double mid = values.length/2.0;
		double sum = values[(int)mid] + values[(int)(mid+0.5)];
		return sum / 2.0;
	}

	/**
	 * calculate a deviation for values
	 * @param values the values to calculate for
	 */
	public static double calcDeviation(double[] values, double mean){
		double sum = 0;
		for(int i = 0; i < values.length; i++)
			sum += Math.pow(values[i] - mean, 2);
		return Math.sqrt( sum / (double)values.length );
	}
}
