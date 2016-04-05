package callcounterUI.callcounter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import main.callcounter.*;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class CallCounterUI extends JFrame {

	CallCounterUI() {

		createUI();
	}
	
	private JButton count = new JButton("Count Call");
	private JTextField counterField = new JTextField();
	private int countCalls = 0;
	private String parser;
	
	private void createUI() {
		// Main Frame
		setTitle("Call Counter");
		setBounds(100, 100, 166, 157);
		getContentPane().setLayout(null);

		// Button
		getContentPane().add(count);
		count.setBounds(12, 59, 124, 38);
		count.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				countCalls++;
				parser = Integer.toString(countCalls);
				counterField.setText(parser);
				
			}
		});

		counterField.setSize(124, 45);
		counterField.setLocation(12, 13);
		add(counterField);
		

	}
}
