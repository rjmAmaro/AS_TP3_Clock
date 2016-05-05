package timeout.state;

import java.time.Duration;

import timeout.TimeoutController;

public class PausedState implements State {
	
	private TimeoutController timeoutController;
	
	public PausedState(TimeoutController timeoutController) {
		this.timeoutController = timeoutController;
	}

	@Override
	public void start() {
		this.timeoutController.setState(this.timeoutController.getDecrementingState());
	}

	@Override
	public void stop() {
		this.timeoutController.setTimeLeft(Duration.ofSeconds(0));
		this.timeoutController.setState(this.timeoutController.getStoppedState());
	}

	@Override
	public void pause() { }

	@Override
	public void edit(int hour, int minute, int second) { }

	@Override
	public void decrement() { }

}
