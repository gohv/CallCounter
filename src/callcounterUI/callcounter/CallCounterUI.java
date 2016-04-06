package callcounterUI.callcounter;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;


/**
 * @author georgi.hristov
 *
 */
public class CallCounterUI extends JFrame {

	/**
	 * 
	 * Will add a date chooser and CallCounter will be able to save the ammount of calls for each day
	 *
	 */
	
	private static final long serialVersionUID = 1L;
	CallCounterUI() {

		createUI();
	}
	
	private JButton count = new JButton("Count Call");
	private JTextField counterField = new JTextField();
	private int countCalls = 0;
	private String parser;
	private JButton resetButton = new JButton("Reset Counter");
	private void createUI() {
		// Main Frame
		setTitle("Call Counter");
		setBounds(100, 100, 230, 177);
		getContentPane().setLayout(null);

		// Button
		getContentPane().add(count);
		count.setBounds(28, 57, 145, 38);
		count.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				countCalls++;
				parser = Integer.toString(countCalls);
				counterField.setText(parser);
				
			}
		});
		// Field
		counterField.setSize(145, 45);
		counterField.setLocation(28, 11);
		getContentPane().add(counterField);
		counterField.setEditable(false);
		
		
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				counterField.setText(" ");
				countCalls = 0;
			}
		});
		resetButton.setBounds(28, 95, 145, 32);
		getContentPane().add(resetButton);

	}
}
