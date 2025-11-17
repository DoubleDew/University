package pp.advanced;

public interface Stackable<T> {
    void push(T e);

    T pop();

    void print();

    boolean isEmpty();

    T peek();

    /*
     * pop removes the top element from the stack and returns it.
     * isEmpty: if empty returns true.
     * peek: returns the top element without removing it.
     */
}
