package clock.state;

import java.time.LocalDateTime;

import javax.swing.JLabel;

import clock.ClockController;
import ui.clock.ClockViewerPanel;
import ui.clock.DigitalClockPanel;

public class DigitalState implements State{
	
	private ClockController clockController;
	
	public DigitalState(ClockController clockController){
		this.clockController = clockController;
	}
	
	@Override
	public void analog() {
		clockController.setState(clockController.getAnalogState());
		clockController.getClockPanel().getClockViewerPanel().changeClockToAnalog();
	}

	@Override
	public void digital() { }

	@Override
	public void edit(int year, int month, int dayOfMonth, int hour, int minute) {
		this.clockController.editCurrentDateTime(year, month, dayOfMonth, hour, minute);
	}

	@Override
	public void refresh() {
		
		ClockViewerPanel clockViewerPanel = this.clockController.getClockPanel().getClockViewerPanel();
		LocalDateTime dt = this.clockController.getDateTime();
		DigitalClockPanel dp = clockViewerPanel.getDigitalClockPanel();
		JLabel dtl = dp.getDateTimeLabel();
		dtl.setText(dt.toString());
	}

	public ClockController getClockController() {
		return clockController;
	}

	public void setClockController(ClockController clockController) {
		this.clockController = clockController;
	}

}
