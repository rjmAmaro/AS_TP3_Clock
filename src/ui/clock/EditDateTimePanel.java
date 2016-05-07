package ui.clock;

import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import clock.ClockController;
import driver.ClockDriver;


public class EditDateTimePanel extends JPanel {
	
	private ClockPanel clockPanel;
	private ClockDriver clockDriver;		// este provavelmente não vai ser preciso
	private ClockController clockController;
	
	private JPanel datePanel;
	private JPanel timePanel;
	private JPanel buttonPanel;
	
	private JButton editDateTimeButton;
	
	private JSpinner timeSpinner;
	private JDatePickerImpl datePicker;
	
	EditDateTimePanel(ClockDriver clockDriver, ClockController clockController, ClockPanel clockPanel){
		super();

		this.clockDriver = clockDriver;
		this.clockController = clockController;
		this.clockPanel = clockPanel;
		buildUI();
	}
	
	private void buildUI() {
		
		buildDatePanel();
		buildTimePanel();
		buildButtonPanel();
	}
	
	private void buildDatePanel() {
		datePanel = new JPanel();
		
		UtilDateModel model = new UtilDateModel();
		//model.setDate(20,04,2014);
		// Need this...
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanelI = new JDatePanelImpl(model, p);
		// Don't know about the formatter, but there it is...
		datePicker = new JDatePickerImpl(datePanelI, new DateComponentFormatter());
		clockPanel.add(datePicker);
		
		this.add(datePanel);
	}

	private void buildTimePanel() {
		timePanel = new JPanel();
		
		timeSpinner = new JSpinner( new SpinnerDateModel() );
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
		timeSpinner.setEditor(timeEditor);
		timeSpinner.setValue(new Date());
		
		clockPanel.add(timeSpinner);
				
		this.add(timePanel);
	}
	
	private void buildButtonPanel() {
		buttonPanel = new JPanel();
		buildSendButton();
		buttonPanel.add(editDateTimeButton);
		this.add(buttonPanel);
	}
	
	public void buildSendButton(){
		editDateTimeButton = new JButton("Edit Date Time"); // reference to the button object
		
		editDateTimeButton.addActionListener(e -> {
			// código para o botão
			int year = 0, month = 0, dayOfMonth = 0, hour = 0, minute = 0, second = 0;
			
			year = datePicker.getModel().getYear();			
			month = datePicker.getModel().getMonth();
			dayOfMonth = datePicker.getModel().getDay();
			
			Date o = (Date) timeSpinner.getValue();

			Calendar cal = Calendar.getInstance();
			cal.setTime(o);
			
			hour = cal.get(Calendar.HOUR_OF_DAY);
			minute = cal.get(Calendar.MINUTE);
			second = cal.get(Calendar.SECOND);
		
			//why not second or why second
			this.clockController.getState().edit(year, month, dayOfMonth, hour, minute,second);
		});			
	}
	
	
	
}
