package maxKVisitors.util;

import java.util.List;
import java.util.Vector;

public class MaxHeapVisitor implements Visitor {

    int k = 0;
        public MaxHeapVisitor(int ink) {
            k = ink;
        }
    @Override
    public void visit(MyVector vector) {
        Vector<Integer> myVector = vector.getMyVector();

        int initialSize = myVector.size(), tempK = k;
        for( int i = initialSize; tempK > 0 && i > 0; i--, tempK--){
            heapify(myVector, i);
        }
    }

    @Override
    public void visit(MyArray array) {


        Vector<Integer> myVector = new Vector<Integer>(array.getmArray());

        int initialSize = myVector.size(), tempK = k;
        for( int i = initialSize; tempK > 0 && i > 0; i--, tempK--){
            heapify(myVector, i);
        }
    }

    private void heapify( Vector<Integer> myVector, int size){
        // (size-1)/2 because actual size doesn't start from index 0
        int left, right, max = 0, index;
        for( int i = (size-1)/2; i >= 0; i--) {
            index = i;
            left = i * 2 + 1;
            right = i * 2 + 2;
            max = myVector.get(index);
            if (left < size && myVector.get(left) > max) {
                max = myVector.get(left);
                index = left;
            }
            if (right < size && myVector.get(right) > max) {
                max = myVector.get(right);
                index = right;
            }
            if (index != i) {
                int temp = myVector.get(index);
                myVector.set(index, myVector.get(i));
                myVector.set(i, temp);
            }
        }


    }
}
