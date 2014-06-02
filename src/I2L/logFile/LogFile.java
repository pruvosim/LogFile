package I2L.logFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class LogFile {

	private String name;
	private String filename;
	private String encoding;
	ArrayList<String> lines;

	public LogFile(String name, String filename)
	{
		this.name = name;
		this.filename = filename;
		encoding = "UTF-8";
		lines = new ArrayList<String>();
	}

	public LogFile(String name, String filename, String encoding)
	{
		this.name = name;
		this.filename = filename;
		this.encoding = encoding;
		lines = new ArrayList<String>();
	}

	public static LogFile createNewLogFile(String name, String filename)
	{
		LogFile lf = new LogFile(name, filename);
		Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
		lf.lines.add(lf.encoding);
		lf.lines.add("Log File created on " + localCalendar.getTime());
		return lf;
	}

	public static LogFile createNewLogFile(String name, String filename, String encoding)
	{
		LogFile lf = new LogFile(name, filename, encoding);
		Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());
		lf.lines.add(encoding);
		lf.lines.add("Log File created on" + localCalendar.getTime());
		return lf;
	}

	public void addToLogFile(String message)
	{
		lines.add(message);
	}

	public boolean saveLogFile() throws FileNotFoundException, UnsupportedEncodingException
	{
		PrintWriter writer = new PrintWriter(filename, encoding);
		for (String line : lines) {
			writer.println(line);
		}
		writer.close();

		return true;
	}

	public static LogFile loadLogFile(String filename) throws IOException
	{
		LogFile lf = new LogFile("", filename);
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line = br.readLine();
		lf.setEncoding(line);
		while (line != null) {
			line = br.readLine();
			lf.addToLogFile(line);
		}
		br.close();
		System.out.println("Fichier " + filename + " bien chargé");
		return lf;
	}
	
	public void displayLog()
	{
		System.out.println("Fichier de log " + name + " ( " + filename + " )");
		System.out.println("Encoding : " + encoding);
		for (String line : lines) {
			System.out.println(line);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	

}
