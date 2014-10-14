

public abstract class ClockState {
	boolean GetIsEditMode(){
		return true;
	}
	boolean GetIsEditHours(){
		return false;
	}
	boolean GetIsEditMinutes(){
		return false;
	}
	boolean GetIsEditSeconds(){
		return false;
	}
	void Increment(){ }
	void Decrement(){ }
	void ChangeMode(SimpleClock simpleClock){ }
	void Cancel(SimpleClock simpleCLock){ }
}
