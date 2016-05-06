package clock.state;

import java.util.Date;

import javax.swing.JTextField;

import clock.ClockController;
import driver.ClockDriver;
import ui.clock.ClockPanel;

public class AnalogState implements State{

	private ClockController clockController;
	
	public AnalogState(ClockController clockController){
		this.clockController = clockController;
	}
	
	@Override
	public void digital() {
		
		clockController.setState(clockController.getDigitalState());
		

	}

	@Override
	public void analog() {	
		
	}
	
	@Override
	public void edit(Date datetime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void count() {
		// TODO Auto-generated method stub
		
	}

	

	public ClockController getClockController() {
		return clockController;
	}

	public void setClockController(ClockController clockController) {
		this.clockController = clockController;
	}

}
