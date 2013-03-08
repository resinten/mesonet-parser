import java.util.ArrayList;

/**
 * Unimplemented class that was going to parse parminfo.xml<br>
 * I didn't finish it because I got distracted by exams and forgot
 * @author Brian West
 */
public class XMLDriver{
	private static ArrayList<Unit> units;
	
	public static void init(){
		units = new ArrayList<Unit>();
		buildTags("data/parminfo.xml");
	}

	public static void buildTags(String xmlPath){
	}
}
