


public class SimpleClock {

	private ClockState _currentClockState;
	private SimpleTimer _timer;
	
	public SimpleClock() {
		_timer = new SimpleTimer();
		_currentClockState = new DisplayTimeClockState(_timer);
	}

	public void SetState(ClockState newState){
		_currentClockState = newState;
	}
	
	public boolean GetIsEditMode() {
		return _currentClockState.GetIsEditMode();
	}
	
	public boolean GetIsEditHours() {
		return _currentClockState.GetIsEditHours();
	}
	
	public boolean GetIsEditMinutes() {
		return _currentClockState.GetIsEditMinutes();
	}
	
	public boolean GetIsEditSeconds() {
		return _currentClockState.GetIsEditSeconds();
	}
	
	public int[] GetTime(){
		return new int[]{0,2, 21};
	}

	public void Increment() {
		_currentClockState.Increment();
	}

	public void Decrement() {
		_currentClockState.Decrement();
	}

	public void ChangeMode() {
		_currentClockState.ChangeMode(this);
	}

	public void Cancel() {
		_currentClockState.Cancel(this);
	}
}
