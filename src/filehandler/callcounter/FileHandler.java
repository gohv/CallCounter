package filehandler.callcounter;

import java.util.Date;

import javax.swing.JOptionPane;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;


public class FileHandler {
	Date date = new Date();

	String getDate = date.toString();

	public void save(String save) throws FileNotFoundException, IOException {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("CSV/calls.csv", true)))) {

			writer.write(getDate + " - ");
			writer.write(save);
			writer.write("\n");
		}
	}

	public void openFile() {

		try {

			Desktop.getDesktop().open(new java.io.File("CSV/calls.csv"));
		} catch (IOException e) {

			JOptionPane.showMessageDialog(null, "No file Found! Check File!", "File Not Found!",
					JOptionPane.ERROR_MESSAGE, null);
		}

	}

}
