

public class SetHoursClockState implements ClockState {
	
	private SimpleClock _clock;
	
	public SetHoursClockState(SimpleClock clock) {
		_clock = clock;
	}

	@Override
	public void Increment() {
		_clock.addHour();
	}

	@Override
	public void Decrement() {
		_clock.subtractHour();
	}

	@Override
	public void ChangeMode() {
		_clock.SetState(new SetMinutesClockState(_clock));
	}

	@Override
	public void Cancel() {
		_clock.SetState(new DisplayTimeClockState(_clock));
	}

	@Override
	public boolean GetIsEditMode() {
		return true;
	}

	@Override
	public boolean GetIsEditHours() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean GetIsEditMinutes() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean GetIsEditSeconds() {
		// TODO Auto-generated method stub
		return false;
	}

}
