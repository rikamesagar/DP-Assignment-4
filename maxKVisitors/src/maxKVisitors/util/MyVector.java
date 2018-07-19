package maxKVisitors.util;

import java.util.Vector;

public class MyVector {

    private Vector<Integer> myVector;

    public MyVector() {
        myVector = new Vector<Integer>();
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void add(Integer elem) {
        myVector.add(elem);
    }
    public Vector<Integer> getMyVector(){
        return myVector;
    }
}