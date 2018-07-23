package maxKVisitors.util;

/**
 * Visitor Interface with visitor and accept methods
 */
public interface Visitor {

    void visit(MyVector vector);
    void visit(MyArray array);
    void accept(MyArray array);
    void accept(MyVector vector);
}