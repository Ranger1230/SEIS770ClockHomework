

public class SetMinutesClockState extends ClockState {

	private SimpleClock _clock;
	
	public SetMinutesClockState(SimpleClock clock){
		_clock = clock;
	}

	@Override
	public void Increment() {
		_clock.addMinute();
	}

	@Override
	public void Decrement() {
		_clock.subtractMinute();
	}

	@Override
	public void ChangeMode() {
		_clock.stopTimer();
		_clock.SetState(new SetSecondsClockState(_clock));
	}

	@Override
	public void Cancel() {
		_clock.SetState(new SetHoursClockState(_clock));
	}

	@Override
	public boolean GetIsEditMinutes() {
		// TODO Auto-generated method stub
		return true;
	}

}
