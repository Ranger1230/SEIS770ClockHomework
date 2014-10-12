
public class SimpleClock {

	private ClockState _currentClockState;
	private Timer _timer;
	
	public SimpleClock() {
		_timer = new Timer();
		_currentClockState = new DisplayTimeClockState(_timer);
	}

	public void SetState(ClockState newState){
		_currentClockState = newState;
	}
	
	public boolean GetIsEdit() {
		return _currentClockState.GetIsEdit();
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
