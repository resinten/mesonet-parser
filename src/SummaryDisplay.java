import com.googlecode.lanterna.gui.*;
import com.googlecode.lanterna.gui.component.*;
import com.googlecode.lanterna.gui.dialog.*;

/**
 * The window displaying the summary requested
 * @author Brian West
 */
public class SummaryDisplay extends Window{
	/**
	 * create a new display for the given summary
	 * @param summary the summary to display
	 */
	public SummaryDisplay(StateSummary summary){
		super(summary.getTag() + " summary");

		OptionPanel options = new OptionPanel();
		options.addComponent(new Label("Count:     "+summary.getCount()));
		if(Driver.minOn) options.addComponent(new Label("Min:       "+summary.getMin()));
		if(Driver.maxOn) options.addComponent(new Label("Max:       "+summary.getMax()));
		if(Driver.medianOn) options.addComponent(new Label("Median:    "+summary.getMedian()));
		if(Driver.meanOn) options.addComponent(new Label("Mean:      "+summary.getMean()));
		if(Driver.stddevOn) options.addComponent(new Label("Std. Dev.: "+summary.getDev()));

		addComponent(options);
		addComponent(new Button("OK", new Action(){
			@Override
			public void doAction(){
				Interface.updateProg(0);
				Interface.summaryMenu.setFocus(Interface.summaryMenu.text);
				Interface.show(Interface.summaryMenu);
			}
		}));
		
	}
}
