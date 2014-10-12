import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;

import java.awt.Button;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


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
		
		_changeMode = new Button("Change Mode");
		_changeMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				_simpleClock.ChangeMode();
				UpdateVisibility();
			}
		});
		_changeMode.setBounds(164, 219, 102, 28);
		frame.getContentPane().add(_changeMode);
		
		_increment = new Button("+");
		_increment.setVisible(false);
		_increment.setBounds(31, 219, 31, 28);
		frame.getContentPane().add(_increment);
		
		_decrement = new Button("-");
		_decrement.setVisible(false);
		_decrement.setBounds(78, 219, 31, 28);
		frame.getContentPane().add(_decrement);
		
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
	
	private void UpdateVisibility(){
		_increment.setVisible(_simpleClock.GetIsEdit());
		_decrement.setVisible(_simpleClock.GetIsEdit());
		_cancel.setVisible(_simpleClock.GetIsEdit());
	}
}
