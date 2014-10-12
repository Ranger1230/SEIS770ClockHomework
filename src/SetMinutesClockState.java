

public class SetMinutesClockState implements ClockState {


	private Timer _timer;
	
	public SetMinutesClockState(Timer timer){
		_timer = timer;
	}

	@Override
	public void Increment() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Decrement() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ChangeMode(SimpleClock simpleClock) {
		simpleClock.SetState(new SetSecondsClockState(_timer));
	}

	@Override
	public void Cancel(SimpleClock simpleClock) {
		simpleClock.SetState(new SetHoursClockState(_timer));
	}

	@Override
	public boolean GetIsEdit() {
		return true;
	}

}
