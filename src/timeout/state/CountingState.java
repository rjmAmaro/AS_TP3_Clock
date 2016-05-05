package timeout.state;

import timeout.TimeoutController;

public class CountingState implements State {

	private TimeoutController timeoutController;
	
	public CountingState(TimeoutController timeoutController) {
		this.timeoutController = timeoutController;
	}
	
	@Override
	public void start() { }

	@Override
	public void stop() {
		this.timeoutController.setState(timeoutController.getStoppedState());
	}

	@Override
	public void pause() {
		this.timeoutController.setState(timeoutController.getPausedState());
	}

	@Override
	public void edit() { }

	@Override
	public void decrement() {
		this.timeoutController.decrementTimer();
	}

}
