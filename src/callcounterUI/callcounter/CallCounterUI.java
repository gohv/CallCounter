package callcounterUI.callcounter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import countcalls.callcounter.CountCalls;
import calendar.callcounter.CalendarUI;
import filehandler.callcounter.*;

/**
 * @author georgi.hristov
 *
 */
public class CallCounterUI extends JFrame {

	/**
	 * 
	 * DONE : Make separate class for countCalls; 
	 * TO DO: Try to add a timer
	 */

	private static final long serialVersionUID = 1L;

	CallCounterUI() {

		createUI();
	}

	private JButton count = new JButton("Count Call");
	private JTextField counterField = new JTextField();
	private JButton resetButton = new JButton("Reset Counter");
	private JButton calendarButton = new JButton("Calendar");
	private JButton endDayButton = new JButton("End Day!");
	FileHandler save = new FileHandler();
	CountCalls counter = new CountCalls();
	private void createUI() {

		// Main Frame
		setTitle("Call Counter");
		setBounds(100, 100, 331, 189);

		getContentPane().setLayout(null);

		// Button

		getContentPane().add(count);
		count.setBounds(28, 57, 145, 38);
		count.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				counter.count();
				counterField.setText(counter.getParser());

			}
		});
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				counterField.setText(" ");				
				counter.getCountCalls();
				endDayButton.setEnabled(false);
			}
		});
		resetButton.setBounds(28, 95, 145, 32);
		getContentPane().add(resetButton);

		calendarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalendarUI calendar = new CalendarUI();
				calendar.setVisible(true);
			}
		});

		calendarButton.setBounds(183, 11, 89, 32);

		getContentPane().add(calendarButton);

		endDayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					JOptionPane.showMessageDialog(null, "Saved! Day Completed!", "File Saved",
							JOptionPane.INFORMATION_MESSAGE, null);

					save.save(" Calls Made: " + counter.getParser());

				} catch (IOException e) {

					JOptionPane.showMessageDialog(null, "No file Found! Check File!", "File Not Found!",
							JOptionPane.ERROR_MESSAGE, null);
				}

			}
		});
		endDayButton.setBounds(185, 60, 89, 32);
		updateButton();
		getContentPane().add(endDayButton);
		
		JButton openFileButton = new JButton("Open");
		openFileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				save.openFile();
			}
		});
		
		openFileButton.setBounds(185, 95, 87, 32);
		getContentPane().add(openFileButton);

		// Field
		counterField.setSize(145, 45);
		counterField.setLocation(28, 11);
		getContentPane().add(counterField);
		counterField.setEditable(false);

		
		counterField.getDocument().addDocumentListener(new DocumentListener() {
			// disable EndOfDayButton if not calls are counter.
			@Override
			public void removeUpdate(DocumentEvent e) {
				updateButton();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				updateButton();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				updateButton();
			}
		});
	}

	// disable method:
	private void updateButton() {
		String getText = counterField.getText();
		if (getText == null || getText.length() == 0) {
			endDayButton.setEnabled(false);
			return;
		}

		endDayButton.setEnabled(true);

	}
}
