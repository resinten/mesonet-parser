import com.googlecode.lanterna.gui.*;

/**
 * a sub thread that runs the parser driver to build a summary<br>
 * this was necessary to hack together the progress bar to work properly so that the GUI is interactable while parsing files
 * @author Brian West
 */
public class ParserRunner implements Runnable{
	/** the thread that runs */
	private Thread t;
	/** the tag to build a summary for */
	private String tag;
	/** the summary menu that displays the results */
	SummaryDisplay sum;

	/** create a new thread to summarize the given tag */
	public ParserRunner(String tag){
		t = new Thread(this, "Parser");
		this.tag = tag;
		t.start();
	}

	/**
	 * run the parsers
	 */
	public void run(){
		sum = new SummaryDisplay(ParserDriver.buildSummary(tag));
		Interface.show(sum);
//		Interface.gui.runInEventThread(new Action(){
//			@Override
//			public void doAction(){
//				Interface.show(sum);
//			}
//		});
	}
}
