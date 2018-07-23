package maxKVisitors.util;

import maxKVisitors.util.MyLogger;

/**
 * PupulateVisitor class to populate the elements to the data structure
 */
public class PopulateVisitor implements Visitor{

    private String fileName = null;
    private FileProcessor fp;
    MyLogger logger;

    /**
     * Constructor for PopulateVisitor
     * @param fileProcessorIn
     */
    public PopulateVisitor(FileProcessor fileProcessorIn ){
        MyLogger.writeMessage("populate Visitor constructor called in MaxHeap",logger.convertToDebugVal(2));
        fp = fileProcessorIn;
    }

    /**
     * visitor which contains method to add elements to the vector
     * @param vector
     */
    @Override
    public void visit(MyVector vector) {

        Integer value = null;
        while((value = fp.nextInt()) != null) {
            vector.add(value);
        }
    }

    /**
     * visitor which contains method to add elements to the array
     * @param array
     */
    @Override
    public void visit(MyArray array) {

        Integer value = null;
        while((value = fp.nextInt()) != null) {
            array.add(value);
        }
    }

    /**
     * accept method fot the array visitor
     * @param array
     */
    @Override
    public void accept(MyArray array) {
        visit(array);
    }

    /**
     * accept method for the vector visitor
     * @param vector
     */
    @Override
    public void accept(MyVector vector) {
        visit(vector);
    }
}
