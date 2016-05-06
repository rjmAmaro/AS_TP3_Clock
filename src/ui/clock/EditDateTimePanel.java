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
	
	private JLabel subTitle;
	
	private JPanel datePanel;
	private JPanel timePanel;
	private JPanel buttonPanel;
	
	private JButton editDateTimeButton;
	
	private JSpinner timeSpinner;
	private JDatePickerImpl datePicker;
	
	EditDateTimePanel(ClockDriver clockDriver, ClockController clockController, ClockPanel clockPanel){
		super();
		this.setLayout(new GridLayout(4, 1));
		this.clockDriver = clockDriver;
		this.clockController = clockController;
		this.clockPanel = clockPanel;
		buildUI();
	}
	
	private void buildUI() {
		subTitle = new JLabel("Edit Date-Time");
		this.add(subTitle);
		
		buildDatePanel();
		buildTimePanel();
		buildButtonPanel();
	}
	
	private void buildDatePanel() {
		datePanel = new JPanel();
		// adicionar os elementos referentes à data ao datePanel
		
		// Adicionar código aqui
		
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
		
		// FIM
		
		this.add(datePanel);
	}

	private void buildTimePanel() {
		timePanel = new JPanel();
		// adicionar os elementos referentes ao tempo ao timePanel
		
		// Adicionar código aqui
		
		timeSpinner = new JSpinner( new SpinnerDateModel() );
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
		timeSpinner.setEditor(timeEditor);
		timeSpinner.setValue(new Date());
		
		clockPanel.add(timeSpinner);
		
		// FIM
		
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
			int year = 0, month = 0, dayOfMonth = 0, hour = 0, minute = 0;
			
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
			
			// no final, invoca este método para editar a data-hora
			this.clockController.getState().edit(year, month, dayOfMonth, hour, minute);
		});			
	}
	
	
	
}
