import java.io.Serializable;
import java.util.*;

public class DoublyLinkedList<T> extends AbstractSequentialList<T> implements List<T>, Cloneable, Serializable {
    private Node<T> head;
    private int size;

    /**
     * constructor
     */
    public DoublyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * adds node to end of list
     *
     * @param value value of node to be added
     */
    public void push(T value) {
        Node<T> toAdd = new Node<>(value);
        if (head == null) {
            head = toAdd;
        } else {
            Node<T> lastElement = head;
            while (lastElement.next != null) {
                lastElement = lastElement.next;
            }
            toAdd.previous = lastElement;
            lastElement.next = toAdd;
        }
        size++;
    }

    /**
     * removes the final item in the list
     *
     * @return weather or not an item is removed
     */
    public Node<T> pop() {
        Node<T> toDelete = head;
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            head = null;
            size--;
            return toDelete;
        }
        while (head.next != null) {
            head = head.next;
        }
        head = head.previous;
        toDelete = head.next;
        head.next = null;
        size--;
        return toDelete;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new DoublyLinkedListIterator(head, index);
    }

    /**
     * @return number of elements in the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @param index index for the nodes to be added to
     * @param c     the collection of nodes to be added
     * @return weather or not anything was added to the list
     */
    public boolean addAll(int index, Collection<? extends T> c) {
        if (c.size() == 0) {
            return false;
        }
        Iterator<T> iterator = (Iterator<T>) c.iterator();
        while (iterator.hasNext()) {
            add(index, iterator.next());
            index++;
        }
        size += c.size();
        return true;

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

            while (nextIndex() != index) {
                next();
            }
        }

        /**
         * @return weather or not there is a non-null node after the head
         */
        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        /**
         * @return moves context to next node
         */
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

        /**
         * @return weather or not there is a non-null node before the head
         */
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