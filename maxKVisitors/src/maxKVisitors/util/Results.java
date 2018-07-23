/**
 *Class to print out the output to respective files
 */

package maxKVisitors.util;


/**
 * Results class to print results to the console
 */

public class Results implements StdoutDisplayInterface {

	private MyLogger logger;
	private String text;
	private String outputFileName = null;

	/**
	 * Constructor for results class
	 * @param loggerIn
	 */
	public Results(MyLogger loggerIn){
		MyLogger.writeMessage("Constructor for Results called",logger.convertToDebugVal(2));
		text = null;
		this.outputFileName = null;
	}

	public Results(String name){
		text = "";
		this.outputFileName = name;
	}

	public void printToStdout(String s){
		System.out.println(s);
	}
}
