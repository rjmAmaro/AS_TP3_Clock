package clock;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import clock.state.AnalogState;
import clock.state.DigitalState;
import clock.state.State;
import driver.ClockDriver;
import ui.clock.ClockPanel;

public class ClockController implements Observer {
	
	JLabel label;

	private State analogState;
	private State digitalState;
	private State state;
	
	private ClockDriver clockDriver;
	private ClockPanel clockPanel;
	
	
	public ClockController(){
		analogState = new AnalogState(this);
		digitalState = new DigitalState(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.clockDriver = (ClockDriver) o;
		
		label.setText(clockDriver.getTime().toString());
	}
	
	
	public State getAnalogState() {
		return analogState;
	}

	public void setAnalogState(State analogState) {
		this.analogState = analogState;
	}

	public State getDigitalState() {
		return digitalState;
	}

	public void setDigitalState(State digitalState) {
		this.digitalState = digitalState;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	
	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public ClockDriver getClockDriver() {
		return clockDriver;
	}

	public void setClockDriver(ClockDriver clockDriver) {
		this.clockDriver = clockDriver;
	}

	public ClockPanel getClockPanel() {
		return clockPanel;
	}

	public void setClockPanel(ClockPanel clockPanel) {
		this.clockPanel = clockPanel;
	}
	
	
	
}
