package calendar.callcounter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.util.Date;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;

public class CalendarUI extends JFrame{
	
	
	
	
	public CalendarUI() {
		createUI();
	}
	
	public void createUI(){
		JButton doneButton = new JButton("Pick");
		setBounds(100, 100, 201, 118);
		getContentPane().setLayout(null);

		Properties p = new Properties();		
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		SpringLayout springLayout = (SpringLayout) datePicker.getLayout();
		springLayout.putConstraint(SpringLayout.SOUTH, datePicker.getJFormattedTextField(), 0, SpringLayout.SOUTH, datePicker);
		datePicker.setBounds(10, 11, 170, 29);
		getContentPane().add(datePicker);
		getContentPane().add(doneButton);
		
		
		doneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date date = (Date) datePicker.getModel().getValue();
				
			}
		});
		doneButton.setBounds(27, 45, 98, 29);
		
	}
	
}
