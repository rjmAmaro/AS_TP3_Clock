package ui.clock;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import clock.ClockController;
import driver.ClockDriver;

public class ClockViewerPanel {

	private ClockPanel clockPanel;
	private ClockDriver clockDriver;
	private ClockController clockController;
	
	
	private JTextField digitalField;
	
	public ClockViewerPanel(ClockPanel clockPanel) {
		
		this.clockPanel = clockPanel;
		
	}
	
	public void build(ClockController clockController, ClockDriver clockDriver){

		this.clockController = clockController;
		this.clockDriver = clockDriver;

		clockTypeButton();
		initiateDigitalClock();
		
	}
	
	
	public void clockTypeButton(){
		
		JButton clockType = new JButton("Go to Analog Clock Timer"); // reference to the button object
		
		clockType.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//if state is x go to y else go to z
				//make state change the curse of events
				clockType.setText("Go to Digital Clock Timer");
					
			}
		});			
		
		clockPanel.add(clockType);
	}
	
	
	
	
	
	public void initiateAnalogClock(){
		
		
		
		
	}
	
	private void initiateDigitalClock(){
		
		digitalField = new JTextField();
		digitalField.setText(clockDriver.getTime().toString());

		clockPanel.add(digitalField);
		
		clockController.getAnalogState().digital();

	}
	
	public JTextField getDigitalField() {
		return digitalField;
	}

	public void setDigitalField(JTextField digitalField) {
		this.digitalField = digitalField;
	}

	
	
	
	
	
	
}