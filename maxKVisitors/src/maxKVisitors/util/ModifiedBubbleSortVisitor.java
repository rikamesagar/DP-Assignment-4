package maxKVisitors.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class ModifiedBubbleSortVisitor implements Visitor {

    int c,d,n,swap,k =0;
    public ModifiedBubbleSortVisitor(int kIn) {
        k = kIn;
    }

    @Override
    public void visit(MyVector vector) {
        Vector copy = new Vector((Collection) vector);
        for ( c = 0; c < (n - 1); c++) {
            for ( d = 0; d < n - c - 1; d++) {
                if ((Integer)copy.get(d) > (Integer)copy.get(d + 1)) {
                    swap = (Integer) copy.get(d);
                    copy.set(d, copy.get(d + 1));
                    copy.set(d + 1, swap);
                }
            }
        }
    }

    @Override
    public void visit(MyArray array) {

        List<Integer> list = array.getmArray();
        int size = list.size();
        int counter = size;

        do {

            for (int i = 0; i < size-1; i++) {

                if (list.get(i) > list.get(i + 1)) {


                    Integer temp1= list.get(i + 1);
                    Integer temp2= list.get(i);
                    list.set(i,temp1);
                    list.set(i+1,temp2);

                }
            }
            size = size - 1;
        } while (size != 1);

    }
}

