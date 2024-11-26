package SPP.s2labrab2.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmptyQueueTest
{

    Queue<Integer> emptyQ;

    @BeforeEach
    void setUp()
    {
        emptyQ = new Queue<>();
    }

    @Test
    void isEmpty()
    {
        assertTrue(emptyQ.isEmpty());
    }

    @Test
    void size()
    {
        assertEquals(0, emptyQ.size());
    }

    @Test
    void peek()
    {
        assertThrows(
                NoSuchElementException.class,
                () -> emptyQ.peek()
        );
    }

    @Test
    void enqueue()
    {
        emptyQ.enqueue(5);
        assertEquals(1, emptyQ.size());
        assertEquals(5, emptyQ.peek());
        assertFalse(emptyQ.isEmpty());
    }

    @Test
    void dequeue()
    {
        assertThrows(
                NoSuchElementException.class,
                () -> emptyQ.dequeue()
        );
    }

    @Test
    void testToString()
    {
        assertEquals("", emptyQ.toString());
    }
}
