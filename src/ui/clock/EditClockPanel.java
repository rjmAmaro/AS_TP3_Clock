package ui.clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import clock.ClockController;
import driver.ClockDriver;


public class EditClockPanel {
	
	private ClockPanel clockPanel;
	private ClockDriver clockDriver;
	private ClockController clockController;
	
	
	EditClockPanel(ClockPanel clockPanel){
		
		this.clockPanel = clockPanel;
		
	}
	
	public void build(ClockController clockController, ClockDriver clockDriver){

		this.clockController = clockController;
		this.clockDriver = clockDriver;
		
		editDateTimePanel();
		
	}
	
	public void editDateTimePanel(){
		
		editDatePanel();
		editTimePanel();
		editSendButton();
		
	}

	
	private void editDatePanel() {
		
		UtilDateModel model = new UtilDateModel();
		//model.setDate(20,04,2014);
		// Need this...
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		// Don't know about the formatter, but there it is...
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
		clockPanel.add(datePicker);
		
		
	}

	private void editTimePanel() {
		
		JSpinner timeSpinner = new JSpinner( new SpinnerDateModel() );
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
		timeSpinner.setEditor(timeEditor);
		timeSpinner.setValue(new Date());
		
		clockPanel.add(timeSpinner);
		
	}
	
	public void editSendButton(){
		
		JButton datetimeChange = new JButton("Change Date Time"); // reference to the button object
		
		datetimeChange.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				datetimeChange.setText("Ok Button clicked.");
				
			}
		});			
		
		clockPanel.add(datetimeChange);
		
	}
	
	
	
}
