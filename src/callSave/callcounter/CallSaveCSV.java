package callSave.callcounter;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;

public class CallSaveCSV {
	Date date = new Date();
	
	String getDate = date.toString();
	
	public void save(String save) throws FileNotFoundException, IOException {

		try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("CSV/calls.txt", true))))
		{
			
				writer.write(getDate + " - ");
				writer.write(save);
				writer.write("\n");
			
		}

	}

}
