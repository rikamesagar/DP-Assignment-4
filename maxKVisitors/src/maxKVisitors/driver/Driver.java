/**
 *This file contains the main method
 *It creates the instance of TreeBuilder and Results
 */

package driver;

/**
 *Importing TreeBuilder and Results from respective packages
 */
import util.TreeBuilder;
import util.Results;
import util.FileProcessor;
import myTree.Node;

public class Driver{

	public static void main(String[] args) {


        /**
         *String Variables for the files red from the command line arguments
         */
		String inputFile = null;
		String deleteFile = null;
		String output1;
		String output2;
		String output3;

        /**
         *Code to check the files if/ if not passed through arguments
         */
		try {
			inputFile = args[0];
			if (!(inputFile.equals("input.txt"))) {
				System.out.println("Input File not found, please check!");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("Output File not Found, please check!");
			System.exit(0);
		}
		try {
			deleteFile = args[1];
			if (!(deleteFile.equals("delete.txt"))) {
				System.out.println("Delete File not found, please check!");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("No file present to delete values from Nodes");
			System.exit(0);
		}
		try {
			output1 = args[2];
			if (!(output1.equals("output1.txt"))) {
				System.out.println("No Output File found, please check!");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("Output File not found, please check");
			System.exit(0);
		}
		try {
			output2 = args[3];
			if (!(output2.equals("output2.txt"))) {
				System.out.println("Output File not found, please check");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("Output File not found, please check!");
			System.exit(0);
		}
		try {
			output3 = args[4];
			if (!(output3.equals("output3.txt"))) {
				System.out.println("Output File not found, please check");
				System.exit(0);
			}
		} catch (Exception e) {
			System.out.println("Output File not found, please check");
			System.exit(0);
		}

        /**
         *TreeBuilder and Results objects created and respective methods called
         */
        String line, course;
        int bNumber;
        // File Processors
        FileProcessor inputFileProcessor = new FileProcessor();
        FileProcessor deleteFileProcessor = new FileProcessor();

        // TreeBuilder objects
        TreeBuilder tree = new TreeBuilder();
        TreeBuilder backup1 = new TreeBuilder();
        TreeBuilder backup2 = new TreeBuilder();

        // Node objects
        Node node = null;
        Node nodeBackup1 = null;
        Node nodeBackup2 = null;
        Node currentNode = null;
        boolean present = true;

        // Results Object
        Results result1 = null;
        Results result2 = null;
        Results result3 = null;

        while ((line = inputFileProcessor.readLine(inputFile)) != null) {
            try {
                bNumber = Integer.parseInt(line.split(":")[0].trim());
                course = line.split(":")[1].trim();
                currentNode = tree.searchNode(bNumber);

                if(course.matches("[A-K]")) {
                    if (currentNode != null) {
                        if(!currentNode.coursesAssigned.contains(course)) {
                            currentNode.coursesAssigned.add(course);
                            currentNode.backupNodesList.get(0).coursesAssigned.add(course);
                            currentNode.backupNodesList.get(1).coursesAssigned.add(course);
                        }
                    } else {
                        node = new Node(bNumber, course);
                        nodeBackup1 = (Node) node.clone();
                        nodeBackup2 = (Node) node.clone();
                        node.registerObserver(nodeBackup1);
                        node.registerObserver(nodeBackup2);
                        tree.insertNode(node);
                        backup1.insertNode(nodeBackup1);
                        backup2.insertNode(nodeBackup2);
                    }
                } else {
                    continue;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            Results res = new Results();

            res.printToStdout("Printing elements of the Main Node\n");
            res.printToFile("Printing elements of the Main Node\n");

            res.printToStdout("___________________________________\n");
            res.printToFile("__________________________________\n");

            tree.printInorder();

           // tree.deleteCreateValue(deleteFile);
        }
	}
}
