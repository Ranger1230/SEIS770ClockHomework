

public interface ClockState {
	boolean GetIsEditMode();
	boolean GetIsEditHours();
	boolean GetIsEditMinutes();
	boolean GetIsEditSeconds();
	void Increment();
	void Decrement();
	void ChangeMode();
	void Cancel();
}
