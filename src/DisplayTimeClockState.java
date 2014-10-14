

public class DisplayTimeClockState implements ClockState {
	
	private SimpleClock _clock;
	
	public DisplayTimeClockState(SimpleClock clock){
		_clock = clock;
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
	public void ChangeMode() {
		_clock.SetState(new SetHoursClockState(_clock));
	}

	@Override
	public void Cancel() {
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
