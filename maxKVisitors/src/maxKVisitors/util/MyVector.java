package maxKVisitors.util;

import java.util.Vector;

/**
 * MyVector class for MyVector data structure
 */
public class MyVector implements Visitable {
    MyLogger logger;
    private Vector<Integer> myVector;

    public MyVector() {

        logger.writeMessage("Constructor for MyVector called",logger.convertToDebugVal(2));
        myVector = new Vector<Integer>();
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void add(Integer elementIn) {
        myVector.add(elementIn);
    }
    public Vector<Integer> getMyVector(){
        return myVector;
    }
}