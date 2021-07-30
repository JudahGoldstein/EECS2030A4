import java.io.Serializable;
import java.util.*;

public class DoublyLinkedList<T> extends AbstractSequentialList<T> implements List<T>, Cloneable, Serializable {
    private Node<T> head;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    /*public void add(int index, T o) {
    }

    public T remove(int index) {
        return null;
    }

    public T get(int index) {
        return null;
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }*/

    public void push(T value) {

    }

    public T pop() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new DoublyLinkedListIterator(head, index);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * ListIterator
     */
    public class DoublyLinkedListIterator implements ListIterator<T> {

        private Node<T> currNode;   // last element returned by next/previous
        private Node<T> prevNode;   // previous node of the cursor
        private Node<T> nextNode;   // next node of the cursor
        private int nxtInd;         // index of nextNode

        public DoublyLinkedListIterator(Node<T> head, int index) {
            currNode = null;
            prevNode = null;
            nextNode = head;
            nxtInd = 0;

            while (nextIndex() != index)
                next();
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public T next() {
            if (nextNode == null) {
                throw new NoSuchElementException();
            }
            currNode = nextNode;
            nextNode = nextNode.next;
            prevNode = currNode;
            nxtInd++;
            return currNode.data;
        }

        @Override
        public boolean hasPrevious() {
            return prevNode != null;
        }

        @Override
        public T previous() {
            if (prevNode == null)
                throw new NoSuchElementException();

            currNode = prevNode;
            prevNode = prevNode.previous;
            nextNode = currNode;
            nxtInd--;
            return currNode.data;
        }

        @Override
        public int nextIndex() {
            return nxtInd;
        }

        @Override
        public int previousIndex() {
            return nxtInd - 1;
        }

        @Override
        public void remove() {
            if (currNode == null)
                throw new IllegalStateException();

            // updates pointer
            if (currNode == nextNode)
                nextNode = currNode.next;
            else
                prevNode = currNode.previous;

            // reforms the link
            if (nextNode != null)
                nextNode.previous = prevNode;
            if (prevNode != null)
                prevNode.next = nextNode;

            // updates head pointer
            if (currNode == head)
                head = currNode.next;

            currNode = null;
            nxtInd--;
            size--;
        }

        @Override
        public void set(T t) {
            if (currNode == null)
                throw new IllegalStateException();
            currNode.data = t;
        }

        @Override
        public void add(T t) {
            Node<T> newNode = new Node(t);

            // reforms link
            if (prevNode != null)
                prevNode.next = newNode;
            if (nextNode != null)
                nextNode.previous = newNode;

            newNode.previous = prevNode;
            newNode.next = nextNode;

            // updates pointers
            prevNode = newNode;
            currNode = null;
            nxtInd++;
            size++;

            // updates head
            if (newNode.previous == null)
                head = newNode;
        }
    }

    /**
     * Node class for DoublyLinkedList
     */
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