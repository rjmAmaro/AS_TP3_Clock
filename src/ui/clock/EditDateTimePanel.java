package ui.clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private ClockDriver clockDriver;
	private ClockController clockController;
	
	private JLabel subTitle;
	
	private JSpinner timeSpinner;
	private JDatePickerImpl datePicker;
	
	EditDateTimePanel(ClockPanel clockPanel){
		super();
		this.clockPanel = clockPanel;
		buildUI();
	}
	
	public void build(ClockController clockController, ClockDriver clockDriver){
		this.clockController = clockController;
		this.clockDriver = clockDriver;
	}
	
	private void buildUI() {
		subTitle = new JLabel("Change time");
		this.add(subTitle);
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
		datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
		clockPanel.add(datePicker);
		
		
	}

	private void editTimePanel() {
		
		timeSpinner = new JSpinner( new SpinnerDateModel() );
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
				System.out.println(datePicker.getModel().getYear());
				System.out.println(datePicker.getModel().getMonth());
				System.out.println(datePicker.getModel().getDay());
				
				Date o = (Date) timeSpinner.getValue();

				Calendar cal = Calendar.getInstance();
				cal.setTime(o);  
				
				int hours = cal.get(Calendar.HOUR_OF_DAY);
				int minutes = cal.get(Calendar.MINUTE);
				int seconds = cal.get(Calendar.SECOND);
				System.out.println(hours);
				System.out.println(minutes);
				System.out.println(seconds);
				
				

				
			}
		});			
		
		clockPanel.add(datetimeChange);
		
	}
	
	
	
}
