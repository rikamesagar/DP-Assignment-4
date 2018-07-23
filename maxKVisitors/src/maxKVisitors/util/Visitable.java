package maxKVisitors.util;

/**
 * Visitable interface with accept and add methods
 */
public interface Visitable {

    void accept(Visitor visitor);
    void add(Integer elementIn);

}
