package maxKVisitors.driver;

import java.io.IOException;

import maxKVisitors.util.FileProcessor;
/**
 * Importing the required files from the package
 */
import maxKVisitors.util.MyVector;
import maxKVisitors.util.MyArray;
import maxKVisitors.util.PopulateVisitor;
import maxKVisitors.util.MaxHeapVisitor;
import maxKVisitors.util.ModifiedBubbleSortVisitor;
import maxKVisitors.util.Visitable;
import maxKVisitors.util.Visitor;
import maxKVisitors.util.MyLogger;
import maxKVisitors.util.Results;

/**
 * Driver class containing the main()
 */

public class Driver {

	public static void main(String args[]) {
		if( args.length != 3){
			System.err.println("Please enter 3 arguments");
			System.exit(1);
		}

		int k = 0;
		try{
			k = Integer.parseInt( args[1]);
		}catch (Exception e){

			System.err.println("invalid format of K.");
			System.exit(1);
		}

		if(args[0].equals("")) {
			System.err.println(" filename is empty.");
			System.exit(1);
		}

		int debugValue = 0;
		if(args.length == 3) {
			try {
				debugValue = Integer.parseInt(args[2]);
			} catch (NumberFormatException e) {

				System.out.println("DEBUG_VALUE is not a number." + " Range of DEBUG_VALUE is 0 to 2");
				return;
			}
			if(debugValue < 0 || debugValue > 2) {
				System.out.println("Invalid range. Range of DEBUG_VALUE is 0 to 2");
				return;
			}

		}
/**
 * Objects for various classes declared and used
 */
		System.out.println("Debug Value is "+ debugValue);
		MyLogger.setDebugValue(debugValue);
		Results output = new Results(args[2]);
		FileProcessor fp = new FileProcessor(args[0]);
		Visitor populateVisitor = null;
		populateVisitor = new PopulateVisitor(fp); //, new FileProcessor(args[1]));

		Visitable vector = new MyVector();
		Visitable array = new MyArray();

		//Visitor maxHeapVisitor = new MaxHeapVisitor(k);
		Visitor bubbleSortVisitor = new ModifiedBubbleSortVisitor(k);

		vector.accept(populateVisitor);

		fp = new FileProcessor(args[0]);
		populateVisitor = new PopulateVisitor(fp);
		array.accept(populateVisitor);

		//vector.accept(maxHeapVisitor);
		//array.accept(maxHeapVisitor);

		vector.accept(bubbleSortVisitor);
		array.accept(bubbleSortVisitor);
	}
}