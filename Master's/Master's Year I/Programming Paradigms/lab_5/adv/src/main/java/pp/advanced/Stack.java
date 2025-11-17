package pp.advanced;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Stack<T> implements Stackable<T> {
    private final LinkedList<T> elements;

    public Stack() {
        elements = new LinkedList<>();
    }

    @Override
    public void push(T e) {
        elements.addFirst(e);
    }

    @Override
    public T pop() {
        if (elements.isEmpty()) 
            throw new NoSuchElementException("Stack is empty, cannot pop");
        return elements.removeLast();
    }

    @Override
    public T peek() {
        if (elements.isEmpty()) 
            throw new NoSuchElementException("Stack is empty, cannot peek");
        return elements.getLast();
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public void print() {
        if(elements.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        for(T e : elements) {
            System.out.println(e + " ");
        }
        System.out.println("");
    }
}