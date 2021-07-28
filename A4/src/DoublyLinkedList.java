import java.io.Serializable;
import java.util.*;

public class DoublyLinkedList<T> extends AbstractSequentialList<T> implements List<T>, Cloneable, Serializable {

    public void add(int index, T o) {
        
    }
    
    public T remove(int index) {
        return null;
    }

    public T get(int index) {
        return null;
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    public void push(T value) {

    }

    public T pop() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /** Node class for DoublyLinkedList */
    private static final class Node<T> {
        private T data; //data holder for the node
        private Node<T> next; //link to the next node
        private Node<T> previous; //link to the previous node
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}