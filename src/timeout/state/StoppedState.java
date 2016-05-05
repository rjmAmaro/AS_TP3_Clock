package timeout.state;

import timeout.TimeoutController;

public class StoppedState implements State {
	
	private TimeoutController timeoutController;
	
	public StoppedState(TimeoutController timeoutController) {
		this.timeoutController = timeoutController;
	}

	@Override
	public void start() {
		timeoutController.setState(timeoutController.getCountingState());
	}

	@Override
	public void stop() { }

	@Override
	public void pause() { }

	@Override
	public void edit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decrement() { }

}
