package maxKVisitors.util;

import java.util.ArrayList;

/**
 * MyArray class for the data structure
 */
public class MyArray implements Visitable {
    MyLogger logger;
    private ArrayList<Integer> myArray;

    /**
     * default constructor
     */
    public MyArray() {
        logger.writeMessage("Constructor for MyArray called",logger.convertToDebugVal(2));
        myArray = new ArrayList<Integer>();
    }

    /**
     *
     * @param visitor
     */
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public void add(Integer elementIn) {
        myArray.add(elementIn);
    }
    public ArrayList<Integer>getmArray(){
        return myArray;
    }
}
