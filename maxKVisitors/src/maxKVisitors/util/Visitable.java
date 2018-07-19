package maxKVisitors.util;

public interface Visitable {

    void accept(Visitor visitor);
    void add(Integer elementIn);

}
