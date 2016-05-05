package timeout;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import timeout.state.CountingState;
import timeout.state.EditedState;
import timeout.state.PausedState;
import timeout.state.State;
import timeout.state.StoppedState;

public class TimeoutController implements Observer {

	private JLabel timeLeftLabel;
	private Duration timeLeft;
	
	private State stoppedState;
	private State countingState;
	private State pausedState;
	private State editedState;
	
	private State state;
	
	public TimeoutController() {
		this.setTimeLeft(Duration.ofSeconds(0));
		
		this.stoppedState = new StoppedState(this);
		this.countingState = new CountingState(this);
		this.pausedState = new PausedState(this);
		this.editedState = new EditedState(this);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.state.decrement();
	}
	
	public void decrementTimer() {
		this.timeLeft = this.timeLeft.minus(1, ChronoUnit.SECONDS);
		this.timeLeftLabel.setText(this.timeLeft.toString());
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

	public State getCountingState() {
		return countingState;
	}

	public State getPausedState() {
		return pausedState;
	}

	public State getEditedState() {
		return editedState;
	}

}
