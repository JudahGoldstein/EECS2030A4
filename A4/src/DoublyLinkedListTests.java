import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DoublyLinkedListTests {
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

    @Test
    void add1() {
        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();
        a.add(0, 0);
        Assertions.assertEquals(a.get(0), 0);
    }

    @Test
    void add2() {
        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();
        a.add(0, 0);
        a.add(1, 1);
        Assertions.assertEquals(a.get(0), 0);
        Assertions.assertEquals(a.get(1), 1);
    }

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

    @Test
    void remove1() {
        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();
        a.add(0, 0);
        a.remove(0);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> a.get(0));
    }

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
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> a.get(0));
    }

    @Test
    void pop1() {
        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();
        a.add(0, 0);
        a.pop();
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> a.get(0));
    }

    @Test
    void pop2() {
        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();
        a.add(0, 0);
        a.add(1, 1);
        a.pop();
        a.add(2, 2);
        a.add(3, 3);
        Assertions.assertEquals(a.get(0), 0);
        Assertions.assertEquals(a.get(1), 2);
        Assertions.assertEquals(a.get(2), 3);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> a.get(3));
    }

    @Test
    void push1() {
        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();
        a.push(0);
        Assertions.assertEquals(a.get(0), 0);
    }

    @Test
    void push2() {
        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();
        a.push(0);
        a.push(1);
        a.pop();
        a.push(2);
        a.push(3);
        Assertions.assertEquals(a.get(0), 0);
        Assertions.assertEquals(a.get(1), 2);
        Assertions.assertEquals(a.get(2), 3);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> a.get(3));
    }

    @Test
    void size1() {
        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();

    }

}
