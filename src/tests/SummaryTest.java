import org.junit.*;
import static org.junit.Assert.*;

public class SummaryTest{
	@Test
	public void minTest(){
		for(int i = 0; i < 100; i++){
			double[] pair = genPair();
			assertEquals( MegaMath.calcMin(pair), Math.min(pair[0], pair[1]), 0.001 );
		}
	}

	@Test
	public void maxTest(){
		for(int i = 0; i < 100; i++){
			double[] pair = genPair();
			assertEquals( MegaMath.calcMax(pair), Math.max(pair[0], pair[1]), 0.001 );
		}
	}

	@Test
	public void meanTest(){ // finish this
		for(int i = 0; i < 100; i++){
			double[] pair = genPair();
			assertEquals( MegaMath.calcMean(pair), (pair[0]+pair[1])/2, 0.001 );
		}
	}

	@Test
	public void deviationTest(){ // finish this
		for(int i = 0; i < 100; i++){
			double[] pair = genPair();
			double mean = (pair[0] + pair[1])/2;

			double deviation = Math.pow(pair[0] - mean, 2) + Math.pow(pair[1] - mean, 2);
			deviation = deviation / 2.0;
			deviation = Math.sqrt(deviation);
			assertEquals( deviation, MegaMath.calcDeviation(pair, mean), 0.001);
		}
	}

	public double[] genPair(){
		double[] pair = { Math.random()*100.0, Math.random()*100.0 };
		return pair;
	}
}
