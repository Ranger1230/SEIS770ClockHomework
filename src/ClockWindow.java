import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;


public class ClockWindow {

	private JFrame frame;
	private SimpleClock _simpleClock;
	private Button _increment;
	private Button _decrement;
	private Button _changeMode;
	private Button _cancel;
	private JTextField _hoursText;
	private JTextField _minutesText;
	private JTextField _secondsText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClockWindow window = new ClockWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClockWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		_simpleClock = new SimpleClock();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		SetupChangeModeButton();
		
		SetupIncrementButton();
		
		SetupDecrementButton();
		
		SetupCancelButton();
		
		SetupTimeDisplay();

		UpdateTime();
		
		StartUIRefresher();
	}
	
	private void SetupChangeModeButton(){
		_changeMode = new Button("Change Mode");
		_changeMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_simpleClock.ChangeMode();
				UpdateVisibility();
			}
		});
		_changeMode.setBounds(164, 219, 102, 28);
		frame.getContentPane().add(_changeMode);
	}
	
	private void SetupIncrementButton(){
		_increment = new Button("+");
		_increment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_simpleClock.Increment();
			}
		});
		_increment.setVisible(false);
		_increment.setBounds(31, 219, 31, 28);
		frame.getContentPane().add(_increment);
	}
	
	private void SetupDecrementButton(){
		_decrement = new Button("-");
		_decrement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_simpleClock.Decrement();
			}
		});
		_decrement.setVisible(false);
		_decrement.setBounds(78, 219, 31, 28);
		frame.getContentPane().add(_decrement);
	}

	private void SetupCancelButton(){
		_cancel = new Button("Cancel");
		_cancel.setVisible(false);
		_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_simpleClock.Cancel();
				UpdateVisibility();
			}
		});
		_cancel.setBounds(317, 219, 102, 28);
		frame.getContentPane().add(_cancel);
	}
	
	private void SetupTimeDisplay(){
		_hoursText = new JTextField();
		_hoursText.setHorizontalAlignment(SwingConstants.CENTER);
		_hoursText.setFont(new Font("Lucida Grande", Font.PLAIN, 75));
		_hoursText.setText("00");
		_hoursText.setEditable(false);
		_hoursText.setBounds(6, 89, 137, 85);
		frame.getContentPane().add(_hoursText);
		_hoursText.setColumns(10);
		
		_minutesText = new JTextField();
		_minutesText.setHorizontalAlignment(SwingConstants.CENTER);
		_minutesText.setFont(new Font("Lucida Grande", Font.PLAIN, 75));
		_minutesText.setText("00");
		_minutesText.setEditable(false);
		_minutesText.setBounds(155, 89, 137, 85);
		frame.getContentPane().add(_minutesText);
		_minutesText.setColumns(10);
		
		_secondsText = new JTextField();
		_secondsText.setHorizontalAlignment(SwingConstants.CENTER);
		_secondsText.setFont(new Font("Lucida Grande", Font.PLAIN, 75));
		_secondsText.setText("00");
		_secondsText.setEditable(false);
		_secondsText.setBounds(307, 89, 137, 85);
		frame.getContentPane().add(_secondsText);
		_secondsText.setColumns(10);
	}
	
	private void StartUIRefresher(){
		ActionListener actionListener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				UpdateTime();
			}
		};
		Timer timer = new Timer(100, actionListener);
		timer.start();
	}
	
	private void UpdateTime(){
		long[] currentTime = _simpleClock.GetTime();
		_hoursText.setText(currentTime[0]+"");
		_minutesText.setText(currentTime[1]+"");
		_secondsText.setText(currentTime[2]+"");
	}
	
	private void UpdateVisibility(){
		_increment.setVisible(_simpleClock.GetIsEditMode());
		_decrement.setVisible(_simpleClock.GetIsEditMode());
		_cancel.setVisible(_simpleClock.GetIsEditMode());
		_hoursText.setBorder(BorderFactory.createLineBorder(Color.black));
		_minutesText.setBorder(BorderFactory.createLineBorder(Color.black));
		_secondsText.setBorder(BorderFactory.createLineBorder(Color.black));
		if(_simpleClock.GetIsEditHours()){
			_hoursText.setBorder(BorderFactory.createLineBorder(Color.yellow));
		}else if(_simpleClock.GetIsEditMinutes()){
			_minutesText.setBorder(BorderFactory.createLineBorder(Color.yellow));
		} else if(_simpleClock.GetIsEditSeconds()){
			_secondsText.setBorder(BorderFactory.createLineBorder(Color.yellow));
		}
		
	}
}
