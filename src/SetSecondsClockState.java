

public class SetSecondsClockState implements ClockState {


	private SimpleTimer _timer;
	
	public SetSecondsClockState(SimpleTimer timer){
		_timer = timer;
	}

	@Override
	public void Increment() {
		_timer.addSecond();
	}

	@Override
	public void Decrement() {
		_timer.subtractSecond();
	}

	@Override
	public void ChangeMode(SimpleClock simpleClock) {
		_timer.start();
		simpleClock.SetState(new DisplayTimeClockState(_timer));
	}

	@Override
	public void Cancel(SimpleClock simpleClock) {
		_timer.start();
		simpleClock.SetState(new SetMinutesClockState(_timer));
	}

	@Override
	public boolean GetIsEditMode() {
		return true;
	}

	@Override
	public boolean GetIsEditHours() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean GetIsEditMinutes() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean GetIsEditSeconds() {
		// TODO Auto-generated method stub
		return true;
	}

}
