package clock.state;

import java.time.LocalDateTime;

import javax.swing.JLabel;

import clock.ClockController;
import ui.clock.AnalogClockPanel;
import ui.clock.ClockViewerPanel;
import ui.clock.DigitalClockPanel;

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
		
		ClockViewerPanel clockViewerPanel = this.clockController.getClockPanel().getClockViewerPanel();
		LocalDateTime dt = this.clockController.getDateTime();
		AnalogClockPanel analogClockPanel = clockViewerPanel.getAnalogClockPanel();
		analogClockPanel.rePaint(dt.getSecond(), dt.getMinute(), dt.getHour());
		

		
	}

	public ClockController getClockController() {
		return clockController;
	}

	public void setClockController(ClockController clockController) {
		this.clockController = clockController;
	}

}
