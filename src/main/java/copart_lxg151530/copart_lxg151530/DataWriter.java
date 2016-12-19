package copart_lxg151530.copart_lxg151530;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DataWriter {
	public static void write(String filename, String lines) {
		try {			
			File file = new File(filename);
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(lines);
			bw.close();
			//System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
