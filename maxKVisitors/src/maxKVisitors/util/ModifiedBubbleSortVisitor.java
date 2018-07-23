package maxKVisitors.util;
/**
 * Importing required Java classes
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

/**
 * ModifiedBubbleSort class to sort the 2 data structures and give the max K Elements
 */
public class ModifiedBubbleSortVisitor implements Visitor {
    private MyLogger logger;
    private Results results;
    int c,d,n,swap,k =0;

    /**
     * Constructor for the class
     * @param kIn passing the value of K
     */
    public ModifiedBubbleSortVisitor(int kIn) {
        logger.writeMessage("Constructor for Modified Bubble Sort Visitor called",logger.convertToDebugVal(2));
        k = kIn;
    }

    /**
     * visit method for vector
     * @param vector
     */
    @Override
    public void visit(MyVector vector) {

        System.out.println("Max K Elements after Visiting Vector Bubble Sort");
        Vector copy = new Vector(vector.getMyVector());
        n = copy.size();
        for (c = 0; c < (n - 1); c++) {
            for (d = 0; d < n - c - 1; d++) {
                if ((Integer) copy.get(d) < (Integer) copy.get(d + 1)) {
                    swap = (Integer) copy.get(d);
                    copy.set(d, copy.get(d + 1));
                    copy.set(d + 1, swap);
                }
            }
        }
        for (c = 0; c < k; c++)
            System.out.println(copy.get(c));
    }

    /**
     * visit method for Array
     * @param array
     */
    @Override
    public void visit(MyArray array) {

        System.out.println("Max K Elements after Visiting Array Bubble Sort");
        List<Integer> list = array.getmArray();
        int size = list.size();
        int counter = size;
        do {

            for (int i = 0; i < size-1; i++) {

                if (list.get(i) < list.get(i + 1)) {
                    Integer temp1= list.get(i + 1);
                    Integer temp2= list.get(i);
                    list.set(i,temp1);
                    list.set(i+1,temp2);
                }
            }
            size = size - 1;
        } while (size != 1);
        for( int i= 0; i< k; i++)
            System.out.println(list.get(i));
    }

    /**
     * accept method for array which sorts and returns the max K elements
     * @param array
     */
    @Override
    public void accept(MyArray array) {
        visit(array);
    }

    /**
     * accept method for vector which sorts and returns the max K elements
     * @param vector
     */
    @Override
    public void accept(MyVector vector) {
        visit(vector);
    }
}