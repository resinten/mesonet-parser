/**
 * An unimplemented feature that was going to parse through the parminfo.xml file and store the units for each tag
 * @author Brian West
 */
public class Unit{
	private String tag;
	private String units;
	private String description;

	public Unit(String tag, String units, String description){
		this.tag = tag;
		this.units = units;
		this.description = description;
	}

	public String getTag(){
		return tag;
	}
	public String getUnits(){
		return units;
	}
	public String getDescription(){
		return description;
	}
}
