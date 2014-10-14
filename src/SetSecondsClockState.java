

public class SetSecondsClockState extends ClockState {


	private SimpleClock _clock;
	
	public SetSecondsClockState(SimpleClock clock){
		_clock = clock;
	}

	@Override
	public void Increment() {
		_clock.addSecond();
	}

	@Override
	public void Decrement() {
		_clock.subtractSecond();
	}

	@Override
	public void ChangeMode() {
		_clock.startTimer();
		_clock.SetState(new DisplayTimeClockState(_clock));
	}

	@Override
	public void Cancel() {
		_clock.startTimer();
		_clock.SetState(new SetMinutesClockState(_clock));
	}
	
	@Override
	public boolean GetIsEditSeconds() {
		// TODO Auto-generated method stub
		return true;
	}

}
