package maxKVisitors.util;

import java.util.ArrayList;

public class MyArray {

    private ArrayList<Integer> myArray;

    public MyArray() {
        myArray = new ArrayList<Integer>();
    }
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
