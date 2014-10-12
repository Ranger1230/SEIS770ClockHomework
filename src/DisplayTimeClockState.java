

public class DisplayTimeClockState implements ClockState {
	
	private SimpleTimer _timer;
	
	public DisplayTimeClockState(SimpleTimer timer){
		_timer = timer;
	}
	
	@Override
	public void Increment() {
			// Do Nothing
	}

	@Override
	public void Decrement() {
		// Do Nothing
	}

	@Override
	public void ChangeMode(SimpleClock simpleClock) {
		simpleClock.SetState(new SetHoursClockState(_timer));
	}

	@Override
	public void Cancel(SimpleClock simpleClock) {
		// Do Nothing
	}

	@Override
	public boolean GetIsEditMode() {
		return false;
	}

	@Override
	public boolean GetIsEditHours() {
		return false;
	}

	@Override
	public boolean GetIsEditMinutes() {
		return false;
	}

	@Override
	public boolean GetIsEditSeconds() {
		return false;
	}
}
