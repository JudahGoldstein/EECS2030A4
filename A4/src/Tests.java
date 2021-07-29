import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {
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
    void remove1(){
        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();
        a.add(0, 0);
        a.remove(0);
        Assertions.assertNull(a.get(0));
    }

    @Test
    void remove2(){
        DoublyLinkedList<Integer> a = new DoublyLinkedList<>();
        a.add(0, 0);
        a.add(1, 1);
        a.add(2, 2);
        a.add(3, 3);
        a.remove(1);
        Assertions.assertEquals(a.get(0), 0);
        Assertions.assertEquals(a.get(1), 2);
        Assertions.assertEquals(a.get(2), 3);
        Assertions.assertNull(a.get(3));
    }
}
