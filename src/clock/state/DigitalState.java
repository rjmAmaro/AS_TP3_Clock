package clock.state;

import clock.ClockController;

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
	public void digital() { }

	@Override
	public void edit(int year, int month, int dayOfMonth, int hour, int minute) {
		this.clockController.editCurrentDateTime(year, month, dayOfMonth, hour, minute);
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
