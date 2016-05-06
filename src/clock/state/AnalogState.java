package clock.state;

import clock.ClockController;

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
	public void analog() { }
	
	@Override
	public void edit(int year, int month, int dayOfMonth, int hour, int minute) {
		this.clockController.editCurrentDateTime(year, month, dayOfMonth, hour, minute);
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}

	public ClockController getClockController() {
		return clockController;
	}

	public void setClockController(ClockController clockController) {
		this.clockController = clockController;
	}

}
