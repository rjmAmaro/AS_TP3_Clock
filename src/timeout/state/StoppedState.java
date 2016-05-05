package timeout.state;

import timeout.TimeoutController;

public class StoppedState implements State {
	
	private TimeoutController timeoutController;
	
	public StoppedState(TimeoutController timeoutController) {
		this.timeoutController = timeoutController;
	}

	@Override
	public void start() {
		timeoutController.setState(timeoutController.getDecrementingState());
	}

	@Override
	public void stop() { }

	@Override
	public void pause() { }

	@Override
	public void edit(int hour, int minute, int second) {
		this.timeoutController.editTimer(hour, minute, second);
	}

	@Override
	public void decrement() { }

}
