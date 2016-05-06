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
		
		timeoutController.getPanel().hideAndDisableStartButton();
		
		timeoutController.getPanel().showAndEnablePauseButton();
		timeoutController.getPanel().showAndEnableStopButton();
	}

	@Override
	public void stop() {
		this.timeoutController.setTimeLeft(Duration.ofSeconds(0));
		this.timeoutController.getPanel().getTimeLeftLabel().setText(this.timeoutController.getTimeAsString());
		this.timeoutController.setState(this.timeoutController.getStoppedState());
		
		timeoutController.getPanel().hideAndDisableStopButton();
		
		timeoutController.getPanel().showAndEnableEditPanel();
	}

	@Override
	public void pause() { }

	@Override
	public void edit(int hour, int minute, int second) { }

	@Override
	public void decrement() { }

}
