package timeout;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import timeout.state.DecrementingState;
import timeout.state.PausedState;
import timeout.state.State;
import timeout.state.StoppedState;
import ui.timeout.TimeoutPanel;

public class TimeoutController implements Observer {

	private TimeoutPanel panel;
	private Duration timeLeft;
	
	private State stoppedState;
	private State decrementingState;
	private State pausedState;
	
	private State state;
	
	public TimeoutController() {
		this.timeLeft = Duration.ofSeconds(0);
		
		this.stoppedState = new StoppedState(this);
		this.decrementingState = new DecrementingState(this);
		this.pausedState = new PausedState(this);
		
		this.state = this.stoppedState;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.state.decrement();
	}
	
	public void decrementTimer() {
		this.timeLeft = this.timeLeft.minus(1, ChronoUnit.SECONDS);
		panel.getTimeLeftLabel().setText(this.timeLeft.toString());
	}
	
	public void editTimer(int hour, int minute, int second) {
		int totalSeconds = hour * 3600 + minute * 60 + second;
		this.timeLeft = Duration.ofSeconds(totalSeconds);
	}

	public TimeoutPanel getPanel() {
		return this.panel;
	}

	public void setPanel(TimeoutPanel panel) {
		this.panel = panel;
	}

	public Duration getTimeLeft() {
		return timeLeft;
	}

	public void setTimeLeft(Duration timeLeft) {
		this.timeLeft = timeLeft;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public State getStoppedState() {
		return stoppedState;
	}

	public State getDecrementingState() {
		return decrementingState;
	}

	public State getPausedState() {
		return pausedState;
	}

}
