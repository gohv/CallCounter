package filehandler.callcounter;

import java.util.Date;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;


public class FileHandler {
	Date date = new Date();		
	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
	String getDate = DATE_FORMAT.format(date);
	
	

	public void save(String save) throws FileNotFoundException, IOException {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("CSV/calls.csv", true)))) {

			writer.write(getDate + " - ");
			writer.write(save);
			writer.write("\n");
		}
	}

	public void openFile() {

		try {
			// this can blow up hard......
			Desktop.getDesktop().open(new java.io.File("CSV/calls.csv"));
			
		} catch (IOException e) {

			System.err.println("Cannot open File!");
					
		}

	}

}
