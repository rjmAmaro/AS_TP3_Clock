package timeout.state;

public interface State {
	public void start();
	public void decrement();
	public void stop();
	public void pause();
	public void edit(int hour, int minute, int second);
}
