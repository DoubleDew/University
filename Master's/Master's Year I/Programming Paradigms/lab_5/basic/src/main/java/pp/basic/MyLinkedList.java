package pp.basic;

import java.util.NoSuchElementException;

public class MyLinkedList<T> {
    private Node<T> first;

    public void add(T val) {
        Node<T> temp = new Node<>(val);

        if(this.first == null)
            first = temp;
        
        else {
            Node<T> x = first;

            while(x.next != null){
                x = x.next;
            }

            x.next = temp;
        }
    }

    public T get(int index) {
        Node<T> first2;
        first2 = first;
        int i=0;
        while(first2.next != null && i<index){
            first2 = first2.next;
            i++;
        }
        if( i == index)
            return first2.value;
        throw new IndexOutOfBoundsException();
    }

    public T remove() {
        if(first == null){
            throw new NoSuchElementException();
        }
        while(first.next.next != null){
            first = first.next;
        }
        T y = first.next.value;
        first.next = null;
        return y;
    }

    private static class Node<T> {
        Node<T> next;
        T value;

        public Node(T value) {
            this.value = value;
        }
    }
}