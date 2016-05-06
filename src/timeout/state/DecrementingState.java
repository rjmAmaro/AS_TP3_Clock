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
		this.timeoutController.getPanel().getTimeLeftLabel().setText(this.timeoutController.getTimeAsString());
		this.timeoutController.setState(timeoutController.getStoppedState());
		
		timeoutController.getPanel().hideAndDisablePauseButton();
		timeoutController.getPanel().hideAndDisableStopButton();
		
		timeoutController.getPanel().showAndEnableStartButton();
		timeoutController.getPanel().showAndEnableEditPanel();
	}

	@Override
	public void pause() {
		this.timeoutController.setState(timeoutController.getPausedState());
		
		timeoutController.getPanel().hideAndDisablePauseButton();
		timeoutController.getPanel().showAndEnableStartButton();
	}

	@Override
	public void edit(int hour, int minute, int second) { }

	@Override
	public void decrement() {
		this.timeoutController.decrementTimer();
		this.timeoutController.getPanel().getTimeLeftLabel().setText(this.timeoutController.getTimeAsString());
		if(this.timeoutController.getTimeLeft().isZero()) {
			this.timeoutController.setState(timeoutController.getStoppedState());
			
			timeoutController.getPanel().hideAndDisablePauseButton();
			timeoutController.getPanel().hideAndDisableStopButton();
			
			timeoutController.getPanel().showAndEnableStartButton();
			timeoutController.getPanel().showAndEnableEditPanel();
		}
	}

}
