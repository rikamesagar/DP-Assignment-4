/**
 *Class to read the input text files line by line using the method readLine()
 */


/**
 *Declaring the package
 */
package maxKVisitors.util;

/**
 *Importing the required java classes
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileProcessor {

	private String file;
	private BufferedReader br;
    /**
     *Method to read the text file line by line
     */

	public FileProcessor(String inputFileIn) {
		file = inputFileIn;
		try {
			br = new BufferedReader(new FileReader(inputFileIn));
		} catch (FileNotFoundException e) {
			//e.printStackTrace();
			System.err.println("File " + inputFileIn + "not found");
			System.exit(1);
		}
	}
	public Integer nextInt() {
		Integer result = null;
		String line = "";
		try {
			line = br.readLine();
			if( line == null){
				return null;
			}
			System.out.println(line);
		} catch (IOException e) {
			//e.printStackTrace();
			System.err.println("Error reading from file");
			System.exit(1);
		}

		try {
			result = Integer.parseInt(line);
		} catch (NumberFormatException e) {
			System.err.println("Invalid number string : " + line);
			//e.printStackTrace();
			System.exit(1);
		}
		return result;
	}
	/*public String readLine(String inputFileIn) {
		String file = inputFileIn;
		try {
			if (in == null) {
				in = new Scanner(new File(file));
			}

			BufferedReader br = new BufferedReader(new FileReader(file));
			try {
				if (br.readLine() == null) {
					System.out.println("File is empty, Please check!");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (in.hasNext()) {
				String curr;
				curr = in.nextLine();
				return curr;
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found, Please check!");
		}
		return null;
	}*/

}
