import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoublyLinkedListIteratorTests {
    @Test
    public void TestConstructor() {
        DoublyLinkedList<Integer> list = getSampleList();
        Assertions.assertEquals(2, list.listIterator(2).nextIndex());
        Assertions.assertEquals(5, list.listIterator(5).nextIndex());
        Assertions.assertThrows(IndexOutOfBoundsException.class,
                () -> list.listIterator(6));
        Assertions.assertThrows(IndexOutOfBoundsException.class,
                () -> list.listIterator(-1));
    }

    @Test
    public void TestHasNext() {
        ListIterator<?> iterator = getSampleList().listIterator(0);
        Assertions.assertTrue(iterator.hasNext());
        iterator.next();
        Assertions.assertTrue(iterator.hasNext());
        iterator.next();
        Assertions.assertTrue(iterator.hasNext());
        iterator.next();
        Assertions.assertTrue(iterator.hasNext());
        iterator.next();
        Assertions.assertTrue(iterator.hasNext());
        iterator.next();
        Assertions.assertFalse(iterator.hasNext());
    }

    @Test
    public void TestNext() {
        ListIterator<?> iterator = getSampleList().listIterator(0);
        Assertions.assertEquals(1, iterator.next());
        Assertions.assertEquals(2, iterator.next());
        Assertions.assertEquals(3, iterator.next());
        Assertions.assertEquals(4, iterator.next());
        Assertions.assertEquals(5, iterator.next());
        Assertions.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void TestHasPrevious() {
        ListIterator<?> iterator = getSampleList().listIterator(5);

        Assertions.assertTrue(iterator.hasPrevious());
        iterator.previous();
        Assertions.assertTrue(iterator.hasPrevious());
        iterator.previous();
        Assertions.assertTrue(iterator.hasPrevious());
        iterator.previous();
        Assertions.assertTrue(iterator.hasPrevious());
        iterator.previous();
        Assertions.assertTrue(iterator.hasPrevious());
        iterator.previous();
        Assertions.assertFalse(iterator.hasPrevious());
    }

    @Test
    public void TestPrevious() {
        ListIterator<?> iterator = getSampleList().listIterator(5);

        Assertions.assertEquals(5, iterator.previous());
        Assertions.assertEquals(4, iterator.previous());
        Assertions.assertEquals(3, iterator.previous());
        Assertions.assertEquals(2, iterator.previous());
        Assertions.assertEquals(1, iterator.previous());
        Assertions.assertThrows(NoSuchElementException.class, iterator::previous);
    }

    @Test
    public void TestNextIndex() {
        ListIterator<?> iterator = getSampleList().listIterator(0);

        Assertions.assertEquals(0, iterator.nextIndex());
        iterator.next();
        Assertions.assertEquals(1, iterator.nextIndex());
        iterator.next();
        Assertions.assertEquals(2, iterator.nextIndex());
        iterator.next();
        Assertions.assertEquals(3, iterator.nextIndex());
        iterator.next();
        Assertions.assertEquals(4, iterator.nextIndex());
        iterator.next();
        Assertions.assertEquals(5, iterator.nextIndex());
    }

    @Test
    public void TestPreviousIndex() {
        ListIterator<?> iterator = getSampleList().listIterator(5);

        Assertions.assertEquals(4, iterator.previousIndex());
        iterator.previous();
        Assertions.assertEquals(3, iterator.previousIndex());
        iterator.previous();
        Assertions.assertEquals(2, iterator.previousIndex());
        iterator.previous();
        Assertions.assertEquals(1, iterator.previousIndex());
        iterator.previous();
        Assertions.assertEquals(0, iterator.previousIndex());
        iterator.previous();
        Assertions.assertEquals(-1, iterator.previousIndex());
    }

    @Test
    public void TestRemoveHead() {
        DoublyLinkedList<Integer> list = getSampleList();
        ListIterator<Integer> iterator = list.listIterator(0);

        Integer futureHead = list.get(1);
        iterator.next();
        iterator.remove();
        Assertions.assertEquals(futureHead, list.get(0));
    }

    @Test
    public void TestRemove() {
        DoublyLinkedList<Integer> list = getSampleList();
        ListIterator<Integer> iterator = list.listIterator(2);

        iterator.next();
        iterator.remove();

        iterator = list.listIterator(0);

        Assertions.assertEquals(4, list.size());
        Assertions.assertEquals(1, iterator.next());
        Assertions.assertEquals(2, iterator.next());
        Assertions.assertEquals(4, iterator.next());
        Assertions.assertEquals(5, iterator.next());
    }

    @Test
    public void TestRemoveException() {
        DoublyLinkedList<Integer> list = getSampleList();
        ListIterator<Integer> iterator = list.listIterator(2);

        // calling remove without calling next/previous
        Assertions.assertThrows(IllegalStateException.class, iterator::remove);

        // calling remove after calling next
        iterator.next();
        Assertions.assertDoesNotThrow(iterator::remove);

        // calling remove again after calling remove
        Assertions.assertThrows(IllegalStateException.class, iterator::remove);

        // calling remove after calling previous
        iterator.previous();
        Assertions.assertDoesNotThrow(iterator::remove);

        // calling remove after calling add
        iterator.add(9);
        Assertions.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void TestSet() {
        DoublyLinkedList<Integer> list = getSampleList();
        ListIterator<Integer> iterator = list.listIterator(2);

        iterator.next();

        Assertions.assertEquals(3, list.get(2));
        iterator.set(9);
        Assertions.assertEquals(9, list.get(2));
    }

    @Test
    public void TestSetException() {
        DoublyLinkedList<Integer> list = getSampleList();
        ListIterator<Integer> iterator = list.listIterator(2);

        // calling set without calling next/previous
        Assertions.assertThrows(IllegalStateException.class, () -> iterator.set(9));

        // calling set after calling next
        iterator.next();
        Assertions.assertDoesNotThrow(() -> iterator.set(9));

        // calling set again after calling set
        Assertions.assertDoesNotThrow(() -> iterator.set(9));

        // calling set after calling previous
        iterator.previous();
        Assertions.assertDoesNotThrow(() -> iterator.set(9));

        // calling set after calling add
        iterator.add(9);
        Assertions.assertThrows(IllegalStateException.class, () -> iterator.set(9));
    }

    @Test
    public void TestAdd() {
        DoublyLinkedList<Integer> list = getSampleList();
        ListIterator<Integer> iterator = list.listIterator(2);

        iterator.next();
        iterator.add(9);

        iterator = list.listIterator(0);

        Assertions.assertEquals(1, iterator.next());
        Assertions.assertEquals(2, iterator.next());
        Assertions.assertEquals(3, iterator.next());
        Assertions.assertEquals(9, iterator.next());
        Assertions.assertEquals(4, iterator.next());
        Assertions.assertEquals(5, iterator.next());
    }

    @Test
    public void TestAddHead() {
        DoublyLinkedList<Integer> list = getSampleList();
        ListIterator<Integer> iterator = list.listIterator(0);

        Integer futureHead = 9;
        iterator.add(futureHead);
        Assertions.assertEquals(futureHead, list.get(0));
    }

    /**
     * Returns a DoublyLinkedList: [1, 2, 3, 4, 5].
     */
    public DoublyLinkedList<Integer> getSampleList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        return list;
    }
}
