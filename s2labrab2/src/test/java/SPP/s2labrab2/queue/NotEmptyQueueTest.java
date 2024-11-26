package SPP.s2labrab2.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotEmptyQueueTest
{

    Queue<Integer> testQ;

    @BeforeEach
    void setUp()
    {
        testQ = new Queue<>();

        testQ.enqueue(1);
        testQ.enqueue(2);
        testQ.enqueue(3);
        testQ.enqueue(4);
        testQ.dequeue();
    }

    @Test
    void isEmpty()
    {
        assertFalse(testQ.isEmpty());
    }

    @Test
    void size()
    {
        assertEquals(3, testQ.size());
    }

    @Test
    void peek()
    {
        assertEquals(2, testQ.peek());
    }

    @Test
    void enqueue()
    {
        testQ.enqueue(5);
        assertEquals(4, testQ.size());
        assertEquals(2, testQ.peek());
        assertFalse(testQ.isEmpty());
    }

    @Test
    void dequeue()
    {
        testQ.dequeue();
        assertEquals(2, testQ.size());
        assertEquals(3, testQ.peek());
        assertFalse(testQ.isEmpty());
    }

    @Test
    void testToString()
    {
        assertEquals("2 3 4 ", testQ.toString());
    }
}
