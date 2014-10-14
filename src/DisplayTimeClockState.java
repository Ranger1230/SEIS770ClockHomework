

public class DisplayTimeClockState extends ClockState {
	
	private SimpleClock _clock;
	
	public DisplayTimeClockState(SimpleClock clock){
		_clock = clock;
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
}
