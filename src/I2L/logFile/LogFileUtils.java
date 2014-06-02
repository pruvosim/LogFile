package I2L.logFile;

import java.io.File;
import java.nio.file.Files;

public class LogFileUtils {
	
	public static void createDirectory(String directory)
	{
		File f = new File(directory);
		//Si le repertoire existe et que c'est bien un repertoire
		if (f.exists() && f.isDirectory()) {
		   System.out.println("Le r�pertoire existe deja");
		}
		else
		{
			boolean success = (new File(directory)).mkdirs();
			if (!success) {
			    // Directory creation failed
				System.out.println("Erreur pendant la cr�ation du r�pertoire");
			}
			else
			{
				System.out.println("Repertoire " + directory + " cr��");
			}
		}
		
		
	}

}
