package clock.state;

import java.util.Date;

import javax.swing.JTextField;

import clock.ClockController;
import driver.ClockDriver;
import ui.clock.ClockPanel;

public class DigitalState implements State{
	
	private ClockController clockController;
	
	public DigitalState(ClockController clockController){
		
		this.clockController = clockController;
		
	}
	
	
	@Override
	public void analog() {
		
		clockController.setState(clockController.getAnalogState());
		
	}

	@Override
	public void digital() {
		
		
		
	}

	@Override
	public void edit(Date datetime) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void refresh() {
		//ClockPanel clockPanel = clockController.getClockPanel();
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	public ClockController getClockController() {
		return clockController;
	}

	public void setClockController(ClockController clockController) {
		this.clockController = clockController;
	}
	
	
	

}
