package I2L.logFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		LogFileUtils.createDirectory("C:/temp");
		
		/*LogFile lf = LogFile.createNewLogFile("log", "C:/temp/log.txt", "UTF-8");
		lf.addToLogFile("test de ligne dans le fichier de log");
		lf.saveLogFile();
		*/
		
		LogFile lf = LogFile.loadLogFile("C:/temp/log.txt");
		lf.displayLog();

	}

}
