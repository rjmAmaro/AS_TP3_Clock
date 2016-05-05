package timeout.state;

import java.time.Duration;

import timeout.TimeoutController;

public class DecrementingState implements State {

	private TimeoutController timeoutController;
	
	public DecrementingState(TimeoutController timeoutController) {
		this.timeoutController = timeoutController;
	}
	
	@Override
	public void start() { }

	@Override
	public void stop() {
		this.timeoutController.resetTimer();
		this.timeoutController.setState(timeoutController.getStoppedState());
	}

	@Override
	public void pause() {
		this.timeoutController.setState(timeoutController.getPausedState());
	}

	@Override
	public void edit(int hour, int minute, int second) { }

	@Override
	public void decrement() {
		this.timeoutController.decrementTimer();
	}

}
