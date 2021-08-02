import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DoublyLinkedListTests {
    /**
     * variables types check
     */
    @Test
    void get1() {
        DoublyLinkedList<Object> a = new DoublyLinkedList<>();
        a.add(0, "Zero");
        a.add(1, 1);
        a.add(2, 2.0);
        a.add(3, true);
        Assertions.assertEquals(a.get(0), "Zero");
        Assertions.assertEquals(a.get(1), 1);
        Assertions.assertEquals(a.get(2), 2.0);
        Assertions.assertEquals(a.get(3), true);
    }

    /**
     * adding single node
     */
    @Test
    void add1() {
        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();
        a.add(0, 0);
        Assertions.assertEquals(a.get(0), 0);
    }

    /**
     * add multiple nodes
     */
    @Test
    void add2() {
        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();
        a.add(0, 0);
        a.add(1, 1);
        Assertions.assertEquals(a.get(0), 0);
        Assertions.assertEquals(a.get(1), 1);
    }

    /**
     * adding node in the middle
     */
    @Test
    void add3() {
        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();
        a.add(0, 0);
        a.add(1, 1);
        a.add(2, 2);
        a.add(1, 3);
        Assertions.assertEquals(a.get(0), 0);
        Assertions.assertEquals(a.get(1), 3);
        Assertions.assertEquals(a.get(2), 1);
        Assertions.assertEquals(a.get(3), 2);
    }

    /**
     * remove node
     */
    @Test
    void remove1() {
        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();
        a.add(0, 0);
        a.remove(0);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> a.get(0));
    }

    /**
     * remove in the middle
     */
    @Test
    void remove2() {
        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();
        a.add(0, 0);
        a.add(1, 1);
        a.add(2, 2);
        a.add(3, 3);
        a.remove(1);
        Assertions.assertEquals(a.get(0), 0);
        Assertions.assertEquals(a.get(1), 2);
        Assertions.assertEquals(a.get(2), 3);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> a.get(3));
    }

    /**
     * pop only node
     */
    @Test
    void pop1() {
        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();
        a.add(0, 0);
        a.pop();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> a.get(0));
    }

    /**
     * repeated pops
     */
    @Test
    void pop2() {
        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();
        a.add(0, 0);
        a.pop();
        a.add(0, 0);
        a.pop();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> a.get(0));
    }

    /**
     * pop between adds
     */
    @Test
    void pop3() {
        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();
        a.add(0, 0);
        a.add(1, 1);
        a.pop();
        a.add(1, 2);
        a.add(2, 3);
        Assertions.assertEquals(a.get(0), 0);
        Assertions.assertEquals(a.get(1), 2);
        Assertions.assertEquals(a.get(2), 3);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> a.get(3));
    }

    /**
     * push single node
     */
    @Test
    void push1() {
        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();
        a.push(0);
        Assertions.assertEquals(a.get(0), 0);
    }

    /**
     * mixing push and pop
     */
    @Test
    void push2() {
        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();
        a.push(0);
        a.push(1);
        a.pop();
        a.push(2);
        System.out.println(a);
        a.push(3);
        System.out.println(a);
        Assertions.assertEquals(a.get(0), 0);
        Assertions.assertEquals(a.get(1), 2);
        Assertions.assertEquals(a.get(2), 3);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> a.get(3));
    }

    /**
     * size with no removal
     */
    @Test
    void size1() {
        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();
        a.push(0);
        a.push(1);
        a.add(2, 2);
        a.add(3, 3);
        Assertions.assertEquals(a.size(), 4);
    }

    /**
     * size with removal
     */
    @Test
    void size2() {
        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();
        a.push(0);
        a.push(1);
        a.pop();
        a.push(1);
        a.add(2, 2);
        a.add(3, 3);
        Assertions.assertEquals(a.size(), 4);
    }

    /**
     * empty size
     */
    @Test
    void size3() {
        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();
        Assertions.assertEquals(a.size(), 0);
    }

    /**
     * addAll to end
     */
    @Test
    void addAll1() {
        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> b = new DoublyLinkedList<>();
        a.push(0);
        a.push(1);
        b.push(2);
        b.push(3);
        a.addAll(2, b);
        Assertions.assertEquals(a.get(0), 0);
        Assertions.assertEquals(a.get(1), 1);
        Assertions.assertEquals(a.get(2), 2);
        Assertions.assertEquals(a.get(3), 3);
    }

    /**
     * addAll to middle
     */
    @Test
    void addAll2() {
        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> b = new DoublyLinkedList<>();
        a.push(0);
        a.push(1);
        a.push(6);
        a.push(7);
        b.push(2);
        b.push(3);
        b.push(4);
        b.push(5);
        a.addAll(2, b);
        Assertions.assertEquals(a.get(0), 0);
        Assertions.assertEquals(a.get(1), 1);
        Assertions.assertEquals(a.get(2), 2);
        Assertions.assertEquals(a.get(3), 3);
        Assertions.assertEquals(a.get(4), 4);
        Assertions.assertEquals(a.get(5), 5);
        Assertions.assertEquals(a.get(6), 6);
        Assertions.assertEquals(a.get(7), 7);
    }

    @Test
    void equals() {
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> list2 = new DoublyLinkedList<>();

        Assertions.assertTrue(list1.equals(list2));

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list2.add(1);
        list2.add(3);
        Assertions.assertFalse(list1.equals(list2));

        list2.add(1, 2);
        Assertions.assertTrue(list1.equals(list2));

        list1.set(1, 9);
        Assertions.assertFalse(list1.equals(list2));
    }
}
