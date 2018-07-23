package maxKVisitors.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import maxKVisitors.util.MyLogger;

/**
 * FileProcessor Class to read the input file
 */
public class FileProcessor {

	private MyLogger logger;
	private BufferedReader br;

	private String InputFile = null;

	/**
	 * Constructor for FileProcessor
	 * @param InputFileIn to pass the input file from the command line argument
	 */
	public FileProcessor(String InputFileIn){
		MyLogger.writeMessage("Constructor for File processor called",logger.convertToDebugVal(2));

		InputFile = InputFileIn;
		try {
			br = new BufferedReader(new FileReader(InputFile));
		}
		catch (FileNotFoundException e) {
			System.out.println("Error Occured: Reading from the file failed");
			System.exit(1);
		}
	}

	/**
	 * nextInt method to read the file line by line as Integers
	 * @return the number read from each line in int format
	 */
	public Integer nextInt() {
		MyLogger.writeMessage("Reading integer line by line using nextInt()",logger.convertToDebugVal(2));
		Integer result = null;
		String line = "";
		try{
			line = br.readLine();
			if(line == null)
				return null;
		}
		catch (IOException e){
			System.err.println("Error reading from file");
			System.exit(1);
		}
		try {
			result = Integer.parseInt(line);
		}
		catch (NumberFormatException e) {
			System.err.println("Error Occured! Number invalid");
			System.exit(1);
		}
		return result;
	}
}